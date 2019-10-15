package com.example.vinayak.cricketers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    String name, details, player;
    TextView textView;
    Button webinfo;
    Integer[] playerdetails = {R.string.SachinTendulker1, R.string.ViratKohli1, R.string.ABdeVilliers1, R.string.MSDhoni1, R.string.ChrisGayle1, R.string.RashidKhan1, R.string.KaneWilliamson1,
            R.string.JasonRoy1, R.string.WilliamPorterfield1, R.string.SteveSmith1, R.string.ShahidAfridi1};
    String[] itemname = {"Sachin Tendulker", "Virat Kohli", "AB de Villiers", "MS Dhoni", "Chris Gayle", "Rashid Khan", "Kane Williamson", "Jason Roy", "William Porterfield", "Steve Smith", "Shahid Afridi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textView = (TextView) findViewById(R.id.moredetails);
        textView.setMovementMethod(new ScrollingMovementMethod());
        webinfo = (Button) findViewById(R.id.webinfo);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("namedetails");

        for (int j = 0; j <= 10; j++) {

            if (name.equals(itemname[j])) {
                player = getResources().getString(playerdetails[j]);
            } else {
                continue;
            }
        }

        textView.setText(player);

    }

    public void webinfo(View view) {
        Intent intent2 = new Intent(getApplicationContext(), FourthActivity.class);
        intent2.putExtra("webdetails", name);
        startActivity(intent2);
        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();

    }
}
