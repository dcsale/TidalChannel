// STAR-CCM+ macro: scene_VerticalProfilesABL.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class scene_VerticalProfilesABL extends StarMacro {

  // NOTE: it would be better to define these as field functions so do not have to duplicate User Inputs over multiple files
  // static final double xo          = 0;       // origin x coordinate [m]
  // static final double yo          = 0;       // origin y coordinate [m]
  // static final double zo          = 0;       // origin z coordinate [m]
  // // static final double length      = 12.3;     // length in x-dimention (steamwise) [m]
  // // static final double width       = 1.0;     // length in y-dimention (crossflow) [m]
  // // static final double depth       = 0.8;      // length in z-dimention (vertical) [m]
  // static final double length      = 1000;     // length in x-dimention (steamwise) [m]
  // static final double width       = 400;     // length in y-dimention (crossflow) [m]
  // static final double depth       = 60;      // length in z-dimention (vertical) [m]

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    // Scene scene_0 = 
    //   simulation_0.getSceneManager().getScene("velocity");

    // scene_0.setTransparencyOverrideMode(1);

      // // get the user defined field functions
      // UserFieldFunction userFieldFunction_0 = 
      //   ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("__xo"));
      // UserFieldFunction userFieldFunction_1 = 
      //   ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("__yo"));
      // UserFieldFunction userFieldFunction_2 = 
      //   ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("__zo"));
      // UserFieldFunction userFieldFunction_3 = 
      //   ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("__length"));
      // UserFieldFunction userFieldFunction_4 = 
      //   ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("__width"));
      // UserFieldFunction userFieldFunction_5 = 
      //   ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("__depth"));



    LinePart linePart_1 = 
      ((LinePart) simulation_0.getPartManager().getObject("line_probe_inflow"));
    //   simulation_0.getPartManager().createLinePart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), new DoubleVector(new double[] {1.0, 0.0, 0.0}), 20);

    // Coordinate coordinate_2 = 
    //   linePart_1.getPoint1Coordinate();

    // LabCoordinateSystem labCoordinateSystem_0 = 
    //   simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    // coordinate_2.setCoordinateSystem(labCoordinateSystem_0);

    // coordinate_2.setValue(new DoubleVector(new double[] {xo, yo+(width-yo)/2, 0.0}));

    // coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {xo, yo+(width-yo)/2, 0.0}));

    // Coordinate coordinate_3 = 
    //   linePart_1.getPoint2Coordinate();

    // coordinate_3.setCoordinateSystem(labCoordinateSystem_0);

    // coordinate_3.setValue(new DoubleVector(new double[] {xo, yo+(width-yo)/2, depth}));

    // coordinate_3.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {xo, yo+(width-yo)/2, depth}));

    // linePart_1.setCoordinateSystem(labCoordinateSystem_0);



    // Region region_0 = 
    //   simulation_0.getRegionManager().getRegion("Block");

    // // linePart_1.getInputParts().setObjects(region_0);

    // // linePart_1.setResolution(200);

    // // scene_0.setTransparencyOverrideMode(0);

    // // linePart_1.setPresentationName("line_probe_inflow");





    XYPlot xYPlot_2 = 
      simulation_0.getPlotManager().createPlot(XYPlot.class);

    xYPlot_2.open();

    AxisType axisType_2 = 
      xYPlot_2.getXAxisType();

    axisType_2.getDirectionVector().setComponents(0.0, 0.0, 1.0);

    YAxisType yAxisType_3 = 
      ((YAxisType) xYPlot_2.getYAxes().getAxisType("Y Type 1"));

    FieldFunctionUnits fieldFunctionUnits_2 = 
      yAxisType_3.getScalarFunction();

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(0));

    fieldFunctionUnits_2.setFieldFunction(vectorComponentFieldFunction_0);

    xYPlot_2.setTitle("Inflow Conditions");

    xYPlot_2.getParts().setObjects(linePart_1);

    Cartesian2DAxisManager cartesian2DAxisManager_1 = 
      ((Cartesian2DAxisManager) xYPlot_2.getAxisManager());

    Cartesian2DAxis cartesian2DAxis_2 = 
      ((Cartesian2DAxis) cartesian2DAxisManager_1.getAxis("Left Axis"));

    cartesian2DAxisManager_1.setPreferredXAxis(cartesian2DAxis_2);

    Cartesian2DAxis cartesian2DAxis_3 = 
      ((Cartesian2DAxis) cartesian2DAxisManager_1.getAxis("Bottom Axis"));

    cartesian2DAxisManager_1.setPreferredYAxis(cartesian2DAxis_2);

    cartesian2DAxis_3.setPosition(Cartesian2DAxis.Position.Left);

    cartesian2DAxis_2.setPosition(Cartesian2DAxis.Position.Bottom);

    yAxisType_3.setSmooth(true);

    InternalDataSet internalDataSet_1 = 
      ((InternalDataSet) yAxisType_3.getDataSetManager().getDataSet("line_probe_inflow"));

    internalDataSet_1.setNeedsSorting(true);

    LineStyle lineStyle_1 = 
      internalDataSet_1.getLineStyle();

    lineStyle_1.getLinePatternOption().setSelected(LinePatternOption.Type.SOLID);

    lineStyle_1.setWidth(3);

    SymbolStyle symbolStyle_0 = 
      internalDataSet_1.getSymbolStyle();

    symbolStyle_0.setSize(10);

    xYPlot_2.setPresentationName("inflow_Ux");








    XYPlot xYPlot_3 = 
      simulation_0.getPlotManager().createPlot(XYPlot.class);

    xYPlot_3.open();

    xYPlot_3.setPresentationName("Copy of inflow_Ux");

    xYPlot_3.copyProperties(xYPlot_2);

    YAxisType yAxisType_4 = 
      ((YAxisType) xYPlot_3.getYAxes().getAxisType("Y Type 1"));

    FieldFunctionUnits fieldFunctionUnits_3 = 
      yAxisType_4.getScalarFunction();

    PrimitiveFieldFunction primitiveFieldFunction_1 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("TurbulentKineticEnergy"));

    fieldFunctionUnits_3.setFieldFunction(primitiveFieldFunction_1);

    xYPlot_3.setPresentationName("inflow_tke");





    XYPlot xYPlot_4 = 
      simulation_0.getPlotManager().createPlot(XYPlot.class);

    xYPlot_4.open();

    xYPlot_4.setPresentationName("Copy of inflow_Ux");

    xYPlot_4.copyProperties(xYPlot_3);

    xYPlot_4.setPresentationName("inflow_tdr");

    YAxisType yAxisType_5 = 
      ((YAxisType) xYPlot_4.getYAxes().getAxisType("Y Type 1"));

    FieldFunctionUnits fieldFunctionUnits_4 = 
      yAxisType_5.getScalarFunction();

    PrimitiveFieldFunction primitiveFieldFunction_2 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("SpecificDissipationRate"));

    fieldFunctionUnits_4.setFieldFunction(primitiveFieldFunction_2);





    XYPlot xYPlot_5 = 
      simulation_0.getPlotManager().createPlot(XYPlot.class);

    xYPlot_5.open();

    xYPlot_5.setPresentationName("Copy of inflow_Ux");

    xYPlot_5.copyProperties(xYPlot_3);

    xYPlot_5.setPresentationName("inflow_TI");

    YAxisType yAxisType_6 = 
      ((YAxisType) xYPlot_5.getYAxes().getAxisType("Y Type 1"));

    FieldFunctionUnits fieldFunctionUnits_5 = 
      yAxisType_6.getScalarFunction();

    // PrimitiveFieldFunction primitiveFieldFunction_3 = 
    //   ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Turbulence_Intensity_(local)"));

    // fieldFunctionUnits_5.setFieldFunction(primitiveFieldFunction_3);


    FieldFunctionUnits fieldFunctionUnits_8 = 
      yAxisType_6.getScalarFunction();

    UserFieldFunction userFieldFunction_2 = 
      ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("local_TI"));

    fieldFunctionUnits_8.setFieldFunction(userFieldFunction_2);


  }
}
