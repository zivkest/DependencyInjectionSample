package com.ziv.dependencyinjectionapp.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.ziv.dependencyinjectionapp.utils.Constants;
import com.ziv.dependencyinjectionapp.R;


public class WorkersQualityPopUp extends Dialog implements CompoundButton.OnCheckedChangeListener
{

    private Switch mProgrammerSwitch;
    private Switch mDesignerSwitch;
    private Switch mMarketingSwitch;
    private TextView mMarketingText;
    private TextView mDesignerText;
    private TextView mProgrammerText;

    public WorkersQualityPopUp(Context context)
    {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_worker_quality);
        setCancelable(true);
        initUi();
    }

    private void initUi()
    {
        mProgrammerSwitch = (Switch) findViewById(R.id.good_programmer);
        mDesignerSwitch = (Switch) findViewById(R.id.good_designer);
        mMarketingSwitch = (Switch) findViewById(R.id.good_marketing);
        mProgrammerText = (TextView) findViewById(R.id.good_programmer_text);
        mDesignerText = (TextView) findViewById(R.id.good_designer_text);
        mMarketingText = (TextView) findViewById(R.id.good_marketing_text);
        mProgrammerSwitch.setChecked(Constants.programerIsGood);
        mDesignerSwitch.setChecked(Constants.designersIsGood);
        mMarketingSwitch.setChecked(Constants.marketerLikesAnalytics);
        mProgrammerSwitch.setOnCheckedChangeListener(this);
        mDesignerSwitch.setOnCheckedChangeListener(this);
        mMarketingSwitch.setOnCheckedChangeListener(this);

    }

    @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        switch (buttonView.getId())
        {
            case R.id.good_programmer:
                Constants.programerIsGood = isChecked;
                mProgrammerText.setText(isChecked? "Good Programmer" : "Bad Programmer");
                break;
            case R.id.good_designer:
                Constants.designersIsGood = isChecked;
                mDesignerText.setText(isChecked? "Good Designer" : "Bad Designer");
                break;
            case R.id.good_marketing:
                Constants.marketerLikesAnalytics = isChecked;
                mMarketingText.setText(isChecked? "Good Marketing Specialist" : "Bad Marketing Specialist");
                break;

        }
    }
}
