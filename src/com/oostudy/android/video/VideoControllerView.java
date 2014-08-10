package com.oostudy.android.video;

import com.oostudy.android.R;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class VideoControllerView extends View {

    private TextView mCurTimeText;
    private SeekBar mSeekBar;
    private TextView mTotalTimeText;

    private ImageButton mPrevBtn;
    private ImageButton mPlayBtn;
    private ImageButton mNextBtn;

    public VideoControllerView(Context context) {
        super(context);
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

    public void hide() {
        
    }

}
