package com.example.myapplication3;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;


public class SecondFragment extends Fragment {
    public SecondFragment() {
        super(R.layout.fragment_second);
    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        TextView textView = view.findViewById(R.id.TextView2);
        getParentFragmentManager().setFragmentResultListener("Key", this, new FragmentResultListener() {

            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String result = bundle.getString("bundleKey");
                textView.setText(result);
            }
        });

        Button button = view.findViewById(R.id.buttonsend3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                //String name = textView.getText().toString();
                result.putString("bundleKey1", "Результат дочки");
                getParentFragmentManager().setFragmentResult("Key1", result);
            }
        });
        return view;
    }
}
