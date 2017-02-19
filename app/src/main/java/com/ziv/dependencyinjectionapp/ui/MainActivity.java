package com.ziv.dependencyinjectionapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziv.dependencyinjectionapp.R;
import com.ziv.dependencyinjectionapp.abstractions.AppProducedListener;
import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.StartUp;
import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations.Flir;
import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations.MissU;
import com.ziv.dependencyinjectionapp.example_dependency_injection_using_dagger.implementations.Shamir;
import com.ziv.dependencyinjectionapp.models.App;

import static com.ziv.dependencyinjectionapp.R.id.error;

//import com.ziv.dependencyinjectionapp.example.StartUp;
//import com.ziv.dependencyinjectionapp.example.implementations.Flir;
//import com.ziv.dependencyinjectionapp.example.implementations.MissU;
//import com.ziv.dependencyinjectionapp.example.implementations.Shamir;
//import com.ziv.dependencyinjectionapp.example_dependency_injection.StartUp;
//import com.ziv.dependencyinjectionapp.example_dependency_injection.implemantations.Flir;
//import com.ziv.dependencyinjectionapp.example_dependency_injection.implemantations.MissU;
//import com.ziv.dependencyinjectionapp.example_dependency_injection.implemantations.Shamir;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    public static final String CHOSEN_STARTUP_FLIR = "chosen startup - Flir";
    public static final String CHOSEN_STARTUP_MISS_U = "chosen startup - Miss U";
    public static final String CHOSEN_STARTUP_SHAMIR = "chosen startup - Shamir";
    private AppProducedListener mAppProducedListener;
    private ImageView mIcon;
    private StartUp mStartUp;
    private TextView mError;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.flir).setOnClickListener(this);
        findViewById(R.id.missu).setOnClickListener(this);
        findViewById(R.id.shamir).setOnClickListener(this);
        findViewById(R.id.create_an_app).setOnClickListener(this);
        findViewById(R.id.worker_quality).setOnClickListener(this);
        mIcon = (ImageView) findViewById(R.id.app_icon);
        mError = (TextView) findViewById(error);
        mAppProducedListener = new AppProducedListener()
        {
            @Override
            public void OnAppProduced(App app)
            {
                if (app.isAppReady())
                {
                    mIcon.setVisibility(View.VISIBLE);
                    mIcon.setImageResource(mStartUp.getCompanyLogo());
                    mError.setVisibility(View.GONE);
                }
                else
                {
                    mIcon.setVisibility(View.GONE);
                }
            }

            @Override
            public void OnAppProductionFailed(String reason)
            {
                mIcon.setVisibility(View.GONE);
                mError.setVisibility(View.VISIBLE);
                mError.setText(reason);
            }
        };
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.flir:
                setStartup(CHOSEN_STARTUP_FLIR, new Flir());
                break;
            case R.id.missu:
                setStartup(CHOSEN_STARTUP_MISS_U, new MissU());
                break;
            case R.id.shamir:
                setStartup(CHOSEN_STARTUP_SHAMIR, new Shamir());
                break;
            case R.id.create_an_app:
                produceAnApp();
                break;
            case R.id.worker_quality:
                showWorkersQualityScreen();
                break;
        }
    }

    private void showWorkersQualityScreen()
    {
        //getSupportFragmentManager().beginTransaction().replace(R.id.activity_container, WorkersQualityFragment.newInstance(), WorkersQualityFragment.class.getSimpleName()).commit();
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        WorkersQualityFragment dialogFragment = WorkersQualityFragment.newInstance();
        dialogFragment.show(fm, "Sample Fragment");
    }

    private void setStartup(String text, StartUp startUp)
    {
        mIcon.setVisibility(View.GONE);
        findViewById(R.id.buttons_layout).setVisibility(View.VISIBLE);
        TextView title = (TextView) findViewById(R.id.chosen_startup);
        title.setVisibility(View.VISIBLE);
        title.setText(text);
        mStartUp = startUp;
    }

    private void produceAnApp()
    {
        mStartUp.produceApp(mAppProducedListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            startActivity(SettingsActivity.getIntent(this));
        }

        return super.onOptionsItemSelected(item);
    }
}
