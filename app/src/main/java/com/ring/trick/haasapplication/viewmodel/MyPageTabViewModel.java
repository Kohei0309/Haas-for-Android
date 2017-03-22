package com.ring.trick.haasapplication.viewmodel;

import android.content.Context;
import android.view.View;

import com.ring.trick.haasapplication.util.BrowseUtil;

/**
 * Created by kohei on 2017/03/11.
 */

public class MyPageTabViewModel {


    private Context context;

    public MyPageTabViewModel(Context context) {
        this.context = context;
    }

    public void onClickMember(View view) {
        BrowseUtil.lunch(context, "http://haasandhaas.sakura.ne.jp/ec/mypage/change.php");
    }

    public void onClickAddress(View view) {
        BrowseUtil.lunch(context, "http://haasandhaas.sakura.ne.jp/ec/mypage/delivery.php");
    }

    public void onClickMailMagazine(View view) {
        BrowseUtil.lunch(context, "http://haas.co.jp/wp/?page_id=1977");
    }

    public void onClickQA(View view) {
        BrowseUtil.lunch(context, "http://haas.co.jp/wp/?p=2834");
    }

    public void onClickCustomer(View view) {
        BrowseUtil.lunch(context, "http://haas.co.jp/wp/?page_id=1984");
    }

    public void onClickInquiry(View view) {
        BrowseUtil.lunch(context, "https://haasandhaas.sakura.ne.jp/ec/contact/");
    }

    public void onClickTerms(View view) {

    }

    public void onClickLicense(View view) {

    }

    public void onClickTransLaw(View view) {
        BrowseUtil.lunch(context, "https://haasandhaas.sakura.ne.jp/ec/order/");
    }

    public void onClickPrivacy(View view) {
        BrowseUtil.lunch(context, "https://haasandhaas.sakura.ne.jp/ec/guide/privacy.php");
    }

    public void onClickSecession(View view) {
        BrowseUtil.lunch(context, "http://haasandhaas.sakura.ne.jp/ec/mypage/refusal.php");
    }

}
