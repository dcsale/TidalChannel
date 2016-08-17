// STAR-CCM+ macro: scene_LineIntegralConvolution_Velocity.java
// Written by STAR-CCM+ 11.02.010
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class scene_LineIntegralConvolution_Velocity extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSceneManager().createVectorScene("Vector Scene", "Outline", "Vector");

    Scene scene_5 = 
      simulation_0.getSceneManager().getScene("Vector Scene 1");

    scene_5.initializeAndWait();

    PartDisplayer partDisplayer_2 = 
      ((PartDisplayer) scene_5.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_2.initialize();

    VectorDisplayer vectorDisplayer_0 = 
      ((VectorDisplayer) scene_5.getDisplayerManager().getDisplayer("Vector 1"));

    vectorDisplayer_0.initialize();

    scene_5.open(true);

    scene_5.resetCamera();

    scene_5.setPresentationName("LIC");

    vectorDisplayer_0.getInputParts().setQuery(null);

    PlaneSection planeSection_0 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane_crossflow"));

    PlaneSection planeSection_1 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane_middepth"));

    PlaneSection planeSection_2 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane_streamwise"));

    vectorDisplayer_0.getInputParts().setObjects(planeSection_0, planeSection_1, planeSection_2);

    vectorDisplayer_0.setDisplayMode(1);

    Legend legend_2 = 
      vectorDisplayer_0.getLegend();

    PredefinedLookupTable predefinedLookupTable_0 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("thermal"));

    legend_2.setLookupTable(predefinedLookupTable_0);

    legend_2.setReverse(true);

    legend_2.setLevels(11);

    vectorDisplayer_0.getVectorDisplayQuantity().setRange(new DoubleVector(new double[] {1.5, 2.7194929764737656}));

    vectorDisplayer_0.getVectorDisplayQuantity().setRange(new DoubleVector(new double[] {1.5, 2.5}));

    vectorDisplayer_0.getVectorDisplayQuantity().setClip(0);

    legend_2.setReverse(false);

    CurrentView currentView_4 = 
      scene_5.getCurrentView();

    currentView_4.setInput(new DoubleVector(new double[] {385.6271836330491, 165.73496613656673, 17.754894159236073}), new DoubleVector(new double[] {385.6271836330491, 165.73496613656673, 1525.6011399338252}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {372.6916489027932, 170.8964356594767, 17.683467695493846}), new DoubleVector(new double[] {372.6916489027932, 170.8964356594767, 1375.541031757667}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {361.04966764556286, 175.5417582300957, 17.61922571931973}), new DoubleVector(new double[] {361.04966764556286, 175.5417582300957, 1240.4869343991247}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {361.04966764556286, 175.5417582300957, 17.61922571931973}), new DoubleVector(new double[] {361.04966764556286, 175.5417582300957, 1240.4869343991247}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {361.04966764556286, 175.5417582300957, 17.61922571931973}), new DoubleVector(new double[] {361.04966764556286, 175.5417582300957, 1240.4869343991247}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 431.53794734646476, 0);

    scene_5.setViewOrientation(new DoubleVector(new double[] {0.0, -1.0, 0.0}), new DoubleVector(new double[] {0.0, 0.0, 1.0}));

    scene_5.setViewOrientation(new DoubleVector(new double[] {-1.0, 0.0, 0.0}), new DoubleVector(new double[] {0.0, 0.0, 1.0}));

    currentView_4.setInput(new DoubleVector(new double[] {400.01534666884936, 174.95235481744385, 17.779972104588417}), new DoubleVector(new double[] {-735.6361976478795, 174.95235481744385, 17.779972104588417}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {400.0154945626689, 174.42189174605718, 17.924643851330234}), new DoubleVector(new double[] {-622.0725386001532, 174.42189174605718, 17.924643851330234}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {400.01209419776444, 173.94447482572937, 17.968045389541853}), new DoubleVector(new double[] {-519.865212043007, 173.94447482572937, 17.968045389541853}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {400.00359096465877, 173.74916775861084, 17.92898397611815}), new DoubleVector(new double[] {-427.87854977048914, 173.74916775861084, 17.92898397611815}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {400.0044422247904, 173.9249442178566, 17.82351810057067}), new DoubleVector(new double[] {-345.0905071734891, 173.9249442178566, 17.82351810057067}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {400.0044676030043, 174.08314303117777, 17.72859881257794}), new DoubleVector(new double[] {-270.581268836189, 174.08314303117777, 17.72859881257794}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {400.0044904433861, 174.2255219631668, 17.643171453384483}), new DoubleVector(new double[] {-203.52295433261895, 174.2255219631668, 17.643171453384483}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {400.00451099971906, 174.35366300195696, 17.56628683011037}), new DoubleVector(new double[] {-143.17047127940592, 174.35366300195696, 17.56628683011037}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {400.0045942527569, 174.5843168717792, 17.42789450821697}), new DoubleVector(new double[] {-34.53600178362247, 174.5843168717792, 17.42789450821697}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {401.1285946480721, 171.94459310211474, 18.55393052185166}), new DoubleVector(new double[] {-78.00697392224326, 171.94459310211474, 18.55393052185166}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {401.13805049890755, 169.04089695548382, 19.792570136849825}), new DoubleVector(new double[] {-125.82504327472614, 169.04089695548382, 19.792570136849825}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {401.14845347881175, 165.8468311941898, 21.155073713347804}), new DoubleVector(new double[] {-178.42491956245732, 165.8468311941898, 21.155073713347804}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {401.1598983011015, 162.33335885676638, 22.65382764749558}), new DoubleVector(new double[] {-236.2847834789616, 162.33335885676638, 22.65382764749558}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 431.53794734646476, 0);

    currentView_4.setInput(new DoubleVector(new double[] {401.1598983011015, 162.33335885676638, 22.65382764749558}), new DoubleVector(new double[] {-236.2847834789616, 162.33335885676638, 22.65382764749558}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 166.40645412734824, 1);

    currentView_4.setInput(new DoubleVector(new double[] {566.6850435666232, 164.99691699731505, 22.680199510273287}), new DoubleVector(new double[] {-236.2847834789616, 164.99691699731505, 22.680199510273287}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 149.7759845697928, 1);

    currentView_4.setInput(new DoubleVector(new double[] {566.6850435666232, 167.39411932380887, 22.703934186773225}), new DoubleVector(new double[] {-236.2847834789616, 167.39411932380887, 22.703934186773225}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 134.80737103947345, 1);

    currentView_4.setInput(new DoubleVector(new double[] {566.5331680267814, 155.85751387827548, 21.422089137269523}), new DoubleVector(new double[] {-236.2847834789616, 155.85751387827548, 21.422089137269523}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 134.80737103947345, 1);
  }
}
