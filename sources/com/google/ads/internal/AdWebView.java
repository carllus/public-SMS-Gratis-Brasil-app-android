package com.google.ads.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.p003v7.widget.ActivityChooserView;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.AdSize;
import com.google.ads.C0367ak;
import com.google.ads.C0449n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0461b;
import com.google.ads.util.C0470g;
import com.google.ads.util.C0480h;
import com.google.ads.util.IcsUtil;
import java.lang.ref.WeakReference;

public class AdWebView extends WebView {

    /* renamed from: a */
    protected final C0449n f415a;

    /* renamed from: b */
    private WeakReference<AdActivity> f416b = null;

    /* renamed from: c */
    private AdSize f417c;

    /* renamed from: d */
    private boolean f418d = false;

    /* renamed from: e */
    private boolean f419e = false;

    /* renamed from: f */
    private boolean f420f = false;

    public AdWebView(C0449n slotState, AdSize adSize) {
        super(slotState.f608f.mo7347a());
        this.f415a = slotState;
        this.f417c = adSize;
        setBackgroundColor(0);
        AdUtil.m464a((WebView) this);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(url), mimeType);
                    AdActivity i = AdWebView.this.mo7081i();
                    if (i != null && AdUtil.m469a(intent, (Context) i)) {
                        i.startActivity(intent);
                    }
                } catch (ActivityNotFoundException e) {
                    C0461b.m498a("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
                } catch (Throwable th) {
                    C0461b.m503b("Unknown error trying to start activity to view URL: " + url, th);
                }
            }
        });
        if (AdUtil.f639a >= 17) {
            C0480h.m528a(settings, slotState);
        } else if (AdUtil.f639a >= 11) {
            C0470g.m522a(settings, slotState);
        }
        setScrollBarStyle(33554432);
        if (AdUtil.f639a >= 14) {
            setWebChromeClient(new IcsUtil.C0458a(slotState));
        } else if (AdUtil.f639a >= 11) {
            setWebChromeClient(new C0470g.C0472a(slotState));
        }
    }

    /* renamed from: f */
    public void mo7078f() {
        AdActivity i = mo7081i();
        if (i != null) {
            i.finish();
        }
    }

    /* renamed from: g */
    public void mo7079g() {
        if (AdUtil.f639a >= 11) {
            C0470g.m520a((View) this);
        }
        this.f419e = true;
    }

    /* renamed from: h */
    public void mo7080h() {
        if (this.f419e && AdUtil.f639a >= 11) {
            C0470g.m523b(this);
        }
        this.f419e = false;
    }

    /* renamed from: i */
    public AdActivity mo7081i() {
        if (this.f416b != null) {
            return (AdActivity) this.f416b.get();
        }
        return null;
    }

    /* renamed from: j */
    public boolean mo7082j() {
        return this.f420f;
    }

    /* renamed from: k */
    public boolean mo7083k() {
        return this.f419e;
    }

    public void setAdActivity(AdActivity adActivity) {
        this.f416b = new WeakReference<>(adActivity);
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        try {
            super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
        } catch (Throwable th) {
            C0461b.m507d("An error occurred while loading data in AdWebView:", th);
        }
    }

    public void loadUrl(String url) {
        try {
            super.loadUrl(url);
        } catch (Throwable th) {
            C0461b.m507d("An error occurred while loading a URL in AdWebView:", th);
        }
    }

    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (Throwable th) {
            C0461b.m507d("An error occurred while stopping loading in AdWebView:", th);
        }
    }

    public void destroy() {
        try {
            super.destroy();
        } catch (Throwable th) {
            C0461b.m507d("An error occurred while destroying an AdWebView:", th);
        }
        try {
            setWebViewClient(new WebViewClient());
        } catch (Throwable th2) {
        }
    }

    public synchronized void setAdSize(AdSize adSize) {
        this.f417c = adSize;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        synchronized (this) {
            if (isInEditMode()) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } else if (this.f417c == null || this.f418d) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } else {
                int mode = View.MeasureSpec.getMode(widthMeasureSpec);
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                float f = getContext().getResources().getDisplayMetrics().density;
                int width = (int) (((float) this.f417c.getWidth()) * f);
                int height = (int) (((float) this.f417c.getHeight()) * f);
                if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                    i = size;
                } else {
                    i = Integer.MAX_VALUE;
                }
                if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                    i2 = size2;
                }
                if (((float) width) - (f * 6.0f) > ((float) i) || height > i2) {
                    C0461b.m502b("Not enough space to show ad! Wants: <" + width + ", " + height + ">, Has: <" + size + ", " + size2 + ">");
                    setVisibility(8);
                    setMeasuredDimension(size, size2);
                } else {
                    setMeasuredDimension(width, height);
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        C0367ak a = this.f415a.f620r.mo7348a();
        if (a != null) {
            a.mo6960a(event);
        }
        return super.onTouchEvent(event);
    }

    public void setCustomClose(boolean useCustomClose) {
        AdActivity adActivity;
        this.f420f = useCustomClose;
        if (this.f416b != null && (adActivity = (AdActivity) this.f416b.get()) != null) {
            adActivity.setCustomClose(useCustomClose);
        }
    }

    public void setIsExpandedMraid(boolean isCurrentlyExpandedMraid) {
        this.f418d = isCurrentlyExpandedMraid;
    }

    /* renamed from: a */
    public void mo7076a(boolean z) {
        if (z) {
            setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    return event.getAction() == 2;
                }
            });
        } else {
            setOnTouchListener((View.OnTouchListener) null);
        }
    }
}
