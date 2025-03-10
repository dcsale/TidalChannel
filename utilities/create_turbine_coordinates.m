%% start up
clear all
clc

% add external dependencies
% addpath([pwd filesep 'stlread']);


%% turbine parameters (user inputs)
nRotors  = 49*2;   % note: each turbine has two rotors
nRpT     = 2;    % rotors per turbine
diameter = 20;

nTurbines = nRotors/nRpT;

%% coordinates of the coastline elevations
% probably easiest to hardcode these value from "topo-cascadia" scripts
% no ... try to read the STL file mesh and figure out the coordinates
% in a more programmatic way
% this stl takes wayyy too much RAM for an STL file of about ~30 megabytes

% this should be a binary file (should update to an absolute path)
% file_mesh = 'mesh_seabed-smooth-no-sill_coastlines-vertical_v1.stl';
% casename = 'mesh_seabed-smooth-no-sill_coastlines-vertical_v1';
casename = 'surface-mesh_seabed-smooth-sill';
% casename = 'Admiralty_10turbines';


%%
file_mesh = [pwd filesep casename '.mat'];

% [v, f, n, c, stltitle] = stlread(file_mesh);

% read in the coordinates used to make the STL as Matlab format (less memory) 
load(file_mesh)



%% set coordinates for turbine placement
% these are somewhat specific to the DOE Ref Model dual-rotor turbine


% 10 turbines single wall
x1 = 10000 .* ones(1, nTurbines);
x2 = 10000 .* ones(1, nTurbines);
y1 = linspace(660, 2500, nTurbines);
y2 = y1 + 28;

x1 = linspace(660, 2500, 2*nTurbines);
x2 = linspace(660, 2500, 2*nTurbines);
y1 = linspace(660, 2500, 2*nTurbines);
y2 = y1 + 28;


% 49 turbines, 7x7 staggered grid, spacing 6D lateral and 10D streamwise
x1 = [ 0  0  0  0  0  0  0, ...
      10 10 10 10 10 10 10, ...
      20 20 20 20 20 20 20, ...
      30 30 30 30 30 30 30, ...
      40 40 40 40 40 40 40, ...
      50 50 50 50 50 50 50, ...
      60 60 60 60 60 60 60] .* diameter + 9400;
y1 = [0 6 12 18 24 30 36, ...
      3 9 15 21 27 33 39, ...
      0 6 12 18 24 30 36, ...
      3 9 15 21 27 33 39, ...
      0 6 12 18 24 30 36, ...
      3 9 15 21 27 33 39, ...
      0 6 12 18 24 30 36] .* diameter + 660;
x2 = x1;
y2 = y1 + 28;


% 49 turbines, inspired from OpenTidalFarm adjoint method
h = 25;
k = 0;
a = 25;
b = 10;
y_fence = [5 10 15 20 25 30 35 40 45];
% x_fence = (sqrt( (1 - ((y_fence - h).^2)/a^2).*b^2 ) + k);

x_fence_up   = 30 + [6.0000    8.0000    9.1652    9.7980   10.0000    9.7980    9.1652    8.0000    6.0000];
x_fence_down = -x_fence_up + 100;
x_fence_mid  = [50 50 50 50 50 50 50 50 50];
y_fence_up   = [5 10 15 20 25 30 35 40 45];
y_fence_down = y_fence_up;
y_fence_mid  = y_fence_up;


x1 = [0 15 25 30 45 50 55 70 75 85 100, ...
      0 15 25 30 45 50 55 70 75 85 100, ...
      x_fence_up, ...
      x_fence_mid, ...
      x_fence_down];
% x2 = x1;

y1 = [0 0 0 0 0 0 0 0 0 0 0, ...
      50 50 50 50 50 50 50 50 50 50 50, ...
      y_fence_up, ...
      y_fence_mid, ...
      y_fence_down];
% y2 = y1 + 28;  
  

% now scale by diameter and channel dimensions
x1 = x1 .* diameter + 9000;
x2 = x1;
y1 = y1 .* diameter + 660;
y2 = y1 + 28;

%% make coorections to any turbine near the free surface limit
z1 = zeros(1, nTurbines);
z2 = zeros(1, nTurbines);
for n = 1:nTurbines

    [x_value x_index] = min(abs(x_dom - x1(n)));
    [y_value y_index] = min(abs(y_dom - y1(n)));

    
    z1(n) = zz_total(y_index, x_index) + 30;
    z2(n) = zz_total(y_index, x_index) + 30;
    
    if z1(n) > -10
        fprintf(1, 'WARNING: turbine %g is too close to surface', n);
    end
    
end
  
%% normal vector for each turbine
na = [-1; 1];
% from "point & click" on Admiralty map, a staggered grid
x1 = [570, ...
      610, ...
      660, ...   
      790, ...
      720, ...   
      850, ...
      880, ...
      920, ...	     
      1060, ...	
      1000];
y1 = [720, ...
      830, ...
      930, ...    
      800, ...
      690, ...    
      620, ...
      720, ...
      800, ...
      670, ...
      590];

  
nb  = [cosd(-90) -sind(-90); sind(-90) cosd(-90)]*na;
ang = rad2deg( atan2(nb(2), nb(1)) );
x2  = x1 + 28*cosd(ang);
y2  = y1 + 28*sind(ang);


file_depths = '/mnt/data-RAID-1/danny/star-ccm+/Admiralty-Inlet/depths_for_turbine_coordinates.csv';
M = csvread(file_depths,1,0); 

x_dom    = M(:,2);
y_dom    = M(:,3);
zz_total = M(:,4);

% make coorections to any turbine near the free surface limit
z1 = zeros(1, nTurbines);
z2 = zeros(1, nTurbines);
for n = 1:nTurbines

%     [x_value x_index] = min(abs(x_dom - x1(n)));
%     [y_value y_index] = min(abs(y_dom - y1(n)));
    r1 = sqrt((x1(n) - x_dom).^2 + ...
              (y1(n) - y_dom).^2);
    r2 = sqrt((x2(n) - x_dom).^2 + ...
              (y2(n) - y_dom).^2);
    
    [r1_value r1_index] = min(r1);
    [r2_value r2_index] = min(r2);
    
    z1(n) = zz_total(r1_index) + 30;
    z2(n) = z1(n);
    
    
    
    if z1(n) > -10
        fprintf(1, 'WARNING: turbine %g is too close to surface', n);
    end
    
end











%% format the coordinates for easy copy-paste into a STAR-CCM+ macro
X = [x1, x2];
Y = [y1, y2];
Z = [z1, z2];

xyz = [X' Y' Z'];

csvwrite(['turbine-coordinates_' casename '.csv'], xyz);

%% Plots
figure()

exaggerate_z = 1;

[xx, yy] = meshgrid(x_dom, y_dom);

surf(xx, yy, zz_total .* exaggerate_z, ...
    'EdgeColor','none');

hold on
nlevels = 21;
contour3(xx, yy, zz_total .* exaggerate_z, nlevels-1,'r')

% add labels
xlabel('streamwise, x (meters)')
ylabel('crossflow, y (meters)')
zlabel('depth, z (meters)')

% adjust appearance
% demcmap(zz_total, 32)
% cmap = haxby(nlevels);
% colormap(cmap);
colorbar
shading interp
% camlight headlight
camlight left
camlight right
lighting gouraud
% camproj('perspective')
% axis vis3d
set(gcf, 'renderer', 'zbuffer')



% 
% % point and click
view(0,90)
% 
% [xt, yt] = ginput();
% 
% % round to nearest accuracy
% accuracy = 50;  
% xt = round(xt ./ accuracy).*accuracy;
% yt = round(yt ./ accuracy).*accuracy;


hold on
scatter3(x1, y1, z1, 'filled')
scatter3(x2, y2, z2, 'filled')




