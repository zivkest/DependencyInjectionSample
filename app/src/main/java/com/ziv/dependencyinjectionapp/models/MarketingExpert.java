package com.ziv.dependencyinjectionapp.models;

import com.ziv.dependencyinjectionapp.utils.Constants;
import com.ziv.dependencyinjectionapp.abstractions.IHighTechWorker;

public class MarketingExpert implements IHighTechWorker
{
    private String mMarketingDoc;

    public MarketingExpert(String marketingDoc)
    {
        mMarketingDoc = marketingDoc;
    }

    public boolean addUselessAnalytics()
    {
        return mMarketingDoc!=null && Constants.marketerLikesAnalytics;
    }

    @Override public boolean work()
    {
        return addUselessAnalytics();
    }
}
