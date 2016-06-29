// STAR-CCM+ macro: physics_InitialConditions.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.turbulence.*;
import star.kwturb.*;
import star.common.*;
import star.base.neo.*;
import star.flow.*;

public class physics_InitialConditions extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));

    InitialPressureProfile initialPressureProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(InitialPressureProfile.class);

    initialPressureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(1.0);

    TurbulenceIntensityProfile turbulenceIntensityProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulenceIntensityProfile.class);

    turbulenceIntensityProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(2.0);

    physicsContinuum_0.getInitialConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.K_OMEGA);

    physicsContinuum_0.getInitialConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.INTENSITY_LENGTH_SCALE);

    TurbulentLengthScaleProfile turbulentLengthScaleProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulentLengthScaleProfile.class);

    turbulentLengthScaleProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(3.0);

    TurbulentVelocityScaleProfile turbulentVelocityScaleProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulentVelocityScaleProfile.class);

    turbulentVelocityScaleProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(4.0);
  }
}
