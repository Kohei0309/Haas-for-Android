package com.ring.trick.haasapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ring.trick.haasapplication.R;
import com.ring.trick.haasapplication.databinding.FragmentHomeTabBinding;
import com.ring.trick.haasapplication.viewmodel.HomeTabViewModel;
import com.squareup.picasso.Picasso;

public class HomeTabFragment extends Fragment {

    private static final int[] CAROUSEL_IMAGE_LIST = {
            R.drawable.carousel_01,
            R.drawable.carousel_02,
            R.drawable.carousel_03,
            R.drawable.carousel_04,
            R.drawable.carousel_05
    };

    public HomeTabFragment() {
        // Required empty public constructor
    }

    public static HomeTabFragment newInstance() {
        HomeTabFragment fragment = new HomeTabFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_tab, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentHomeTabBinding binding = FragmentHomeTabBinding.bind(getView());
        binding.carouselView.setImageListener((position, imageView) -> {
            Picasso.with(getContext())
                    .load(CAROUSEL_IMAGE_LIST[position])
                    .centerInside()
                    .fit()
                    .into(imageView);
        });
        binding.carouselView.setPageCount(CAROUSEL_IMAGE_LIST.length);

        HomeTabViewModel viewModel = new HomeTabViewModel(getContext());
        binding.setViewModel(viewModel);
    }
}
