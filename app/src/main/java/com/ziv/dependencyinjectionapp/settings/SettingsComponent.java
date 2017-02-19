package com.ziv.dependencyinjectionapp.settings;

import dagger.Subcomponent;
import dagger.releasablereferences.CanReleaseReferences;

@SettingsScope
@Subcomponent(modules = { SettingsModule.class })
public interface SettingsComponent {
    void inject(SettingsFragment target);
}
