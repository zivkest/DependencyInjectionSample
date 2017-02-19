package com.ziv.dependencyinjectionapp.settings;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsModule {
    // All settings screen dependencies go here

    @Provides
    public ServiceRunBySettings provideSettingsService() {
        return new ServiceRunBySettingsImpl();
    }
}
