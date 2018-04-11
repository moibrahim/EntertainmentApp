package com.ibrahim.mohammad.entertainmentapp;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentPost extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_post,
                container, false);
        return view;
    }

    public void setText(String text) {
        //TextView view = (TextView) getView().findViewById(R.id.tvTitle);
        //view.setText(text);
    }
}