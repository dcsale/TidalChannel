// STAR-CCM+ macro: scene_Velocity.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class scene_Velocity extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar");

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_0.initializeAndWait();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.initialize();

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_0.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_0.initialize();

    LogoAnnotation logoAnnotation_0 = 
      ((LogoAnnotation) simulation_0.getAnnotationManager().getObject("Logo"));

    logoAnnotation_0.setOpacity(0.0);

    scene_0.open(true);

    scene_0.resetCamera();

    scene_0.setPresentationName("velocity_x");

    scalarDisplayer_0.getInputParts().setQuery(null);

    PlaneSection planeSection_0 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane_crossflow"));

    PlaneSection planeSection_1 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane_middepth"));

    PlaneSection planeSection_2 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane_streamwise"));

    scalarDisplayer_0.getInputParts().setObjects(planeSection_0, planeSection_1, planeSection_2);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(0));

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(vectorComponentFieldFunction_0);

    scalarDisplayer_0.getScalarDisplayQuantity().setClip(0);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {400.00000000000017, 160.00000000000006, 25.00000000000001}), new DoubleVector(new double[] {400.00000000000017, 160.00000000000006, 1692.3345934628899}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 431.53794734646476, 0);

    scene_0.setViewOrientation(new DoubleVector(new double[] {0.0, -1.0, 0.0}), new DoubleVector(new double[] {0.0, 0.0, 1.0}));

    scalarDisplayer_0.setFillMode(5);

    Legend legend_0 = 
      scalarDisplayer_0.getLegend();

    legend_0.setLevels(11);

    PredefinedLookupTable predefinedLookupTable_0 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("Kelvin temperature"));

    legend_0.setLookupTable(predefinedLookupTable_0);

    legend_0.setReverse(true);

    currentView_0.setInput(new DoubleVector(new double[] {447.9429667178996, 163.59095562743255, 53.02819592738737}), new DoubleVector(new double[] {447.9429667178996, -637.4809673160605, 53.02819592738737}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 209.12173559241742, 1);

  }
}
