// STAR-CCM+ macro: newPart.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class newPart extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    scene_0.setTransparencyOverrideMode(1);

    MeshPartFactory meshPartFactory_0 = 
      simulation_0.get(MeshPartFactory.class);

    SimpleBlockPart simpleBlockPart_8 = 
      meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));

    simpleBlockPart_8.setDoNotRetessellate(true);

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    simpleBlockPart_8.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_0 = 
      simpleBlockPart_8.getCorner1();

    coordinate_0.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    Coordinate coordinate_1 = 
      simpleBlockPart_8.getCorner2();

    coordinate_1.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {12.3, 1.0, 0.8}));

    simpleBlockPart_8.rebuildSimpleShapePart();

    simpleBlockPart_8.setDoNotRetessellate(false);

    scene_0.setTransparencyOverrideMode(0);

    PartSurface partSurface_0 = 
      ((PartSurface) simpleBlockPart_8.getPartSurfaceManager().getPartSurface("Block Surface"));

    simpleBlockPart_8.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_0}), 89.0);

    partSurface_0.setPresentationName("seasurface");

    PartSurface partSurface_1 = 
      ((PartSurface) simpleBlockPart_8.getPartSurfaceManager().getPartSurface("Block Surface 2"));

    partSurface_1.setPresentationName("right");

    PartSurface partSurface_2 = 
      ((PartSurface) simpleBlockPart_8.getPartSurfaceManager().getPartSurface("Block Surface 3"));

    partSurface_2.setPresentationName("inlet");

    PartSurface partSurface_3 = 
      ((PartSurface) simpleBlockPart_8.getPartSurfaceManager().getPartSurface("Block Surface 4"));

    partSurface_3.setPresentationName("left");

    PartSurface partSurface_4 = 
      ((PartSurface) simpleBlockPart_8.getPartSurfaceManager().getPartSurface("Block Surface 5"));

    partSurface_4.setPresentationName("seabed");

    PartSurface partSurface_5 = 
      ((PartSurface) simpleBlockPart_8.getPartSurfaceManager().getPartSurface("Block Surface 6"));

    partSurface_5.setPresentationName("outlet");

    Region region_7 = 
      simulation_0.getRegionManager().createEmptyRegion();
 
    region_7.setPresentationName("Region");

    Boundary boundary_0 = 
      region_7.getBoundaryManager().getBoundary("Default");

    region_7.getBoundaryManager().removeBoundaries(new NeoObjectVector(new Object[] {boundary_0}));

    FeatureCurve featureCurve_0 = 
      ((FeatureCurve) region_7.getFeatureCurveManager().getObject("Default"));

    region_7.getFeatureCurveManager().removeObjects(featureCurve_0);

    FeatureCurve featureCurve_1 = 
      region_7.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {simpleBlockPart_8}), "OneRegion", region_7, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_1, RegionManager.CreateInterfaceMode.BOUNDARY);
  }
}
