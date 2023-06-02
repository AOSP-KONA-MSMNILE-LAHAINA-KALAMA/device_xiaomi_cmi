package org.lineageos.settings.utils;

import android.content.Context;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.UserHandle;
import android.provider.Settings;

import static android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE;
import static android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL;
import static android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;

import org.lineageos.settings.hbm.HBMFragment;
import org.lineageos.settings.hbm.AutoHBMService;

public class DisplayUtils {

    private static boolean mServiceEnabled = false;

    private static void startService(Context context) {
        context.startServiceAsUser(new Intent(context, AutoHBMService.class),
                UserHandle.CURRENT);
        mServiceEnabled = true;
    }

    private static void stopService(Context context) {
        mServiceEnabled = false;
        context.stopServiceAsUser(new Intent(context, AutoHBMService.class),
                UserHandle.CURRENT);
    }

    public static void enableService(Context context) {
        if (HBMFragment.isAUTOHBMEnabled(context) && !mServiceEnabled) {
            startService(context);
        } else if (!HBMFragment.isAUTOHBMEnabled(context) && mServiceEnabled) {
            stopService(context);
        }
    }

    public static boolean isAutoBrightnessEnabled(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver,
                    SCREEN_BRIGHTNESS_MODE , SCREEN_BRIGHTNESS_MODE_MANUAL)
                        == SCREEN_BRIGHTNESS_MODE_AUTOMATIC ? true : false;
    }
}
