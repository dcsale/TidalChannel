// STAR-CCM+ macro: scene_BoundaryLayerProfile.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;

public class scene_BoundaryLayerProfile extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PlaneSection planeSection_0 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    Coordinate coordinate_0 = 
      planeSection_0.getOrientationCoordinate();

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("m"));

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    planeSection_0.getInputParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Block");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Inlet");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Left Bank");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Outlet");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Right Bank");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Sea Surface");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Seabed");

    planeSection_0.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5);

    Coordinate coordinate_1 = 
      planeSection_0.getOriginCoordinate();

    coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {100.0, 160.0, 25.0}));

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("mesh");

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {771.8499819730905, 166.67875816773767, 21.824867241879872}), new DoubleVector(new double[] {-28.292051737965643, -1027.7995703610425, 300.8964043739325}), new DoubleVector(new double[] {0.07028485065732681, 0.1819918076575475, 0.9807849008389229}), 431.53794734646476, 0);

    planeSection_0.setPresentationName("inflow_plane");

    scene_0.setTransparencyOverrideMode(1);

    PartDisplayer partDisplayer_6 = 
      ((PartDisplayer) scene_0.getCreatorDisplayer());

    partDisplayer_6.initialize();

    scene_0.getCreatorGroup().setObjects(region_0);

    currentView_0.setInput(new DoubleVector(new double[] {771.8499819730905, 166.67875816773767, 21.824867241879872}), new DoubleVector(new double[] {-28.292051737965643, -1027.7995703610425, 300.8964043739325}), new DoubleVector(new double[] {0.07028485065732681, 0.1819918076575475, 0.9807849008389229}), 431.53794734646476, 0);

    PlaneSection planeSection_1 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_1.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_1.getInputParts().setObjects(region_0);

    Coordinate coordinate_2 = 
      planeSection_1.getOriginCoordinate();

    coordinate_2.setValue(new DoubleVector(new double[] {100.0, 160.0, 25.0}));

    coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {100.0, 160.0, 25.0}));

    coordinate_2.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_3 = 
      planeSection_1.getOrientationCoordinate();

    coordinate_3.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_3.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_3.setCoordinateSystem(labCoordinateSystem_0);

    SingleValue singleValue_0 = 
      planeSection_1.getSingleValue();

    singleValue_0.getValueQuantity().setValue(0.0);

    singleValue_0.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_0 = 
      planeSection_1.getRangeMultiValue();

    rangeMultiValue_0.setNValues(2);

    rangeMultiValue_0.getStartQuantity().setValue(0.0);

    rangeMultiValue_0.getStartQuantity().setUnits(units_0);

    rangeMultiValue_0.getEndQuantity().setValue(1.0);

    rangeMultiValue_0.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_0 = 
      planeSection_1.getDeltaMultiValue();

    deltaMultiValue_0.setNValues(2);

    deltaMultiValue_0.getStartQuantity().setValue(0.0);

    deltaMultiValue_0.getStartQuantity().setUnits(units_0);

    deltaMultiValue_0.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_0.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_0 = 
      planeSection_1.getArbitraryMultiValue();

    multiValue_0.getValueQuantities().setUnits(units_0);

    multiValue_0.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_1.setValueMode(0);

    scene_0.setTransparencyOverrideMode(0);

    planeSection_1.getInputParts().setQuery(null);

    planeSection_1.getInputParts().setObjects(region_0, planeSection_0);

    planeSection_1.getInputParts().setQuery(null);

    planeSection_1.getInputParts().setObjects(planeSection_0);

    planeSection_1.setPresentationName("inflow_profile");

    MaxReport maxReport_0 = 
      simulation_0.getReportManager().createReport(MaxReport.class);

    maxReport_0.setPresentationName("WallShearStress");

    maxReport_0.getParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, planeSection_1);
    // maxReport_0.getParts().setObjects(planeSection_1);


    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("WallShearStress"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    maxReport_0.setScalar(vectorMagnitudeFieldFunction_0);

    UserFieldFunction userFieldFunction_0 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

    userFieldFunction_0.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

    userFieldFunction_0.setPresentationName("Utau");

    userFieldFunction_0.setFunctionName("Utau");

    userFieldFunction_0.setDefinition("sqrt($WallShearStressReport/$Density)");

    userFieldFunction_0.setIgnoreBoundaryValues(true);

    UserFieldFunction userFieldFunction_1 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

    userFieldFunction_1.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

    userFieldFunction_1.setPresentationName("y+");

    userFieldFunction_1.setFunctionName("y+");

    userFieldFunction_1.setDefinition("$Utau*$WallDistance*$Density/$DynamicViscosity");

    userFieldFunction_1.setIgnoreBoundaryValues(true);

    UserFieldFunction userFieldFunction_2 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

    userFieldFunction_2.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

    userFieldFunction_2.setPresentationName("u+");

    userFieldFunction_2.setFunctionName("u+");

    Units units_1 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Units units_2 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    userFieldFunction_2.setDefinition("mag([$$Velocity[0], 0, $$Velocity[2]])/$Utau");

    XYPlot xYPlot_0 = 
      simulation_0.getPlotManager().createPlot(XYPlot.class);

    xYPlot_0.open();

    xYPlot_0.setPresentationName("boundary_layer");

    xYPlot_0.setTitle("boundary layer");

    xYPlot_0.getParts().setObjects(planeSection_1);

    AxisType axisType_0 = 
      xYPlot_0.getXAxisType();

    axisType_0.setMode(1);

    FieldFunctionUnits fieldFunctionUnits_0 = 
      axisType_0.getScalarFunction();

    fieldFunctionUnits_0.setFieldFunction(userFieldFunction_1);

    simulation_0.getSimulationIterator().step(1);

    maxReport_0.getParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, planeSection_1);

    simulation_0.getSimulationIterator().step(1);

    YAxisType yAxisType_0 = 
      ((YAxisType) xYPlot_0.getYAxes().getAxisType("Y Type 1"));

    FieldFunctionUnits fieldFunctionUnits_1 = 
      yAxisType_0.getScalarFunction();

    fieldFunctionUnits_1.setFieldFunction(userFieldFunction_2);

    Cartesian2DAxisManager cartesian2DAxisManager_0 = 
      ((Cartesian2DAxisManager) xYPlot_0.getAxisManager());

    Cartesian2DAxis cartesian2DAxis_0 = 
      ((Cartesian2DAxis) cartesian2DAxisManager_0.getAxis("Bottom Axis"));

    cartesian2DAxis_0.setLogarithmic(true);

    InternalDataSet internalDataSet_0 = 
      ((InternalDataSet) yAxisType_0.getDataSetManager().getDataSet("inflow_profile"));


    internalDataSet_0.setNeedsSorting(true);

    LineStyle lineStyle_0 = 
      internalDataSet_0.getLineStyle();

    lineStyle_0.getLinePatternOption().setSelected(LinePatternOption.Type.SOLID);
  }
}
