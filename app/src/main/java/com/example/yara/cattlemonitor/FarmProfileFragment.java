package com.example.yara.cattlemonitor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class FarmProfileFragment extends Fragment {

    FragmentTabHost tabHost ;


    public FarmProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_farm_profile , container , false) ;

        tabHost = new FragmentTabHost(getActivity());
        tabHost.setup(getActivity(), getChildFragmentManager(), R.id.farmProfileFragmentLayout);

        tabHost.addTab(tabHost.newTabSpec("test").setIndicator("test") , FarmInfoFragment.class , null);
        tabHost.addTab(tabHost.newTabSpec("test2").setIndicator("test2") , HomePageFragment.class , null);

        return tabHost;

    }

}
