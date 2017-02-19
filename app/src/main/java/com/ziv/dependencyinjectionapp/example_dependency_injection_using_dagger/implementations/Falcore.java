package com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations;

import com.ziv.dependencyinjectionapp.DependencyInjectionApplication;
import com.ziv.dependencyinjectionapp.abstractions.ISoftwareHouse;
import com.ziv.dependencyinjectionapp.models.Programmer;
import com.ziv.dependencyinjectionapp.utils.Constants;

import javax.inject.Inject;
import javax.inject.Named;

public class Falcore implements ISoftwareHouse
{
    @Inject
    @Named(Constants.Injection.Named.DESIGN_SPEC)
    String mEngineeringDocument;

    @Inject
    Programmer mProgrammer;

    public Falcore()
    {
        DependencyInjectionApplication.getComponent().inject(this);
    }

    @Override
    public Programmer getProgrammer()
    {
        return mProgrammer;
    }
}
