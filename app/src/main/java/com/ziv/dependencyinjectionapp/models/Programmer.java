package com.ziv.dependencyinjectionapp.models;

import com.ziv.dependencyinjectionapp.utils.Constants;
import com.ziv.dependencyinjectionapp.abstractions.IHighTechWorker;

public class Programmer implements IHighTechWorker
{
    protected String mEngeneeringDoc;

    public Programmer(String engeneeringDoc)
    {
        mEngeneeringDoc = engeneeringDoc;
    }

    public boolean code()
    {
        return mEngeneeringDoc != null && Constants.programerIsGood;
    }

    @Override public boolean work()
    {
        return code();
    }
}
