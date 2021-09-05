package brasil.gratis.sms.smsgratisbrasil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class CaptchaActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0338R.layout.activity_captcha);
        setSupportActionBar((Toolbar) findViewById(C0338R.C0340id.toolbar));
        WebView web = (WebView) findViewById(C0338R.C0340id.webView);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://167.114.14.172/01_sms/confirma.php");
        ((FloatingActionButton) findViewById(C0338R.C0340id.fab)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Snackbar.make(view, (CharSequence) "", 0).setAction((CharSequence) "Action", (View.OnClickListener) null).show();
            }
        });
    }
}
