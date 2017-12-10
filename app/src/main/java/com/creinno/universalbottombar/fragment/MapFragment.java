package com.creinno.universalbottombar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creinno.universalbottombar.R;


public class MapFragment extends Fragment {
    private static final String ARGS_LAYOUT_FILE_URL = MapFragment.class.getName() + ".layoutFileName";
    private static String TAG = "AddEventPartBasic";
    View rootView;

    public static MapFragment newInstance(String pageName) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_LAYOUT_FILE_URL, pageName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_map, container, false);

        return rootView;
    }


}



