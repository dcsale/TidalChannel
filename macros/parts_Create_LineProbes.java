// STAR-CCM+ macro: parts_Create_LineProbes.java
// tested on STAR-CCM+ v10 and v11
// 
// by Danny Clay Sale (dsale@uw.edu)
// 
// license: ?
// 

package macro;
import java.util.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class parts_Create_LineProbes extends StarMacro {

  // NOTE: it would be better to define these as field functions so do not have to duplicate User Inputs over multiple files
  static final double xo          = 0;       // origin x coordinate [m]
  static final double yo          = 0;       // origin y coordinate [m]
  static final double zo          = 0;       // origin z coordinate [m]
  static final double length      = 800;     // length in x-dimention (steamwise) [m]
  static final double width       = 320;     // length in y-dimention (crossflow) [m]
  static final double depth       = 50;      // length in z-dimention (vertical) [m]


  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_2 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Block");

      





    LinePart linePart_0 = 
      simulation_0.getPartManager().createLinePart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), new DoubleVector(new double[] {1.0, 0.0, 0.0}), 200);

    Coordinate coordinate_0 = 
      linePart_0.getPoint1Coordinate();

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    coordinate_0.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_0.setValue(new DoubleVector(new double[] {xo, (width-yo)/2, (depth-zo)/2}));

    coordinate_0.setCoordinate(units_2, units_2, units_2, new DoubleVector(new double[] {xo, yo + (width-yo)/2, zo + (depth-zo)/2}));


    Coordinate coordinate_1 = 
      linePart_0.getPoint2Coordinate();

    coordinate_1.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_1.setValue(new DoubleVector(new double[] {length, (width-yo)/2, (depth-zo)/2}));

    coordinate_1.setCoordinate(units_2, units_2, units_2, new DoubleVector(new double[] {length, yo + (width-yo)/2, zo + (depth-zo)/2}));

    linePart_0.setCoordinateSystem(labCoordinateSystem_0);

    linePart_0.getInputParts().setObjects(region_0);

    linePart_0.setResolution(200);

    linePart_0.setPresentationName("line_probe_centerline");





    LinePart linePart_1 = 
      simulation_0.getPartManager().createLinePart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), new DoubleVector(new double[] {1.0, 0.0, 0.0}), 20);

    Coordinate coordinate_2 = 
      linePart_1.getPoint1Coordinate();

    // LabCoordinateSystem labCoordinateSystem_0 = 
    //   simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    coordinate_2.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_2.setValue(new DoubleVector(new double[] {xo, yo+(width-yo)/2, 0.0}));

    coordinate_2.setCoordinate(units_2, units_2, units_2, new DoubleVector(new double[] {xo, yo+(width-yo)/2, 0.0}));

    Coordinate coordinate_3 = 
      linePart_1.getPoint2Coordinate();

    coordinate_3.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_3.setValue(new DoubleVector(new double[] {xo, yo+(width-yo)/2, depth}));

    coordinate_3.setCoordinate(units_2, units_2, units_2, new DoubleVector(new double[] {xo, yo+(width-yo)/2, depth}));

    linePart_1.setCoordinateSystem(labCoordinateSystem_0);

    linePart_1.getInputParts().setObjects(region_0);

    linePart_1.setResolution(200);

    // scene_0.setTransparencyOverrideMode(0);

    linePart_1.setPresentationName("line_probe_inflow");







    // setup XYZ internal table for line probes
    XyzInternalTable xyzInternalTable_1 = 
      simulation_0.getTableManager().createTable(XyzInternalTable.class);

    xyzInternalTable_1.setPresentationName("line_probe_TI_local");

    UserFieldFunction userFieldFunction_1 = 
      ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("local_TI"));

    xyzInternalTable_1.setFieldFunctions(new NeoObjectVector(new Object[] {userFieldFunction_1}));

    xyzInternalTable_1.getParts().setObjects(linePart_0);




    XyzInternalTable xyzInternalTable_2 = 
      simulation_0.getTableManager().createTable(XyzInternalTable.class);

    xyzInternalTable_2.setPresentationName("line_probe_Ux");

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));
    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(0));

    xyzInternalTable_2.setFieldFunctions(new NeoObjectVector(new Object[] {vectorComponentFieldFunction_0}));

    xyzInternalTable_2.getParts().setObjects(linePart_0);





  }
}
