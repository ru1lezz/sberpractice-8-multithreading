package com.serzhan.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.serzhan.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Fragment {

    private List<String> mList;

    private CustomAdapter adapter;
    private CustomThread customThread;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            String value;
            switch (msg.what) {
                case CustomThread.MESSAGE_SEND:
                    value = (String) msg.obj;
                    if(!mList.contains(value)) {
                        addValue(value);
                    }
                    break;
                case CustomThread.MESSAGE_DELETE:
                    value = (String) msg.obj;
                    if(mList.contains(value)){
                        removeValue(value);
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    };

    private void addValue(String value) {
        mList.add(value);
        adapter.setList(mList);
    }

    private void removeValue(String value) {
        mList.remove(value);
        adapter.setList(mList);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mList = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new CustomAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        customThread = new CustomThread(mHandler);
        customThread.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        customThread.interrupt();
    }

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

}
