// STAR-CCM+ macro: physics_RealizableKEpsilonEllipticBlending.java
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

public class physics_RealizableKEpsilonEllipticBlending extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));

    simulation_0.getContinuumManager().remove(physicsContinuum_0);

    PhysicsContinuum physicsContinuum_1 = 
      simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);

    physicsContinuum_1.enable(ThreeDimensionalModel.class);

    physicsContinuum_1.enable(SteadyModel.class);

    physicsContinuum_1.enable(SingleComponentLiquidModel.class);

    physicsContinuum_1.enable(SegregatedFlowModel.class);

    physicsContinuum_1.enable(ConstantDensityModel.class);

    physicsContinuum_1.enable(TurbulentModel.class);

    physicsContinuum_1.enable(RansTurbulenceModel.class);

    physicsContinuum_1.enable(KEpsilonTurbulence.class);

    physicsContinuum_1.enable(EblKeTurbModel.class);

    physicsContinuum_1.enable(EblKeAllYplusWallTreatment.class);

    physicsContinuum_1.enable(VirtualDiskModel.class);

    EblKeAllYplusWallTreatment eblKeAllYplusWallTreatment_0 = 
      physicsContinuum_1.getModelManager().getModel(EblKeAllYplusWallTreatment.class);

    eblKeAllYplusWallTreatment_0.setIterativeUstarOption(true);

    SingleComponentLiquidModel singleComponentLiquidModel_0 = 
      physicsContinuum_1.getModelManager().getModel(SingleComponentLiquidModel.class);

    Liquid liquid_0 = 
      ((Liquid) singleComponentLiquidModel_0.getMaterial());

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_0 = 
      ((ConstantMaterialPropertyMethod) liquid_0.getMaterialProperties().getMaterialProperty(ConstantDensityProperty.class).getMethod());

    constantMaterialPropertyMethod_0.getQuantity().setValue(1025.0);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_1 = 
      ((ConstantMaterialPropertyMethod) liquid_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).getMethod());

    constantMaterialPropertyMethod_1.getQuantity().setValue(0.00108);

    SegregatedFlowModel segregatedFlowModel_0 = 
      physicsContinuum_1.getModelManager().getModel(SegregatedFlowModel.class);

    segregatedFlowModel_0.getDeltaVDissipationOption().setSelected(DeltaVDissipationOption.Type.ON);

    physicsContinuum_1.getInitialConditions().get(KeTurbSpecOption.class).setSelected(KeTurbSpecOption.Type.INTENSITY_LENGTH_SCALE);

    TurbulentLengthScaleProfile turbulentLengthScaleProfile_0 = 
      physicsContinuum_1.getInitialConditions().get(TurbulentLengthScaleProfile.class);

    turbulentLengthScaleProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(3.125);

    TurbulentVelocityScaleProfile turbulentVelocityScaleProfile_0 = 
      physicsContinuum_1.getInitialConditions().get(TurbulentVelocityScaleProfile.class);

    turbulentVelocityScaleProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.1);

    TurbulenceIntensityProfile turbulenceIntensityProfile_0 = 
      physicsContinuum_1.getInitialConditions().get(TurbulenceIntensityProfile.class);

    turbulenceIntensityProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.1);

    VelocityProfile velocityProfile_0 = 
      physicsContinuum_1.getInitialConditions().get(VelocityProfile.class);

    velocityProfile_0.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponents(0.01, 0.0, 0.0);

    ReducedStressFunctionProfile reducedStressFunctionProfile_0 = 
      physicsContinuum_1.getInitialConditions().get(ReducedStressFunctionProfile.class);

    reducedStressFunctionProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.6666);
  }
}
