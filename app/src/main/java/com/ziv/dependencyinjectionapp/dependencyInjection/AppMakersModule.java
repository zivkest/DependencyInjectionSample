package com.ziv.dependencyinjectionapp.dependencyInjection;

import com.ziv.dependencyinjectionapp.abstractions.IAppMaker;
import com.ziv.dependencyinjectionapp.abstractions.IDesignStudio;
import com.ziv.dependencyinjectionapp.abstractions.IMarketingCompany;
import com.ziv.dependencyinjectionapp.abstractions.ISoftwareHouse;
import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations.Falcore;
import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations.PandaPepper;
import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations.YellowTale;
import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations.ZemingoGroup;
import com.ziv.dependencyinjectionapp.models.Engineer;
import com.ziv.dependencyinjectionapp.models.Programmer;
import com.ziv.dependencyinjectionapp.utils.Constants;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

@Module
public class AppMakersModule
{

    @Reusable
    @Provides
    IAppMaker provideAppMaker()
    {
        return new ZemingoGroup();
    }

    @Provides
    ISoftwareHouse provideSoftwareHouse()
    {
        return new Falcore();
    }

    @Provides
    IDesignStudio provideDesignStudio()
    {
        return new YellowTale();
    }

    @Provides
    IMarketingCompany provideMarketingCompany(@Named(Constants.Injection.Named.MARKETING_DOC) String marketingDoc)
    {
        return new PandaPepper(marketingDoc);
    }

    @Provides Programmer provideProgramer(@Named(Constants.Injection.Named.ENGINEERING_DOC) String engineeringDoc)
    {
        return new Engineer(engineeringDoc);
    }
}
