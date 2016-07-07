// STAR-CCM+ macro: physics_BC_PeriodicPrecursor.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.turbulence.*;
import star.kwturb.*;
import star.common.*;
import star.base.neo.*;
import star.flow.*;

public class physics_BC_PeriodicPrecursor extends StarMacro {

 
  int  nPrecursors = 5;   // number of times to repeat the pre-cursor simulation

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSimulationIterator().run();



    PhysicsContinuum physicsContinuum_0 = 
          ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));








    XyzInternalTable xyzInternalTable_0 = 
      simulation_0.getTableManager().createTable(XyzInternalTable.class);

    xyzInternalTable_0.setPresentationName("outlet");

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Block");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Outlet");




    xyzInternalTable_0.getParts().setObjects(boundary_0);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(0));

    VectorComponentFieldFunction vectorComponentFieldFunction_1 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(1));

    VectorComponentFieldFunction vectorComponentFieldFunction_2 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(2));

    PrimitiveFieldFunction primitiveFieldFunction_1 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("TurbulentKineticEnergy"));

    PrimitiveFieldFunction primitiveFieldFunction_2 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("SpecificDissipationRate"));

    xyzInternalTable_0.setFieldFunctions(new NeoObjectVector(new Object[] {vectorMagnitudeFieldFunction_0, vectorComponentFieldFunction_0, vectorComponentFieldFunction_1, vectorComponentFieldFunction_2, primitiveFieldFunction_1, primitiveFieldFunction_2}));

    xyzInternalTable_0.extract();

    xyzInternalTable_0.export("../outputs/outlet_to_inlet.csv", ",");





    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_InflowABL.java"))).play();


    


    physicsContinuum_0.getInitialConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.K_OMEGA);




    TurbulentKineticEnergyProfile turbulentKineticEnergyProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulentKineticEnergyProfile.class);

    turbulentKineticEnergyProfile_0.setMethod(XyzTabularScalarProfileMethod.class);

    turbulentKineticEnergyProfile_0.getMethod(XyzTabularScalarProfileMethod.class).setTable(xyzInternalTable_0);

    turbulentKineticEnergyProfile_0.getMethod(XyzTabularScalarProfileMethod.class).setData("Turbulent Kinetic Energy");




    SpecificDissipationRateProfile specificDissipationRateProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(SpecificDissipationRateProfile.class);

    specificDissipationRateProfile_0.setMethod(XyzTabularScalarProfileMethod.class);

    specificDissipationRateProfile_0.getMethod(XyzTabularScalarProfileMethod.class).setTable(xyzInternalTable_0);

    specificDissipationRateProfile_0.getMethod(XyzTabularScalarProfileMethod.class).setData("Specific Dissipation Rate");




    VelocityProfile velocityProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(VelocityProfile.class);

    velocityProfile_0.setMethod(XyzTabularVectorProfileMethod.class);

    velocityProfile_0.getMethod(XyzTabularVectorProfileMethod.class).setTable(xyzInternalTable_0);

    velocityProfile_0.getMethod(XyzTabularVectorProfileMethod.class).setXData("Velocity[i]");

    velocityProfile_0.getMethod(XyzTabularVectorProfileMethod.class).setYData("Velocity[j]");

    velocityProfile_0.getMethod(XyzTabularVectorProfileMethod.class).setZData("Velocity[k]");




    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Inlet");

    boundary_1.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.K_OMEGA);




    SpecificDissipationRateProfile specificDissipationRateProfile_1 = 
      boundary_1.getValues().get(SpecificDissipationRateProfile.class);

    specificDissipationRateProfile_1.setMethod(XyzTabularScalarProfileMethod.class);

    specificDissipationRateProfile_1.getMethod(XyzTabularScalarProfileMethod.class).setTable(xyzInternalTable_0);

    specificDissipationRateProfile_1.getMethod(XyzTabularScalarProfileMethod.class).setData("Specific Dissipation Rate");




    TurbulentKineticEnergyProfile turbulentKineticEnergyProfile_1 = 
      boundary_1.getValues().get(TurbulentKineticEnergyProfile.class);

    turbulentKineticEnergyProfile_1.setMethod(XyzTabularScalarProfileMethod.class);

    turbulentKineticEnergyProfile_1.getMethod(XyzTabularScalarProfileMethod.class).setTable(xyzInternalTable_0);

    turbulentKineticEnergyProfile_1.getMethod(XyzTabularScalarProfileMethod.class).setData("Turbulent Kinetic Energy");




    VelocityProfile velocityProfile_1 = 
      boundary_1.getValues().get(VelocityProfile.class);

    velocityProfile_1.setMethod(XyzTabularVectorProfileMethod.class);

    velocityProfile_1.getMethod(XyzTabularVectorProfileMethod.class).setTable(xyzInternalTable_0);

    velocityProfile_1.getMethod(XyzTabularVectorProfileMethod.class).setXData("Velocity[i]");

    velocityProfile_1.getMethod(XyzTabularVectorProfileMethod.class).setYData("Velocity[j]");

    velocityProfile_1.getMethod(XyzTabularVectorProfileMethod.class).setZData("Velocity[k]");

    boundary_0.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.K_OMEGA);




    SpecificDissipationRateProfile specificDissipationRateProfile_2 = 
      boundary_0.getValues().get(SpecificDissipationRateProfile.class);

    specificDissipationRateProfile_2.setMethod(XyzTabularScalarProfileMethod.class);

    specificDissipationRateProfile_2.getMethod(XyzTabularScalarProfileMethod.class).setTable(xyzInternalTable_0);

    specificDissipationRateProfile_2.getMethod(XyzTabularScalarProfileMethod.class).setData("Specific Dissipation Rate");




    TurbulentKineticEnergyProfile turbulentKineticEnergyProfile_2 = 
      boundary_0.getValues().get(TurbulentKineticEnergyProfile.class);

    turbulentKineticEnergyProfile_2.setMethod(XyzTabularScalarProfileMethod.class);

    turbulentKineticEnergyProfile_2.getMethod(XyzTabularScalarProfileMethod.class).setTable(xyzInternalTable_0);

    turbulentKineticEnergyProfile_2.getMethod(XyzTabularScalarProfileMethod.class).setData("Turbulent Kinetic Energy");







    Solution solution_0 = 
      simulation_0.getSolution();

    solution_0.initializeSolution();

    simulation_0.getSimulationIterator().step(1);

    simulation_0.getSimulationIterator().run();


    for (int i = 0; i < nPrecursors; i++) {
      // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_PeriodicPrecursor_RunAgain.java"))).play();

      // XyzInternalTable xyzInternalTable_0 = 
      //   ((XyzInternalTable) simulation_0.getTableManager().getTable("outlet"));

      xyzInternalTable_0.extract();

      xyzInternalTable_0.export("../outputs/outlet_to_inlet.csv", ",");

      simulation_0.getSimulationIterator().run();


    }

  }
}
