// STAR-CCM+ macro: solver_RunAMR.java
// tested on STAR-CCM+ v10 and v11
// 
// by Danny Clay Sale (dsale@uw.edu)
// 
// license: ?
// 

package macro;
import java.util.*;
import star.common.*;
import star.base.neo.*;
import star.meshing.*;

public class solver_RunAMR extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    // run the simulation (this will restart from solution of previous known iteration)
    simulation_0.getSimulationIterator().run();
    
    // create any new field functions, parts, scenes, etc.  used for Adaptive Mesh Refinement
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("AMR_Initialize.java"))).play(); 

    // now run the AMR, loop through all the refinement levels (this loops meshing and solver)
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("AMR_Run.java"))).play();

    simulation_0.saveState(getSimulation().getPresentationName() + ".sim");

  } // end execute0()
} // end public class
