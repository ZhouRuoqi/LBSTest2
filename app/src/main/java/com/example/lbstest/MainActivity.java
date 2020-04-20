package com.example.lbstest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MKMapViewListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity{
    private MapView mMapView = null;
    private BaiduMap mBaiduMap;
    private BMapManager mBMapManager;
    MKMapViewListener mMapListener = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        //显示卫星图层
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
        mBMapManager = new BMapManager(this);
        mBMapManager.init("7SdFKx0iHdXYW3GgG9GQjsLowLljHG6fY", new MKGeneralListener() {

            //授权错误的时候调用的回调函数
            @Override
            public void onGetPermissionState(int iError) {
                if (iError ==  MKEvent.ERROR_PERMISSION_DENIED) {
                    showToast("API KEY错误, 请检查！");
                }
            }

    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时必须调用mMapView. onResume ()
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时必须调用mMapView. onPause ()
        mMapView.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时必须调用mMapView.onDestroy()
        mMapView.onDestroy();
    }
}