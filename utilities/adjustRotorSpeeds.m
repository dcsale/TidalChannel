% function adjustRotorSpeeds()
%%adjustRotorSpeeds ensures that RPM control uses the correct rotor speeds specified in the "input table"


%% STARTUP - start from a clean slate, and add any dependencies to the path
clear global
close all
clearvars
fclose('all');
clc


addpath(genpath([pwd filesep 'utilities']));
% addpath(genpath([pwd filesep 'utilities']));

%% Main
% Options.filesIO.turbines = 'inputs/turbines.csv';

%% adsf

% get directories and filenames
Options.filesIO = init_cfd();

% read the auxiallary input files
rotors = read_Inputs_Turbines(Options);
probes = read_Inputs_Probes(Options);

% rotors = read_Inputs_Turbines(Options);

% 
% rotors = lookupRotorSpeeds(file_turbines,rotors);

% read the output from the previous starccm iteration
[probes, rotors] = readOutputs(Options.filesIO,probes,rotors);
    
% for n = 1:Mooring.OptionsCFD.nUpdateRPM
%     
%     % RUN STAR-CCM+, and as the velocity field update ... the rotor speed
%     % should also update to perform at target tip-speed-ratio, this call
%     % also updates the positions of the rotors (from the mooring model)
%     % and finally, the starccm solver is run again
%     [probes, rotors] = adjustRotorSpeeds(Mooring,probes,rotors);
%     
%     % read the output from the previous starccm iteration
%     [probes, rotors] = readOutputs(Mooring.OptionsCFD.filesIO,probes,rotors);
% 
% end



% use the last known rotor speed from STAR-CCM+ and then update according to the input table
% compute the new rotor speed based on the updated inflow speeds
% for n = 1:size(rotors.data, 1)
for n = 1:size(rotors.table, 1)
    % read wind and rpm from the file table
%     file_perf  = [filesIO.dir_input filesep 'tables' filesep rotors.tables{n} '.csv'];
%     file_perf  = [filesIO.dir_input filesep 'tables' filesep rotors.data{n,2} '.csv'];
    file_perf  = ['inputs' filesep 'tables' filesep rotors.table{n} '.csv'];

    perf_table = csvread(file_perf,1);
    wind       = perf_table(:,1);
    rpm        = perf_table(:,4);
    new_rpm    = interp1(wind, rpm, rotors.vel(n));
    
%     rotors.data{n,3} = new_rpm;
    rotors.rpm(n) = new_rpm;
end

% write the new coordinates/settings to file (for the next iteration of the CFD model)
% writeInputsRotors(Options.filesIO,rotors);
% 
% 
% %%
% switch Mooring.OptionsCFD.control
%     case 'RPM'
%         % compute new rotor speed and write new inputs files with updated rotor speeds
%         rotors = lookupRotorSpeeds(file_turbines,rotors);
% 
%         % update the Virtual Disks from the updated input files about rotor speed
%         system(run_starccm_command1);
% 
%         % re-run the solver now that Virtual Disk rotor speeds are updated
%         system(run_starccm_command2);
%         % wake is fully developed and turbines operate at target rpm now
% 
%     case 'TSR'
%         error('ERROR: sorry, TSR control is not finished yet.');
% 
%     case 'none'
%         error('ERROR: sorry, "none" control is not finished yet');
% 
%     otherwise
%         error('ERROR: unrecognized option for control.  why you do that?');
% end     
% 
% % read the output from the previous starccm iteration
% [probes, rotors] = readOutputs(Mooring.OptionsCFD.filesIO,probes,rotors);
%     
% end % function
% 
% function [rotors] = lookupRotorSpeeds(file_turbines,rotors)
% %updateRotorSpeeds uses the last known rotor speed from STAR-CCM+ and then update according to the input table
% %   Detailed explanation goes here
% 
% % compute the new rotor speed based on the updated inflow speeds
% for n = 1:size(rotors.data, 1)
%     % read wind and rpm from the file table
% %     file_perf  = [filesIO.dir_input filesep 'tables' filesep rotors.tables{n} '.csv'];
%     file_perf  = [filesIO.dir_input filesep 'tables' filesep rotors.data{n,2} '.csv'];
%     perf_table = csvread(file_perf,1);
%     wind       = perf_table(:,1);
%     rpm        = perf_table(:,4);
%     new_rpm    = interp1(wind, rpm, rotors.vel(n));
%     
%     rotors.data{n,3} = new_rpm;
% end
% 
% % write the new coordinates/settings to file (for the next iteration of the CFD model)
% writeInputsRotors(filesIO,rotors);
%     
% % end % function

