package com.serzhan.loader;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.serzhan.R;

public class ChangeColorFragment extends Fragment implements LoaderManager.LoaderCallbacks<Integer> {

    private static final int LOADER_ID = 10000;
    private ConstraintLayout mConstraintLayout;
    private Loader<Integer> mLoader;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoader = getLoaderManager().initLoader(LOADER_ID, Bundle.EMPTY,this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mConstraintLayout = view.findViewById(R.id.constraint_layout1);
    }

    @NonNull
    @Override
    public Loader<Integer> onCreateLoader(int id, @Nullable Bundle args) {
        return new ChangeColorLoader(getContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Integer> loader, Integer data) {
        mConstraintLayout.setBackgroundColor(data);
        mLoader.forceLoad();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Integer> loader) {

    }

    public static Fragment newInstance() {
        return new ChangeColorFragment();
    }
}
