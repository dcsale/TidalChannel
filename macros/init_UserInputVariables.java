// STAR-CCM+ macro: physics_VirtualDisks.java
// tested on STAR-CCM+ v10 and v11
// 
// by Danny Clay Sale (dsale@uw.edu)
// 
// license: ?
// 

// 
// ideas: * for help with debgging: split the main or loop into multiple foor loops: make VD, vamke shape parts, refine, reports , monitors, ... 
//        * there might be more inputs to pull from the WT_Perf files into here, like: the combined-case table (U RPM PITCH)
// 
// 

//  in other files
public class OtherFile extends ThisFile 
//  and in OtherFile write
[x,y,z,...] = ThisFile(inputArgs_fromCSV)

package macro;
import java.util.*;
import star.vdm.*;
import star.common.*;
import star.base.neo.*;
import star.base.report.*;
// import star.trimmer.*;
import star.dualmesher.*;
import star.prismmesher.*;
import star.meshing.*;
import star.vis.*;

// import star.common.*;
// import star.base.neo.*;
// import star.resurfacer.*;
import star.dualmesher.*;
import star.prismmesher.*;
import star.meshing.*;

import java.io.*;
import java.util.logging.*;



public class physics_VirtualDisks extends StarMacro {

	///////////////////////////////////////////////////////////////////////////////
	// USER INPUTS (all these user inputs should be read from a CSV file instead)
	String path0    = "../inputs/turbines.csv";

	///////////////////////////////////////////////////////////////////////////////

	public void execute() {
		execute0();
	}

	private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));

    AutoMeshOperation autoMeshOperation_0 = 
      ((AutoMeshOperation) simulation_0.get(MeshOperationManager.class).getObject("Automated Mesh"));



      //
      int 			nVirtualDisks 	= 0;
      List<String>	textline 		= new ArrayList<String>();


		File f = new File(path0);
        try {

            FileReader	fr   = new FileReader(f);
            Scanner     sc   = new Scanner(fr);
            String      line = "";
            
            Integer nLines = new Integer(0);
            while (sc.hasNextLine()) {
			    // this skips the header line
			    if(nLines == 0) {
			       nLines = nLines + 1;
			       sc.nextLine();
			       continue;
			    }
                nLines = nLines + 1;
                line = sc.nextLine();
                textline.add(line);
            }
            nVirtualDisks = nLines - 1;          

        } catch (FileNotFoundException ex) {
            Logger.getLogger(physics_VirtualDisks.class.getName()).log(Level.SEVERE, null, ex);
        } // end try

// DEBUG
simulation_0.println("nVirtualDisks = " + nVirtualDisks);

      List<String>	names   = new ArrayList<String>();
      // ArrayList<String> names = new ArrayList<String>();
      // String[] name        	= new String[nVirtualDisks];
      String[] table       	= new String[nVirtualDisks];
      double[] rotor_rpm	= new double[nVirtualDisks];
      double[] x 			= new double[nVirtualDisks];
      double[] y 			= new double[nVirtualDisks];
      double[] z 			= new double[nVirtualDisks];
      double[] nx 			= new double[nVirtualDisks];
      double[] ny 			= new double[nVirtualDisks];
      double[] nz 			= new double[nVirtualDisks];
      double[] rotor_radius	= new double[nVirtualDisks];
      double[] hub_radius	= new double[nVirtualDisks];
      double[] rotor_thick	= new double[nVirtualDisks];
      for (int i = 0; i < nVirtualDisks; i++) {
      	
      	String name = textline.get(i).split(",")[0];
        names.add(name);
//DEBUG
simulation_0.println("name = " + name); 
simulation_0.println("names(i) = " + names.get(i));        
      	// name[i]			= textline.get(i).split(",")[0];
      	table[i]		= textline.get(i).split(",")[1];
      	rotor_rpm[i] 	= Double.parseDouble(textline.get(i).split(",")[2]);
      	x[i]			= Double.parseDouble(textline.get(i).split(",")[3]);
      	y[i]			= Double.parseDouble(textline.get(i).split(",")[4]);
      	z[i]			= Double.parseDouble(textline.get(i).split(",")[5]);
      	nx[i]			= Double.parseDouble(textline.get(i).split(",")[6]);
      	ny[i]			= Double.parseDouble(textline.get(i).split(",")[7]);
      	nz[i]           = Double.parseDouble(textline.get(i).split(",")[8]);
      	rotor_radius[i] = Double.parseDouble(textline.get(i).split(",")[9]);
      	hub_radius[i]   = Double.parseDouble(textline.get(i).split(",")[10]);
      	rotor_thick[i]  = Double.parseDouble(textline.get(i).split(",")[11]);
      }


      return table
      return rotor_rpm

  } // end execute0()
} // end public class
