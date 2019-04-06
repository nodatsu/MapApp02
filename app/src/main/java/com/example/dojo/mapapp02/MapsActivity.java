package com.example.dojo.mapapp02;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        // 航空写真に変更
//        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//        // 渋滞状況を表示
//        mMap.setTrafficEnabled(true);
        // 現在の位置情報を表示
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 1);
            return;
        }
        mMap.setMyLocationEnabled(true);

        // 現在位置表示の有効化
        mMap.setMyLocationEnabled(true);
        // 設定の取得
        UiSettings settings = mMap.getUiSettings();
        // コンパスの有効化
        settings.setCompassEnabled(true);
        // 現在位置に移動するボタンの有効化
        settings.setMyLocationButtonEnabled(true);
        // ズームイン・アウトボタンの有効化
        settings.setZoomControlsEnabled(true);
        // すべてのジェスチャーの有効化
        settings.setAllGesturesEnabled(true);
        // 回転ジェスチャーの有効化
        settings.setRotateGesturesEnabled(true);
        // スクロールジェスチャーの有効化
        settings.setScrollGesturesEnabled(true);
        // Tlitジェスチャー(立体表示)の有効化
        settings.setTiltGesturesEnabled(true);
        // ズームジェスチャー(ピンチイン・アウト)の有効化
        settings.setZoomGesturesEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        // ソウルにピンを立てる
        LatLng seoul = new LatLng(37.555277, 126.969014);
//        mMap.addMarker(new MarkerOptions().position(seoul).title("ソウルです"));

        // カメラをソウルに設定
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul, 15));

//        // 地図に線を引く(ロサンゼルス - ソウル間) 直線 + 測地線
//        LatLng los = new LatLng(34.054267, -118.250177);
//        // 測地線
//        PolylineOptions geodesics = new PolylineOptions();
//        geodesics.add(seoul, los);
//        geodesics.geodesic(true);
//        geodesics.color(Color.RED);
//        geodesics.width(3);
//        mMap.addPolyline(geodesics);
//
//        // 直線
//        PolylineOptions straight = new PolylineOptions();
//        straight.add(seoul, los);
//        straight.geodesic(false);
//        straight.color(Color.YELLOW);
//        straight.width(3);
//        mMap.addPolyline(straight);

//        // 地図に図形(ポリゴン)を描く(ロサンゼルス - ソウル - シドニー を結ぶ三角形)
//        LatLng los = new LatLng(34.054267, -118.250177);
//        PolygonOptions options = new PolygonOptions();
//        options.add(los, seoul, sydney);
//        options.strokeColor(Color.BLUE);
//        options.strokeWidth(5);
//        options.fillColor(Color.argb(0x80, 0x00, 0xff, 0xff));
//        mMap.addPolygon(options);

//        // 地図に円を描く(東京から半径200kmの範囲をしめす円)
//        LatLng tokyo = new LatLng(35.684086, 139.755999);
//        CircleOptions circleOptions = new CircleOptions();
//        circleOptions.center(tokyo);
//        circleOptions.radius(200000);
//        Circle circle = mMap.addCircle(circleOptions);
//        // 後からも設定変更できる
//        circle.setStrokeColor(Color.argb(0x99, 0x33, 0x99, 0xFF));
//        circle.setStrokeWidth(10.0f);
//        circle.setFillColor(Color.argb(0x44, 0x33, 0x99, 0xFF));

//        // 画像をマップに表示(オーバーレイ)
//        GroundOverlayOptions options = new GroundOverlayOptions();
//        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.drawable.ame);
//        options.image(bitmap);
//        options.anchor(0.5f,0.5f);
//        options.position(seoul, 300.0f, 300.0f);
//        GroundOverlay overlay = mMap.addGroundOverlay(options);
//        overlay.setTransparency(0.3f);

        // マーカーを画像でカスタマイズ
        MarkerOptions options = new MarkerOptions();
        options.position(seoul);
        options.title("ソウルです。");
        options.snippet("ここはそうるですよ。");
        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.yajirushi));
        mMap.addMarker(options);
    }
}
