package example.ru.geoinn;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);

        return super.onCreateView(inflater, container, savedInstanceState);
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
}
