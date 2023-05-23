package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentTextBinding;

public class LiveDataTextFragment extends Fragment {

    FragmentTextBinding binding;
    TextView textView;
    private TextViewModel textViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_text, container, false);
        textView = view.findViewById(R.id.liveDataText);

        textView.setText("Hallo?=");

        binding = FragmentTextBinding.inflate(getLayoutInflater());

        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewModel = new ViewModelProvider(requireActivity()).get(TextViewModel.class);

        textViewModel.getText().observe(getViewLifecycleOwner(), r -> {

            textView.setText(r);
            //binding.liveDataText.setText(r);
        });
    }

    public void setUps() {


    }


}
