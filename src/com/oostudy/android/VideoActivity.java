package com.oostudy.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;


public class VideoActivity extends Activity {


    private View mVideoControllerContainer;
    private TextView mCurTimeText;
    private SeekBar mSeekBar;
    private TextView mTotalTimeText;

    private ImageButton mPrevBtn;
    private ImageButton mPlayBtn;
    private ImageButton mNextBtn;


    private long mTouchTimeDelay;
    private static long DEFALY_DELAY = 400L;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        initUI();

    }

    private void initUI() {
        mVideoControllerContainer = (View) findViewById(R.id.video_controller_container);
        mCurTimeText = (TextView) findViewById(R.id.time_current);
        mSeekBar = (SeekBar) findViewById(R.id.media_progress);
        mTotalTimeText = (TextView) findViewById(R.id.time_total);

        mPrevBtn = (ImageButton) findViewById(R.id.prev_btn);
        mPlayBtn = (ImageButton) findViewById(R.id.play_btn);
        mNextBtn = (ImageButton) findViewById(R.id.next_btn);
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
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            mTouchTimeDelay = System.currentTimeMillis();
        else if (event.getAction() == MotionEvent.ACTION_UP) {
            long time = System.currentTimeMillis() - mTouchTimeDelay;
            if (time < DEFALY_DELAY) {
                //mVideoControllerContainer.setVisibility();
            }
        }

        return true;
    }


    
}
