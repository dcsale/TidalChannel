// STAR-CCM+ macro: scene_vorticity.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;

public class scene_vorticity extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar");

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_4.initializeAndWait();

    PartDisplayer partDisplayer_1 = 
      ((PartDisplayer) scene_4.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_1.initialize();

    ScalarDisplayer scalarDisplayer_2 = 
      ((ScalarDisplayer) scene_4.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_2.initialize();

    scene_4.open(true);

    scene_4.resetCamera();

    scene_4.setPresentationName("vort_mag");

    scalarDisplayer_2.setPresentationName("w_mag");

    scalarDisplayer_2.setPresentationName("vort_mag");

    scalarDisplayer_2.getInputParts().setQuery(null);

    PlaneSection planeSection_0 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane_crossflow"));

    PlaneSection planeSection_1 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane_middepth"));

    PlaneSection planeSection_2 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane_streamwise"));

    scalarDisplayer_2.getInputParts().setObjects(planeSection_0, planeSection_1, planeSection_2);

    VorticityVectorFunction vorticityVectorFunction_0 = 
      ((VorticityVectorFunction) simulation_0.getFieldFunctionManager().getFunction("VorticityVector"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) vorticityVectorFunction_0.getMagnitudeFunction());

    scalarDisplayer_2.getScalarDisplayQuantity().setFieldFunction(vectorMagnitudeFieldFunction_0);

    scalarDisplayer_2.getScalarDisplayQuantity().setClip(0);

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {8.0, 43.420310734161795}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {8.0, 12.0}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.1, 12.0}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.1, 1.0}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.1, 0.2}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.001, 0.2}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.001, 0.1}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.001, 0.01}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.001, 0.1}));

    Legend legend_1 = 
      scalarDisplayer_2.getLegend();

    PredefinedLookupTable predefinedLookupTable_0 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("thermal"));

    legend_1.setLookupTable(predefinedLookupTable_0);

    legend_1.setLevels(11);

    legend_1.setReverse(true);

    CurrentView currentView_3 = 
      scene_4.getCurrentView();

    currentView_3.setInput(new DoubleVector(new double[] {398.94664361978, 160.61132786752202, 21.849421546053666}), new DoubleVector(new double[] {621.937220385154, 31.196102088938048, 1681.908930476996}), new DoubleVector(new double[] {0.005205857074680913, 0.9970106063625513, 0.07708923305297584}), 431.53794734646476, 0);

    scene_4.setViewOrientation(new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 1.0, 0.0}));
  }
}
