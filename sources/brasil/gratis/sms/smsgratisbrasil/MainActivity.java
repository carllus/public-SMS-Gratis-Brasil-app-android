package brasil.gratis.sms.smsgratisbrasil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.C0342Ad;
import com.google.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity implements AdListener {

    /* renamed from: ANÚNCIO_ID  reason: contains not printable characters */
    private static final String f706ANNCIO_ID = "ca-app-pub-3491610413834288/4900950854";
    private static final String INTERCALAR_ID = "ca-app-pub-3491610413834288/6377684059";
    private static AdView adView1;
    private InterstitialAd interstitial;
    WebView web;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0338R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(C0338R.C0340id.toolbar));
        ((FloatingActionButton) findViewById(C0338R.C0340id.fab)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.compartilhar();
            }
        });
        this.web = (WebView) findViewById(C0338R.C0340id.webView1);
        this.web.getSettings().setBuiltInZoomControls(true);
        this.web.getSettings().setDisplayZoomControls(false);
        this.web.getSettings().setJavaScriptEnabled(true);
        CookieManager.getInstance().setAcceptCookie(true);
        this.web.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                view.loadUrl("javascript:replace('ANÚNCIOS', 'FUNCIONOU')");
                view.loadUrl("javascript:replace('replace2', 'new content 2')");
            }
        });
        this.web.loadUrl("http://167.114.14.172/01_sms/");
        adView1 = new AdView((Activity) this, AdSize.BANNER, f706ANNCIO_ID);
        ((LinearLayout) findViewById(C0338R.C0340id.banner)).addView(adView1);
        adView1.loadAd(new AdRequest());
        intersetial();
    }

    /* access modifiers changed from: package-private */
    public void intersetial() {
        this.interstitial = new InterstitialAd(this, INTERCALAR_ID);
        AdRequest adRequest2 = new AdRequest();
        this.interstitial.setAdListener(this);
        this.interstitial.loadAd(adRequest2);
    }

    /* access modifiers changed from: package-private */
    public void compartilhar() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", "Envie SMS's gratuitos para qualquer operadora, com o\nAPP SMS Gratis Brasil\n\nhttps://play.google.com/store/apps/details?id=brasil.gratis.sms.smsgratisbrasil");
        startActivity(Intent.createChooser(intent, "Share with"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0338R.C0341menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void onReceiveAd(C0342Ad ad) {
        if (ad == this.interstitial) {
            this.interstitial.show();
        }
    }

    public void onFailedToReceiveAd(C0342Ad ad, AdRequest.ErrorCode errorCode) {
    }

    public void onPresentScreen(C0342Ad ad) {
    }

    public void onDismissScreen(C0342Ad ad) {
    }

    public void onLeaveApplication(C0342Ad ad) {
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == 0) {
            switch (keyCode) {
                case 4:
                    if (this.web.canGoBack()) {
                        this.web.goBack();
                        intersetial();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
