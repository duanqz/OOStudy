package com.oostudy.android;

import android.app.Activity;
import android.os.Bundle;

import com.baidu.cyberplayer.core.BVideoView;

public class VideoPlayerActivity extends Activity {

    private BVideoView mVideoView;
    private String mUriString = "http://pan.baidu.com/s/1eQkWADs";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio_player);

        mVideoView = (BVideoView) findViewById(R.id.video_view);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mVideoView.setVideoPath(mUriString);
        mVideoView.start();
    }
    
}
