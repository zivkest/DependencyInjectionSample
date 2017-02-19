package com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations;

import com.ziv.dependencyinjectionapp.DependencyInjectionApplication;
import com.ziv.dependencyinjectionapp.abstractions.IDesignStudio;
import com.ziv.dependencyinjectionapp.models.Designer;
import com.ziv.dependencyinjectionapp.utils.Constants;

import javax.inject.Inject;
import javax.inject.Named;

public class YellowTale implements IDesignStudio
{
    @Inject
    @Named(Constants.Injection.Named.DESIGN_SPEC)
    String mDesignSpec;

    public YellowTale()
    {
        DependencyInjectionApplication.getComponent().inject(this);
    }

    @Override
    public Designer getDesigner()
    {
        return new Designer(mDesignSpec);
    }
}
