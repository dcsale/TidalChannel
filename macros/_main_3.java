// STAR-CCM+ macro: _main_3.java
// tested on STAR-CCM+ v10 and v11
// 
// by Danny Clay Sale (dsale@uw.edu)
// 
// license: ?
// 

package macro;
import java.util.*;
import star.common.*;

///////////////////////////////////////////////////////////////////////////////
// This is the MAIN driver, which calls all the other macros
///////////////////////////////////////////////////////////////////////////////
public class _main_3 extends StarMacro {

  ///////////////////////////////////////////////////////////////////////////////
  // USER INPUTS
  ///////////////////////////////////////////////////////////////////////////////
  // this macro run all the precursor simultions, or ABL, without any turbines
  // the next "main" macro adds the turbines and runs again
  // 


  public void execute() {
    execute0();
  }

  private void execute0() {


    // generate the precursor periodic simulation, to develop the correct inflow condition
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_PeriodicPrecursor.java"))).play();


    // export important data here    
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("export_PointProbes.java"))).play(); 
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_SaveHardcopies.java"))).play();

    // simulation_0.saveState(getSimulation().getPresentationName()+"_inflowPeriodicPrecursor.sim");
    Simulation simulation_0 = getActiveSimulation();
    simulation_0.saveState(resolvePath("inflowPeriodicPrecursor.sim"));

  } // end execute0()
} // end public class
