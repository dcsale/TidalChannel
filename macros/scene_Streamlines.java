// STAR-CCM+ macro: scene_Streamlines.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class scene_Streamlines extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("velocity_x");

    scene_0.setTransparencyOverrideMode(1);

    PartDisplayer partDisplayer_6 = 
      ((PartDisplayer) scene_0.getCreatorDisplayer());

    partDisplayer_6.initialize();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    scene_0.getCreatorGroup().setObjects(region_0);

    StreamDisplayer streamDisplayer_0 = 
      scene_0.getDisplayerManager().createStreamDisplayer("Streamline Stream");

    streamDisplayer_0.initialize();

    scene_0.setTransparencyOverrideMode(1);

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Block.Inlet");

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    StreamPart streamPart_0 = 
      simulation_0.getPartManager().createStreamPart(new NeoObjectVector(new Object[] {region_0}), new NeoObjectVector(new Object[] {boundary_0}), primitiveFieldFunction_0, 5, 5, 0);

    streamDisplayer_0.getVisibleParts().addParts(streamPart_0);

    scene_0.setTransparencyOverrideMode(0);

    streamPart_0.setPresentationName("Streamline_Inlet");

    StreamDisplayer streamDisplayer_1 = 
      scene_0.getDisplayerManager().createStreamDisplayer("Streamlines");

    streamDisplayer_1.initialize();

    streamDisplayer_1.getInputParts().setQuery(null);

    streamDisplayer_1.getInputParts().setObjects(streamPart_0);

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    streamDisplayer_1.getScalarDisplayQuantity().setFieldFunction(vectorMagnitudeFieldFunction_0);

    scene_0.getDisplayerManager().deleteDisplayers(new NeoObjectVector(new Object[] {streamDisplayer_0}));

    SourceSeed sourceSeed_0 = 
      streamPart_0.getSourceSeed();

    sourceSeed_0.setNGridPoints(new IntVector(new int[] {50, 50}));

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {406.1452845697552, 120.21600646147023, 14.363649481289372}), new DoubleVector(new double[] {406.1452845697552, 120.21600646147023, 968.3672390785144}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 227.71550082598608, 1);

    Legend legend_1 = 
      streamDisplayer_1.getLegend();

    CoolWarmLookupTable coolWarmLookupTable_0 = 
      ((CoolWarmLookupTable) simulation_0.get(LookupTableManager.class).getObject("cool-warm"));

    legend_1.setLookupTable(coolWarmLookupTable_0);

    streamDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.5, 2.347298043741156}));

    streamDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.5, 3.5}));

    legend_1.updateLayout(new DoubleVector(new double[] {0.2990494296577947, 0.15755020080321303}), 0.5999999999999999, 0.04399999999999982, 0);

    streamDisplayer_1.setWidth(1.0);

    streamDisplayer_1.setMode(2);
  }
}
