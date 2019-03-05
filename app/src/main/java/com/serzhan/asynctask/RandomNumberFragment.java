package com.serzhan.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.serzhan.R;

import java.util.Random;

public class RandomNumberFragment extends Fragment {

    private TextView mRandomNumberTextView;
    private Random random = new Random();
    private GenerateNumberTask task;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        task = new GenerateNumberTask();
        task.execute();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random_number, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRandomNumberTextView = view.findViewById(R.id.tv_random_number);
    }

    @Override
    public void onDestroy() {
        if(task != null) {
            task.cancel(false);
        }
        super.onDestroy();
    }

    public static RandomNumberFragment newInstance() {
        return new RandomNumberFragment();
    }

    class GenerateNumberTask extends AsyncTask<Void, String, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while(true) {
                publishProgress(String.valueOf(random.nextInt(100)));
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            mRandomNumberTextView.setText(values[0]);
        }
    }
}
