package com.creinno.universalbottombar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creinno.universalbottombar.R;


public class ListingFragment extends Fragment {

    private static final String ARGS_LAYOUT_FILE_URL = ListingFragment.class.getName() + ".layoutFileName";

    String mPageName;
    private View rootView;


    public static ListingFragment newInstance(String pageName) {
        ListingFragment fragment = new ListingFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_LAYOUT_FILE_URL, pageName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageName = getArguments().getString(ARGS_LAYOUT_FILE_URL);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_list, container, false);


        return rootView;
    }


}
