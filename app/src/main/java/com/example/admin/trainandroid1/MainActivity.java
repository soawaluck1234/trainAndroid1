package com.example.admin.trainandroid1;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends Activity {


    LocalActivityManager localActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localActivityManager= new LocalActivityManager (this,false);
        localActivityManager.dispatchCreate(savedInstanceState);

        TabHost tabHost= (TabHost) findViewById(R.id.tabHost);
        tabHost.setup(localActivityManager);

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tab1")
                .setIndicator("Tab 1")
                .setContent(new Intent(this,Tab1.class));


        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2")
                .setIndicator("Tab 2")
                .setContent(new Intent(this,Tab2.class));

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3")
                .setIndicator("Tab 3")
                .setContent(new Intent(this,Tab3.class));

        tabHost.addTab(tabSpec);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);



    }//OnCreate

    @Override
    protected void onPause() {
        super.onPause();
    localActivityManager.dispatchPause(!isFinishing());

    }

    @Override
    protected void onResume() {
        super.onResume();
    localActivityManager.dispatchResume();

    }
}//main
