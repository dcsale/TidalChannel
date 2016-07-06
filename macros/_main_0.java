// STAR-CCM+ macro: _main_0.java
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
public class _main_0 extends StarMacro {

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

      // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("_main_1.java"))).play();
      // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("_main_2.java"))).play();


      // run a simple case with uniform flow to convergence
      new StarScript(getActiveSimulation(), new java.io.File(resolvePath("_main_1.java"))).play();
      // add the ABL
      new StarScript(getActiveSimulation(), new java.io.File(resolvePath("_main_2.java"))).play();
      // add the precursor inflow
      new StarScript(getActiveSimulation(), new java.io.File(resolvePath("_main_3.java"))).play();
      // add the virtual disks
      new StarScript(getActiveSimulation(), new java.io.File(resolvePath("_main_4.java"))).play();

    

  }
}
