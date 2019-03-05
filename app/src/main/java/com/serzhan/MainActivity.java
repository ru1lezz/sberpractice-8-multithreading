package com.serzhan;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.serzhan.asynctask.RandomNumberFragment;
import com.serzhan.loader.ChangeColorFragment;
import com.serzhan.thread.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragments();
    }

    private void initFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.frame_layout3, RecyclerViewFragment.newInstance())
                .add(R.id.frame_layout2, RandomNumberFragment.newInstance())
                .add(R.id.frame_layout1, ChangeColorFragment.newInstance())
                .commitNow();
    }
}
