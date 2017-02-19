package com.ziv.dependencyinjectionapp.models;

import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations.SomeFreeLancer;

public class App
{
    private boolean mAppLooksGood;
    private boolean mHasAlotOfAnalitycs;
    private boolean mHasAmazingCode;

    public App(Programmer programmer, Designer designer, MarketingExpert marketingExpert)
    {
        //... everyone is doing their jobs...
        mHasAmazingCode = programmer.code();
        mAppLooksGood = designer.design();
        mHasAlotOfAnalitycs = marketingExpert.addUselessAnalytics();
    }

    public App(SomeFreeLancer someFreeLancer)
    {
        //... The freelance is doing all the work...
        mHasAmazingCode = mAppLooksGood = mHasAlotOfAnalitycs = someFreeLancer.work();
    }

    public boolean isAppReady()
    {
        return mAppLooksGood && mHasAlotOfAnalitycs && mHasAmazingCode;
    }
}
