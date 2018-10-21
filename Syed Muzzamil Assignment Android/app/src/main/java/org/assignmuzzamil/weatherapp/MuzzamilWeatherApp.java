package org.assignmuzzamil.weatherapp;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;

import org.assignmuzzamil.weatherapp.utils.LanguageUtil;
import org.assignmuzzamil.weatherapp.utils.PreferenceUtil;
import org.assignmuzzamil.weatherapp.utils.PreferenceUtil.Theme;

public class MuzzamilWeatherApp extends Application {

    private static final String TAG = "MuzzamilWeatherApp";

    private static Theme sTheme = Theme.light;

    @Override
    public void onCreate() {
        super.onCreate();
        LanguageUtil.setLanguage(this, PreferenceUtil.getLanguage(this));

        sTheme = PreferenceUtil.getTheme(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LanguageUtil.setLanguage(this, PreferenceUtil.getLanguage(this));
    }

    public void reloadTheme() {
        sTheme = PreferenceUtil.getTheme(this);
    }

    public void applyTheme(Activity activity) {
        activity.setTheme(getThemeResId());
    }

    public static int getThemeResId() {
        switch (sTheme) {
            case light:
                return R.style.AppThemeLight;
            case dark:
                return R.style.AppThemeDark;
            default:
                return R.style.AppThemeLight;
        }
    }
}
