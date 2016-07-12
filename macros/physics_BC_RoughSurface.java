// STAR-CCM+ macro: physics_BC_RoughSurface.java
// Written by STAR-CCM+ 11.04.010
package macro;

import java.util.*;

import star.turbulence.*;
import star.common.*;
import star.base.neo.*;

public class physics_BC_RoughSurface extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Block.Seabed");

    boundary_0.getConditions().get(WallSurfaceOption.class).setSelected(WallSurfaceOption.Type.ROUGH);

    BlendedWallFunctionCondition blendedWallFunctionCondition_0 = 
      boundary_0.getValues().get(BlendedWallFunctionCondition.class);

    blendedWallFunctionCondition_0.setE(9.0);

    blendedWallFunctionCondition_0.setKappa(0.42);

    RoughnessHeightProfile roughnessHeightProfile_0 = 
      boundary_0.getValues().get(RoughnessHeightProfile.class);

    roughnessHeightProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.0136);

    WallRoughnessCondition wallRoughnessCondition_0 = 
      boundary_0.getValues().get(WallRoughnessCondition.class);

    wallRoughnessCondition_0.setB(0.0);

    wallRoughnessCondition_0.setC(0.253);

    wallRoughnessCondition_0.setRplusSmooth(2.25);

    wallRoughnessCondition_0.setRplusRough(90.0);

    // wallRoughnessCondition_0.setRoughnessLimiter(false);

    wallRoughnessCondition_0.setRoughnessLimiter(true);
  }
}
