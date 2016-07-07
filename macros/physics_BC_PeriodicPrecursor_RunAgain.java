// STAR-CCM+ macro: physics_BC_PeriodicPrecursor_RunAgain.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class physics_BC_PeriodicPrecursor_RunAgain extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    XyzInternalTable xyzInternalTable_0 = 
      ((XyzInternalTable) simulation_0.getTableManager().getTable("outlet"));

    xyzInternalTable_0.extract();

    xyzInternalTable_0.export("../outputs/outlet_to_inlet.csv", ",");

    simulation_0.getSimulationIterator().run();
  }
}

