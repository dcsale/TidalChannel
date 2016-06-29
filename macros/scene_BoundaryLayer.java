// STAR-CCM+ macro: scene_BoundaryLayer.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class scene_BoundaryLayer extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    UserFieldFunction userFieldFunction_0 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

    userFieldFunction_0.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

    userFieldFunction_0.setPresentationName("boundaryLayer");

    userFieldFunction_0.setFunctionName("boundaryLayer");

    userFieldFunction_0.setDefinition("($$Velocity.mag() < 0.99 * 2) ? 1:0");

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("m"));

    NullFieldFunction nullFieldFunction_0 = 
      ((NullFieldFunction) simulation_0.getFieldFunctionManager().getFunction("NullFieldFunction"));








    ThresholdPart thresholdPart_4 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 1.0}), units_0, nullFieldFunction_0, 0);

    thresholdPart_4.setPresentationName("boundaryLayer");

    thresholdPart_4.getInputParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Block");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Inlet");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Left Bank");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Outlet");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Right Bank");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Sea Surface");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Seabed");

    thresholdPart_4.getInputParts().setObjects(region_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_0);

    thresholdPart_4.setFieldFunction(userFieldFunction_0);

    thresholdPart_4.setMode(1);

    thresholdPart_4.getRangeQuantities().setArray(new DoubleVector(new double[] {0.0, 0.0}));






    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("mesh");

    CurrentView currentView_1 = 
      scene_1.getCurrentView();

    currentView_1.setInput(new DoubleVector(new double[] {315.00805306437894, 49.06838782361602, 13.775156170573126}), new DoubleVector(new double[] {93.79248567338703, -341.25174281002313, 174.7721245453998}), new DoubleVector(new double[] {0.17621528764773012, 0.288535358203342, 0.9411139779355616}), 431.53794734646476, 0);

    simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar");









    Scene scene_3 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_3.initializeAndWait();

    PartDisplayer partDisplayer_4 = 
      ((PartDisplayer) scene_3.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_4.initialize();

    ScalarDisplayer scalarDisplayer_2 = 
      ((ScalarDisplayer) scene_3.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_2.initialize();

    scene_3.open(true);

    scene_3.resetCamera();

    scene_3.setPresentationName("boundaryLayer");

    scalarDisplayer_2.getInputParts().setQuery(null);

    scalarDisplayer_2.getInputParts().setObjects(thresholdPart_4);

    PrimitiveFieldFunction primitiveFieldFunction_3 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("WallDistance"));

    scalarDisplayer_2.getScalarDisplayQuantity().setFieldFunction(primitiveFieldFunction_3);

    CurrentView currentView_2 = 
      scene_3.getCurrentView();

    currentView_2.setInput(new DoubleVector(new double[] {281.5056028742266, -16.073784086647617, 77.4966864233739}), new DoubleVector(new double[] {-180.97869686190444, -347.4811817840572, 94.34681941230242}), new DoubleVector(new double[] {0.09851048798024295, -0.08687208287066206, 0.991336938167648}), 431.53794734646476, 0);

    scalarDisplayer_2.setDisplayMesh(0);

    scalarDisplayer_2.setFillMode(0);

    currentView_2.setInput(new DoubleVector(new double[] {165.38834272990638, -42.74557670336756, 52.74816437546174}), new DoubleVector(new double[] {-47.90744189565852, -382.3887972291501, 144.8108961012149}), new DoubleVector(new double[] {0.12871793613746696, 0.18391745860935607, 0.974477327255584}), 431.53794734646476, 0);





    UserFieldFunction userFieldFunction_1 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

    userFieldFunction_1.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

    userFieldFunction_1.setPresentationName("BL_thickness");

    userFieldFunction_1.setFunctionName("boundary layer thickness");

    userFieldFunction_1.setDefinition("${WallDistance}");

    scalarDisplayer_2.getScalarDisplayQuantity().setFieldFunction(userFieldFunction_1);

    userFieldFunction_1.setDimensionsVector(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));


  }
}
