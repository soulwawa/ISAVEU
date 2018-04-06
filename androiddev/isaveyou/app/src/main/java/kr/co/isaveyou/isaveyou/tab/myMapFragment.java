    package kr.co.isaveyou.isaveyou.tab;

    import android.Manifest;
    import android.app.AlertDialog;
    import android.content.Context;
    import android.content.DialogInterface;
    import android.content.Intent;
    import android.content.pm.PackageManager;
    import android.location.Location;
    import android.location.LocationManager;
    import android.os.Build;
    import android.os.Bundle;
    import android.provider.Settings;
    import android.support.annotation.NonNull;
    import android.support.annotation.Nullable;
    import android.support.v4.app.ActivityCompat;
    import android.support.v4.app.Fragment;
    import android.support.v4.content.ContextCompat;
    import android.text.Layout;
    import android.util.Log;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;

    import com.google.android.gms.common.ConnectionResult;
    import com.google.android.gms.common.api.GoogleApiClient;
    import com.google.android.gms.common.api.PendingResult;
    import com.google.android.gms.common.api.ResultCallback;
    import com.google.android.gms.common.api.Status;
    import com.google.android.gms.location.LocationListener;
    import com.google.android.gms.location.LocationRequest;
    import com.google.android.gms.location.LocationServices;
    import com.google.android.gms.location.places.AutocompleteFilter;
    import com.google.android.gms.location.places.Place;
    import com.google.android.gms.location.places.PlaceLikelihood;
    import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
    import com.google.android.gms.location.places.Places;
    import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
    import com.google.android.gms.location.places.ui.PlaceSelectionListener;
    import com.google.android.gms.maps.CameraUpdateFactory;
    import com.google.android.gms.maps.GoogleMap;
    import com.google.android.gms.maps.MapView;
    import com.google.android.gms.maps.MapsInitializer;
    import com.google.android.gms.maps.OnMapReadyCallback;
    import com.google.android.gms.maps.model.BitmapDescriptorFactory;
    import com.google.android.gms.maps.model.LatLng;
    import com.google.android.gms.maps.model.Marker;
    import com.google.android.gms.maps.model.MarkerOptions;

    import kr.co.isaveyou.isaveyou.R;


    public class myMapFragment extends Fragment implements OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener,LocationListener {
        private GoogleMap googleMap = null;
        private MapView mapView = null;
        private GoogleApiClient googleApiClient = null;
        private GoogleApiClient mGoogleApiClient = null;
        private Marker currentMarker = null;

        private static final LatLng DEFAULT_LOCATION = new LatLng(37.56,126.97);
        private static final String TAG = "myMapFragment";
        private static final int GPS_ENABLE_REQUEST_CODE = 2001;
        private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 2002;
        private static final int UPDATE_INTERVAL_MS = 15000;
        private static final int FASTEST_UPDATE_INTERVAL_MS = 15000;

        private final static int MAXENTRIES = 5;
        private String [] LikelyPlaceNames = null;
        private String [] LikelyAddress = null;
        private String [] LikelyAttributions = null;
        private LatLng [] LikelyLatLngs = null;

        public void setCurrentLocation(Location location, String markerTitle, String markerSnippet){
            if(currentMarker != null){
                currentMarker.remove();
            }
            if(location != null){
                //현재 위치의 위도, 경도 가져옴
                LatLng currentLocation = new LatLng(location.getLatitude(),location.getLongitude());
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(currentLocation);
                markerOptions.title(markerTitle);
                markerOptions.snippet(markerSnippet);
                markerOptions.draggable(true);
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
                currentMarker = this.googleMap.addMarker(markerOptions);

                this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));
                return;
            }
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(DEFAULT_LOCATION);
            markerOptions.title(markerTitle);
            markerOptions.snippet(markerSnippet);
            markerOptions.draggable(true);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(DEFAULT_LOCATION));
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragment_map_google,container,false);

            mapView = (MapView) layout.findViewById(R.id.map);
            mapView.getMapAsync(this);
            PlaceAutocompleteFragment autoCompleteFragment = (PlaceAutocompleteFragment) getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
            AutocompleteFilter typeFilter = new AutocompleteFilter.Builder().setTypeFilter(AutocompleteFilter.TYPE_FILTER_ADDRESS).build();
            autoCompleteFragment.setFilter(typeFilter);
            autoCompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
                @Override
                public void onPlaceSelected(Place place) {
                    Location location = new Location("");
                    location.setLatitude(place.getLatLng().latitude);
                    location.setLongitude(place.getLatLng().longitude);
                    Log.v(TAG, "Place : " + place.getName());
                    setCurrentLocation(location, place.getName().toString(), place.getAddress().toString());
                }

                @Override
                public void onError(Status status) {
                    Log.v(TAG, "An error occureed : " + status);
                }
            });
            return layout;
        }

        @Override
        public void onStart() {
            super.onStart();
            mapView.onStart();
        }

        @Override
        public void onStop() {
            super.onStop();
            mapView.onStop();
            if(googleApiClient != null && googleApiClient.isConnected()){
                googleApiClient.disconnect();
            }
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            mapView.onSaveInstanceState(outState);
        }

        @Override
        public void onResume() {
            super.onResume();
            mapView.onResume();
        }

        @Override
        public void onPause() {
            super.onPause();
            mapView.onPause();

            if(googleApiClient != null && googleApiClient.isConnected()){
                LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient,this);
                googleApiClient.disconnect();
            }
        }

        @Override
        public void onLowMemory() {
            super.onLowMemory();
            mapView.onLowMemory();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            mapView.onLowMemory();
            if(googleApiClient!=null){
                googleApiClient.unregisterConnectionCallbacks(this);
                googleApiClient.unregisterConnectionFailedListener(this);
                if(googleApiClient.isConnected()){
                    LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient,this);
                    googleApiClient.disconnect();
                }
            }
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            //activity가 처음 생성될 때 실행되는 함수
            MapsInitializer.initialize(getActivity().getApplicationContext());
            if(mapView != null){
                mapView.onCreate(savedInstanceState);
            }
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            // OnMapReadyCallback implements 해야 mapView.getMapAsync(this); 사용가능. this 가 OnMapReadyCallback
            this.googleMap = googleMap;

            //런타임 퍼미션 요청 대화상자나 GPS 활성 요청 대화상자 보이기전에 지도의 초기위치를 서울로 이동
            setCurrentLocation(null,"위치정보 가져올 수 없음", "위치 퍼미션과 GPS 활성 여부 확인");

            //나침반이 나타나도록 설정
            googleMap.getUiSettings().setCompassEnabled(true);
            //매끄럽게 이동함
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));

            //API23이상이면 런타임 퍼미션 처리 필요
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                //사용 권한 체크
                int hasFineLocationPermission = ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION);
                if(hasFineLocationPermission == PackageManager.PERMISSION_DENIED){
                    //사용 권한이 없을 경우, 권한 재요청
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                } else {
                    //사용 권한이 있는 경우
                    if(googleApiClient == null){
                        buildGoogleApiClient();
                    }
                    if(ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                        googleMap.setMyLocationEnabled(true);
                    }
                }
            }else {
                if(googleApiClient == null){
                    buildGoogleApiClient();
                }
                googleMap.setMyLocationEnabled(true);
            }
        }

        private void buildGoogleApiClient(){
            googleApiClient = new GoogleApiClient.Builder(getActivity())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .addApi(Places.GEO_DATA_API)
                    .addApi(Places.PLACE_DETECTION_API)
                    .enableAutoManage(getActivity(),this)
                    .build();
            googleApiClient.connect();
        }

        public  boolean checkLocationServicesStatus(){
            LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

            return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        }

        @Override
        public void onConnected(@Nullable Bundle bundle) {
            if(!checkLocationServicesStatus()){
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("위치 서비스 비활성화");
                builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n" + "위치 설정을 수정하십시오.");
                builder.setCancelable(true);
                builder.setPositiveButton("설정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent callGPSSettingIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
            }

            LocationRequest locationRequest = new LocationRequest();
            locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            locationRequest.setInterval(UPDATE_INTERVAL_MS);
            locationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_MS);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(ActivityCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.ACCESS_FINE_LOCATION )== PackageManager.PERMISSION_GRANTED){
                    LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient,locationRequest,this);
                }
            }else {
                LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient,locationRequest,this);
                this.googleMap.getUiSettings().setCompassEnabled(true);
                this.googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));
            }
        }

        @Override
        public void onConnectionSuspended(int cause) {
            if(cause == CAUSE_NETWORK_LOST){
                Log.v(TAG, " onConnectionSuspended() : Google Play services" + "connection lost. Cause : network lost");
            } else if (cause == CAUSE_SERVICE_DISCONNECTED){
                Log.v(TAG, "onConnectionSuspended() : Google Play services" + "connection lost. Cause : service disconnected");
            }
        }

        @Override
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            Location location = new Location("");
            location.setLatitude(DEFAULT_LOCATION.latitude);
            location.setLongitude(DEFAULT_LOCATION.longitude);

            setCurrentLocation(location, "위치정보 가져올 수 없음", "위치 퍼미션과 GPS 활성 여부 확인");
        }

        @Override
        public void onLocationChanged(Location location) {
            Log.v(TAG, "onLocationChanged call..");
            searchCurrentPlaces();
        }
        private void searchCurrentPlaces(){
            @SuppressWarnings("MissingPermission")
            PendingResult<PlaceLikelihoodBuffer>result = Places.PlaceDetectionApi.getCurrentPlace(googleApiClient, null);
            result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
                @Override
                public void onResult(@NonNull PlaceLikelihoodBuffer placeLikelihoods) {
                    int i = 0;
                    LikelyPlaceNames = new String[MAXENTRIES];
                    LikelyAddress = new String[MAXENTRIES];
                    LikelyAttributions = new String[MAXENTRIES];
                    LikelyLatLngs = new LatLng[MAXENTRIES];
                    for(PlaceLikelihood placeLikelihood : placeLikelihoods){
                        LikelyPlaceNames[i] = (String) placeLikelihood.getPlace().getName();
                        LikelyAddress[i] = (String) placeLikelihood.getPlace().getAddress();
                        LikelyAttributions[i] = (String) placeLikelihood.getPlace().getAttributions();
                        LikelyLatLngs[i] = placeLikelihood.getPlace().getLatLng();
                        i++;
                        if(i>MAXENTRIES - 1){
                            break;
                        }
                    }
                    placeLikelihoods.release();

                    Location location = new Location("");
                    location.setLatitude(LikelyLatLngs[0].latitude);
                    location.setLongitude(LikelyLatLngs[0].longitude);

                    setCurrentLocation(location, LikelyPlaceNames[0],LikelyAddress[0]);
                }
            });
        }
    }
