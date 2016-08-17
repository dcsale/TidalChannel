// STAR-CCM+ macro: _main.java
// tested on STAR-CCM+ v10 and v11
// 
// by Danny Clay Sale (dsale@uw.edu)
// 
// license: ?
// 

package macro;
import java.util.*;
import star.common.*;

///////////////////////////////////////////////////////////////////////////////
// This is the MAIN driver, which calls all the other macros
///////////////////////////////////////////////////////////////////////////////
public class _main extends StarMacro {

  ///////////////////////////////////////////////////////////////////////////////
  // USER INPUTS
  ///////////////////////////////////////////////////////////////////////////////
  // this macro run all the precursor simultions, or ABL, without any turbines
  // the next "main" macro adds the turbines and runs again
  // 


  public void execute() {
    execute0();
  }

  private void execute0() {

    ///////////////////////////////////////////////////////////////////////////////
    // setup Physics and Meshing, and Field Functions
    ///////////////////////////////////////////////////////////////////////////////

    // define the physics continua, parts and boundary conditions
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_SST_KOmega.java"))).play();
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_KEpsilon_REB.java"))).play();
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_RST_QLS.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("parts_RegionsBoundaryConditions.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_InflowUniform.java"))).play();
    

    // setup the meshing controls, add virtual disks (with local mesh refinements), and then run the mesher
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("mesh_Background_Polyhedral.java"))).play();
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_Create_VirtualDisks.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("mesh_MeshAll.java"))).play();
   

    

    // create some field functions
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("fieldFunction_TurbulenceIntensity.java"))).play();



    // create derived parts (derived from field functions)
    // create any other derived parts useful for scenes (best to create parts prior, so can be used in multiple scenes)
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("parts_SectionPlanes.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("parts_Create_PointProbes.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("parts_Create_LineProbes.java"))).play();


    // these scenes need the parts derived above
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_Mesh.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_Velocity.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_LineProbes.java"))).play();
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_VerticalProfilesABL.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_BoundaryLayer.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_vorticity.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_TurbulenceIntensityLocal.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_LineIntegralConvolution_Velocity.java"))).play();


    //  sometimes field functions cannot be evaluated without an initial condition, therefore initialize a simplified verions of your more complex boundary conditions first
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_UpdateConvergenceCriteria.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_InitSolution.java"))).play();
    

    // more scenes! need to initialize the solution first for these scenes & field functions
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_BoundaryLayerProfile.java"))).play();


    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_Run.java"))).play();

    // now create the ABL inflow
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("fieldFunction_ABL_inlet.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_InflowABL.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_OutletABL.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_VerticalProfilesABL.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_Run.java"))).play();
    
    

    // // Now, generate the precursor periodic simulation, to develop the correct inflow condition
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_PeriodicPrecursor.java"))).play();

    // // now add turbines once the ABL flow has been developed
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_VirtualDisks.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("parts_SectionPlanesTurbines.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_VirtualDisks_Reports.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("mesh_MeshAll.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_Run.java"))).play();
    


new StarScript(getActiveSimulation(), new java.io.File(resolvePath("fieldFunction_Residuals.java"))).play();
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_RunAMR.java"))).play();






































    // // create any useful field functions
    
    // // after stepping the solution once, the full solution field is available, so now is convenient time to make field functions
    
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("fieldFunction_ABL_inlet.java"))).play();
    // // now can change the inlet boundary condition to ABL flow
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_InflowABL.java"))).play();
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_OutletABL.java"))).play();
    // // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_Periodic_Precursor.java"))).play();
        



    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_InitSolution.java"))).play();



    // // setup a pre-cursor simulation (recycle the outflow to the inflow boundary), this will need to loop a few times
    // // then update the inlet boundary condition by exporting the outlet to CSV, and then importing the CSV upon the inlet


    // ///////////////////////////////////////////////////////////////////////////////
    // // setup Runtime Post-Processing
    // ///////////////////////////////////////////////////////////////////////////////

    


    // // create some scenes (NOTE: scenes are also useful to define field functions or derived parts)

    // // scene of data focus with FF of wall shear stress coloroed on the seabed, data focus range on gretaer than 2 Pascals
    // // also shown are the limited streamlines on the seabed
    // // scene of the volume render on velocity magnitude, and data focus upon the FF of velocity via +-1,3,5,7 standard deviations from the mean velocity (this visualizes a model of u,v,w_rms)
    // // scene of the 

    
    
    
    

    // ///////////////////////////////////////////////////////////////////////////////
    // // Run the Solver
    // ///////////////////////////////////////////////////////////////////////////////
    // // the initial run (or final if AMR is not enabled)
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_Run.java"))).play();
    // // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_RunAMR.java"))).play();



    // ///////////////////////////////////////////////////////////////////////////////
    // // POST-PROCESSING
    // ///////////////////////////////////////////////////////////////////////////////
    // // export important data here    
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("export_PointProbes.java"))).play(); 
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("export_VirtualDisks.java"))).play();



    // ///////////////////////////////////////////////////////////////////////////////
    // // POST-POST-PROCESSING
    // ///////////////////////////////////////////////////////////////////////////////
    // // after the final run, all scenes should be finally updated, and hardcopy saves
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_SaveHardcopies.java"))).play();
    // // archive the simfile, print reports, write the papers ...


        

    

  } // end execute0()
} // end public class
