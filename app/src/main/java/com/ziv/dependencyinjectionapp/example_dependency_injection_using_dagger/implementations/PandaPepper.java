package com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations;

import com.ziv.dependencyinjectionapp.abstractions.IMarketingCompany;
import com.ziv.dependencyinjectionapp.models.MarketingExpert;

public class PandaPepper implements IMarketingCompany
{
    String mMarketingDoc;

    public PandaPepper(String marketingDoc)
    {
        mMarketingDoc = marketingDoc;
    }

    public MarketingExpert getMarketingExpert()
    {
        return new MarketingExpert(mMarketingDoc);
    }


}
