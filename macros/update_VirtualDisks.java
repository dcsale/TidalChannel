// STAR-CCM+ macro: update_VirtualDisks.java
// tested on STAR-CCM+ v10 and v11
// 
// by Danny Clay Sale (dsale@uw.edu)
// 
// license: ?
// 

package macro;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import star.common.*;
import star.base.neo.*;
import star.vdm.*;
import star.base.report.*;
import star.vis.*;

public class update_VirtualDisks extends StarMacro {


    ///////////////////////////////////////////////////////////////////////////////
    // USER INPUTS
    //
    // path to CSV file with names and coordinates of point probes (this gets updated from the "mooring model" code) This file should NOT have any empty lines at bottom 
    // String path1                = "../outputs/rotors.csv";
    // String path1                = "../inputs/turbines.csv";
    // static final int nUpdates   = 3;

    ///////////////////////////////////////////////////////////////////////////////

    public void execute() {

        Simulation simulation_0 = getActiveSimulation();

        PhysicsContinuum physicsContinuum_0 = 
          ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));

        VirtualDiskModel virtualDiskModel_0 = 
          physicsContinuum_0.getModelManager().getModel(VirtualDiskModel.class);

        Region region_0 =
                simulation_0.getRegionManager().getRegion("Region");

        Units units_0 = 
          ((Units) simulation_0.getUnitsManager().getObject("m"));




        SimpleAnnotation simpleAnnotation_00 = 
            ((SimpleAnnotation) simulation_0.getAnnotationManager().getObject("file_turbines"));
        // File f = new File("../inputs/" + simpleAnnotation_00.getText() + ".csv");

        UserFieldFunction userFieldFunction_0 = 
            ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("__nUpdates"));

        


        for (int i = 0; i < Integer.parseInt(userFieldFunction_0.getDefinition()); i++) {
        // for (int i = 0; i < nUpdates; i++) {

                // run Matlab to compute the new rotor speeds
                // the Matlab script could also do things like run the UW Mooring code and then update the "turbine input file"
                // String cmd = "matlab -nodesktop -nosplash < adjustRotorSpeeds.m 2>&1 | tee log.adjustRotorSpeeds";
                String cmd = "../utilities/run_matlab_scripts.sh";
                try {
                    Process p = Runtime.getRuntime().exec(new String[]{"bash", "-c", cmd});
                } catch (IOException ex) {
                    simulation_0.println("Error: failed to execute batch command.");
                }


                // read the turbine input file again
                // then recompute the tip-speed-ratio and update the rotor speed accordingly
                File f = new File("../inputs/" + simpleAnnotation_00.getText() + ".csv");
                // File f = new File(path1);
                try {

                    FileReader  fr      = new FileReader(f);
                    Scanner     sc      = new Scanner(fr);
                    String      line    = "";

                    Integer nLines = new Integer(0);
                    while (sc.hasNextLine()) {
                        if(nLines == 0) {
                           nLines = nLines + 1;
                           sc.nextLine();
                           continue;
                        }
                        line        = sc.nextLine();
                        String name = line.split(",")[0];
                        double rpm  = Double.parseDouble(line.split(",")[2]);
                        double x    = Double.parseDouble(line.split(",")[3]);
                        double y    = Double.parseDouble(line.split(",")[4]);
                        double z    = Double.parseDouble(line.split(",")[5]);
                        // double nx   = Double.parseDouble(line.split(",")[6]);
                        // double ny   = Double.parseDouble(line.split(",")[7]);
                        // double nz   = Double.parseDouble(line.split(",")[8]);

                        VirtualDisk virtualDisk_0 = 
                          ((VirtualDisk) virtualDiskModel_0.getVirtualDiskManager().getObject(name));

                        SimpleDiskGeometry simpleDiskGeometry_0 = 
                          virtualDisk_0.getComponentsManager().get(SimpleDiskGeometry.class);

                        Coordinate coordinate_0 = 
                          simpleDiskGeometry_0.getDiskOrigin();

                        coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {x, y, z}));

                        simulation_0.println("Virtual Disk '" + name + "' updated coordinates (" + x + "," + y + "," + z + ")");






                        VdmRotationRateInputValue vdmRotationRateInputValue_0 = 
                          virtualDisk_0.getComponentsManager().get(VdmRotationRateInputValue.class);

                        vdmRotationRateInputValue_0.getRotationRate().setValue(rpm);  

                        ExpressionReport expressionReport_0 = 
                          ((ExpressionReport) simulation_0.getReportManager().getReport("Rotor Speed (" + name + ")"));
                        expressionReport_0.setDefinition(Double.toString(rpm));                   

                        simulation_0.println("Virtual Disk '" + name + "' updated rotor speed (" + rpm + ")");






                        // simulation_0.println("Virtual Disk '" + name + "' updated direction vectors (" + nx + "," + ny + "," + nz + ")");


                        


                    } // end while


                } catch (FileNotFoundException ex) {
                    Logger.getLogger(update_VirtualDisks.class.getName()).log(Level.SEVERE, null, ex);
                }




                // run the solver again
                new StarScript(getActiveSimulation(), new java.io.File(resolvePath("solver_Run.java"))).play();


        }






        


  } // end execute0()
} // end public class

