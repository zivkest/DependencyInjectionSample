package com.ziv.dependencyinjectionapp;

public class ApiConfigurator
{
    String mUrl;

    public String getUrl()
    {
        return mUrl;
    }

    public static ApiConfigurator getInstance()
    {
        return new ApiConfigurator();
    }
}
