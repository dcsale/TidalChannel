// STAR-CCM+ macro: scene_Mesh_2.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class scene_Mesh_2 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSceneManager().createGeometryScene("Mesh Scene", "Outline", "Mesh", 3);

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 1");

    scene_1.initializeAndWait();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getDisplayer("Mesh 1"));

    partDisplayer_0.initialize();

    scene_1.open(true);

    scene_1.resetCamera();

    scene_1.setPresentationName("Mesh");

    CurrentView currentView_1 = 
      scene_1.getCurrentView();

    currentView_1.setInput(new DoubleVector(new double[] {511.5474642221504, -323.3846285640434, -67.01041959588956}), new DoubleVector(new double[] {-929.2198846826702, -1442.6243783476257, 672.8970668712974}), new DoubleVector(new double[] {0.20894765258452036, 0.33766413402228534, 0.917782006292561}), 431.53794734646476, 0);

    ScalarDisplayer scalarDisplayer_0 = 
      scene_1.getDisplayerManager().createScalarDisplayer("Scalar");

    scalarDisplayer_0.initialize();

    scalarDisplayer_0.getInputParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Block");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Seabed");

    scalarDisplayer_0.getInputParts().setObjects(boundary_0);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("WallYplus"));

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_0);

    scalarDisplayer_0.setPresentationName("wall_yPlus");

    partDisplayer_0.getInputParts().setQuery(null);

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Inlet");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Left Bank");

    PlaneSection planeSection_0 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane-xz"));

    partDisplayer_0.getInputParts().setObjects(boundary_1, boundary_2, planeSection_0);

    currentView_1.setInput(new DoubleVector(new double[] {128.52880595453124, -47.31632200189705, 39.01065919001087}), new DoubleVector(new double[] {-179.47322412460628, -286.5833454673089, 197.1854041104001}), new DoubleVector(new double[] {0.20894765258452036, 0.33766413402228534, 0.917782006292561}), 431.53794734646476, 0);

    scalarDisplayer_0.setDisplayMesh(1);

    partDisplayer_0.getInputParts().setQuery(null);

    PlaneSection planeSection_1 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane-yz"));

    partDisplayer_0.getInputParts().setObjects(boundary_1, boundary_2, planeSection_0, planeSection_1);

    currentView_1.setInput(new DoubleVector(new double[] {255.76128150473002, 20.666683430650835, -2.6143011319363723}), new DoubleVector(new double[] {-254.25617601929847, -375.53316936193323, 259.3056648763426}), new DoubleVector(new double[] {0.20894765258452036, 0.33766413402228534, 0.917782006292561}), 431.53794734646476, 0);

    ScalarDisplayer scalarDisplayer_1 = 
      scene_1.getDisplayerManager().createScalarDisplayer("Scalar");

    scalarDisplayer_1.initialize();

    scalarDisplayer_1.setPresentationName("turbines");

    scalarDisplayer_1.getInputParts().setQuery(null);

    ThresholdPart thresholdPart_0 = 
      ((ThresholdPart) simulation_0.getPartManager().getObject("Turbine-01"));

    ThresholdPart thresholdPart_1 = 
      ((ThresholdPart) simulation_0.getPartManager().getObject("Turbine-02"));

    scalarDisplayer_1.getInputParts().setObjects(thresholdPart_0, thresholdPart_1);

    currentView_1.setInput(new DoubleVector(new double[] {183.65622076331977, 79.1536239433939, 29.64745554907634}), new DoubleVector(new double[] {93.01980146396494, 8.74400275437904, 76.19387766028552}), new DoubleVector(new double[] {0.20894765258452036, 0.33766413402228534, 0.917782006292561}), 431.53794734646476, 0);

    PartDisplayer partDisplayer_1 = 
      scene_1.getDisplayerManager().createPartDisplayer("Geometry", -1, 4);

    partDisplayer_1.initialize();

    partDisplayer_1.setPresentationName("rotors");

    partDisplayer_1.getInputParts().setQuery(null);

    partDisplayer_1.getInputParts().setObjects(thresholdPart_0, thresholdPart_1);

    scalarDisplayer_1.setVisibilityOverrideMode(2);

    partDisplayer_1.setMesh(true);

    partDisplayer_1.setSurface(true);

    currentView_1.setInput(new DoubleVector(new double[] {315.22983071061475, 56.76048145676947, 20.585880771803147}), new DoubleVector(new double[] {94.359551500313, -280.2975834546988, 165.76156778584718}), new DoubleVector(new double[] {0.1691929108499835, 0.2945323767931151, 0.9405447559466311}), 431.53794734646476, 0);

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    scene_1.setTransparencyOverrideMode(1);

    scene_1.getCreatorGroup().setObjects(region_0);

    PartDisplayer partDisplayer_2 = 
      scene_1.getDisplayerManager().createPartDisplayer("Threshold Geometry", -1, 1);

    partDisplayer_2.initialize();

    scene_1.setTransparencyOverrideMode(1);

    PrimitiveFieldFunction primitiveFieldFunction_1 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Centroid"));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    CartesianCoordinateSystem cartesianCoordinateSystem_0 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("Turbine-01-CSys 1"));

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_1.getFunctionInCoordinateSystem(cartesianCoordinateSystem_0).getComponentFunction(1));

    ThresholdPart thresholdPart_2 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {region_0}), new DoubleVector(new double[] {-1.0, 1.0}), units_0, vectorComponentFieldFunction_0, 0);

    partDisplayer_2.getVisibleParts().addParts(thresholdPart_2);

    PartDisplayer partDisplayer_3 = 
      scene_1.getDisplayerManager().createPartDisplayer("Threshold Geometry", -1, 1);

    partDisplayer_3.initialize();

    scene_1.setTransparencyOverrideMode(1);

    ThresholdPart thresholdPart_3 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {region_0}), new DoubleVector(new double[] {-10.0, 10.0}), units_0, vectorComponentFieldFunction_0, 0);

    partDisplayer_3.getVisibleParts().addParts(thresholdPart_3);

    scene_1.setTransparencyOverrideMode(0);

    thresholdPart_3.setPresentationName("threshold_centroid");

    partDisplayer_3.setVisibilityOverrideMode(2);

    partDisplayer_2.setVisibilityOverrideMode(2);

    partDisplayer_0.getInputParts().setQuery(null);

    partDisplayer_0.getInputParts().setObjects(boundary_1, boundary_2, planeSection_1, thresholdPart_3);

    currentView_1.setInput(new DoubleVector(new double[] {258.0989193118725, -30.849834081392434, 58.26360231094543}), new DoubleVector(new double[] {-73.31419041128879, -207.36433042190566, 186.02416782729657}), new DoubleVector(new double[] {0.19114782316993764, 0.31422131087031857, 0.9299072413377223}), 431.53794734646476, 0);

    partDisplayer_0.setOpacity(0.095505618);

    partDisplayer_0.setOpacity(0.314606742);

    partDisplayer_0.setOpacity(0.483146067);

    partDisplayer_0.setOpacity(1.0);

    scene_1.setTransparencyOverrideMode(1);

    thresholdPart_3.setBatched(true);

    CartesianCoordinateSystem cartesianCoordinateSystem_1 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("Turbine-02-CSys 1"));

    VectorComponentFieldFunction vectorComponentFieldFunction_1 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_1.getFunctionInCoordinateSystem(cartesianCoordinateSystem_1).getComponentFunction(1));

    thresholdPart_3.setFieldFunction(vectorComponentFieldFunction_1);

    thresholdPart_3.getRangeQuantities().setArray(new DoubleVector(new double[] {-10.0, 10.0}));

    thresholdPart_3.getRangeQuantities().setUnits(units_0);

    thresholdPart_3.setBatched(false);

    scene_1.setTransparencyOverrideMode(0);


    currentView_1.setInput(new DoubleVector(new double[] {241.51304790539874, -45.50115163466521, 64.90396381589707}), new DoubleVector(new double[] {44.32961673457117, -383.4501466682966, 150.77730416605792}), new DoubleVector(new double[] {0.07676644708528935, 0.2032137296280403, 0.9761204294002679}), 431.53794734646476, 0);
  }
}
