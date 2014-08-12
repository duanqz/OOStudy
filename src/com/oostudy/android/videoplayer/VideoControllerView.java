package com.oostudy.android.videoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.baidu.cyberplayer.core.BVideoView;
import com.oostudy.android.R;

public class VideoControllerView extends RelativeLayout {


    private TextView mCurTimeText;
    private SeekBar mSeekBar;
    private TextView mTotalTimeText;

    private ImageButton mPrevBtn;
    private ImageButton mPlayBtn;
    private ImageButton mNextBtn;

    private BVideoView mVideoView;

    public VideoControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_video_controller, this);
    }

    @Override
    protected void onFinishInflate() {
        mCurTimeText = (TextView) findViewById(R.id.time_current);
        mSeekBar = (SeekBar) findViewById(R.id.media_progress);
        mTotalTimeText = (TextView) findViewById(R.id.time_total);

        mPrevBtn = (ImageButton) findViewById(R.id.prev_btn);
        mPlayBtn = (ImageButton) findViewById(R.id.play_btn);
        mNextBtn = (ImageButton) findViewById(R.id.next_btn);
    }

    public void bindVideoView(BVideoView videoView) {
        mVideoView = videoView;
        registerListeners();
    }

    private void registerListeners() {
        mPlayBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mVideoView.isPlaying()) {
                    mPlayBtn.setImageResource(R.drawable.play_btn);
                    mVideoView.pause();
                } else {
                    mPlayBtn.setImageResource(R.drawable.stop_btn);
                    mVideoView.resume();
                }
            }
        });
        
    }

    public void setShown(boolean shown) {
        setVisibility(shown ? View.VISIBLE : View.INVISIBLE);
    }

}
