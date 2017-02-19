package com.ziv.dependencyinjectionapp.abstractions;

import com.ziv.dependencyinjectionapp.models.App;

public interface AppProducedListener
{
    void OnAppProduced(App app);
    void OnAppProductionFailed(String reason);
}
