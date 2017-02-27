package com.ziv.dependencyinjectionapp;

import android.app.Application;

import com.ziv.dependencyinjectionapp.api.ApiModule;
import com.ziv.dependencyinjectionapp.dependencyInjection.AndroidModule;
import com.ziv.dependencyinjectionapp.dependencyInjection.AppMakersModule;
import com.ziv.dependencyinjectionapp.dependencyInjection.ApplicationComponent;
import com.ziv.dependencyinjectionapp.dependencyInjection.DaggerApplicationComponent;
import com.ziv.dependencyinjectionapp.dependencyInjection.RequirementsDocModule;

public class DependencyInjectionApplication extends Application
{
    private static ApplicationComponent mComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder()
                .appMakersModule(new AppMakersModule())
                .requirementsDocModule(new RequirementsDocModule())
                /*the next two modules are declared but not used in code, which is why there is a line over them*/
                .apiModule(new ApiModule(ApiConfigurator.getInstance()))
                .androidModule(new AndroidModule(this)).build();
    }

    public static ApplicationComponent getComponent()
    {
        return mComponent;
    }
}
