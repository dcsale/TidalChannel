// STAR-CCM+ macro: _main_2.java
// tested on STAR-CCM+ v10 and v11
// 
// by Danny Clay Sale (dsale@uw.edu)
// 
// license: ?tables
// 

package macro;
import java.util.*;
import star.common.*;

///////////////////////////////////////////////////////////////////////////////
// This is the MAIN driver, which calls all the other macros
///////////////////////////////////////////////////////////////////////////////
public class _main_2 extends StarMacro {

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


    // now create the ABL inflow
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("fieldFunction_ABL_inlet.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_InflowABL.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_OutletABL.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_VerticalProfilesABL.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_Run.java"))).play();
    
  
    // export important data here    
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("export_PointProbes.java"))).play(); 
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_SaveHardcopies.java"))).play();
  

  } // end execute0()
} // end public class
