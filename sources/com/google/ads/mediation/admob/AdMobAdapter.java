package com.google.ads.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.C0342Ad;
import com.google.ads.InterstitialAd;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.AdUtil;

public class AdMobAdapter implements MediationBannerAdapter<AdMobAdapterExtras, AdMobAdapterServerParameters>, MediationInterstitialAdapter<AdMobAdapterExtras, AdMobAdapterServerParameters> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MediationBannerListener f585a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MediationInterstitialListener f586b;

    /* renamed from: c */
    private AdView f587c;

    /* renamed from: d */
    private InterstitialAd f588d;

    /* renamed from: a */
    private void m433a() {
        if (m435b()) {
            throw new IllegalStateException("Adapter has already been destroyed");
        }
    }

    /* renamed from: b */
    private boolean m435b() {
        return this.f587c == null && this.f588d == null;
    }

    /* renamed from: a */
    private AdRequest m431a(Activity activity, AdMobAdapterServerParameters adMobAdapterServerParameters, MediationAdRequest mediationAdRequest, AdMobAdapterExtras adMobAdapterExtras) {
        AdMobAdapterExtras adMobAdapterExtras2 = new AdMobAdapterExtras(adMobAdapterExtras);
        adMobAdapterExtras2.addExtra("_norefresh", "t");
        adMobAdapterExtras2.addExtra("gw", 1);
        if (adMobAdapterServerParameters.allowHouseAds != null) {
            adMobAdapterExtras2.addExtra("mad_hac", adMobAdapterServerParameters.allowHouseAds);
        }
        AdRequest networkExtras = new AdRequest().setBirthday(mediationAdRequest.getBirthday()).setGender(mediationAdRequest.getGender()).setKeywords(mediationAdRequest.getKeywords()).setLocation(mediationAdRequest.getLocation()).setNetworkExtras(adMobAdapterExtras2);
        if (mediationAdRequest.isTesting()) {
            networkExtras.addTestDevice(AdUtil.m459a((Context) activity));
        }
        return networkExtras;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AdView mo7280a(Activity activity, AdSize adSize, String str) {
        return new AdView(activity, adSize, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public InterstitialAd mo7281a(Activity activity, String str) {
        return new InterstitialAd(activity, str);
    }

    public Class<AdMobAdapterExtras> getAdditionalParametersType() {
        return AdMobAdapterExtras.class;
    }

    public Class<AdMobAdapterServerParameters> getServerParametersType() {
        return AdMobAdapterServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, AdMobAdapterServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, AdMobAdapterExtras extras) {
        this.f585a = listener;
        if (adSize.isAutoHeight() || adSize.isFullWidth() || ((extras != null && extras.getUseExactAdSize()) || (adSize = adSize.findBestSize(AdSize.BANNER, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_MRECT, AdSize.IAB_WIDE_SKYSCRAPER)) != null)) {
            this.f587c = mo7280a(activity, adSize, serverParameters.adUnitId);
            this.f587c.setAdListener(new C0445a());
            this.f587c.loadAd(m431a(activity, serverParameters, mediationAdRequest, extras));
            return;
        }
        listener.onFailedToReceiveAd(this, AdRequest.ErrorCode.NO_FILL);
    }

    public View getBannerView() {
        return this.f587c;
    }

    public void destroy() {
        m433a();
        if (this.f587c != null) {
            this.f587c.stopLoading();
            this.f587c.destroy();
            this.f587c = null;
        }
        if (this.f588d != null) {
            this.f588d.stopLoading();
            this.f588d = null;
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, AdMobAdapterServerParameters serverParameters, MediationAdRequest mediationAdRequest, AdMobAdapterExtras extras) {
        this.f586b = listener;
        this.f588d = mo7281a(activity, serverParameters.adUnitId);
        this.f588d.setAdListener(new C0446b());
        this.f588d.loadAd(m431a(activity, serverParameters, mediationAdRequest, extras));
    }

    public void showInterstitial() {
        this.f588d.show();
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$a */
    private class C0445a implements AdListener {
        private C0445a() {
        }

        public void onReceiveAd(C0342Ad ad) {
            AdMobAdapter.this.f585a.onReceivedAd(AdMobAdapter.this);
        }

        public void onFailedToReceiveAd(C0342Ad ad, AdRequest.ErrorCode error) {
            AdMobAdapter.this.f585a.onFailedToReceiveAd(AdMobAdapter.this, error);
        }

        public void onPresentScreen(C0342Ad ad) {
            AdMobAdapter.this.f585a.onClick(AdMobAdapter.this);
            AdMobAdapter.this.f585a.onPresentScreen(AdMobAdapter.this);
        }

        public void onDismissScreen(C0342Ad ad) {
            AdMobAdapter.this.f585a.onDismissScreen(AdMobAdapter.this);
        }

        public void onLeaveApplication(C0342Ad ad) {
            AdMobAdapter.this.f585a.onLeaveApplication(AdMobAdapter.this);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$b */
    private class C0446b implements AdListener {
        private C0446b() {
        }

        public void onReceiveAd(C0342Ad ad) {
            AdMobAdapter.this.f586b.onReceivedAd(AdMobAdapter.this);
        }

        public void onFailedToReceiveAd(C0342Ad ad, AdRequest.ErrorCode error) {
            AdMobAdapter.this.f586b.onFailedToReceiveAd(AdMobAdapter.this, error);
        }

        public void onPresentScreen(C0342Ad ad) {
            AdMobAdapter.this.f586b.onPresentScreen(AdMobAdapter.this);
        }

        public void onDismissScreen(C0342Ad ad) {
            AdMobAdapter.this.f586b.onDismissScreen(AdMobAdapter.this);
        }

        public void onLeaveApplication(C0342Ad ad) {
            AdMobAdapter.this.f586b.onLeaveApplication(AdMobAdapter.this);
        }
    }
}
