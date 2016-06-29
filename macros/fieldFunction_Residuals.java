// STAR-CCM+ macro: fieldFunction_Residuals.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.kwturb.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.segregatedflow.*;

public class fieldFunction_Residuals extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    SegregatedFlowSolver segregatedFlowSolver_0 = 
      ((SegregatedFlowSolver) simulation_0.getSolverManager().getSolver(SegregatedFlowSolver.class));

    segregatedFlowSolver_0.setLeaveTemporaryStorage(true);

    ResidualPlot residualPlot_0 = 
      ((ResidualPlot) simulation_0.getPlotManager().getPlot("Residuals"));

    residualPlot_0.open();

    simulation_0.getSimulationIterator().step(1);

    Scene scene_0 = 
      simulation_0.getSceneManager().createScene("Copy of velocity_x");

    scene_0.setPresentationName("Copy of velocity_x");

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("velocity_x");

    scene_0.copyProperties(scene_1);

    scene_0.initializeAndWait();

    KwTurbSolver kwTurbSolver_0 = 
      ((KwTurbSolver) simulation_0.getSolverManager().getSolver(KwTurbSolver.class));

    kwTurbSolver_0.setLeaveTemporaryStorage(true);

    simulation_0.getSimulationIterator().step(1);

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_0.getDisplayerManager().getDisplayer("Scalar 1"));

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("TurbulentKineticEnergyResidual"));

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_0);

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.initialize();

    scalarDisplayer_0.initialize();

    scene_0.open(true);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {447.9429667178996, 163.59095562743255, 53.02819592738737}), new DoubleVector(new double[] {447.9429667178996, -637.4809673160605, 53.02819592738737}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 209.12173559241742, 1);

    scene_0.setViewOrientation(new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-3570.6977214441085, 100.0}));

    scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-100.0, 100.0}));

    scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-1.0, 100.0}));

    scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-1.0, 1.0}));

    scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-100.0, 1.0}));

    scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-100.0, 100.0}));
  }
}
