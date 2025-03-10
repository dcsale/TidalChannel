function [rotors] = writeInputsRotors(filesIO,rotors)
%writeInputs writes the input files for STAR-CCM+
%   Detailed explanation goes here

% construct the cell array
rotors_vars = {'name','table','rotor_rpm','x','y','z','nx','ny','nz','rotor_radius','hub_radius','rotor_thick'};
rotors.data = horzcat(rotors.name, ...
                      rotors.table, ...
                      num2cell( rotors.rpm ), ...
                      num2cell( rotors.x ), ...
                      num2cell( rotors.y ), ...
                      num2cell( rotors.z ), ...
                      num2cell( rotors.nx ), ...
                      num2cell( rotors.ny ), ...
                      num2cell( rotors.nz ), ...
                      num2cell( rotors.radius_rotor ), ...
                      num2cell( rotors.radius_hub ), ...
                      num2cell( rotors.thickness ));                  
R           = vertcat(rotors_vars, rotors.data);

% write to CSV file
f = CsvWriter(filesIO.turbines,'delimiter',',');
f.append(R);
f.close();

end

