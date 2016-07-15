// STAR-CCM+ macro: init_UserInputVariables.java
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

// //  in other files
// public class OtherFile extends ThisFile 
// //  and in OtherFile write
// [x,y,z,...] = ThisFile(inputArgs_fromCSV)

// package macro;
// import java.util.*;
// import star.vdm.*;
// import star.common.*;
// import star.base.neo.*;
// import star.base.report.*;
// // import star.trimmer.*;
// import star.dualmesher.*;
// import star.prismmesher.*;
// import star.meshing.*;
// import star.vis.*;

// // import star.common.*;
// // import star.base.neo.*;
// // import star.resurfacer.*;
// import star.dualmesher.*;
// import star.prismmesher.*;
// import star.meshing.*;

// import java.io.*;
// import java.util.logging.*;



package macro;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.vis.*;


public class init_UserInputVariables extends StarMacro {

	///////////////////////////////////////////////////////////////////////////////
	// USER INPUTS (all these user inputs should be read from a CSV file instead)
	String path0    = "../inputs/user_inputs.csv";

	///////////////////////////////////////////////////////////////////////////////

	public void execute() {
		execute0();
	}

	private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    // PhysicsContinuum physicsContinuum_0 = 
    //   ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));

    // AutoMeshOperation autoMeshOperation_0 = 
    //   ((AutoMeshOperation) simulation_0.get(MeshOperationManager.class).getObject("Automated Mesh"));



      //
      // int 			nVariables 	= 0;
      List<String>	textline 		= new ArrayList<String>();


  		File f = new File(path0);
      try {

          FileReader	fr   = new FileReader(f);
          Scanner     sc   = new Scanner(fr);
          String      line = "";
          
          Integer nLines = new Integer(0);
          while (sc.hasNextLine()) {
      		    // this skips the header line
      		    // if(nLines == 0) {
      		    //     nLines = nLines + 1;
      		    //     sc.nextLine();
      		    //     continue;
      		    // }
              nLines = nLines + 1;
              line   = sc.nextLine();
              textline.add(line);




              // double density   = Double.parseDouble(line.split(",")[0]);
          String name = line.split(",")[0];
          String value = line.split(",")[1];


          simulation_0.println("DEBUG 0: line = " + line);
          simulation_0.println("DEBUG 0: name = " + name);
          simulation_0.println("DEBUG 0: density = " + value);




          UserFieldFunction userFieldFunction_0 = 
            simulation_0.getFieldFunctionManager().createFieldFunction();

            userFieldFunction_0.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

            userFieldFunction_0.setPresentationName("__" + name);

            // userFieldFunction_0.setIgnoreBoundaryValues(true);

            userFieldFunction_0.setFunctionName("__" + name);

            userFieldFunction_0.setDefinition(value);
            // userFieldFunction_0.setDefinition("${__length}");



    //         UserFieldFunction userFieldFunction_9 = 
    //   simulation_0.getFieldFunctionManager().createFieldFunction();

    // userFieldFunction_9.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

    // userFieldFunction_9.setPresentationName("9.uref");

    // userFieldFunction_9.setFunctionName("uref");

    // userFieldFunction_9.setDefinition("$${WINDSPEED}[0]");

          }






      } catch (FileNotFoundException ex) {
          Logger.getLogger(init_UserInputVariables.class.getName()).log(Level.SEVERE, null, ex);
      } // end try



  }
}
