package com.sounakmondal.appversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView appName, appVersion;
    ImageView appIcon;
    String packName = "com.android.chrome"; //change 'packageName' for different app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //item declaration
        appName = findViewById(R.id.nameTV);
        appVersion = findViewById(R.id.versionTV);
        appIcon = findViewById(R.id.appIconIV);



        try {

            PackageInfo packageInfo = getPackageManager().getPackageInfo(packName,0);
            appName.setText(packageInfo.packageName);   // setting app name
            appVersion.setText(packageInfo.versionName);   // setting app version
            appIcon.setImageDrawable(getPackageManager().getApplicationIcon(packName));   //setting app icon

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.i("Error","App Not Found");
        }


    }
}
