package com.ziv.dependencyinjectionapp.dependencyInjection;

import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.StartUp;
import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations.Falcore;
import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations.SomeFreeLancer;
import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations.YellowTale;
import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations.ZemingoGroup;
import com.ziv.dependencyinjectionapp.settings.SettingsComponent;
import com.ziv.dependencyinjectionapp.settings.SettingsModule;

import dagger.Component;

// refer to the component as a singleton as so not to create new ones

@Component(modules = {AppMakersModule.class, RequirmentsDocModule.class, AndroidModule.class})
public interface ApplicationComponent
{
    void inject(StartUp target);
    void inject(SomeFreeLancer target);
    void inject(Falcore target);
    void inject(YellowTale target);
    void inject(ZemingoGroup target);

    SettingsComponent plus(SettingsModule module);
}
