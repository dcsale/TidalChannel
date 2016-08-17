// STAR-CCM+ macro: _main_1.java
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
public class _main_1 extends StarMacro {

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
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("parts_FluidRegion_BC.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_RoughSurface.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("physics_BC_InflowUniform.java"))).play();

    

    // setup the meshing controls, add virtual disks (with local mesh refinements), and then run the mesher
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("mesh_Background_Polyhedral.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("mesh_MeshAll.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_InitSolution.java"))).play();
   

    

    // create some field functions
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("fieldFunction_TurbulenceIntensity.java"))).play();
    



    // create derived parts (derived from field functions)
    // create any other derived parts useful for scenes (best to create parts prior, so can be used in multiple scenes)
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("parts_SectionPlanes.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("parts_Create_PointProbes.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("parts_Create_LineProbes.java"))).play();


    // these scenes need the parts derived above
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_Velocity.java"))).play();
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_Streamlines.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_Mesh.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_LineProbes.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_BoundaryLayer.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_vorticity.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_TurbulenceIntensityLocal.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_LineIntegralConvolution_Velocity.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_BoundaryLayerProfile.java"))).play();
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("fieldFunction_Residuals.java"))).play();


    
    


    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_OptimalSettings.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_UpdateConvergenceCriteria.java"))).play();
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_Run.java"))).play();
    // new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_RunAMR.java"))).play();



    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("export_PointProbes.java"))).play(); 
    new StarScript(getActiveSimulation(), new java.io.File(resolvePath("scene_SaveHardcopies.java"))).play();

    // simulation_0.saveState(getSimulation().getPresentationName()+"_inflowUniform.sim");
    Simulation simulation_0 = getActiveSimulation();
    simulation_0.saveState(resolvePath("1_inflowUniform.sim"));

    

  }
}
