package com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger;

import android.support.annotation.DrawableRes;

import com.ziv.dependencyinjectionapp.abstractions.IAppMaker;
import com.ziv.dependencyinjectionapp.DependencyInjectionApplication;
import com.ziv.dependencyinjectionapp.abstractions.AppProducedListener;
import com.ziv.dependencyinjectionapp.models.App;

import javax.inject.Inject;

public abstract class StartUp
{

    @Inject IAppMaker mAppMaker;

    @DrawableRes protected int mCompanyLogo;


    public StartUp()
    {
        DependencyInjectionApplication.getComponent().inject(this);
    }

    public void produceApp(final AppProducedListener appProducedListener)
    {
        mAppMaker.makeApp(new AppProducedListener()
        {
            @Override
            public void OnAppProduced(App app)
            {
                appProducedListener.OnAppProduced(app);
            }

            @Override
            public void OnAppProductionFailed(String reason)
            {
                appProducedListener.OnAppProductionFailed(reason);
            }
        });
    }

    @DrawableRes
    public int getCompanyLogo()
    {
        return mCompanyLogo;
    }
}
