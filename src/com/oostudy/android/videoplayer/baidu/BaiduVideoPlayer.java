package com.oostudy.android.videoplayer.baidu;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.baidu.cyberplayer.core.BVideoView;
import com.oostudy.android.R;
import com.oostudy.android.videoplayer.VideoControllerView;
import com.oostudy.android.videoplayer.VideoPlayer;

public class BaiduVideoPlayer extends RelativeLayout implements VideoPlayer {


    private final String TAG = BaiduVideoPlayer.class.getSimpleName();

    private final static String AK = "EKCmWpyXavPGlhQsQiRaP1t5";
    private final static String SK = "eu6O8mhsh09ppFP7G76aozenGyRhVHGb";

    private RelativeLayout mVideoViewContainer;
    private VideoControllerView mVideoControllerView;

    private BVideoView mVideoView;
    private String mVideoSource;

    private long mTouchTimeDelay;
    private static long DEFALY_DELAY = 400L;

    static {
        BVideoView.setAKSK(AK, SK);
    }

    public BaiduVideoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_video_player, this);
    }


    @Override
    protected void onFinishInflate() {
        mVideoViewContainer = (RelativeLayout) findViewById(R.id.video_view);
        mVideoView = new BVideoView(getContext());
        mVideoViewContainer.addView(mVideoView);

        mVideoControllerView = (VideoControllerView) findViewById(R.id.video_controller_view);
        mVideoControllerView.bindVideoView(mVideoView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            mTouchTimeDelay = System.currentTimeMillis();
        else if (event.getAction() == MotionEvent.ACTION_UP) {
            long time = System.currentTimeMillis() - mTouchTimeDelay;
            if (time < DEFALY_DELAY) {
                mVideoControllerView.setShown(!mVideoControllerView.isShown());
            }
        }

        return true;
    }

    public void start() {
        mVideoSource = "http://pan.baidu.com/play/video#video/path=%2F%E6%88%91%E7%9A%84%E8%A7%86%E9%A2%91%2FCoron-video.webm&t=0";
        mVideoView.setVideoPath(mVideoSource);
        mVideoView.showCacheInfo(true);
        mVideoView.start();
    }
}
