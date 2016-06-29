// STAR-CCM+ macro: physics_BC_InflowUniform.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.turbulence.*;
import star.kwturb.*;
import star.common.*;
import star.flow.*;

public class physics_BC_InflowUniform extends StarMacro {

  ///////////////////////////////////////////////////////////////////////////////
  // USER INPUTS
  //
  static final double density             = 1025;      // fluid density [kg/m^2]
  static final double dynamic_viscosity   = 0.00108;   // fluid dynamic viscosity [Pa-s]
  static final double init_TI             = 0.1;       // turbulence intensity, TI = u' / U [unitless]
  static final double init_Lturb          = 3.125;     // turbulent length scale [m]
  static final double init_Vturb          = 0.1;       // turbulent velocity scale [m/s]
  static final double init_Vx             = 0.001;       // initial x-velocity [m/s]    NOTE: do not start from 0 because sometime field functions may divide by 0
  static final double init_Vy             = 0.001;       // initial y-velocity [m/s]
  static final double init_Vz             = 0.001;       // initial z-velocity [m/s]
  static final double inlet_Vx    = 2.0;     // inlet x-velocity [m/s]
  static final double inlet_Vy    = 0.0;     // inlet y-velocity [m/s]
  static final double inlet_Vz    = 0.0;     // inlet z-velocity [m/s]
  ///////////////////////////////////////////////////////////////////////////////

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));


    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Block");


      ///////////////////////////////////////////////////////////////////////////////
     // Set Initial Conditions
    //   

    physicsContinuum_0.getInitialConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.INTENSITY_LENGTH_SCALE);

    TurbulenceIntensityProfile turbulenceIntensityProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulenceIntensityProfile.class);

    turbulenceIntensityProfile_0.setMethod(ConstantScalarProfileMethod.class);

    turbulenceIntensityProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(init_TI);

    TurbulentLengthScaleProfile turbulentLengthScaleProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulentLengthScaleProfile.class);

    turbulentLengthScaleProfile_0.setMethod(ConstantScalarProfileMethod.class);

    turbulentLengthScaleProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(init_Lturb);

    TurbulentVelocityScaleProfile turbulentVelocityScaleProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulentVelocityScaleProfile.class);

    turbulentVelocityScaleProfile_0.setMethod(FunctionScalarProfileMethod.class);

    turbulentVelocityScaleProfile_0.setMethod(ConstantScalarProfileMethod.class);

    turbulentVelocityScaleProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(init_Vturb);

    VelocityProfile velocityProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(VelocityProfile.class);

    velocityProfile_0.setMethod(ConstantVectorProfileMethod.class);

    velocityProfile_0.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponents(init_Vx, init_Vy, init_Vz);







    

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Inlet");

    boundary_1.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.INTENSITY_LENGTH_SCALE);



    TurbulenceIntensityProfile turbulenceIntensityProfile_1 = 
      boundary_1.getValues().get(TurbulenceIntensityProfile.class);

    turbulenceIntensityProfile_1.setMethod(FunctionScalarProfileMethod.class);

    turbulenceIntensityProfile_1.setMethod(ConstantScalarProfileMethod.class);

    turbulenceIntensityProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(init_TI);



    TurbulentLengthScaleProfile turbulentLengthScaleProfile_1 = 
      boundary_1.getValues().get(TurbulentLengthScaleProfile.class);

    turbulentLengthScaleProfile_1.setMethod(FunctionScalarProfileMethod.class);

    turbulentLengthScaleProfile_1.setMethod(ConstantScalarProfileMethod.class);

    turbulentLengthScaleProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(init_Lturb);

    VelocityProfile velocityProfile_1 = 
      boundary_1.getValues().get(VelocityProfile.class);

    velocityProfile_1.setMethod(ConstantVectorProfileMethod.class);

    velocityProfile_1.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponents(inlet_Vx, inlet_Vy, inlet_Vz);






    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Outlet");

    boundary_3.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.INTENSITY_LENGTH_SCALE);

    TurbulenceIntensityProfile turbulenceIntensityProfile_2 = 
      boundary_3.getValues().get(TurbulenceIntensityProfile.class);

    turbulenceIntensityProfile_2.setMethod(FunctionScalarProfileMethod.class);

    turbulenceIntensityProfile_2.setMethod(ConstantScalarProfileMethod.class);

    turbulenceIntensityProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(init_TI);

    TurbulentLengthScaleProfile turbulentLengthScaleProfile_2 = 
      boundary_3.getValues().get(TurbulentLengthScaleProfile.class);

    turbulentLengthScaleProfile_2.setMethod(FunctionScalarProfileMethod.class);

    turbulentLengthScaleProfile_2.setMethod(ConstantScalarProfileMethod.class);

    turbulentLengthScaleProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(init_Lturb);
























    // VelocityProfile velocityProfile_0 = 
    //   physicsContinuum_0.getInitialConditions().get(VelocityProfile.class);

    // UserFieldFunction userFieldFunction_32 = 
    //   ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("VelocityProfile"));

    // velocityProfile_0.getMethod(FunctionVectorProfileMethod.class).setFieldFunction(userFieldFunction_32);

    // TurbulenceIntensityProfile turbulenceIntensityProfile_0 = 
    //   physicsContinuum_0.getInitialConditions().get(TurbulenceIntensityProfile.class);

    // turbulenceIntensityProfile_0.setMethod(FunctionScalarProfileMethod.class);

    // UserFieldFunction userFieldFunction_33 = 
    //   ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("TI"));

    // turbulenceIntensityProfile_0.getMethod(FunctionScalarProfileMethod.class).setFieldFunction(userFieldFunction_33);

    // TurbulentLengthScaleProfile turbulentLengthScaleProfile_0 = 
    //   physicsContinuum_0.getInitialConditions().get(TurbulentLengthScaleProfile.class);

    // turbulentLengthScaleProfile_0.setMethod(FunctionScalarProfileMethod.class);

    // physicsContinuum_0.getInitialConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.K_OMEGA);

    // SpecificDissipationRateProfile specificDissipationRateProfile_0 = 
    //   physicsContinuum_0.getInitialConditions().get(SpecificDissipationRateProfile.class);

    // specificDissipationRateProfile_0.setMethod(FunctionScalarProfileMethod.class);

    // UserFieldFunction userFieldFunction_34 = 
    //   ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("tdr"));

    // specificDissipationRateProfile_0.getMethod(FunctionScalarProfileMethod.class).setFieldFunction(userFieldFunction_34);

    // TurbulentKineticEnergyProfile turbulentKineticEnergyProfile_0 = 
    //   physicsContinuum_0.getInitialConditions().get(TurbulentKineticEnergyProfile.class);

    // turbulentKineticEnergyProfile_0.setMethod(FunctionScalarProfileMethod.class);

    // UserFieldFunction userFieldFunction_35 = 
    //   ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("tke"));

    // turbulentKineticEnergyProfile_0.getMethod(FunctionScalarProfileMethod.class).setFieldFunction(userFieldFunction_35);

    // Region region_0 = 
    //   simulation_0.getRegionManager().getRegion("Block");

    // Boundary boundary_0 = 
    //   region_0.getBoundaryManager().getBoundary("Inlet");

    // boundary_0.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.K_OMEGA);

    // boundary_0.getConditions().get(InletVelocityOption.class).setSelected(InletVelocityOption.Type.COMPONENTS);

    // VelocityProfile velocityProfile_1 = 
    //   boundary_0.getValues().get(VelocityProfile.class);

    // velocityProfile_1.getMethod(FunctionVectorProfileMethod.class).setFieldFunction(userFieldFunction_32);

    // SpecificDissipationRateProfile specificDissipationRateProfile_1 = 
    //   boundary_0.getValues().get(SpecificDissipationRateProfile.class);

    // specificDissipationRateProfile_1.setMethod(FunctionScalarProfileMethod.class);

    // specificDissipationRateProfile_1.getMethod(FunctionScalarProfileMethod.class).setFieldFunction(userFieldFunction_34);

    // TurbulentKineticEnergyProfile turbulentKineticEnergyProfile_1 = 
    //   boundary_0.getValues().get(TurbulentKineticEnergyProfile.class);

    // turbulentKineticEnergyProfile_1.setMethod(FunctionScalarProfileMethod.class);

    // turbulentKineticEnergyProfile_1.getMethod(FunctionScalarProfileMethod.class).setFieldFunction(userFieldFunction_35);




    // Solution solution_0 = 
    //   simulation_0.getSolution();

    // solution_0.initializeSolution();
  }
}
