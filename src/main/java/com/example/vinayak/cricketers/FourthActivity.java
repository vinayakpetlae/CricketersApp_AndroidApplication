package com.example.vinayak.cricketers;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.annotation.TargetApi;

public class FourthActivity extends Activity {
    String name, player;
    private WebView mWebview;

    String[] itemname = {"Sachin Tendulker", "Virat Kohli", "AB de Villiers", "MS Dhoni", "Chris Gayle", "Rashid Khan", "Kane Williamson", "Jason Roy", "William Porterfield", "Steve Smith", "Shahid Afridi"};

    String urls[] = {"https://en.wikipedia.org/wiki/Sachin_Tendulkar", "https://en.wikipedia.org/wiki/Virat_Kohli", "https://en.wikipedia.org/wiki/AB_de_Villiers", "https://en.wikipedia.org/wiki/MS_Dhoni"
            , "https://en.wikipedia.org/wiki/Chris_Gayle", "https://en.wikipedia.org/wiki/Rashid_Khan_(cricketer)", "https://en.wikipedia.org/wiki/Kane_Williamson",
            "https://en.wikipedia.org/wiki/Jason_Roy", "https://en.wikipedia.org/wiki/William_Porterfield", "https://en.wikipedia.org/wiki/Steve_Smith_(cricketer)"
            , "https://en.wikipedia.org/wiki/Shahid_Afridi"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWebview = new WebView(this);
        WebView webView = (WebView) findViewById(R.id.webview);
        mWebview.getSettings().setJavaScriptEnabled(true);

        final Activity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }

            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("webdetails");

        for (int j = 0; j <= 10; j++) {

            if (name.equals(itemname[j])) {
                mWebview.loadUrl(urls[j]);
            } else {
                continue;
            }
        }

        setContentView(mWebview);

    }

}

