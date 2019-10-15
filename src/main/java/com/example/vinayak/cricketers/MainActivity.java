package com.example.vinayak.cricketers;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends Activity {
    VideoView videoView;
    ListView list;
    String player, selectedPlayer;

    Integer[] playerdetails = {R.string.SachinTendulker, R.string.ViratKohli, R.string.ABdeVilliers, R.string.MSDhoni, R.string.ChrisGayle, R.string.RashidKhan, R.string.KaneWilliamson, R.string.JasonRoy, R.string.WilliamPorterfield,
            R.string.SteveSmith, R.string.ShahidAfridi};

    String[] itemname = {"Sachin Tendulker", "Virat Kohli", "AB de Villiers", "MS Dhoni", "Chris Gayle", "Rashid Khan", "Kane Williamson", "Jason Roy", "William Porterfield", "Steve Smith", "Shahid Afridi"};

    String[] subitem1 = {"INDIA", "INDIA", "SOUTH AFRICA", "INDIA", "WEST INDIES", "AFGHANISTHAN", "NEW ZEALAND", "ENGLAND", "IRELAND", "AUSTRALIA", "PAKISTHAN"};

    String[] subitem2 = {"Right-Handed Batsman", "Right-Handed Batsman", "Right-Handed Batsman", "Wicket-Keeper/Batsman", "Left-Handed Batsman", "Right-Arm Leg Spin Bowler", "Right-Handed Batsman",
            "Right-Handed Batsman", "Left-Handed Batsman", "Right-Handed Batsman", "All-Rounder"};

    Integer[] imgid = {R.drawable.sachin, R.drawable.virat, R.drawable.abd, R.drawable.msd, R.drawable.gayle, R.drawable.rasid, R.drawable.willaimson, R.drawable.roy, R.drawable.william, R.drawable.smith, R.drawable.afridi,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView3);
        imageView.animate().x(100).setDuration(5000).setStartDelay(1500).rotationX(180f).translationX(100f).alpha(0);
        imageView1.setAlpha(0.15f);


        CustomListAdapter adapter = new CustomListAdapter(this, itemname, subitem1, subitem2, imgid);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                selectedPlayer = itemname[+position];
                Integer image = imgid[+position];
                for (int j = 0; j <= 10; j++) {

                    if (selectedPlayer.equals(itemname[j])) {
                        player = getResources().getString(playerdetails[j]);
                    } else {
                        continue;
                    }
                }

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("name", selectedPlayer);
                intent.putExtra("photo", image);
                intent.putExtra("details", player);
                startActivity(intent);

            }
        });
    }
}

