package com.ziv.dependencyinjectionapp.models;

import com.ziv.dependencyinjectionapp.utils.Constants;
import com.ziv.dependencyinjectionapp.abstractions.IHighTechWorker;

public class Designer implements IHighTechWorker
{
    private String mDesignSpec;

    public Designer(String designSpec)
    {
        mDesignSpec = designSpec;
    }

    public boolean design()
    {
        return mDesignSpec!=null && Constants.designersIsGood;
    }

    @Override public boolean work()
    {
        return design();
    }
}
