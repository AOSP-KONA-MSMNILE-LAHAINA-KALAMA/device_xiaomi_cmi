package org.lineageos.settings.utils;

import android.content.ContentResolver;
import android.provider.Settings;

import static android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE;
import static android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL;
import static android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;

public class DisplayUtils {

    public static boolean isAutoBrightnessEnabled(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver,
                    SCREEN_BRIGHTNESS_MODE , SCREEN_BRIGHTNESS_MODE_MANUAL)
                        == SCREEN_BRIGHTNESS_MODE_AUTOMATIC ? true : false;
    }
}
