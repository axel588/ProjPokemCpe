package fr.cpe.pokemongoplagiat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;
import java.util.Random;

import fr.cpe.pokemongoplagiat.databinding.PokemonMapBinding;

public class PokemonMapFragment extends Fragment {

    public GeoPoint[] points = new GeoPoint[]{
            new GeoPoint(45.7661, 4.7185),
            new GeoPoint(45.8021, 4.6796),
            new GeoPoint(45.7919, 4.7152),
            new GeoPoint(45.7982, 4.7153),
            new GeoPoint(45.8019, 4.7271),
            new GeoPoint(45.8313, 4.7051),
            new GeoPoint(45.8241, 4.7529),
            new GeoPoint(45.8171, 4.7036),
            new GeoPoint(45.8302, 4.7056),
            new GeoPoint(45.8082, 4.7066),
            new GeoPoint(45.8304, 4.7076),
            new GeoPoint(45.8024, 4.7076),
            new GeoPoint(45.8083, 4.7271),
            new GeoPoint(45.8184, 4.7184),
            new GeoPoint(45.8155, 4.7015),
            new GeoPoint(45.8062, 4.6985),
            new GeoPoint(45.8205, 4.7176),
            new GeoPoint(45.8255, 4.7196),
            new GeoPoint(45.8242, 4.7269),
            new GeoPoint(45.8213, 4.7201),
            new GeoPoint(45.8251, 4.7089),
            new GeoPoint(45.8355, 4.7291),
            new GeoPoint(45.8332, 4.7275),
            new GeoPoint(45.8118, 4.7214),
            new GeoPoint(45.8224, 4.7264),
            new GeoPoint(45.8278, 4.7164),
            new GeoPoint(45.8218, 4.7123),
            new GeoPoint(45.8081, 4.7024),
            new GeoPoint(45.8296, 4.7143),
            new GeoPoint(45.8216, 4.7184),
            new GeoPoint(45.8086, 4.6984),
            new GeoPoint(45.8206, 4.7171),
            new GeoPoint(45.8348, 4.7232),
            new GeoPoint(45.8148, 4.7173),
            new GeoPoint(45.8241, 4.7313),
            new GeoPoint(45.8283, 4.7217),
            new GeoPoint(45.8319, 4.7071),
            new GeoPoint(45.8194, 4.7116),
            new GeoPoint(45.8199, 4.7156),
            new GeoPoint(45.8177, 4.7287),
            new GeoPoint(45.8309, 4.7297),
            new GeoPoint(45.8287, 4.7271),
            new GeoPoint(45.8233, 4.7067),
            new GeoPoint(45.8325, 4.7065),
            new GeoPoint(45.8303, 4.7245),
            new GeoPoint(45.8129, 4.6962),
            new GeoPoint(45.8293, 4.7273),
            new GeoPoint(45.8219, 4.7164),
            new GeoPoint(45.8172, 4.6994),
            new GeoPoint(45.8149, 4.7045),
            new GeoPoint(45.8155, 4.7171),
            new GeoPoint(45.8235, 4.7245),
            new GeoPoint(45.8265, 4.7142),
            new GeoPoint(45.8331, 4.7253),
            new GeoPoint(45.8246, 4.7052),
            new GeoPoint(45.8172, 4.7259),
            new GeoPoint(45.8304, 4.7274),
            new GeoPoint(45.8316, 4.7259),
            new GeoPoint(45.8236, 4.7102),
            new GeoPoint(45.8186, 4.7269),
            new GeoPoint(45.8151, 4.7083),
            new GeoPoint(45.8165, 4.7015),
            new GeoPoint(45.8255, 4.7125),
            new GeoPoint(45.8325, 4.7299),
            new GeoPoint(45.8292, 4.7115),
            new GeoPoint(45.8252, 4.7209),
            new GeoPoint(45.8244, 4.7094),
            new GeoPoint(45.8201, 4.7043),
            new GeoPoint(45.8223, 4.7311),
            new GeoPoint(45.8294, 4.7171),
            new GeoPoint(45.8269, 4.7239),
            new GeoPoint(45.8234, 4.7164),
            new GeoPoint(45.8232, 4.7073),
            new GeoPoint(45.8132, 4.7023),
            new GeoPoint(45.8229, 4.7229),
            new GeoPoint(45.8161, 4.7226),
            new GeoPoint(45.8079, 4.7151),
            new GeoPoint(45.8181, 4.7096),
            new GeoPoint(45.8209, 4.7246),
            new GeoPoint(45.8272, 4.7243),
            new GeoPoint(45.8219, 4.7266),
            new GeoPoint(45.8324, 4.7245),
            new GeoPoint(45.8192, 4.7283),
            new GeoPoint(45.8155, 4.7062),
            new GeoPoint(45.8175, 4.7275),
            new GeoPoint(45.8245, 4.7275),
            new GeoPoint(45.8211, 4.7144),
    };






    private MapView mapView;
    public PokemonMapBinding binding;
    private MyLocationNewOverlay mLocationOverlay;

    public Context context;
    private SensorManager sensorManager;
    private SensorEventListener sensorListener;
    public LocationListener locationListener;
    private LocationManager locationManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //android.view.ContextThemeWrapper
        binding = DataBindingUtil.inflate(inflater,
                R.layout.pokemon_map,container,false);
        PokemonMapViewModel viewModel = new PokemonMapViewModel();
        binding.setPokemonMapViewModel(viewModel);

        /*this.sensorManager = (SensorManager)
                getActivity().getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(
                Sensor.TYPE_MAGNETIC_FIELD) != null){
            this.sensorListener = new SensorEventListener() {
                @Override
                public final void onAccuracyChanged(Sensor sensor, int
                        accuracy) {
                    // Que faire si la precision change ´
                }
                @Override
                public final void onSensorChanged(SensorEvent event) {
                    //la taille de values depend du capteur ´
                    //lumiere/proximit ` e 1 seule valeur ´
                    //gyroscope, accelero,... 3 (Axes X,Y,Z)

                    float X = event.values[0];
                    float Y = event.values[1];
                    float Z = event.values[2];
                    binding.mapView.setX(X);
                    binding.mapView.setY(Y);
                    binding.mapView.setZ(Z);
                    binding.mapView.getController().setCenter(new GeoPoint(Z, Y));

                }
            };

        } else {
            Context context = getActivity().getApplicationContext();
            CharSequence text = "Capteur absent";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }*/

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // If permission not granted, request for it
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 2/*PERMISSION_REQUEST_CODE*/);

        }
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            this.locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    binding.mapView.getController().setCenter(new GeoPoint(latitude, longitude));


                    binding.mapView.getOverlays().clear();

                    // Display a Pokemon marker at the specified location
                    Marker pokemonMarker = new Marker(binding.mapView);
                    GeoPoint pokemonPoint = new GeoPoint(latitude, longitude);
                    Drawable persoIcon = ContextCompat.getDrawable(getContext(), org.osmdroid.library.R.drawable.person); // assuming you have a Pokemon icon in your drawable folder
                    pokemonMarker.setIcon(persoIcon);
                    pokemonMarker.setPosition(pokemonPoint);
                    binding.mapView.getOverlays().add(pokemonMarker);

                    //On vérifie les marqueurs dans un rayon de 1km
                    for (GeoPoint point : points) {
                        if (point.distanceToAsDouble(new GeoPoint(latitude, longitude)) <= 1000) {
                            Marker marker = new Marker(binding.mapView);

                            int pokemonId = 1 + new Random().nextInt(50 - 1 + 1);
                            String iconName = "p" + pokemonId;
                            int iconResourceId = getResources().getIdentifier(iconName, "drawable", getContext().getPackageName());
                            Drawable pokeIcon = ContextCompat.getDrawable(getContext(), iconResourceId);

                            marker.setPosition(point);
                            // assuming you have a Pokemon icon in your drawable folder
                            marker.setIcon(pokeIcon);
                            binding.mapView.getOverlays().add(marker);
                        }
                    }


                    binding.mapView.getController().setCenter(new GeoPoint(latitude, longitude));
                    binding.mapView.getController().setZoom(18.0);
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {}

                @Override
                public void onProviderEnabled(String provider) {}

                @Override
                public void onProviderDisabled(String provider) {}
            };

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        } else {
            CharSequence text = "GPS provider is not enabled";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(getActivity().getApplicationContext(), text, duration);
            toast.show();
        }

        context = binding.getRoot().getContext();
        Configuration.getInstance().load(context,
                PreferenceManager.
                        getDefaultSharedPreferences(context));


        binding.mapView.setTileSource(
                TileSourceFactory.MAPNIK);

        binding.mapView.setMultiTouchControls(true);



        this.mLocationOverlay = new
                MyLocationNewOverlay(new
                GpsMyLocationProvider(context),binding.mapView);
        this.mLocationOverlay.enableMyLocation();
        binding.mapView.getOverlays()
                .add(this.mLocationOverlay);
        // Créer un GeoPoint avec la coordonnée
        GeoPoint point = new GeoPoint(45.5,5.5);
        binding.mapView.getController().setCenter(point);
        binding.mapView.getController().setZoom(12.0);
        Marker marker = new Marker(binding.mapView);
        marker.setPosition(new
                GeoPoint(45.5,5.5));
        marker.setAnchor(Marker.ANCHOR_CENTER,
                Marker.ANCHOR_CENTER);
        marker.setIcon(getResources().getDrawable(R.drawable.eau,context.getTheme()));
        marker.setTitle("Start point");
        binding.mapView.getOverlays().add(marker);



        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.mapView.onResume();
        /*Sensor sensor = sensorManager.getDefaultSensor(
                Sensor.TYPE_MAGNETIC_FIELD);
        this.locationManager.register(sensorListener, sensor,
                SensorManager.SENSOR_DELAY_NORMAL);*/
        if (locationListener != null) {
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }
        }

    }
    @Override
    public void onPause() {
        super.onPause();
        binding.mapView.onPause();
        //sensorManager.unregisterListener(sensorListener);
        if (locationListener != null) {
            locationManager.removeUpdates(locationListener);
        }
    }
    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (int i = 0; i < grantResults.length; i++) {
            permissionsToRequest.add(permissions[i]);
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    this.getActivity(),
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    private void requestPermissionsIfNecessary(String[] permissions) {
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this.getActivity(), permission)
                    != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted
                permissionsToRequest.add(permission);
            }
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    this.getActivity(),
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }
}