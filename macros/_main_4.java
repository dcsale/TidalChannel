// STAR-CCM+ macro: _main_4.java
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
public class _main_4 extends StarMacro {

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





    // now add turbines once the inflow has been developed
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_VirtualDisks.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("parts_SectionPlanesTurbines.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_VirtualDisks_Reports.java"))).play();

    // re-mesh and re-solve
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("mesh_MeshAll.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_InitSolution.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_Run.java"))).play();
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_RunAMR.java"))).play();


    // export important data here    
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("export_PointProbes.java"))).play(); 
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("export_VirtualDisks.java"))).play(); 
    
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_SaveHardcopies.java"))).play();

    // simulation_0.saveState(getSimulation().getPresentationName()+"_inflowPrecursorWithTurbines.sim");
    Simulation simulation_0 = getActiveSimulation();
    simulation_0.saveState(resolvePath("inflowPrecursorWithTurbines.sim"));
        

    

  } // end execute0()
} // end public class
