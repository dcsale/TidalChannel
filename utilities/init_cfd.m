function filesIO = init_cfd()
%initMain read the user inputs, and does some bookkeeping about file I/O
%   Detailed explanation goes here

%% run from the utilities directory

%% some bookkeeping
filesIO.dir_input       = [pwd filesep 'inputs'];
filesIO.dir_output      = [pwd filesep 'outputs'];
filesIO.turbines        = [filesIO.dir_input filesep 'turbines.csv'];
filesIO.probes          = [filesIO.dir_input filesep 'probes_points.csv'];
% filesIO.environment     = [filesIO.dir_output filesep 'environment.csv'];    

% % filesIO.fileOut_probes = [filesIO.dir_output filesep 'probes-velocity.csv'];
filesIO.fileOut_probesX = [filesIO.dir_output filesep 'probes-velocity-x.csv'];
filesIO.fileOut_probesY = [filesIO.dir_output filesep 'probes-velocity-y.csv'];
filesIO.fileOut_probesZ = [filesIO.dir_output filesep 'probes-velocity-z.csv'];
filesIO.fileOut_rotors  = [filesIO.dir_output filesep 'rotors-velocity.csv'];  
filesIO.fileOut_thrust  = [filesIO.dir_output filesep 'rotors-thrust.csv'];  
filesIO.fileOut_torque  = [filesIO.dir_output filesep 'rotors-torque.csv'];  


end

