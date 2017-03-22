package com.ring.trick.haasapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ring.trick.haasapplication.R;
import com.ring.trick.haasapplication.databinding.FragmentMyPageTabBinding;
import com.ring.trick.haasapplication.viewmodel.MyPageTabViewModel;

public class MyPageTabFragment extends Fragment {

    public MyPageTabFragment() {
        // Required empty public constructor
    }

    public static MyPageTabFragment newInstance() {
        MyPageTabFragment fragment = new MyPageTabFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_page_tab, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentMyPageTabBinding binding = FragmentMyPageTabBinding.bind(getView());
        MyPageTabViewModel viewModel = new MyPageTabViewModel(getContext());
        binding.setViewModel(viewModel);
    }
}
