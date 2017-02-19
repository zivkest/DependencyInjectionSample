package com.ziv.dependencyinjectionapp.settings;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ziv.dependencyinjectionapp.DependencyInjectionApplication;
import com.ziv.dependencyinjectionapp.R;

import javax.inject.Inject;
import javax.inject.Provider;


public class SettingsFragment extends Fragment
{

    public static final int DELAY_MILLIS = 3000;
    @Inject protected Context mContext;
    @Inject protected Resources mResources;
    @Inject protected Provider<ServiceRunBySettingsImpl> mServiceRunBySettingsImpl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        doSomethingInIntervals();
        return view;
    }

    private void doSomethingInIntervals()
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                mServiceRunBySettingsImpl.get().doSomething();
            }
        }, DELAY_MILLIS);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ((DependencyInjectionApplication) getActivity().getApplication()).createSettingsComponent().inject(this);
    }



    @Override
    public void onDestroy()
    {
        super.onDestroy();
        ((DependencyInjectionApplication) getActivity().getApplication()).releaseSettingsComponent();
    }

    public SettingsFragment()
    {
        // Required empty public constructor
    }


    public static SettingsFragment newInstance()
    {
        return new SettingsFragment();
    }


}
