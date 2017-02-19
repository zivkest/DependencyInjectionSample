package com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations;

import android.util.Log;

import com.ziv.dependencyinjectionapp.utils.Constants;
import com.ziv.dependencyinjectionapp.DependencyInjectionApplication;
import com.ziv.dependencyinjectionapp.abstractions.IAppMaker;
import com.ziv.dependencyinjectionapp.abstractions.AppProducedListener;
import com.ziv.dependencyinjectionapp.abstractions.IDesignStudio;
import com.ziv.dependencyinjectionapp.abstractions.IHighTechWorker;
import com.ziv.dependencyinjectionapp.abstractions.ISoftwareHouse;
import com.ziv.dependencyinjectionapp.abstractions.IMarketingCompany;
import com.ziv.dependencyinjectionapp.models.App;
import com.ziv.dependencyinjectionapp.models.Designer;
import com.ziv.dependencyinjectionapp.models.MarketingExpert;
import com.ziv.dependencyinjectionapp.models.Programmer;

import javax.inject.Inject;
import javax.inject.Named;

public class SomeFreeLancer implements IAppMaker, ISoftwareHouse, IDesignStudio, IMarketingCompany, IHighTechWorker
{

    @Inject
    @Named("ENGINEERING_DOC")
    String mEngineeringDoc;

    @Inject
    @Named(Constants.Injection.Named.DESIGN_SPEC)
    String mDesignSpec;

    @Inject
    @Named(Constants.Injection.Named.MARKETING_DOC)
    String mMarketingDoc;

    public SomeFreeLancer()
    {
        DependencyInjectionApplication.getComponent().inject(this);
    }

    @Override public void makeApp(AppProducedListener appProducedListener)
    {
        final App app = new App(this);
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

    @Override public Designer getDesigner()
    {
        return new Designer(mEngineeringDoc);
    }

    @Override public MarketingExpert getMarketingExpert()
    {
        return new MarketingExpert(mDesignSpec);
    }

    @Override public Programmer getProgrammer()
    {
        return new Programmer(mEngineeringDoc);
    }

    @Override public boolean work()
    {
        return getDesigner().design() && getProgrammer().code() && getMarketingExpert().addUselessAnalytics();
    }
}
