package com.example.myapplication3;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;


public class FirstFragment extends Fragment {
    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Toast.makeText(getContext(), "onAttach", Toast.LENGTH_LONG).show();
        Log.i("Live", "onAttach");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            getChildFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view1, SecondFragment.class, null)
                    .commit();
        }
        Log.i("Live", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        EditText editText = view.findViewById(R.id.editField);
        Button button = view.findViewById(R.id.buttonSend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                String name = editText.getText().toString();
                result.putString("bundleKey", name);
                getParentFragmentManager().setFragmentResult("Key", result);
            }
        });

        getChildFragmentManager().setFragmentResultListener("Key1", this, new FragmentResultListener(){
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String result = bundle.getString("bundleKey1");
                editText.setText(result);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_LONG).show();
        Log.i("Live", "onViewCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_LONG).show();
        Log.i("Live", "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "onStart", Toast.LENGTH_LONG).show();
        Log.i("Live", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "onResume", Toast.LENGTH_LONG).show();
        Log.i("Live", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), "onPause", Toast.LENGTH_LONG).show();
        Log.i("Live", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(), "onStop", Toast.LENGTH_LONG).show();
        Log.i("Live", "onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getContext(), "onSaveInstanceState", Toast.LENGTH_LONG).show();
        Log.i("Live", "onSaveInstanceState");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_LONG).show();
        Log.i("Live", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_LONG).show();
        Log.i("Live", "onDestroy");
    }
}