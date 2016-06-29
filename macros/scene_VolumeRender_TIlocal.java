// STAR-CCM+ macro: scene_VolumeRender_TIlocal.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class scene_VolumeRender_TIlocal extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar");

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_1.initializeAndWait();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.initialize();

    ScalarDisplayer scalarDisplayer_1 = 
      ((ScalarDisplayer) scene_1.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_1.initialize();

    scene_1.open(true);

    scene_1.resetCamera();

    scene_1.setPresentationName("vol_Tilocal");

    scalarDisplayer_1.getInputParts().setQuery(null);

    ResampledVolumePart resampledVolumePart_0 = 
      ((ResampledVolumePart) simulation_0.getPartManager().getObject("resampled_volume"));

    scalarDisplayer_1.getInputParts().setObjects(resampledVolumePart_0);

    UserFieldFunction userFieldFunction_0 = 
      ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("local_TI"));

    scalarDisplayer_1.getScalarDisplayQuantity().setFieldFunction(userFieldFunction_0);

    CurrentView currentView_1 = 
      scene_1.getCurrentView();

    currentView_1.setInput(new DoubleVector(new double[] {471.92681719587705, 307.9758646673358, -142.6540273594919}), new DoubleVector(new double[] {-204.16547386324274, -1082.9565478143904, 746.8949978010421}), new DoubleVector(new double[] {-0.19674948023583194, 0.5953362935572452, 0.779014980344057}), 431.53794734646476, 0);

    currentView_1.setInput(new DoubleVector(new double[] {433.2911952085941, 333.2443055413861, -475.98014172022846}), new DoubleVector(new double[] {-307.6971643425394, -1191.1995317885237, 498.9540227581776}), new DoubleVector(new double[] {-0.19674948023583194, 0.5953362935572452, 0.779014980344057}), 431.53794734646476, 0);

    currentView_1.setInput(new DoubleVector(new double[] {647.2585498012252, 650.8893125578073, -320.6665898641364}), new DoubleVector(new double[] {-188.95464697999353, -1069.4616728467145, 779.5569208311839}), new DoubleVector(new double[] {-0.19674948023583194, 0.5953362935572452, 0.779014980344057}), 431.53794734646476, 0);

    currentView_1.setInput(new DoubleVector(new double[] {905.9844170141225, 760.1441203413789, -392.33999664628914}), new DoubleVector(new double[] {147.5884406883959, -800.1126063174594, 605.4977399286862}), new DoubleVector(new double[] {-0.19674948023583194, 0.5953362935572452, 0.779014980344057}), 431.53794734646476, 0);

    currentView_1.setInput(new DoubleVector(new double[] {946.601631083169, 843.7063799625363, -445.78093016626246}), new DoubleVector(new double[] {147.5884406883959, -800.1126063174594, 605.4977399286862}), new DoubleVector(new double[] {0.67887793617572, 0.1319509850577418, 0.7222975047140108}), 431.53794734646476, 0);

    currentView_1.setInput(new DoubleVector(new double[] {1051.541385820352, 976.3866826201172, -558.7791321427985}), new DoubleVector(new double[] {-216.04137599822366, -251.4593753190004, 693.2051298127327}), new DoubleVector(new double[] {0.6521523515711867, 0.09450756045894279, 0.7521739369030748}), 431.53794734646476, 0);

    currentView_1.setInput(new DoubleVector(new double[] {1119.4827781641648, 1042.1982203540024, -625.8844577372896}), new DoubleVector(new double[] {-216.04137599822366, -251.4593753190004, 693.2051298127327}), new DoubleVector(new double[] {0.7186215301320744, -0.03363590293940796, 0.6945874476724199}), 431.53794734646476, 0);

    currentView_1.setInput(new DoubleVector(new double[] {1109.776313970814, 1034.6080413084428, -613.8655570340101}), new DoubleVector(new double[] {-256.3467411661849, -593.3425656478126, 326.5724471734978}), new DoubleVector(new double[] {0.6486690665778267, -0.10923214058270442, 0.7531910657520915}), 431.53794734646476, 0);

    currentView_1.setInput(new DoubleVector(new double[] {1138.2519698755962, 1068.5412665324466, -633.4681754854698}), new DoubleVector(new double[] {-256.3467411661849, -593.3425656478126, 326.5724471734978}), new DoubleVector(new double[] {0.2210785440516219, 0.3420731075349516, 0.9132963738356772}), 431.53794734646476, 0);

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0843520313501358, 0.13}));

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0843520313501358, 0.11}));

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.09, 0.11}));

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.098, 0.11}));

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.098, 1.01}));

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.098, 1.2}));

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.098, 1.1}));

    scalarDisplayer_1.getScalarDisplayQuantity().setClip(0);

    scalarDisplayer_1.getScalarDisplayQuantity().setClip(1);

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.098, 1.5}));

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.011, 0.011}));

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.011, 0.013}));

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.05, 0.05}));

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.05, 0.15}));

    currentView_1.setInput(new DoubleVector(new double[] {1138.2519698755962, 1068.5412665324466, -633.4681754854698}), new DoubleVector(new double[] {-256.3467411661849, -593.3425656478126, 326.5724471734978}), new DoubleVector(new double[] {0.2210785440516219, 0.3420731075349516, 0.9132963738356772}), 431.53794734646476, 0);

    currentView_1.setInput(new DoubleVector(new double[] {1163.6508473038762, 1098.350968302343, -648.9789033228872}), new DoubleVector(new double[] {-292.1142469051323, -609.9580108818459, 238.88082316923936}), new DoubleVector(new double[] {0.19781216713797214, 0.31455950447667447, 0.9283979021279443}), 431.53794734646476, 0);

    currentView_1.setInput(new DoubleVector(new double[] {1163.6508473038762, 1098.350968302343, -648.9789033228872}), new DoubleVector(new double[] {-292.1142469051323, -609.9580108818459, 238.88082316923936}), new DoubleVector(new double[] {0.19781216713797214, 0.31455950447667447, 0.9283979021279443}), 431.53794734646476, 0);

    scalarDisplayer_1.getScalarDisplayQuantity().setAutoRange(1);
  }
}
