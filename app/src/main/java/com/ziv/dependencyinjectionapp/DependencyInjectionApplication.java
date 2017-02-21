package com.ziv.dependencyinjectionapp;

import android.app.Application;

import com.ziv.dependencyinjectionapp.dependencyInjection.AndroidModule;
import com.ziv.dependencyinjectionapp.dependencyInjection.AppMakersModule;
import com.ziv.dependencyinjectionapp.dependencyInjection.ApplicationComponent;
import com.ziv.dependencyinjectionapp.dependencyInjection.DaggerApplicationComponent;
import com.ziv.dependencyinjectionapp.dependencyInjection.RequirementsDocModule;
import com.ziv.dependencyinjectionapp.settings.SettingsComponent;
import com.ziv.dependencyinjectionapp.settings.SettingsModule;

public class DependencyInjectionApplication extends Application
{
    private static ApplicationComponent mComponent;
    private SettingsComponent mSettingsComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder()
                .appMakersModule(new AppMakersModule())
                .requirmentsDocModule(new RequirementsDocModule())
                .androidModule(new AndroidModule(this)).build();
    }

    public static ApplicationComponent getComponent()
    {
        return mComponent;
    }


    public SettingsComponent createSettingsComponent() {
        mSettingsComponent = mComponent.plus(new SettingsModule());
        return mSettingsComponent;
    }

    public void releaseSettingsComponent() {
        mSettingsComponent = null;
    }
}
