package com.ziv.dependencyinjectionapp.dependencyInjection;

import com.ziv.dependencyinjectionapp.utils.Constants;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class RequirementsDocModule
{

    // Using this annotation i can make sure that if someone requires a string with the "Named" annotation
    // of "Constants.Injection.Named.requirments", i will always provide him with this sting
    @Provides
    @Named(Constants.Injection.Named.ENGINEERING_DOC)
    public String provideEngineeringDoc()
    {
        return Constants.ENGINEERING_DOC;
    }

    @Provides
    // Using this annotation i can make sure that if someone requires a string with the "Named" annotation
    // of "Constants.Injection.Named.DESIGN_SPEC", i will always provide him with this sting
    @Named(Constants.Injection.Named.DESIGN_SPEC)
    String provideDesignSpec()
    {
        return Constants.DESIGN_SPEC;
    }

    @Provides
    // Using this annotation i can make sure that if someone requires a string with the "Named" annotation
    // of "Constants.Injection.Named.MARKETING_DOC", i will always provide him with this sting
    @Named(Constants.Injection.Named.MARKETING_DOC)
    String provideMarketingDoc()
    {
        return Constants.MARKETING_DOC;
    }
}
