package com.xdd.repluginproject;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qihoo360.replugin.RePlugin;

public class WelcomActivity extends AppCompatActivity implements View.OnClickListener {
    private Button toPlugTestMainActivityByPackageName;
    private Button toPlugTestMainActivityByAlias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        toPlugTestMainActivityByPackageName = findViewById(R.id.toPlugTestMainActivityByPackageName);
        toPlugTestMainActivityByAlias = findViewById(R.id.toPlugTestMainActivityByAlias);
        Toast.makeText(this, "" + BuildConfig.DEBUG, Toast.LENGTH_SHORT).show();
        addListener();
    }

    private void addListener() {
        toPlugTestMainActivityByPackageName.setOnClickListener(this);
        toPlugTestMainActivityByAlias.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.toPlugTestMainActivityByPackageName:
                RePlugin.startActivity(WelcomActivity.this,
                        RePlugin.createIntent("com.example.xiangdada.test", "com.example.xiangdada.test.MainActivity"));
                break;
            case R.id.toPlugTestMainActivityByAlias:
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("test", "com.example.xiangdada.test.MainActivity"));
                RePlugin.startActivityForResult(WelcomActivity.this, intent, 100, null);
                break;
            default:
                break;
        }
    }
}
