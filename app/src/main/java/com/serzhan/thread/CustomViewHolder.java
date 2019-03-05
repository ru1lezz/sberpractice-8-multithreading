package com.serzhan.thread;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.serzhan.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    private TextView mTextView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.textView);
    }

    public void bind(String value) {
        mTextView.setText(value);
    }
}
