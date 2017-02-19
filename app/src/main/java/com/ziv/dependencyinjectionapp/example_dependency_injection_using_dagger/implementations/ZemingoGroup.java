package com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations;

import android.util.Log;

import com.ziv.dependencyinjectionapp.DependencyInjectionApplication;
import com.ziv.dependencyinjectionapp.abstractions.IAppMaker;
import com.ziv.dependencyinjectionapp.abstractions.AppProducedListener;
import com.ziv.dependencyinjectionapp.abstractions.IDesignStudio;
import com.ziv.dependencyinjectionapp.abstractions.IMarketingCompany;
import com.ziv.dependencyinjectionapp.abstractions.ISoftwareHouse;
import com.ziv.dependencyinjectionapp.models.App;

import javax.inject.Inject;

public class ZemingoGroup implements IAppMaker
{
    @Inject ISoftwareHouse mISoftwareHouse;
    @Inject IDesignStudio mIDesignStudio;
    @Inject IMarketingCompany mIMarketingCompany;

    public ZemingoGroup()
    {
        DependencyInjectionApplication.getComponent().inject(this);
    }

    @Override
    public void makeApp(final AppProducedListener appProducedListener)
    {

        final App app = new App(mISoftwareHouse.getProgrammer(), mIDesignStudio.getDesigner(), mIMarketingCompany.getMarketingExpert());
        if (app.isAppReady())
        {
            appProducedListener.OnAppProduced(app);
        }
        else
        {
            String reason = "everybody played vive all day";
            Log.e("Error", reason);
            appProducedListener.OnAppProductionFailed(reason);
        }
    }
}
