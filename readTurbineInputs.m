function rotors = readTurbineInputs(Options)

% read the "input file" regarding turbines
fid = fopen(Options.filesIO.turbines);
data = textscan(fid, '%s %s %f %f %f %f %f %f %f %f %f %f', ...
                     'headerLines',     1, ...
                     'CollectOutput',   1, ...
                     'Delimiter',       ',');
% data = textscan(fid, '%s %f %f %f %f %f %f %f %f %f %f', ...
%                      'headerLines',     1, ...
%                      'CollectOutput',   1, ...
%                      'Delimiter',       ',');
fclose(fid);

% reshape data
rotors.name         = data{1}(:,1);
rotors.table        = data{1}(:,2);

rotors.rpm          = data{2}(:,1);
rotors.x            = data{2}(:,2);
rotors.y            = data{2}(:,3);
rotors.z            = data{2}(:,4);
rotors.nx           = data{2}(:,5);
rotors.ny           = data{2}(:,6);
rotors.nz           = data{2}(:,7);
rotors.radius_rotor = data{2}(:,8);
rotors.radius_hub   = data{2}(:,9);
rotors.thickness    = data{2}(:,10);

end % function