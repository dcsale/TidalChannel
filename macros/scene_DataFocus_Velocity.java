// STAR-CCM+ macro: scene_DataFocus_Velocity.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.vis.datafocus.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class scene_DataFocus_Velocity extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    DataFocus dataFocus_1 = 
      simulation_0.get(DataFocusManager.class).createDataFocus();

    dataFocus_1.setPresentationName("VelocityMag");

    RootCompoundDataFocusPredicate rootCompoundDataFocusPredicate_1 = 
      dataFocus_1.getRootPredicate();

    RangeDataFocusPredicate rangeDataFocusPredicate_1 = 
      rootCompoundDataFocusPredicate_1.getDataFocusPredicateManager().createDataFocusPredicate(RangeDataFocusPredicate.class);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    rangeDataFocusPredicate_1.setFieldFunction(vectorMagnitudeFieldFunction_0);

    rangeDataFocusPredicate_1.getMinimum().setValue(1.0);

    rangeDataFocusPredicate_1.getMaximum().setValue(3.0);

    new StarScript(getActiveSimulation(),

                   new java.io.File(resolvePath("scene_Mesh_Velocity.java"))).play();


    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("velocity 2");

    scene_1.open(true);

    ScalarDisplayer scalarDisplayer_1 = 
      ((ScalarDisplayer) scene_1.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_1.setDataFocus(dataFocus_1);

    CurrentView currentView_1 = 
      scene_1.getCurrentView();

    currentView_1.setInput(new DoubleVector(new double[] {566.9139028689426, 284.56708104957227, -35.35732001762776}), new DoubleVector(new double[] {160.99280274284536, -960.7612839751055, 855.3307478905991}), new DoubleVector(new double[] {-0.12896336122145058, 0.6043523440200658, 0.7862103381029263}), 404.5021674270079, 0);

    currentView_1.setInput(new DoubleVector(new double[] {473.6230762971755, 116.92255252604104, 82.56006801780461}), new DoubleVector(new double[] {158.12269198709203, -851.0034252944786, 774.843439436921}), new DoubleVector(new double[] {-0.12896336122145058, 0.6043523440200658, 0.7862103381029263}), 404.5021674270079, 0);

    currentView_1.setInput(new DoubleVector(new double[] {441.0005076585774, 123.54631488719508, 76.03527651042077}), new DoubleVector(new double[] {155.53959230691402, -752.2213524819144, 702.4048618286107}), new DoubleVector(new double[] {-0.12896336122145058, 0.6043523440200658, 0.7862103381029263}), 404.5021674270079, 0);

    currentView_1.setInput(new DoubleVector(new double[] {411.63949954729526, 129.50556471616642, 70.16449208285007}), new DoubleVector(new double[] {153.21480259475382, -663.3174869506067, 637.2101419811315}), new DoubleVector(new double[] {-0.12896336122145058, 0.6043523440200658, 0.7862103381029263}), 404.5021674270079, 0);

    currentView_1.setInput(new DoubleVector(new double[] {385.21390476106643, 134.86678041859352, 64.88229460706339}), new DoubleVector(new double[] {151.12249185380963, -583.3040079724298, 578.5348941184002}), new DoubleVector(new double[] {-0.12896336122145058, 0.6043523440200658, 0.7862103381029263}), 404.5021674270079, 0);

    currentView_1.setInput(new DoubleVector(new double[] {361.4301915664599, 139.6897948562023, 60.129804325215275}), new DoubleVector(new double[] {149.23941218695987, -511.2918768920705, 525.727171041942}), new DoubleVector(new double[] {-0.12896336122145058, 0.6043523440200658, 0.7862103381029263}), 404.5021674270079, 0);

    currentView_1.setInput(new DoubleVector(new double[] {340.024182198396, 144.0284600435577, 55.85402771080646}), new DoubleVector(new double[] {147.5446404867951, -446.48095891974714, 478.2002202731297}), new DoubleVector(new double[] {-0.12896336122145058, 0.6043523440200658, 0.7862103381029263}), 404.5021674270079, 0);

    currentView_1.setInput(new DoubleVector(new double[] {301.6768141251772, 152.40086128719463, 47.75509924499681}), new DoubleVector(new double[] {144.4940514264985, -329.82130656956514, 392.6517088892674}), new DoubleVector(new double[] {-0.12896336122145058, 0.6043523440200658, 0.7862103381029263}), 404.5021674270079, 0);

    currentView_1.setInput(new DoubleVector(new double[] {270.992259457569, 159.0783493772281, 41.29057056536817}), new DoubleVector(new double[] {142.0535801782612, -236.49358468941955, 324.2128997821776}), new DoubleVector(new double[] {-0.12896336122145058, 0.6043523440200658, 0.7862103381029263}), 404.5021674270079, 0);

    currentView_1.setInput(new DoubleVector(new double[] {233.77904008482176, 64.1034875606213, 102.02456035917014}), new DoubleVector(new double[] {-49.39167518844251, -250.40082802518236, 119.20398090183444}), new DoubleVector(new double[] {-0.30092836115684285, 0.32006770178352617, 0.8983311125228095}), 404.5021674270079, 0);

    XYPlot xYPlot_3 = 
      simulation_0.getPlotManager().createXYPlot();

    xYPlot_3.open();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Block.Inlet");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Block.Left Bank");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Block.Outlet");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Block.Right Bank");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Block.Sea Surface");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Block.Seabed");

    xYPlot_3.getParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5);

    AxisType axisType_0 = 
      xYPlot_3.getXAxisType();

    axisType_0.setMode(1);

    FieldFunctionUnits fieldFunctionUnits_0 = 
      axisType_0.getScalarFunction();

    fieldFunctionUnits_0.setFieldFunction(vectorMagnitudeFieldFunction_0);

    YAxisType yAxisType_0 = 
      ((YAxisType) xYPlot_3.getYAxes().getAxisType("Y Type 1"));

    FieldFunctionUnits fieldFunctionUnits_1 = 
      yAxisType_0.getScalarFunction();

    UserFieldFunction userFieldFunction_1 = 
      ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("14.TI"));

    fieldFunctionUnits_1.setFieldFunction(userFieldFunction_1);

    yAxisType_0.setSmooth(true);

    yAxisType_0.setDataFocus(dataFocus_1);

    Cartesian2DAxisManager cartesian2DAxisManager_0 = 
      ((Cartesian2DAxisManager) xYPlot_3.getAxisManager());

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.08295630462912215, true, 1.1523149345916126, true), new star.common.AxisManager.AxisBounds("Left Axis", -0.36639175117015843, true, 0.5336082488298416, true))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.1576169787953321, true, 1.1200397457615734, true), new star.common.AxisManager.AxisBounds("Left Axis", -0.33614432722330095, true, 0.47385567277669904, true))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.22481158554492103, true, 1.0909920758145382, true), new star.common.AxisManager.AxisBounds("Left Axis", -0.30892164567112923, true, 0.42007835432887075, true))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.2851337360769733, true, 1.0646961773196286, true), new star.common.AxisManager.AxisBounds("Left Axis", -0.2844212322741747, true, 0.3716787677258253, true))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.23084380059812626, true, 1.0883624859650471, true), new star.common.AxisManager.AxisBounds("Left Axis", -0.3064716043314338, true, 0.41523839566856624, true))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.17112487157139455, true, 1.1143954254750075, true), new star.common.AxisManager.AxisBounds("Left Axis", -0.33072701359441875, true, 0.46315398640558125, true))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.10543404964198967, true, 1.143031658935964, true), new star.common.AxisManager.AxisBounds("Left Axis", -0.35740796378370226, true, 0.5158611362162978, true))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.03299087215919036, true, 1.174348242382562, true), new star.common.AxisManager.AxisBounds("Left Axis", -0.3867570089919141, true, 0.5738390010080859, true))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.0, false, 1.1881762555138782, false), new star.common.AxisManager.AxisBounds("Left Axis", -0.4, false, 0.6, false))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.0, false, 1.1881762555138782, false), new star.common.AxisManager.AxisBounds("Left Axis", -0.4, false, 0.6, false))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.0, false, 1.1881762555138782, false), new star.common.AxisManager.AxisBounds("Left Axis", -0.4, false, 0.6, false))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.0, false, 1.1881762555138782, false), new star.common.AxisManager.AxisBounds("Left Axis", -0.4, false, 0.6, false))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.0, false, 1.1881762555138782, false), new star.common.AxisManager.AxisBounds("Left Axis", -0.4, false, 0.6, false))));

    xYPlot_3.getParts().setObjects(region_0);

    UserFieldFunction userFieldFunction_0 = 
      ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Turbulence_Intensity_Ratio"));

    fieldFunctionUnits_1.setFieldFunction(userFieldFunction_0);

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.0, false, 1.1881762555138782, false), new star.common.AxisManager.AxisBounds("Left Axis", 0.0, false, 2.612017759892371, false))));

    dataFocus_1.addBrush(DataFocus.BrushMode.IntersectBrush, new Vector(Arrays.asList(new star.vis.datafocus.DataFocus.BrushRange(0.5805244718720775, 0.7948302348528911, ((Units) simulation_0.getUnitsManager().getObject("m/s")), ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction())), new star.vis.datafocus.DataFocus.BrushRange(1.1632903837871178, 2.100385415171185, ((Units) simulation_0.getUnitsManager().getObject("")), ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Turbulence_Intensity_Ratio"))))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.0, false, 1.1881762555138782, false), new star.common.AxisManager.AxisBounds("Left Axis", 0.0, false, 2.612017759892371, false))));

    yAxisType_0.setDataFocus(dataFocus_1);

    scalarDisplayer_1.setDataFocus(dataFocus_1);

    currentView_1.setInput(new DoubleVector(new double[] {227.51623561561374, 56.70255628705877, 103.83410943005168}), new DoubleVector(new double[] {56.31166886678306, -218.06602045284998, 385.78871956549636}), new DoubleVector(new double[] {0.003833289104091614, 0.7149004660719586, 0.6992157245834371}), 404.5021674270079, 0);

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.0, false, 1.1881762555138782, false), new star.common.AxisManager.AxisBounds("Left Axis", 0.0, false, 2.612017759892371, false))));

    CompoundDataFocusPredicate compoundDataFocusPredicate_0 = 
      ((CompoundDataFocusPredicate) rootCompoundDataFocusPredicate_1.getDataFocusPredicateManager().getDataFocusPredicate("Compound 2"));

    star.vis.datafocus.RangeDataFocusPredicate.setRanges(new Vector(Arrays.asList(new star.vis.datafocus.RangeDataFocusPredicate.PredicateRange(((RangeDataFocusPredicate) compoundDataFocusPredicate_0.getDataFocusPredicateManager().getDataFocusPredicate("Velocity: Magnitude Range")), 0.5805244445800781, 1.1718999147415161, ((Units) simulation_0.getUnitsManager().getObject("m/s"))), new star.vis.datafocus.RangeDataFocusPredicate.PredicateRange(((RangeDataFocusPredicate) compoundDataFocusPredicate_0.getDataFocusPredicateManager().getDataFocusPredicate("Turbulence_Intensity_Ratio Range")), 0.721670925617218, 2.1003854274749756, ((Units) simulation_0.getUnitsManager().getObject(""))))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.0, false, 1.1881762555138782, false), new star.common.AxisManager.AxisBounds("Left Axis", 0.0, false, 2.612017759892371, false))));

    CompoundDataFocusPredicate compoundDataFocusPredicate_1 = 
      ((CompoundDataFocusPredicate) rootCompoundDataFocusPredicate_1.getDataFocusPredicateManager().getDataFocusPredicate("Compound"));

    star.vis.datafocus.RangeDataFocusPredicate.setRanges(new Vector(Arrays.asList(new star.vis.datafocus.RangeDataFocusPredicate.PredicateRange(((RangeDataFocusPredicate) compoundDataFocusPredicate_1.getDataFocusPredicateManager().getDataFocusPredicate("Velocity: Magnitude Range")), 0.6429173350334167, 3.0, ((Units) simulation_0.getUnitsManager().getObject("m/s"))))));

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.0, false, 1.1881762555138782, false), new star.common.AxisManager.AxisBounds("Left Axis", 0.0, false, 2.612017759892371, false))));

    star.vis.datafocus.RangeDataFocusPredicate.setRanges(new Vector(Arrays.asList(new star.vis.datafocus.RangeDataFocusPredicate.PredicateRange(((RangeDataFocusPredicate) compoundDataFocusPredicate_0.getDataFocusPredicateManager().getDataFocusPredicate("Velocity: Magnitude Range")), 0.6863210201263428, 1.1718999147415161, ((Units) simulation_0.getUnitsManager().getObject("m/s"))), new star.vis.datafocus.RangeDataFocusPredicate.PredicateRange(((RangeDataFocusPredicate) compoundDataFocusPredicate_0.getDataFocusPredicateManager().getDataFocusPredicate("Turbulence_Intensity_Ratio Range")), 0.721670925617218, 1.5241258144378662, ((Units) simulation_0.getUnitsManager().getObject(""))))));

    scalarDisplayer_1.setVisibilityOverrideMode(2);

    scalarDisplayer_1.setVisibilityOverrideMode(0);

    currentView_1.setInput(new DoubleVector(new double[] {266.06080232043763, 122.65667538127067, 48.22544952144947}), new DoubleVector(new double[] {51.56454614345887, -404.68425739011707, 49.610324026715226}), new DoubleVector(new double[] {-0.29059734678753296, 0.12013272220428249, 0.949274096926612}), 404.5021674270079, 0);

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.asList(new star.common.AxisManager.AxisBounds("Bottom Axis", 0.0, false, 1.1881762555138782, false), new star.common.AxisManager.AxisBounds("Left Axis", 0.0, false, 2.612017759892371, false))));

    star.vis.datafocus.RangeDataFocusPredicate.setRanges(new Vector(Arrays.asList(new star.vis.datafocus.RangeDataFocusPredicate.PredicateRange(((RangeDataFocusPredicate) compoundDataFocusPredicate_0.getDataFocusPredicateManager().getDataFocusPredicate("Velocity: Magnitude Range")), 0.3770696520805359, 0.8626485466957092, ((Units) simulation_0.getUnitsManager().getObject("m/s"))), new star.vis.datafocus.RangeDataFocusPredicate.PredicateRange(((RangeDataFocusPredicate) compoundDataFocusPredicate_0.getDataFocusPredicateManager().getDataFocusPredicate("Turbulence_Intensity_Ratio Range")), 1.7664780616760254, 2.5689330101013184, ((Units) simulation_0.getUnitsManager().getObject(""))))));

    currentView_1.setInput(new DoubleVector(new double[] {250.92968478484892, 80.95745709350601, 74.00499324240323}), new DoubleVector(new double[] {185.02788544907276, -169.9154855448673, 583.6017467517349}), new DoubleVector(new double[] {-0.010445443450436326, 0.8976684315607003, 0.44054770421655354}), 404.5021674270079, 0);
  }
}
