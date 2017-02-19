package com.ziv.dependencyinjectionapp.settings;

import android.util.Log;

public class ServiceRunBySettingsImpl implements ServiceRunBySettings
{
    private static final String LOG_TAG = ServiceRunBySettingsImpl.class.getSimpleName();

    @Override
    public void doSomething() {
        Log.d(LOG_TAG, "ServiceRunBySettingsImpl did something");
    }
}
