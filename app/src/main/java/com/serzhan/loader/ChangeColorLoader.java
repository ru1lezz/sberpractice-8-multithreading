package com.serzhan.loader;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.Random;

public class ChangeColorLoader extends AsyncTaskLoader<Integer> {
    private Random mRandom = new Random();

    public ChangeColorLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public Integer loadInBackground() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Color.argb(255, mRandom.nextInt(255), mRandom.nextInt(255), mRandom.nextInt(255));
    }

    @Override
    public void deliverResult(@Nullable Integer data) {
        super.deliverResult(data);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
    }
}
