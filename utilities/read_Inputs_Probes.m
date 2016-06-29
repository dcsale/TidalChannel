function probes = read_Inputs_Probes(Options)

% read the "input file" regarding turbines
fid = fopen(Options.filesIO.probes);
data = textscan(fid, '%s %f %f %f', ...
                     'headerLines',     1, ...
                     'CollectOutput',   1, ...
                     'Delimiter',       ',');
fclose(fid);

% reshape data
probes.name         = data{1}(:,1);
probes.x            = data{2}(:,1);
probes.y            = data{2}(:,2);
probes.z            = data{2}(:,3);

end % function