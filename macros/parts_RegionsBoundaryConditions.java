// STAR-CCM+ macro: parts_RegionsBoundaryConditions.java
// tested on STAR-CCM+ v10 and v11
// 
// by Danny Clay Sale (dsale@uw.edu)
// 
// license: ?
// 


///////////////////////////////////////////////////////////////////////////////
// import all the classes we need
//
package macro;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import star.vdm.*;
import star.turbulence.*;
import star.kwturb.*;
import star.material.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import star.flow.*;
import star.trimmer.*;
import star.prismmesher.*;
import star.segregatedflow.*;
import star.metrics.*;
import star.meshing.*;


public class parts_RegionsBoundaryConditions extends StarMacro {

	///////////////////////////////////////////////////////////////////////////////
	// USER INPUTS
	//
  // TODO: some of these variable should be read in from Matlab, easiest way is write/read from a CSV file
  // String path0    = "outputs/mooring-variables.csv";

  // CASE: Bamfield Flume
  // static final double xo          = 0;       // origin x coordinate [m]
  // static final double yo          = 0;       // origin y coordinate [m]
  // static final double zo          = 0;       // origin z coordinate [m]
  // static final double length      = 12.3;    // length in x-dimention (steamwise) [m]
  // static final double width       = 0.98;     // length in y-dimention (crossflow) [m]
  // static final double depth       = 0.76;      // length in z-dimention (vertical) [m]
  // static final double bc_TI       = 0.10;     // turbulence intensity for inlet and outlet TI = u' / U [unitless]
  // static final double bc_Lturb    = 0.0125;   // turbulent length scale for inlet and outlet [m]
  // static final double inlet_Vx    = 0.9;     // inlet x-velocity [m/s]
  // static final double inlet_Vy    = 0.0;     // inlet y-velocity [m/s]
  // static final double inlet_Vz    = 0.0;     // inlet z-velocity [m/s]
  // CASE: Tidal Channel (large domain)
  // static final double xo          = 0;       // origin x coordinate [m]
  // static final double yo          = -150;       // origin y coordinate [m]
  // static final double zo          = 0;       // origin z coordinate [m]
  // static final double length 			= 3000;	   // length in x-dimention (steamwise) [m]
  // static final double width 			= 790;		 // length in y-dimention (crossflow) [m]
  // static final double depth 			= 50;		   // length in z-dimention (vertical) [m]
  // static final double bc_TI 			= 0.1; 		 // turbulence intensity for inlet and outlet TI = u' / U [unitless]
  // static final double bc_Lturb 		= 2.5; 	 // turbulent length scale for inlet and outlet [m]
  // static final double inlet_Vx 		= 2.0; 		 // inlet x-velocity [m/s]
  // static final double inlet_Vy 		= 0.0; 		 // inlet y-velocity [m/s]
  // static final double inlet_Vz 		= 0.0; 		 // inlet z-velocity [m/s]
  // // CASE: Tidal Channel (small domain)
  static final double xo          = 0;       // origin x coordinate [m]
  static final double yo          = 0;       // origin y coordinate [m]
  static final double zo          = 0;       // origin z coordinate [m]
  static final double length      = 800;    // length in x-dimention (steamwise) [m]
  static final double width       = 320;     // length in y-dimention (crossflow) [m]
  static final double depth       = 50;      // length in z-dimention (vertical) [m]
  static final double bc_TI       = 0.1;     // turbulence intensity for inlet and outlet TI = u' / U [unitless]
  static final double bc_Lturb    = 2.5;   // turbulent length scale for inlet and outlet [m]
  static final double inlet_Vx    = 2.0;     // inlet x-velocity [m/s]
  static final double inlet_Vy    = 0.0;     // inlet y-velocity [m/s]
  static final double inlet_Vz    = 0.0;     // inlet z-velocity [m/s]
  // CASE: Tidal Channel (small domain) with 2 DOE-RM1 turbines
  // static final double xo          = 0;       // origin x coordinate [m]
  // static final double yo          = 0;       // origin y coordinate [m]
  // static final double zo          = 0;       // origin z coordinate [m]
  // static final double length      = 1000;    // length in x-dimention (steamwise) [m]
  // static final double width       = 400;     // length in y-dimention (crossflow) [m]
  // static final double depth       = 60;      // length in z-dimention (vertical) [m]
  // static final double bc_TI       = 0.1;     // turbulence intensity for inlet and outlet TI = u' / U [unitless]
  // static final double bc_Lturb    = 5.0;   // turbulent length scale for inlet and outlet [m]
  // static final double inlet_Vx    = 2.0;     // inlet x-velocity [m/s]
  // static final double inlet_Vy    = 0.0;     // inlet y-velocity [m/s]
  // static final double inlet_Vz    = 0.0;     // inlet z-velocity [m/s]

  // Usually z0 is larger than the median grain size; 
  // a first approximation might be z0 =~ 2 * d_90, where d_90 grain size at 
  // which 90% of the sample is finer. Hence, the highest value of bottom friction coefficient
  // under consideration would imply d_90 ~ 20 cm = 0.02 m
  // static final double z0          = 0.0001;    // for the Bamfield flume (smooth)
  static final double z0 				  = 0.0136;		 // seabed surface roughness height [m], UW-NNMREC
  // static final double z0          = 0.0025;    // seabed surface roughness height [m], OpenTidalFarm
  // static final double z0          = 0.043;    // seabed surface roughness height [m], as estimated by Neary in riverine environment http://www.pnnl.gov/main/publications/external/technical_reports/PNNL-20463.pdf, and further discussion here: http://www.homepages.ed.ac.uk/shs/Tidal%20Stream/Baston%20and%20Harris.pdf
  // static final double z0          = 0.04;    // used by Churchfield et al. for SOWFA tidal turbines

	///////////////////////////////////////////////////////////////////////////////

  public void execute() {
    execute0();
  }

  private void execute0() {

	Simulation simulation_0 = 
	  getActiveSimulation();

	///////////////////////////////////////////////////////////////////////////////
	// create the "Block" Shape Part
	//
	Units units_0 = 
	  simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    MeshPartFactory meshPartFactory_0 = 
      simulation_0.get(MeshPartFactory.class);

    SimpleBlockPart simpleBlockPart_0 = 
      meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));

    simpleBlockPart_0.setDoNotRetessellate(true);

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    simpleBlockPart_0.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_0 = 
      simpleBlockPart_0.getCorner1();

    coordinate_0.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-1.0, -1.0, -1.0}));

    // coordinate_0.setValue(new DoubleVector(new double[] {0.0, 0.0, 0.0}));
    coordinate_0.setValue(new DoubleVector(new double[] {xo, yo, zo}));

    Coordinate coordinate_1 = 
      simpleBlockPart_0.getCorner2();

    coordinate_1.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 1.0, 1.0}));

    coordinate_1.setValue(new DoubleVector(new double[] {xo+length, yo+width, zo+depth}));

    simpleBlockPart_0.rebuildSimpleShapePart();

    simpleBlockPart_0.setDoNotRetessellate(false);



	///////////////////////////////////////////////////////////////////////////////
	// split the surface of "Block" Shape Part into separate surfaces
    
    // Split the Block part into surfaces, splitting by angle at the sharp corners of Block
    PartSurface partSurface_0 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface"));
    simpleBlockPart_0.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_0}), 89.0);
    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {simpleBlockPart_0}), "OneRegionPerPart", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", null, true);
    
    // NOTE: there is a very annoying "feature" that changes the ordering of how the block
    // is split into surfaces ... if the X-Y aspect ratio of the boxes switches orientations
    // you will get unexpected boundary conditions ... need to detect and correct this
    if (length <= width) {
            // partSurface_0.setPresentationName("Inlet");
            partSurface_0.setPresentationName("Sea Surface");


            PartSurface partSurface_1 = 
              ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 2"));
            // partSurface_1.setPresentationName("Left Bank");
              partSurface_1.setPresentationName("Right Bank");


            PartSurface partSurface_2 = 
              ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 3"));
            // partSurface_2.setPresentationName("Seabed");
              partSurface_2.setPresentationName("Inlet");


            PartSurface partSurface_3 = 
              ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 4"));
            // partSurface_3.setPresentationName("Right Bank");
              partSurface_3.setPresentationName("Left Bank");


            PartSurface partSurface_4 = 
              ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 5"));
            // partSurface_4.setPresentationName("Sea Surface");
              partSurface_4.setPresentationName("Seabed");


            PartSurface partSurface_5 = 
              ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 6"));
            partSurface_5.setPresentationName("Outlet");

        } else {
            partSurface_0.setPresentationName("Inlet");
            // partSurface_0.setPresentationName("Sea Surface");


            PartSurface partSurface_1 = 
              ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 2"));
            partSurface_1.setPresentationName("Left Bank");
              // partSurface_1.setPresentationName("Right Bank");


            PartSurface partSurface_2 = 
              ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 3"));
            partSurface_2.setPresentationName("Seabed");
              // partSurface_2.setPresentationName("Inlet");


            PartSurface partSurface_3 = 
              ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 4"));
            partSurface_3.setPresentationName("Right Bank");
              // partSurface_3.setPresentationName("Left Bank");


            PartSurface partSurface_4 = 
              ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 5"));
            partSurface_4.setPresentationName("Sea Surface");
              // partSurface_4.setPresentationName("Seabed");


            PartSurface partSurface_5 = 
              ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface 6"));
            partSurface_5.setPresentationName("Outlet");

    }

    


	///////////////////////////////////////////////////////////////////////////////
	// assign types to Regions and Boundary Conditions
  //
  Region region_0 = 
    simulation_0.getRegionManager().getRegion("Block");

    // NOTE: there is a very annoying "feature" that changes the ordering of how the block
    // is split into surfaces ... if the X-Y aspect ratio of the boxes switches orientations
    // you will get unexpected boundary conditions ... need to detect and correct this
    if (length <= width) {
      
      // INLET
      Boundary boundary_0 = 
        region_0.getBoundaryManager().getBoundary("Block Surface 3");
        boundary_0.setBoundaryType(InletBoundary.class);
        boundary_0.setPresentationName("Inlet");
        boundary_0.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.INTENSITY_LENGTH_SCALE);
        boundary_0.getConditions().get(InletVelocityOption.class).setSelected(InletVelocityOption.Type.COMPONENTS);

      TurbulenceIntensityProfile turbulenceIntensityProfile_0 = 
        boundary_0.getValues().get(TurbulenceIntensityProfile.class);
        turbulenceIntensityProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(bc_TI);

      TurbulentLengthScaleProfile turbulentLengthScaleProfile_0 = 
        boundary_0.getValues().get(TurbulentLengthScaleProfile.class);
        turbulentLengthScaleProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(bc_Lturb);

      VelocityProfile velocityProfile_0 = 
        boundary_0.getValues().get(VelocityProfile.class);
        velocityProfile_0.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponents(inlet_Vx, inlet_Vy, inlet_Vz);
        region_0.getConditions().get(TwoEquationTurbulenceUserSourceOption.class).setSelected(TwoEquationTurbulenceUserSourceOption.Type.AMBIENT);

      AmbientTurbulenceSpecification ambientTurbulenceSpecification_0 = 
        region_0.getValues().get(AmbientTurbulenceSpecification.class);
        ambientTurbulenceSpecification_0.setInflowBoundary(boundary_0);


      // OUTLET
      Boundary boundary_5 = 
        region_0.getBoundaryManager().getBoundary("Block Surface 6");
        boundary_5.setPresentationName("Outlet");
        boundary_5.setBoundaryType(PressureBoundary.class);
        boundary_5.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.INTENSITY_LENGTH_SCALE);

      TurbulenceIntensityProfile turbulenceIntensityProfile_1 = 
        boundary_5.getValues().get(TurbulenceIntensityProfile.class);
        turbulenceIntensityProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(bc_TI);

      TurbulentLengthScaleProfile turbulentLengthScaleProfile_1 = 
        boundary_5.getValues().get(TurbulentLengthScaleProfile.class);
        turbulentLengthScaleProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(bc_Lturb);


      // SIDE WALLS & SEA SURFACE
      Boundary boundary_1 = 
        region_0.getBoundaryManager().getBoundary("Block Surface 2");
        boundary_1.setPresentationName("Right Bank");
        boundary_1.getConditions().get(WallShearStressOption.class).setSelected(WallShearStressOption.Type.SLIP);

      Boundary boundary_3 = 
        region_0.getBoundaryManager().getBoundary("Block Surface 4");
      // boundary_3.setPresentationName("Right Bank");
        boundary_3.setPresentationName("Left Bank");
        boundary_3.getConditions().get(WallShearStressOption.class).setSelected(WallShearStressOption.Type.SLIP);

      Boundary boundary_4 = 
        region_0.getBoundaryManager().getBoundary("Block Surface");
        boundary_4.setPresentationName("Sea Surface");
        boundary_4.getConditions().get(WallShearStressOption.class).setSelected(WallShearStressOption.Type.SLIP);


      // SEABED
      Boundary boundary_2 = 
        region_0.getBoundaryManager().getBoundary("Block Surface 5");
        boundary_2.setPresentationName("Seabed");
        boundary_2.getConditions().get(WallShearStressOption.class).setSelected(WallShearStressOption.Type.NO_SLIP);
        boundary_2.getConditions().get(WallSurfaceOption.class).setSelected(WallSurfaceOption.Type.ROUGH);

      RoughnessHeightProfile roughnessHeightProfile_0 = 
        boundary_2.getValues().get(RoughnessHeightProfile.class);
        roughnessHeightProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(z0);


    } else {

      // INLET
      Boundary boundary_0 = 
        region_0.getBoundaryManager().getBoundary("Block Surface");
        boundary_0.setBoundaryType(InletBoundary.class);
        boundary_0.setPresentationName("Inlet");
        boundary_0.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.INTENSITY_LENGTH_SCALE);
        boundary_0.getConditions().get(InletVelocityOption.class).setSelected(InletVelocityOption.Type.COMPONENTS);

      TurbulenceIntensityProfile turbulenceIntensityProfile_0 = 
        boundary_0.getValues().get(TurbulenceIntensityProfile.class);
        turbulenceIntensityProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(bc_TI);

      TurbulentLengthScaleProfile turbulentLengthScaleProfile_0 = 
        boundary_0.getValues().get(TurbulentLengthScaleProfile.class);
        turbulentLengthScaleProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(bc_Lturb);

      VelocityProfile velocityProfile_0 = 
        boundary_0.getValues().get(VelocityProfile.class);
        velocityProfile_0.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponents(inlet_Vx, inlet_Vy, inlet_Vz);
        region_0.getConditions().get(TwoEquationTurbulenceUserSourceOption.class).setSelected(TwoEquationTurbulenceUserSourceOption.Type.AMBIENT);

      AmbientTurbulenceSpecification ambientTurbulenceSpecification_0 = 
        region_0.getValues().get(AmbientTurbulenceSpecification.class);
        ambientTurbulenceSpecification_0.setInflowBoundary(boundary_0);


      // OUTLET
      Boundary boundary_5 = 
        region_0.getBoundaryManager().getBoundary("Block Surface 6");
        boundary_5.setPresentationName("Outlet");
        boundary_5.setBoundaryType(PressureBoundary.class);
        boundary_5.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.INTENSITY_LENGTH_SCALE);

      TurbulenceIntensityProfile turbulenceIntensityProfile_1 = 
        boundary_5.getValues().get(TurbulenceIntensityProfile.class);
        turbulenceIntensityProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(bc_TI);

      TurbulentLengthScaleProfile turbulentLengthScaleProfile_1 = 
        boundary_5.getValues().get(TurbulentLengthScaleProfile.class);
        turbulentLengthScaleProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(bc_Lturb);


      // SIDE WALLS & SEA SURFACE
      Boundary boundary_1 = 
        region_0.getBoundaryManager().getBoundary("Block Surface 4");
        boundary_1.setPresentationName("Right Bank");
        boundary_1.getConditions().get(WallShearStressOption.class).setSelected(WallShearStressOption.Type.SLIP);

      Boundary boundary_3 = 
        region_0.getBoundaryManager().getBoundary("Block Surface 2");
        boundary_3.setPresentationName("Left Bank");
        boundary_3.getConditions().get(WallShearStressOption.class).setSelected(WallShearStressOption.Type.SLIP);

      Boundary boundary_4 = 
        region_0.getBoundaryManager().getBoundary("Block Surface 5");
        boundary_4.setPresentationName("Sea Surface");
        boundary_4.getConditions().get(WallShearStressOption.class).setSelected(WallShearStressOption.Type.SLIP);


      // SEABED
      Boundary boundary_2 = 
        region_0.getBoundaryManager().getBoundary("Block Surface 3");
        boundary_2.setPresentationName("Seabed");
        boundary_2.getConditions().get(WallShearStressOption.class).setSelected(WallShearStressOption.Type.NO_SLIP);
        boundary_2.getConditions().get(WallSurfaceOption.class).setSelected(WallSurfaceOption.Type.ROUGH);

      RoughnessHeightProfile roughnessHeightProfile_0 = 
        boundary_2.getValues().get(RoughnessHeightProfile.class);
        roughnessHeightProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(z0);
 


    }


    


    ///////////////////////////////////////////////////////////////////////////////
	  // after creating the Regions some new Solver options appear
    //
    KwTurbViscositySolver kwTurbViscositySolver_0 = 
      ((KwTurbViscositySolver) simulation_0.getSolverManager().getSolver(KwTurbViscositySolver.class));

    kwTurbViscositySolver_0.setMaxTvr(1.0E10);  // this is recommended for ABL high Reynolds # flows



    ///////////////////////////////////////////////////////////////////////////////
    // setup some stoping criteria (default values will be fine for now)
    //
    ResidualMonitor residualMonitor_0 = 
      ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Continuity"));

    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_0 = 
      residualMonitor_0.createIterationStoppingCriterion();

  } // end execute0()
} // end public class