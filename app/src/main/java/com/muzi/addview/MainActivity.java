package com.muzi.addview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private NoNetFrameLayout noNetFrameLayout;
    private ProgressBar progressBar;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnData);
        noNetFrameLayout = findViewById(R.id.noNetFrameLayout);
        progressBar = findViewById(R.id.progressBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        noNetFrameLayout.set404Visiable(true);
                        Toast.makeText(MainActivity.this, "断网了", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });

        noNetFrameLayout.setRefreshListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noNetFrameLayout.set404Visiable(false);
                Toast.makeText(MainActivity.this, "有网了", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
