package com.ziv.dependencyinjectionapp.example.implementations;

import android.util.Log;

import com.ziv.dependencyinjectionapp.abstractions.IAppMaker;
import com.ziv.dependencyinjectionapp.abstractions.AppProducedListener;
import com.ziv.dependencyinjectionapp.abstractions.IDesignStudio;
import com.ziv.dependencyinjectionapp.abstractions.ISoftwareHouse;
import com.ziv.dependencyinjectionapp.abstractions.IMarketingCompany;
import com.ziv.dependencyinjectionapp.models.App;
import com.ziv.dependencyinjectionapp.models.Designer;
import com.ziv.dependencyinjectionapp.models.MarketingExpert;
import com.ziv.dependencyinjectionapp.models.Programmer;

public class IAppMakerImpl implements IAppMaker
{
    @Override
    public void makeApp(AppProducedListener appProducedListener)
    {

        ISoftwareHouse ISoftwareHouseImpl = new ISoftwareHouse()
        {
            @Override
            public Programmer getProgrammer()
            {
                return new Programmer("engineerirng plans");
            }
        };

        IDesignStudio IDesignStudioImpl = new IDesignStudio()
        {
            @Override
            public Designer getDesigner()
            {
                return new Designer("design specs");
            }
        };

        IMarketingCompany IMarketingCompanyImpl = new IMarketingCompany()
        {
            @Override
            public MarketingExpert getMarketingExpert()
            {
                return new MarketingExpert("list of analytics");
            }
        };

        Programmer programmer = ISoftwareHouseImpl.getProgrammer();
        Designer designer = IDesignStudioImpl.getDesigner();
        MarketingExpert marketingExpert = IMarketingCompanyImpl.getMarketingExpert();


        App app =  new App(programmer, designer, marketingExpert);

        if(app.isAppReady())
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
