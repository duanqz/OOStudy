package com.oostudy.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.oostudy.android.videoplayer.baidu.BaiduVideoPlayer;


public class VideoActivity extends Activity {

    private BaiduVideoPlayer mBaiduVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        initUI();

    }

    private void initUI() {
        mBaiduVideoPlayer = (BaiduVideoPlayer) findViewById(R.id.video_player);
    }

    @Override
    protected void onStart() {
        super.onStart();

        handleIntent();
    }

    private void handleIntent() {
        Intent intent = this.getIntent();
        intent.getData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBaiduVideoPlayer.start();
    }
}
