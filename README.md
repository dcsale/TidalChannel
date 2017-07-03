This code builds STAR-CCM+ simulations of wind/marine turbines within an atmospheric/oceanic boundary layer.

To get started, all of the user inputs are contained within these files, which are convenienty edited with a spreadsheet software or text editor:
* inputs/user_inputs_TidalChannel.csv (this contains setup of the atmospheric boundary conditions and mesh generation)
* inputs/turbines_TidalChannel.csv (this contains setup of turbine types, control, and farm layout)
* inputs/probes_lines_TidalChannel.csv (this contains setup of point/line probes for post-processing of CFD output)

After editing all the User Input files, create a folder called "cases", then you can start STAR-CCM+ from within the "TidalChannel/cases" directory.  Start star-ccm+ and open a 
new simulation, then run the macro file "macros/_main_0.java"

The series of macros will
* create the CAD geometry of tidal/flume/wind channel, and assign Boundary Conditions to all regions (like inlets, outlets, seabeds, surfaces)
* create Virtual Disks to represent turbines, with mesh refinements around turbines and turbulent wakes, and monitors/reports/plots of turbine diagnostics (like power output, 
thrust, inflow, etc.)
* create the mesh and run the solver, auto-saving Scenes and run-time post-processing

Finally, you should results with a directory containing the final simulations and figures within the "cases" folders

And to run this on a supercomputer, see the "submit-Hyak.sh" script, and run:
    qsub submit-job-Hyak.sh

