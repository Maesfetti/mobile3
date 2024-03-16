package com.example.myapplication3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public MainActivity(){
        super(R.layout.layout_liner);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, FirstFragment.class, null)
                    .add(R.id.fragment_container_view, SecondFragment.class, null)
                    .add(R.id.fragment_container_view, ThirdFragment.class, null)
                    .commit();
        }
    }

}