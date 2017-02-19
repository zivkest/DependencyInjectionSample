package com.ziv.dependencyinjectionapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.ziv.dependencyinjectionapp.R;
import com.ziv.dependencyinjectionapp.utils.Constants;

public class WorkersQualityFragment extends DialogFragment implements CompoundButton.OnCheckedChangeListener
{

    private Switch mProgrammerSwitch;
    private Switch mDesignerSwitch;
    private Switch mMarketingSwitch;
    private TextView mMarketingText;
    private TextView mDesignerText;
    private TextView mProgrammerText;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view  = inflater.inflate(R.layout.fragment_worker_quality, container, false);
        initUi(view);
        return view;
    }

    public static WorkersQualityFragment newInstance()
    {
        return new WorkersQualityFragment();
    }

    private void initUi(View view)
    {
        mProgrammerSwitch = (Switch) view.findViewById(R.id.good_programmer);
        mDesignerSwitch = (Switch) view.findViewById(R.id.good_designer);
        mMarketingSwitch = (Switch) view.findViewById(R.id.good_marketing);
        mProgrammerText = (TextView) view.findViewById(R.id.good_programmer_text);
        mDesignerText = (TextView) view.findViewById(R.id.good_designer_text);
        mMarketingText = (TextView) view.findViewById(R.id.good_marketing_text);
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
