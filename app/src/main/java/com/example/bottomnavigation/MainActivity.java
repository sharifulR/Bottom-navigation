package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavigation.databinding.ActivityMainBinding;
import com.example.bottomnavigation.view.HomeFragment;
import com.example.bottomnavigation.view.ProfileFragment;
import com.example.bottomnavigation.view.SettingsFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        getSupportActionBar().hide();

        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item ->{
            
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.setting:
                    replaceFragment(new SettingsFragment());
                    break;
            }
            return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        if (fragment!=null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.FrameLayout,fragment)
                    .commit();
        }

    }

    @Override
    public void onBackPressed() {
        if (binding.bottomNavigationView.getSelectedItemId()==R.id.home){
            super.onBackPressed();
            finish();
        }
        else {

            binding.bottomNavigationView.setSelectedItemId(R.id.home);
        }
    }
}