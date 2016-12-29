package com.example.enclaveit.version1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.enclaveit.version1.fragment.HomeRssFragment;
import com.example.enclaveit.version1.fragment.NewsRssFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            addRSSFragment();
        }
    }

    private void addRSSFragment() {
        /**
         * This is Home: Contain content home when you open website vnexpress.net
         */
        HomeRssFragment homeRssFragment = new HomeRssFragment();
        NewsRssFragment newsRssFragment = new NewsRssFragment();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, homeRssFragment);
        transaction.commit();
    }
}
