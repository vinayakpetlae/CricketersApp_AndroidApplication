package com.example.vinayak.cricketers;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class SecondActivity extends AppCompatActivity {
    String[] itemname = {"Sachin Tendulker", "Virat Kohli", "AB de Villiers", "MS Dhoni", "Chris Gayle", "Rashid Khan", "Kane Williamson", "Jason Roy", "William Porterfield", "Steve Smith", "Shahid Afridi"
    };

    String[] fb = {"https://www.facebook.com/SachinTendulkar/", "https://www.facebook.com/virat.kohli/", "https://www.facebook.com/ABdeVilliers17/", "https://www.facebook.com/MSDhoni/",
            "https://www.facebook.com/ChrisGayleSpartan/", "https://www.facebook.com/Rashid-Khan-1480520732221607/?__tn__=kC-R&eid=ARCLwCSqeV482vAJeBjQgoG1dXf1hKa9QYsCv-88tYIaTKA75HMocpS0GEdEXyql87ymtZRDDREozvio&hc_ref=ARThY8fx7XkYN27iywUlxYc8ojcakoRwDZaeWXRTbk0JvIZ_tbb724m7QdtmF7bVf0A&fref=nf&__xts__[0]=68.ARBsdsLn2zjYE1S3zbAgMuIwRmCwke9Nkk9R0lH5j7Owa0LwUu3Ys-2HxlOYnP4sRm9EWGKrOLyRE6sEkJKftjxYv-P3cPhbkeqDzX0ghLpTpLI7S5jkl-_47LH6l6ZiFmX5f7pIUE32_aoGkC_uko8zndo6O8srHbN7W-Pgm0dJAqbJGkSiiJHkNoCU2pn3J2_B0A",
            "https://www.facebook.com/KaneWillTrain/", "https://www.facebook.com/JasonRoy20/", "https://www.facebook.com/william.porterfield.3", "https://www.facebook.com/SteveSmith/?__tn__=kC-R&eid=ARApTpmroluLUs6v-pEhOySUHblqWoQRcG8IkRY4yt2DPiRJFkP7_wDsSGdf7yvJYqTgqPawoEnxYPI-&hc_ref=ARQVuCCDaAFTe6pPDDlcAkxkp9c6UW7Kxtw1PT59ezr6O-vga_W_XUl_m0v8Yk_MCc0&__xts__[0]=68.ARBlDAv_Mq9kSVvIN7AvXElMXtkXNBsPXZuUhAqUTEcTO8xqF610U4QC0ciDa_CmMU3IPeYxNzFKe5FqpjHWJXwNwnaF0uFfbjXAv7g6cX_cl7FFwrxYvbzi0_UjwP6XTjanziN_zn1GWeCg9zll7RhPsY-FxE3-gush_ZcqJPOgF8oiMUoWG8qHSdUELoDgTsgO", "https://www.facebook.com/ShahidAfridiOfficial10/"
    };

    String[] tw = {"https://twitter.com/sachin_rt?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor", "https://twitter.com/imVkohli", "https://twitter.com/ABdeVilliers17", "https://twitter.com/msdhoni",
            "https://twitter.com/henrygayle", "https://twitter.com/rashidkhan_19", "https://twitter.com/NotNossy", "https://twitter.com/JasonRoy20", "https://twitter.com/purdy34", "https://twitter.com/stevesmith49", "https://twitter.com/SAfridiOfficial"
    };

    Integer[] video = {
            R.raw.sachin1,
            R.raw.virat,
            R.raw.abd,
            R.raw.msd,
            R.raw.gayle,
            R.raw.rashid,
            R.raw.kane,
            R.raw.jason,
            R.raw.porter,
            R.raw.smith,
            R.raw.afridi,

    };
    Integer[] imgid1 = {
            R.drawable.sachin1,
            R.drawable.virat1,
            R.drawable.abd1,
            R.drawable.msd1,
            R.drawable.gayle1,
            R.drawable.rashid1,
            R.drawable.kane1,
            R.drawable.jason1,
            R.drawable.porter1,
            R.drawable.smith1,
            R.drawable.afridi1,
    };
    Integer[] imgid2 = {R.drawable.sachin2,
            R.drawable.virat2,
            R.drawable.abd2,
            R.drawable.msd2,
            R.drawable.gayle2,
            R.drawable.rashid2,
            R.drawable.kane2,
            R.drawable.jason2,
            R.drawable.porter2,
            R.drawable.smith2,
            R.drawable.afridi2,
    };

    String value2, s, f;
    TextView title, details;
    ImageView image, enlarge, facebook, image9, image10, twitter;
    Button more;
    Integer i;
    boolean isImageFitToScreen;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        facebook = (ImageView) findViewById(R.id.imageView6);
        twitter = (ImageView) findViewById(R.id.imageView7);
        image9 = (ImageView) findViewById(R.id.imageView9);
        image10 = (ImageView) findViewById(R.id.imageView10);
        title = (TextView) findViewById(R.id.title);
        image = (ImageView) findViewById(R.id.photo);
        details = (TextView) findViewById(R.id.details);
        more = (Button) findViewById(R.id.moreinfo);


        Bundle bundle = getIntent().getExtras();
        value2 = bundle.getString("name");
        i = bundle.getInt("photo");
        s = bundle.getString("details");
        title.setText(value2);
        image.setImageResource(i);
        details.setText(s);
        details.setMovementMethod(new ScrollingMovementMethod());


        for (int i = 0; i <= 10; i++) {

            if (value2.equals(itemname[i])) {
                image9.setImageResource(imgid1[i]);
            } else {
                continue;
            }
        }

        for (int j = 0; j <= 10; j++) {

            if (value2.equals(itemname[j])) {
                image10.setImageResource(imgid2[j]);
            } else {
                continue;
            }
        }

        for (int n = 0; n <= 10; n++) {

            if (value2.equals(itemname[n])) {
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + video[n]);
                videoview.setVideoURI(uri);
                videoview.start();
            } else {
                continue;
            }
        }
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isImageFitToScreen) {
                    isImageFitToScreen = false;

                    image.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                    image.setAdjustViewBounds(true);

                } else {
                    isImageFitToScreen = true;
                    image.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));

                    image.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
            }
        });


    }

    public void facebook(View view) {
        facebook = (ImageView) findViewById(R.id.imageView6);
        for (int i = 0; i <= 10; i++) {

            if (value2.equals(itemname[i])) {
                Intent intent = new Intent(
                        Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, fb[i]);
                startActivity(intent);
            } else {
                continue;
            }
        }


    }

    public void twitter(View view) {
        twitter = (ImageView) findViewById(R.id.imageView7);
        for (int i = 0; i <= 10; i++) {

            if (value2.equals(itemname[i])) {
                Intent intent = new Intent(
                        Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, tw[i]);
                startActivity(intent);
            } else {
                continue;
            }
        }


    }

    public void more(View view) {
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        intent.putExtra("namedetails", value2);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), value2, Toast.LENGTH_SHORT).show();

    }


}
