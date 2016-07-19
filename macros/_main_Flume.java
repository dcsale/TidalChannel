// STAR-CCM+ macro: _main_Flume.java
// tested on STAR-CCM+ v10 and v11
// 
// by Danny Clay Sale (dsale@uw.edu)
// license: ?
// 

package macro;
import java.util.*;
import star.common.*;

public class _main_Flume extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

      // read in all the user inputs, and store them as field functions for easy access
      new StarScript(getActiveSimulation(), new java.io.File(resolvePath("init_UserInputVariables.java"))).play();
      
      // run a simple case with uniform flow to convergence
      new StarScript(getActiveSimulation(), new java.io.File(resolvePath("_main_1.java"))).play();
      
      // // add the ABL
      // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("_main_2.java"))).play();
      
      // // add the precursor inflow
      // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("_main_3.java"))).play();
      
      // add the virtual disks
      new StarScript(getActiveSimulation(), new java.io.File(resolvePath("_main_4.java"))).play();
      
      // adjust the rotor speed control
      new StarScript(getActiveSimulation(), new java.io.File(resolvePath("_main_5.java"))).play();
      

  }
}
