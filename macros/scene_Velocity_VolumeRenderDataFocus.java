// STAR-CCM+ macro: scene_Velocity_VolumeRenderDataFocus.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class scene_Velocity_VolumeRenderDataFocus extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar");

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_6.initializeAndWait();

    PartDisplayer partDisplayer_5 = 
      ((PartDisplayer) scene_6.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_5.initialize();

    ScalarDisplayer scalarDisplayer_3 = 
      ((ScalarDisplayer) scene_6.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_3.initialize();

    scene_6.open(true);

    scene_6.resetCamera();

    scene_6.setPresentationName("vel_vol_render");

    Units units_1 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    scene_6.setTransparencyOverrideMode(1);

    PartDisplayer partDisplayer_6 = 
      ((PartDisplayer) scene_6.getCreatorDisplayer());

    partDisplayer_6.initialize();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    scene_6.getCreatorGroup().setObjects(region_0);

    CurrentView currentView_3 = 
      scene_6.getCurrentView();

    currentView_3.setInput(new DoubleVector(new double[] {397.9809565349888, 68.09573275842155, 191.55189770328835}), new DoubleVector(new double[] {364.8869641978974, -1438.3003248529474, 945.9358642961382}), new DoubleVector(new double[] {-0.01212341755497846, 0.44816203752052813, 0.8938701308759771}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {396.0093443190633, 67.1653840338895, 176.596462074805}), new DoubleVector(new double[] {366.1103505803526, -1293.7984379121451, 858.1498166534104}), new DoubleVector(new double[] {-0.01212341755497846, 0.44816203752052813, 0.8938701308759771}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {393.3710235848174, 66.59417077555281, 162.45027262128826}), new DoubleVector(new double[] {366.348595572866, -1163.4320711374585, 778.43175418397}), new DoubleVector(new double[] {-0.01212341755497846, 0.44816203752052813, 0.8938701308759771}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {387.9900189084102, 61.108208475736205, 138.51505046739152}), new DoubleVector(new double[] {366.26002067649904, -928.0134222730861, 633.8545698964772}), new DoubleVector(new double[] {-0.01212341755497846, 0.44816203752052813, 0.8938701308759771}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {385.1811136813545, 147.31169309905522, 83.26937853040477}), new DoubleVector(new double[] {363.8142549190337, -825.2802950553622, 570.3310633994996}), new DoubleVector(new double[] {-0.01212341755497846, 0.44816203752052813, 0.8938701308759771}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {380.85588210514976, 143.08782384172002, 74.51618055422148}), new DoubleVector(new double[] {361.61306573731497, -732.8204805594107, 513.1599075522198}), new DoubleVector(new double[] {-0.01212341755497846, 0.44816203752052813, 0.8938701308759771}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {375.64490231356035, 144.14540456382747, 64.02179120486323}), new DoubleVector(new double[] {358.2175373888991, -649.1258801352014, 461.28195084997486}), new DoubleVector(new double[] {-0.01212341755497846, 0.44816203752052813, 0.8938701308759771}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {370.8581451995734, 140.68758781881002, 56.78513205698471}), new DoubleVector(new double[] {355.16156187532476, -573.8007397534132, 414.5917898179544}), new DoubleVector(new double[] {-0.01212341755497846, 0.44816203752052813, 0.8938701308759771}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {366.5500629813116, 137.575515619881, 50.27215741733073}), new DoubleVector(new double[] {352.4111839131079, -506.0081134098036, 372.570644889136}), new DoubleVector(new double[] {-0.01212341755497846, 0.44816203752052813, 0.8938701308759771}), 431.53794734646476, 0);

    ScalarDisplayer scalarDisplayer_4 = 
      scene_6.getDisplayerManager().createScalarDisplayer("Resampled Volume Scalar");

    scalarDisplayer_4.initialize();

    scene_6.setTransparencyOverrideMode(1);

    ResampledVolumePart resampledVolumePart_0 = 
      simulation_0.getPartManager().createResampledVolumePart(new NeoObjectVector(new Object[] {region_0}), 2.0, 0.001, new DoubleVector(new double[] {400.0, 160.0, 25.0}), new DoubleVector(new double[] {800.0, 320.0, 50.0}), new DoubleVector(new double[] {1.0, 0.0, 0.0}), 0.0);

    Coordinate coordinate_1 = 
      resampledVolumePart_0.getOriginCoordinate();

    coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {400.0, 160.0, 25.0}));

    coordinate_1.setValue(new DoubleVector(new double[] {400.0, 160.0, 25.0}));

    Coordinate coordinate_2 = 
      resampledVolumePart_0.getSizeCoordinate();

    coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {800.0, 320.0, 50.0}));

    coordinate_2.setValue(new DoubleVector(new double[] {800.0, 320.0, 50.0}));

    Coordinate coordinate_3 = 
      resampledVolumePart_0.getRotationAxisCoordinate();

    coordinate_3.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_3.setValue(new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    resampledVolumePart_0.getRotationAngle().setUnits(units_1);

    resampledVolumePart_0.getRotationAngle().setValue(0.0);

    resampledVolumePart_0.getMinimumVoxelSize().setUnits(units_0);

    resampledVolumePart_0.getMinimumVoxelSize().setValue(0.001);

    scalarDisplayer_4.getVisibleParts().addParts(resampledVolumePart_0);

    scene_6.setTransparencyOverrideMode(0);

    resampledVolumePart_0.setPresentationName("resampled_volume");

    scalarDisplayer_3.getInputParts().setQuery(null);

    scalarDisplayer_3.getInputParts().setObjects(resampledVolumePart_0);

    scalarDisplayer_4.setVisibilityOverrideMode(2);

    PrimitiveFieldFunction primitiveFieldFunction_4 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorComponentFieldFunction vectorComponentFieldFunction_5 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_4.getComponentFunction(0));

    scalarDisplayer_3.getScalarDisplayQuantity().setFieldFunction(vectorComponentFieldFunction_5);

    Legend legend_0 = 
      scalarDisplayer_3.getLegend();

    PredefinedLookupTable predefinedLookupTable_0 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("purple-red (large difference)"));

    legend_0.setLookupTable(predefinedLookupTable_0);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.8, 2.1751902103424072}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.8, 2.1}));

    currentView_3.setInput(new DoubleVector(new double[] {417.048469297594, 322.5366694088399, 10.543195286030194}), new DoubleVector(new double[] {144.55766088664893, -441.7914498999638, 101.95006225482756}), new DoubleVector(new double[] {-0.07150329957516863, 0.14192221997435944, 0.9872919333345194}), 431.53794734646476, 0);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.6, 2.1}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.6, 1.5}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.6, 1.6}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.6, 1.8}));

    currentView_3.setInput(new DoubleVector(new double[] {390.7998063700397, 231.26972236915344, 19.666843706958034}), new DoubleVector(new double[] {-300.5060684814123, -366.2813031725369, 215.81332650522648}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {390.4588961522038, 233.8790431717319, 12.053026707571462}), new DoubleVector(new double[] {-233.94592709924794, -305.84404621653294, 189.2174547537878}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {390.11113359335724, 236.22257116203264, 5.2652015856205026}), new DoubleVector(new double[] {-173.8250583188912, -251.23263799505725, 165.27266657354008}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {389.76157990947513, 238.32760291785314, -0.7848926355117953}), new DoubleVector(new double[] {-119.5245399012814, -201.8891726917264, 143.7165281868164}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {389.34815509518046, 240.1279953578165, -5.941608668376404}), new DoubleVector(new double[] {-70.43518361576754, -157.29956249817067, 124.51422574323817}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {388.8450594626928, 241.71906599151032, -10.273581010787026}), new DoubleVector(new double[] {-26.10967876671451, -116.95954271501472, 107.4628875844841}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {388.304316341839, 243.19168410575782, -14.0239882952593}), new DoubleVector(new double[] {13.86222336723393, -80.46860116381441, 92.21769461300902}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {386.8696343679767, 248.70756306675204, -16.65887794432004}), new DoubleVector(new double[] {47.63898015928202, -44.51665604051627, 79.59214797772779}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {382.31663507505607, 257.0593860487231, -20.709638208659385}), new DoubleVector(new double[] {108.84447460325538, 20.6754988408493, 56.88351465050539}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {381.2552663830947, 261.16826646298324, -22.473263390458705}), new DoubleVector(new double[] {133.49398427060646, 47.00835027876971, 47.824857640838395}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {386.97970311322797, 259.89402779300974, -22.432218706232703}), new DoubleVector(new double[] {111.9191917773907, 22.137201742501148, 55.61160215209715}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {390.5260924461485, 256.1148955721452, -21.606663702832705}), new DoubleVector(new double[] {88.18692003485334, -5.221061647394276, 64.17702111448178}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {394.42713946761154, 251.95786634085908, -20.698558520581415}), new DoubleVector(new double[] {62.08142111806226, -35.31515137627924, 73.59898197310487}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {398.7183099694338, 247.38515041795753, -19.69964814810892}), new DoubleVector(new double[] {33.36537230959207, -68.4186500780527, 83.96313891759027}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {403.43861632041956, 242.35517915223068, -18.60085207228579}), new DoubleVector(new double[] {1.7777186202748574, -104.83249865000352, 95.36371155652421}), new DoubleVector(new double[] {0.02572093285428924, 0.2846958893282556, 0.9582727608633665}), 431.53794734646476, 0);

    UserFieldFunction userFieldFunction_5 = 
      ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Turbulence_Intensity_Ratio"));

    scalarDisplayer_3.getScalarDisplayQuantity().setFieldFunction(userFieldFunction_5);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.7553624510765076, 1.5}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.1, 1.5}));

    currentView_3.setInput(new DoubleVector(new double[] {434.3582081795541, 278.5839831716827, -28.183763597847623}), new DoubleVector(new double[] {100.18164163716851, -163.20106406716954, 79.68173186052033}), new DoubleVector(new double[] {-0.011283628225301726, 0.2451727488311914, 0.9694137418897211}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {469.3172823330559, 294.45851022404975, -27.87255317286035}), new DoubleVector(new double[] {82.14140242565065, -217.39220439792297, 97.10005800646005}), new DoubleVector(new double[] {-0.011283628225301726, 0.2451727488311914, 0.9694137418897211}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {486.4229020342136, 283.6964019229762, -20.6390757479969}), new DoubleVector(new double[] {62.297139292981015, -277.00245876175177, 116.26021676699374}), new DoubleVector(new double[] {-0.011283628225301726, 0.2451727488311914, 0.9694137418897211}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {505.2398805405104, 271.8591362163428, -12.682507783016092}), new DoubleVector(new double[] {40.46844984704441, -342.5737385619634, 137.3363914035808}), new DoubleVector(new double[] {-0.011283628225301726, 0.2451727488311914, 0.9694137418897211}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {547.0280603961321, 246.33382938417333, 4.695790574641023}), new DoubleVector(new double[] {-7.554666934016112, -486.830554122429, 183.70397560407233}), new DoubleVector(new double[] {-0.011283628225301726, 0.2451727488311914, 0.9694137418897211}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {571.8688741980308, 230.71181435096616, 15.1976849149452}), new DoubleVector(new double[] {-36.368537002652424, -573.3846434587084, 211.52452612436724}), new DoubleVector(new double[] {-0.011283628225301726, 0.2451727488311914, 0.9694137418897211}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {599.1946019076703, 213.5286984248944, 26.749499966078503}), new DoubleVector(new double[] {-68.06379407815237, -668.5941417286158, 242.12713169669166}), new DoubleVector(new double[] {-0.011283628225301726, 0.2451727488311914, 0.9694137418897211}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {629.2537388342234, 194.62837669683745, 39.45622653434333}), new DoubleVector(new double[] {-102.92857686120232, -773.3245898255138, 275.7899978262485}), new DoubleVector(new double[] {-0.011283628225301726, 0.2451727488311914, 0.9694137418897211}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {597.0193863349629, 216.51692252647422, 25.210694611583875}), new DoubleVector(new double[] {-64.57731579984738, -658.121096918926, 238.76084508373597}), new DoubleVector(new double[] {-0.011283628225301726, 0.2451727488311914, 0.9694137418897211}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {568.0066622149745, 236.21422507053626, 12.390299102719723}), new DoubleVector(new double[] {-30.06118084462794, -554.4379533029969, 205.4346076154747}), new DoubleVector(new double[] {-0.011283628225301726, 0.2451727488311914, 0.9694137418897211}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {541.8934215625786, 253.93943235627415, 0.8525205801281572}), new DoubleVector(new double[] {1.003340615069554, -461.1231240486607, 175.44099389403954}), new DoubleVector(new double[] {-0.011283628225301726, 0.2451727488311914, 0.9694137418897211}), 431.53794734646476, 0);

    MonitorPlot monitorPlot_6 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("rotor speed"));

    monitorPlot_6.close();

    MonitorPlot monitorPlot_5 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("rotors-torque"));

    monitorPlot_5.close();

    MonitorPlot monitorPlot_4 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("rotors-thrust"));

    monitorPlot_4.close();

    MonitorPlot monitorPlot_3 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("rotors-inflow"));

    monitorPlot_3.close();

    MonitorPlot monitorPlot_2 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("probes-velocity-z"));

    monitorPlot_2.close();

    MonitorPlot monitorPlot_1 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("probes-velocity-y"));

    monitorPlot_1.close();

    MonitorPlot monitorPlot_0 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("probes-velocity-x"));

    monitorPlot_0.close();

    ResidualPlot residualPlot_0 = 
      ((ResidualPlot) simulation_0.getPlotManager().getPlot("Residuals"));

    residualPlot_0.close();

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("AMR_UpdateCellSizes");

    scene_2.close(true);

    Scene scene_7 = 
      simulation_0.getSceneManager().getScene("Turbulence_Intensity_Ratio");

    scene_7.close(true);

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Mesh");

    scene_1.close(true);

    XYPlot xYPlot_6 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("line_probe_TI"));

    xYPlot_6.close();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("velocity");

    scene_0.close(true);

    Scene scene_8 = 
      simulation_0.getSceneManager().getScene("TI_local");

    scene_8.close(true);

    MonitorPlot monitorPlot_7 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Tip-Speed-Ratio"));

    monitorPlot_7.close();

    MonitorPlot monitorPlot_8 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Power"));

    monitorPlot_8.close();

    XYPlot xYPlot_5 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("line_probe_TI_ratio"));

    xYPlot_5.close();

    XYPlot xYPlot_4 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("line_probe_Ux"));

    xYPlot_4.close();

    XYPlot xYPlot_2 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("inflow_Ux"));

    xYPlot_2.close();

    XYPlot xYPlot_0 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("inflow_tke"));

    xYPlot_0.close();

    XYPlot xYPlot_1 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("inflow_tdr"));

    xYPlot_1.close();

    xYPlot_6.open();

    xYPlot_5.open();

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.0, 1.5}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.0, 1.1}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.0, 1.05}));

    currentView_3.setInput(new DoubleVector(new double[] {574.445046785982, 294.64737892653, -12.171376501861566}), new DoubleVector(new double[] {-12.267521975739784, -439.62414056787884, 221.9780728339403}), new DoubleVector(new double[] {0.02186149310466942, 0.2878117273809777, 0.9574374573313978}), 431.53794734646476, 0);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.01, 1.05}));

    currentView_3.setInput(new DoubleVector(new double[] {692.7623108020811, 504.8872834629589, -82.92236806795731}), new DoubleVector(new double[] {215.2830856455151, -443.32469188719074, 240.37531264768663}), new DoubleVector(new double[] {0.034818835188003605, 0.30822463452166193, 0.950676192712397}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {694.9177020301574, 618.9674945805408, -125.45803678138881}), new DoubleVector(new double[] {217.51923772629775, -329.08410016320556, 197.78496135332395}), new DoubleVector(new double[] {0.034818835188003605, 0.30822463452166193, 0.950676192712397}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {696.8686232906307, 732.1798123497653, -167.59376283755253}), new DoubleVector(new double[] {219.94986642995065, -214.91914546587483, 155.3244289063666}), new DoubleVector(new double[] {0.034818835188003605, 0.30822463452166193, 0.950676192712397}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {698.6153830976888, 844.4339995474351, -209.2959463760124}), new DoubleVector(new double[] {222.5727117975018, -100.92516567383937, 113.02905426158583}), new DoubleVector(new double[] {0.034818835188003605, 0.30822463452166193, 0.950676192712397}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {658.4863212847222, 862.6496871670929, -218.59237175477116}), new DoubleVector(new double[] {224.93327262829783, 1.6694161389925455, 74.96321708128315}), new DoubleVector(new double[] {0.034818835188003605, 0.30822463452166193, 0.950676192712397}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {622.3651228283966, 879.0337916273493, -226.95574013607228}), new DoubleVector(new double[] {227.05777737601426, 94.00453977054127, 40.703963619010736}), new DoubleVector(new double[] {0.034818835188003605, 0.30822463452166193, 0.950676192712397}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {655.5066399081584, 865.5440386016435, -219.85692804093745}), new DoubleVector(new double[] {225.14572310306949, 10.902928502147418, 71.5372917350559}), new DoubleVector(new double[] {0.034818835188003605, 0.30822463452166193, 0.950676192712397}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {691.9653144683191, 850.7112793485772, -212.05026992274708}), new DoubleVector(new double[] {223.04246340283024, -80.50884389308582, 105.45395266270559}), new DoubleVector(new double[] {0.034818835188003605, 0.30822463452166193, 0.950676192712397}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {732.0729154325845, 834.4013188454088, -203.4650171840491}), new DoubleVector(new double[] {220.72887773256704, -181.06179352784238, 142.76227968312025}), new DoubleVector(new double[] {0.034818835188003605, 0.30822463452166193, 0.950676192712397}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {730.6949170260016, 829.8138292550069, -201.8555420454037}), new DoubleVector(new double[] {88.45083821190026, -140.1309558183988, 124.38344858057002}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {768.0762398523805, 844.1940278382971, -196.7438515282803}), new DoubleVector(new double[] {45.641520533129366, -246.85813079515341, 170.22936223659258}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {791.7897861491322, 833.7250899808757, -182.27935945685095}), new DoubleVector(new double[] {-1.4487289135186217, -364.2580232695835, 220.6598672582174}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {817.874972394979, 822.2096892394402, -166.36856311121403}), new DoubleVector(new double[] {-53.24800330483141, -493.3979049914565, 276.1334227820047}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {846.5689634294948, 809.543180601238, -148.8668324930107}), new DoubleVector(new double[] {-110.22720513527547, -635.4517748855169, 337.15433385817073}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {815.4707018303503, 824.178797339539, -168.35500626103135}), new DoubleVector(new double[] {-47.550083121787004, -479.1925180020505, 270.03133167438807}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    scalarDisplayer_3.getScalarDisplayQuantity().setClip(2);

    scalarDisplayer_3.getScalarDisplayQuantity().setClip(1);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.02, 1.05}));

    scalarDisplayer_3.getScalarDisplayQuantity().setClip(2);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.02, 2.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.01, 2.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.0, 2.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.9, 2.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.02, 2.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.2, 2.0}));

    scene_7.open(true);

    CurrentView currentView_4 = 
      scene_7.getCurrentView();

    currentView_4.setInput(new DoubleVector(new double[] {634.5991145579088, 130.3240983428281, -100.23303164433764}), new DoubleVector(new double[] {634.5991145579088, 130.3240983428281, 2179.1318835657125}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1040.111173394782, 0);

    currentView_4.setInput(new DoubleVector(new double[] {601.0675230441475, 113.44943378233133, -131.27500262056424}), new DoubleVector(new double[] {601.0675230441475, 113.44943378233133, 1951.1953920447074}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1040.111173394782, 0);

    currentView_4.setInput(new DoubleVector(new double[] {567.2992412917383, 109.87073000965754, -0.10711121039889804}), new DoubleVector(new double[] {567.2992412917383, 109.87073000965754, 1759.0758455056105}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1040.111173394782, 0);

    currentView_4.setInput(new DoubleVector(new double[] {534.9257380245663, 110.6139992173222, -0.3916123483747924}), new DoubleVector(new double[] {534.9257380245663, 110.6139992173222, 1586.1682623276038}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1040.111173394782, 0);

    currentView_4.setInput(new DoubleVector(new double[] {504.8976619121008, 113.3640952969292, 0.7368713711850887}), new DoubleVector(new double[] {504.8976619121008, 113.3640952969292, 1430.551436830934}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1040.111173394782, 0);

    currentView_4.setInput(new DoubleVector(new double[] {477.6048174188484, 116.37433549839085, 3.0444301406153045}), new DoubleVector(new double[] {477.6048174188484, 116.37433549839085, 1290.4962986245794}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1040.111173394782, 0);

    currentView_4.setInput(new DoubleVector(new double[] {448.70650784411225, 121.85297335526792, -4.232402775092169}), new DoubleVector(new double[] {448.70650784411225, 121.85297335526792, 1164.4466583587111}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1040.111173394782, 0);

    currentView_4.setInput(new DoubleVector(new double[] {422.58966197022346, 126.67537850625568, -1.0083001487635102}), new DoubleVector(new double[] {422.58966197022346, 126.67537850625568, 1051.0019882192464}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1040.111173394782, 0);

    currentView_4.setInput(new DoubleVector(new double[] {399.08450068372355, 131.01554314214468, -1.3089808322156387}), new DoubleVector(new double[] {399.08450068372355, 131.01554314214468, 948.9017850937282}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1040.111173394782, 0);

    currentView_4.setInput(new DoubleVector(new double[] {377.9298555258736, 134.92169131444476, -1.5785213525700783}), new DoubleVector(new double[] {377.9298555258736, 134.92169131444476, 857.0116022807618}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1040.111173394782, 0);

    currentView_4.setInput(new DoubleVector(new double[] {378.1258382733907, 135.69438735770217, 40.68403381724416}), new DoubleVector(new double[] {317.9668540621485, -101.49286333355172, 847.4620187202529}), new DoubleVector(new double[] {-0.010268093823285227, 0.959532812229127, 0.2814095742950105}), 1040.111173394782, 0);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.1, 2.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.8, 2.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.5, 2.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {1.1, 2.0}));

    UserFieldFunction userFieldFunction_6 = 
      ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("local_TI"));

    scalarDisplayer_3.getScalarDisplayQuantity().setFieldFunction(userFieldFunction_6);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.1, 0.24081559479236603}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.12, 0.24081559479236603}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.101, 0.24081559479236603}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.101, 0.15}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.101, 0.12}));

    currentView_3.setInput(new DoubleVector(new double[] {257.45410981247716, -2.9849604111557824, 98.93398842441894}), new DoubleVector(new double[] {-26.135222394076926, -431.27383523286517, 242.98809580084458}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {254.70233085745906, 1.7871874359999538, 94.38979603131784}), new DoubleVector(new double[] {-2.439309556235294, -386.55923936955844, 225.00934081773653}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {250.5244214838307, 3.512731100375049, 91.16423186823387}), new DoubleVector(new double[] {18.887011997822178, -346.3161030925824, 208.82846133293927}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {246.76428601813234, 5.065694679726562, 88.26123277185334}), new DoubleVector(new double[] {38.0807013964739, -310.097280443304, 194.26566979662175}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {243.38014710707228, 6.463336239193097, 85.64854221645645}), new DoubleVector(new double[] {55.355021855260446, -277.5003400589534, 181.159157413936}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {241.85009679206942, 19.048409547780068, 79.69160932986406}), new DoubleVector(new double[] {66.83398920357556, -245.26848563132177, 168.59406894986762}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {235.31494717859297, 22.584983276828012, 76.9505180613034}), new DoubleVector(new double[] {77.16505981705916, -216.25981664645332, 157.2854893322061}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {223.6754532777563, 29.1377469566838, 71.9536799204179}), new DoubleVector(new double[] {95.76098692132963, -164.0442124736901, 136.93004602041538}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {218.96948234791188, 31.68307843597924, 69.98043109510309}), new DoubleVector(new double[] {103.19935776303782, -143.1579708045848, 128.78786869569907}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {210.5857735445274, 36.396124965148886, 66.38437030958119}), new DoubleVector(new double[] {116.58842527811257, -105.5627358001953, 114.13194951120974}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {203.87651976214596, 40.163108655326965, 63.508683270141475}), new DoubleVector(new double[] {127.29967929017236, -75.4865477966837, 102.40721416361828}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {201.1649283988799, 41.62778167321039, 62.37257558632544}), new DoubleVector(new double[] {131.58418089499628, -63.45607259527905, 97.7173200245817}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {194.00344546491374, 45.82375645398419, 59.22390468253823}), new DoubleVector(new double[] {143.15233522802086, -30.97378955148652, 85.05460584918292}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {192.29436797383585, 46.74533011909568, 58.50855048196169}), new DoubleVector(new double[] {145.85157123905992, -23.394590174601596, 82.09997254158986}), new DoubleVector(new double[] {0.030356056344455568, 0.3005387549273755, 0.9532864032545074}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {187.17418242179184, 40.802356768326014, 60.64500646745416}), new DoubleVector(new double[] {107.70668531926869, -0.09238594437964998, 80.4799127834631}), new DoubleVector(new double[] {0.06460079857654104, 0.33110273670367557, 0.9413807489908691}), 431.53794734646476, 0);

    PredefinedLookupTable predefinedLookupTable_1 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("gray-darkred"));

    legend_0.setLookupTable(predefinedLookupTable_1);

    UserLookupTable userLookupTable_0 = 
      simulation_0.get(LookupTableManager.class).createLookupTable();

    userLookupTable_0.setColorMap(new ColorMap(new DoubleVector(new double[] {0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0}), new DoubleVector(new double[] {0.0, 1.0, 0.1580547112462006, 1.0, 0.20972644376899696, 0.0, 0.2674772036474164, 1.0, 0.46504559270516715, 1.0, 0.48328267477203646, 0.0, 0.5167173252279635, 1.0, 0.7416413373860182, 1.0, 0.7781155015197568, 0.29, 0.8267477203647416, 1.0, 1.0, 1.0}), 1));

    userLookupTable_0.setPresentationName("volume_render");

    legend_0.setLookupTable(userLookupTable_0);

    currentView_3.setInput(new DoubleVector(new double[] {203.22603039055474, 43.44715752879565, 59.55646758355718}), new DoubleVector(new double[] {102.48626942126158, -8.394497940279232, 84.70088252020959}), new DoubleVector(new double[] {0.06460079857654104, 0.33110273670367557, 0.9413807489908691}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {206.35061638520406, 38.87790068192456, 61.98634043249791}), new DoubleVector(new double[] {96.74381193345377, -17.52682113576877, 89.34394923063071}), new DoubleVector(new double[] {0.06460079857654104, 0.33110273670367557, 0.9413807489908691}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {209.78905820638903, 33.85243717693259, 64.65885182163758}), new DoubleVector(new double[] {90.42710869686518, -27.572376650807264, 94.45132261209395}), new DoubleVector(new double[] {0.06460079857654104, 0.33110273670367557, 0.9413807489908691}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {213.57276697850165, 28.32515949203333, 67.59825922983634}), new DoubleVector(new double[] {83.47873513661773, -38.62248771734961, 100.06943333170351}), new DoubleVector(new double[] {0.06460079857654104, 0.33110273670367557, 0.9413807489908691}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {217.736293041676, 22.245898377203005, 70.83124635725164}), new DoubleVector(new double[] {75.83552422034553, -50.77760989054619, 106.24935512327403}), new DoubleVector(new double[] {0.06460079857654104, 0.33110273670367557, 0.9413807489908691}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {222.31763994482844, 15.559466718133919, 74.38716572963017}), new DoubleVector(new double[] {67.42799221244611, -64.14824428106243, 113.04726909400159}), new DoubleVector(new double[] {0.06460079857654104, 0.33110273670367557, 0.9413807489908691}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {227.35860984530362, 8.20515779034065, 78.2983055612066}), new DoubleVector(new double[] {58.179707003756754, -78.8559421106303, 120.52497446180192}), new DoubleVector(new double[] {0.06460079857654104, 0.33110273670367557, 0.9413807489908691}), 431.53794734646476, 0);

    currentView_3.setInput(new DoubleVector(new double[] {229.3857624648476, 57.86338130043822, 39.243663973734165}), new DoubleVector(new double[] {32.078548519998, -43.672819584630346, 88.49109527284536}), new DoubleVector(new double[] {0.06460079857654104, 0.33110273670367557, 0.9413807489908691}), 431.53794734646476, 0);

    userLookupTable_0.setColorMap(new ColorMap(new DoubleVector(new double[] {0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0}), new DoubleVector(new double[] {0.0, 1.0, 0.0, 0.28, 0.3495440729483283, 1.0, 0.42857142857142855, 0.0, 0.48936170212765956, 1.0, 0.5501519756838906, 1.0, 0.6231003039513677, 0.0, 0.7416413373860182, 1.0, 0.8115501519756839, 1.0, 0.8753799392097265, 1.0, 1.0, 0.0}), 1));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.101, 0.11}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.101, 0.15}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.101, 0.11}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.105, 0.11}));
  }
}
