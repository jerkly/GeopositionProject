package example.ru.geoinn;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * Shilin Dmitriy
 * 13.07.15.
 * Inno Geoposition Service
 */
public class GroupMapFragment extends Fragment implements OnMapReadyCallback {

    private MapFragment mapFragment;
    private LatLng groupCoordinate;
    private CameraUpdate cameraUpdate;

    public static final String GROUP_ID = "groupId";
    public static final String GROUP_LATITUDE = "groupLat";
    public static final String GROUP_LONGITUDE = "groupLongitude";


    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mapFragment = savedInstanceState.getParcelable("map");
        }
        return inflater.inflate(R.layout.map_fragment, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.group_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap = mapFragment.getMap();
        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);


        //TODO: get data from server
        double latitude = 0;
        double longitude = 0;
        String placeTitle = "";

        MarkerOptions markerOptions = new MarkerOptions();

        groupCoordinate = new LatLng(latitude, longitude);
        googleMap.addMarker(markerOptions.position(groupCoordinate).title(placeTitle));
        cameraUpdate = CameraUpdateFactory.newLatLngZoom(groupCoordinate, 15);
        googleMap.moveCamera(cameraUpdate);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        //todo: press back and app crush. it happens because of onActivityCreated called only one times and then
        outState.putParcelable("map", (Parcelable) mapFragment);
        super.onSaveInstanceState(outState);
    }
}
