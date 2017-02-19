package com.ziv.dependencyinjectionapp.models;

import com.ziv.dependencyinjectionapp.utils.Constants;

public class Engineer extends Programmer
{
    public Engineer(String engeneeringDoc)
    {
        super(engeneeringDoc);
    }

    public boolean code()
    {
        return mEngeneeringDoc!=null && Constants.programerIsGood;
    }
}
