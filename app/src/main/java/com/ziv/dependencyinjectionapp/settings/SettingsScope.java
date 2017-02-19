package com.ziv.dependencyinjectionapp.settings;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import dagger.releasablereferences.CanReleaseReferences;


@CanReleaseReferences
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface SettingsScope {
}
