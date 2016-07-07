// STAR-CCM+ macro: physics_RealizableKEpsilon.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.vdm.*;
import star.turbulence.*;
import star.material.*;
import star.common.*;
import star.keturb.*;
import star.base.neo.*;
import star.flow.*;
import star.segregatedflow.*;
import star.metrics.*;

public class physics_RealizableKEpsilon extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PhysicsContinuum physicsContinuum_0 = 
      simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);

    physicsContinuum_0.enable(ThreeDimensionalModel.class);

    physicsContinuum_0.enable(SteadyModel.class);

    physicsContinuum_0.enable(SingleComponentLiquidModel.class);

    physicsContinuum_0.enable(SegregatedFlowModel.class);

    physicsContinuum_0.enable(ConstantDensityModel.class);

    physicsContinuum_0.enable(TurbulentModel.class);

    physicsContinuum_0.enable(RansTurbulenceModel.class);

    physicsContinuum_0.enable(KEpsilonTurbulence.class);

    physicsContinuum_0.enable(RkeTwoLayerTurbModel.class);

    physicsContinuum_0.enable(KeTwoLayerAllYplusWallTreatment.class);

    physicsContinuum_0.enable(VirtualDiskModel.class);

    SingleComponentLiquidModel singleComponentLiquidModel_0 = 
      physicsContinuum_0.getModelManager().getModel(SingleComponentLiquidModel.class);

    Liquid liquid_0 = 
      ((Liquid) singleComponentLiquidModel_0.getMaterial());

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_0 = 
      ((ConstantMaterialPropertyMethod) liquid_0.getMaterialProperties().getMaterialProperty(ConstantDensityProperty.class).getMethod());

    constantMaterialPropertyMethod_0.getQuantity().setValue(1025.0);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_1 = 
      ((ConstantMaterialPropertyMethod) liquid_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).getMethod());

    constantMaterialPropertyMethod_1.getQuantity().setValue(0.00108);

    RkeTwoLayerTurbModel rkeTwoLayerTurbModel_0 = 
      physicsContinuum_0.getModelManager().getModel(RkeTwoLayerTurbModel.class);

    rkeTwoLayerTurbModel_0.getTwoLayerOption().setSelected(TwoLayerOption.Type.NORRIS_REYNOLDS);

    SegregatedFlowModel segregatedFlowModel_0 = 
      physicsContinuum_0.getModelManager().getModel(SegregatedFlowModel.class);

    segregatedFlowModel_0.getDeltaVDissipationOption().setSelected(DeltaVDissipationOption.Type.ON);

    KeTwoLayerAllYplusWallTreatment keTwoLayerAllYplusWallTreatment_0 = 
      physicsContinuum_0.getModelManager().getModel(KeTwoLayerAllYplusWallTreatment.class);

    keTwoLayerAllYplusWallTreatment_0.setIterativeUstarOption(true);

    physicsContinuum_0.getInitialConditions().get(KeTurbSpecOption.class).setSelected(KeTurbSpecOption.Type.INTENSITY_LENGTH_SCALE);

    TurbulentLengthScaleProfile turbulentLengthScaleProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulentLengthScaleProfile.class);

    turbulentLengthScaleProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.1);

    TurbulentVelocityScaleProfile turbulentVelocityScaleProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulentVelocityScaleProfile.class);

    turbulentVelocityScaleProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.1);

    VelocityProfile velocityProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(VelocityProfile.class);

    velocityProfile_0.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponents(0.01, 0.0, 0.0);

    TurbulenceIntensityProfile turbulenceIntensityProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulenceIntensityProfile.class);

    turbulenceIntensityProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.1);

    turbulentLengthScaleProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(3.125);
  }
}
