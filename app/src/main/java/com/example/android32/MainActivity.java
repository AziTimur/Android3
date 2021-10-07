package com.example.android32;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android32.ui.ViewModelMain;
public class MainActivity extends AppCompatActivity {
    private ViewModelMain viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel=new ViewModelMain();
    }
}
