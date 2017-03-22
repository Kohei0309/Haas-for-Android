package com.ring.trick.haasapplication.activity;

import android.databinding.DataBindingUtil;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ncapdevi.fragnav.FragNavController;
import com.ring.trick.haasapplication.R;
import com.ring.trick.haasapplication.databinding.ActivityMainBinding;
import com.ring.trick.haasapplication.fragment.HomeTabFragment;
import com.ring.trick.haasapplication.fragment.MyPageTabFragment;
import com.ring.trick.haasapplication.fragment.WebViewFragment;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int HOME_TAB_INDEX = 0;

    private static final int RECIPE_TAB_INDEX = 1;

    private static final int SHOP_TAB_INDEX = 2;

    private static final int MY_PAGE_TAB_INDEX = 3;

    /**
     * ActivityMainBinding
     */
    private ActivityMainBinding binding;

    private FragNavController fragNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(HomeTabFragment.newInstance());
        fragments.add(WebViewFragment.newInstance("http://haas.co.jp/wp/?cat=42"));
        fragments.add(WebViewFragment.newInstance("http://haasandhaas.sakura.ne.jp/ec/"));
        fragments.add(MyPageTabFragment.newInstance());

        fragNavController = new FragNavController(
                savedInstanceState,
                getSupportFragmentManager(),
                R.id.container,
                fragments,
                HOME_TAB_INDEX);

        binding.bottomBar.setOnTabSelectListener(tabId -> {
                    switch (tabId) {
                        case R.id.tab_home:
                            Log.d(TAG, "タブ：ホーム");
                            fragNavController.switchTab(HOME_TAB_INDEX);
                            break;
                        case R.id.tab_recipe:
                            Log.d(TAG, "タブ：レシピ");
                            fragNavController.switchTab(RECIPE_TAB_INDEX);
                            break;
                        case R.id.tab_shop:
                            Log.d(TAG, "タブ：ショップ");
                            fragNavController.switchTab(SHOP_TAB_INDEX);
                            break;
                        case R.id.tab_my_page:
                            Log.d(TAG, "タブ：マイページ");
                            fragNavController.switchTab(MY_PAGE_TAB_INDEX);
                            break;
                    }
                }
        );
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (fragNavController != null) {
            fragNavController.onSaveInstanceState(outState);
        }
    }

}
