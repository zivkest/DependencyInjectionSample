package com.ziv.dependencyinjectionapp.api;

import com.ziv.dependencyinjectionapp.ApiConfigurator;
import com.ziv.dependencyinjectionapp.utils.Constants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.RestAdapter;

@Module
public class ApiModule
{
    ApiConfigurator mApiConfigurator;

    public ApiModule(ApiConfigurator apiConfigurator) {
        mApiConfigurator = apiConfigurator;
    }

    @Provides
    @Named(Constants.Injection.Named.FORECAST_API_KEY)
    public String provideForecastIOApiKey() {
        return mApiConfigurator.getUrl();
    }

    @Provides
    public Endpoint provideEndpoint(@Named(Constants.Injection.Named.FORECAST_API_KEY) String apiKey) {
        return new ForecastIOApiEndpoint().setApiKey(mApiConfigurator.getUrl(), apiKey);
    }

    @Provides
    @Singleton
    public RestAdapter provideRestAdapter(Endpoint endpoint) {
        return new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(endpoint).build();
    }

    public class ForecastIOApiEndpoint implements Endpoint {

        private String url;

        public ForecastIOApiEndpoint setApiKey(String base, String apiKey) {
            url = base + apiKey;
            return this;
        }

        @Override public String getName() {
            return "default Forecast.io endpoint";
        }

        @Override public String getUrl() {
            if (url == null) throw new IllegalStateException("API key not set.");
            return url;
        }
    }
}
