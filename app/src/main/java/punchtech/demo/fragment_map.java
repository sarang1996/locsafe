package punchtech.demo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by ASUS on 11-01-2017.
 */

public class fragment_map extends Fragment implements OnMapReadyCallback {

    // Google Map
    private GoogleMap googleMap;

    GoogleMapOptions options = new GoogleMapOptions();

    private ArrayList<LatLng> latlngs = new ArrayList<>();

    Map<LatLng, String> temp = new HashMap<>();
    SupportMapFragment mapFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);

        try {
            mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapwhere);

            if(mapFragment == null) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                mapFragment = SupportMapFragment.newInstance();
                fragmentTransaction.replace(R.id.mapwhere, mapFragment).commit();
            }

            if(mapFragment != null) {
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        if(googleMap != null) {
                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(23.10, 72.44), 8.0f));

        /*Bitmap.Config conf = Bitmap.Config.ARGB_8888;
        Bitmap bmp = Bitmap.createBitmap(200, 50, conf);
        Canvas canvas = new Canvas(bmp);

        Paint paint = new Paint();
        paint.setColor(0XFF000000);
        paint.setStrokeWidth(20f);
        paint.setTextSize(20f);
        canvas.drawText("Dhen ten nen", 0, 50, paint); // paint defines the text color, stroke width, size*/


        /*latlngs.add(new LatLng(23.10,72.44));
        latlngs.add(new LatLng(23.30,72.44));
        latlngs.add(new LatLng(23.50,72.64));

        temp.put(new LatLng(23.10,72.44),"aaa");
        temp.put(new LatLng(23.30,72.44),"bbb");
        temp.put(new LatLng(23.50,72.64),"ccc");*/


        /*for (LatLng point : temp) {
            marker = googleMap.addMarker(new MarkerOptions().position(point).title("aaa"));
            marker.showInfoWindow();

            *//*googleMap.addMarker(new MarkerOptions()
                    .position(point)
                    //.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker2))
                    .icon(BitmapDescriptorFactory.fromBitmap(bmp))
                    .anchor(0.5f, 1)
            );*//*

        }*/
                            Marker marker = googleMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(23.10, 72.44))
                                    .title("Manali"));
                            marker.showInfoWindow();

                            marker = googleMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(23.30, 72.44))
                                    .title("Kishan"));
                            marker.showInfoWindow();

                            marker = googleMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(23.50, 72.64))
                                    .title("Yash"));
                            marker.showInfoWindow();

                            googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                                @Override
                                public void onInfoWindowClick(Marker marker) {
                /*Intent intent1 = new Intent(getApplicationContext(), Main2Activity.class);
                String title = marker.getTitle();
                //intent1.putExtra("markertitle", title);
                startActivity(intent1);*/
                                }
                            });

                            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                            options.zoomControlsEnabled(true);
                            options.zoomGesturesEnabled(true);
                            options.compassEnabled(true);
                            options.mapToolbarEnabled(true);
                            options.scrollGesturesEnabled(true);
                            if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                // TODO: Consider calling
                                //    ActivityCompat#requestPermissions
                                // here to request the missing permissions, and then overriding
                                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                //                                          int[] grantResults)
                                // to handle the case where the user grants the permission. See the documentation
                                // for ActivityCompat#requestPermissions for more details.
                                return;
                            }
                            googleMap.setMyLocationEnabled(true);

                        }
                    }
                });
            }

            // Loading map
            /*mapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);*/

            /*FragmentManager fragmentManager = getFragmentManager();
            Fragment fragment = fragmentManager.findFragmentById(R.id.map);
            mapFragment = (SupportMapFragment) fragment;
            mapFragment.getMapAsync(this);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        try {
            // Loading map
            //mapFragment.getMapAsync(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(23.10, 72.44), 8.0f));

        /*Bitmap.Config conf = Bitmap.Config.ARGB_8888;
        Bitmap bmp = Bitmap.createBitmap(200, 50, conf);
        Canvas canvas = new Canvas(bmp);

        Paint paint = new Paint();
        paint.setColor(0XFF000000);
        paint.setStrokeWidth(20f);
        paint.setTextSize(20f);
        canvas.drawText("Dhen ten nen", 0, 50, paint); // paint defines the text color, stroke width, size


        latlngs.add(new LatLng(23.10,72.44));
        latlngs.add(new LatLng(23.30,72.44));
        latlngs.add(new LatLng(23.50,72.64));

        temp.put(new LatLng(23.10,72.44),"aaa");
        temp.put(new LatLng(23.30,72.44),"bbb");
        temp.put(new LatLng(23.50,72.64),"ccc");


        for (LatLng point : temp) {
            marker = googleMap.addMarker(new MarkerOptions().position(point).title("aaa"));
            marker.showInfoWindow();

            googleMap.addMarker(new MarkerOptions()
                    .position(point)
                    //.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker2))
                    .icon(BitmapDescriptorFactory.fromBitmap(bmp))
                    .anchor(0.5f, 1)
            );

        }*/
        Marker marker = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(23.10, 72.44))
                .title("Manali"));
        marker.showInfoWindow();

        marker = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(23.30, 72.44))
                .title("Kishan"));
        marker.showInfoWindow();

        marker = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(23.50, 72.64))
                .title("Yash"));
        marker.showInfoWindow();

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                /*Intent intent1 = new Intent(getApplicationContext(), Main2Activity.class);
                String title = marker.getTitle();
                //intent1.putExtra("markertitle", title);
                startActivity(intent1);*/
            }
        });

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        options.zoomControlsEnabled(true);
        options.zoomGesturesEnabled(true);
        options.compassEnabled(true);
        options.mapToolbarEnabled(true);
        options.scrollGesturesEnabled(true);
        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        googleMap.setMyLocationEnabled(true);

    }
}
