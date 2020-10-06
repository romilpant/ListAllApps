package com.romilpant.listallapps;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<AppList> installedApps;
    private ListAdapter installedAppsListAdapter;
    ListView installedAppsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        installedAppsListView = findViewById(R.id.installed_apps_list);
        TextView appCount = findViewById(R.id.appCount);

        installedApps = getInstalledApps();

        installedAppsListAdapter = new ListAdapter(MainActivity.this, installedApps);
        installedAppsListView.setAdapter(installedAppsListAdapter);
        appCount.setText(installedAppsListAdapter.getCount() + " Apps installed");

    }

    private boolean isSystemPackage(PackageInfo packageInfo) {
        return (packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }

    private List<AppList> getInstalledApps() {
        PackageManager packageManager = getPackageManager();
        List<AppList> apps = new ArrayList<>();
        List<PackageInfo> packages = getPackageManager().getInstalledPackages(0);

        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
            if (!isSystemPackage(packageInfo)) {
                String appName = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                Drawable appIcon = packageInfo.applicationInfo.loadIcon(getPackageManager());
                String packageName = packageInfo.applicationInfo.packageName;
                apps.add(new AppList(appIcon, appName, packageName));
            }
        }
        return apps;
    }
}

