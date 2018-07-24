package com.home24.task.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.home24.task.R;


/**
 * Created by Alaeddine Khoudi .
 */

public final class AppUtils {

    private AppUtils() {
        //
    }

    public static void openPlayStoreForApp(Context context) {
        String packageName = context.getPackageName();

        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                    .getResources()
                    .getString(R.string.app_market_link) + packageName)));
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                    .getResources()
                    .getString(R.string.app_google_playstore_link) + packageName)));
        }
    }
}
