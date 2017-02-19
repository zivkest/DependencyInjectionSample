package com.ziv.dependencyinjectionapp.example_dependency_injection;

import android.support.annotation.DrawableRes;

import com.ziv.dependencyinjectionapp.abstractions.AppProducedListener;
import com.ziv.dependencyinjectionapp.abstractions.IAppMaker;
import com.ziv.dependencyinjectionapp.models.App;

public abstract class StartUp
{

    @DrawableRes protected int mCompanyLogo;


    // Provide the client with an app making company ro produce its app
    public void produceApp(IAppMaker someCompanyOrFreeLance, final AppProducedListener appProducedListener)
    {

        //The app making company or freelancer will make the app
        someCompanyOrFreeLance.makeApp(new AppProducedListener()
        {
            @Override public void OnAppProduced(App app)
            {

                // once the app is done, deliver it back to the client
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
