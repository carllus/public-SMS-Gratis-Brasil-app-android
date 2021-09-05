package com.google.ads;

import android.app.Activity;
import android.view.ViewGroup;
import com.google.ads.internal.C0424d;

public class InterstitialAd implements C0342Ad {

    /* renamed from: a */
    private C0424d f67a;

    public InterstitialAd(Activity activity, String adUnitId) {
        this(activity, adUnitId, false);
    }

    public InterstitialAd(Activity activity, String adUnitId, boolean shortTimeout) {
        this.f67a = new C0424d(this, activity, (AdSize) null, adUnitId, (ViewGroup) null, shortTimeout);
    }

    public boolean isReady() {
        return this.f67a.mo7182s();
    }

    public void loadAd(AdRequest adRequest) {
        this.f67a.mo7152a(adRequest);
    }

    public void show() {
        this.f67a.mo7139B();
    }

    public void setAdListener(AdListener adListener) {
        this.f67a.mo7172i().f617o.mo7349a(adListener);
    }

    /* access modifiers changed from: protected */
    public void setAppEventListener(AppEventListener appEventListener) {
        this.f67a.mo7172i().f618p.mo7349a(appEventListener);
    }

    public void stopLoading() {
        this.f67a.mo7140C();
    }
}
