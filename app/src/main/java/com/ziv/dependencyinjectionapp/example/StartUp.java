package com.ziv.dependencyinjectionapp.example;

import android.support.annotation.DrawableRes;

import com.ziv.dependencyinjectionapp.abstractions.AppProducedListener;
import com.ziv.dependencyinjectionapp.example.implementations.IAppMakerImpl;
import com.ziv.dependencyinjectionapp.models.App;

public abstract class StartUp
{
    @DrawableRes protected int mCompanyLogo;
    private IAppMakerImpl mAppMaker;

    public StartUp()
    {
        // Create a new appMaker implementation once
        mAppMaker = new IAppMakerImpl();
    }


    /**
     * This is what startup knows how to do, "produceApp"
     * @param appProducedListener - A callback notifying the UI that the app is ready
     */
    public void produceApp(final AppProducedListener appProducedListener)
    {
        //The startup's appMaker produces the app
        mAppMaker.makeApp(new AppProducedListener()
        {
            @Override public void OnAppProduced(App app)
            {
                appProducedListener.OnAppProduced(app);
            }

            @Override public void OnAppProductionFailed(String reason)
            {
                appProducedListener.OnAppProductionFailed(reason);
            }
        });
    }

    @DrawableRes public int getCompanyLogo()
    {
        return mCompanyLogo;
    }
}
