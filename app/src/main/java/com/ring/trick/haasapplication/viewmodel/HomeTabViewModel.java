package com.ring.trick.haasapplication.viewmodel;

import android.content.Context;
import android.view.View;

import com.ring.trick.haasapplication.util.BrowseUtil;

/**
 * Created by kohei on 2017/03/10.
 */

public class HomeTabViewModel {

    private Context context;

    public HomeTabViewModel(Context context) {
        this.context = context;
    }

    public void onClickInformation(View view) {
        BrowseUtil.lunch(context, "http://haas.co.jp/wp/?cat=12");
    }

    public void onClickEvent(View view) {
        BrowseUtil.lunch(context, "http://haas.co.jp/wp/?cat=6");
    }

    public void onClickShop(View view) {
        BrowseUtil.lunch(context, "http://haas.co.jp/wp/?p=2754");
    }

    public void onClickHaas(View view) {
        BrowseUtil.lunch(context, "http://haas.co.jp/wp/?p=2756");
    }

    public void onClickBeginer(View view) {
        BrowseUtil.lunch(context, "http://haas.co.jp/wp/?p=2752");
    }
}
