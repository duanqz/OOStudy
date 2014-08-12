package com.oostudy.android;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class DrawerActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        setupActionBar();
    }

    private void setupActionBar() {
        ActionBar actionBar = this.getActionBar();
        actionBar.setCustomView(R.layout.actionbar_main);
        actionBar.setDisplayShowCustomEnabled(true);
    }
}
