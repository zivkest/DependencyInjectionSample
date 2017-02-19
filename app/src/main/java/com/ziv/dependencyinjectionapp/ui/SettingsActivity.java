package com.ziv.dependencyinjectionapp.ui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ziv.dependencyinjectionapp.R;
import com.ziv.dependencyinjectionapp.settings.SettingsFragment;


public class SettingsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupActionBar();
        getSupportFragmentManager().beginTransaction().replace(R.id.setting_container, SettingsFragment.newInstance(), SettingsFragment.class.getSimpleName()).commit();
    }

    public static Intent getIntent(Activity callingActivity)
    {
        return new Intent(callingActivity, SettingsActivity.class);
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    private void setupActionBar()
    {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


}
