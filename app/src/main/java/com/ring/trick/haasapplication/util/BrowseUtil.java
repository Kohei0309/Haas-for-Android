package com.ring.trick.haasapplication.util;

import android.content.Context;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;

import com.ring.trick.haasapplication.R;

/**
 * Created by kohei on 2017/03/10.
 */
public class BrowseUtil {

    public static void lunch(Context context, String url) {
        // ビルダーを使って表示方法を指定する
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary)).setShowTitle(true);

        // CustomTabsでURLをひらくIntentを発行
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(context, Uri.parse(url));
    }
}
