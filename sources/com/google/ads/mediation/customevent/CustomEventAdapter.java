package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.C0398g;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.C0459a;
import com.google.ads.util.C0461b;

public class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f593a;

    /* renamed from: b */
    private CustomEventBanner f594b = null;

    /* renamed from: c */
    private C0447a f595c = null;

    /* renamed from: d */
    private CustomEventInterstitial f596d = null;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    private class C0447a implements CustomEventBannerListener {

        /* renamed from: b */
        private View f598b;

        /* renamed from: c */
        private final MediationBannerListener f599c;

        public C0447a(MediationBannerListener mediationBannerListener) {
            this.f599c = mediationBannerListener;
        }

        public synchronized void onReceivedAd(View view) {
            C0461b.m498a(m441b() + " called onReceivedAd.");
            this.f598b = view;
            this.f599c.onReceivedAd(CustomEventAdapter.this);
        }

        public void onFailedToReceiveAd() {
            C0461b.m498a(m441b() + " called onFailedToReceiveAd().");
            this.f599c.onFailedToReceiveAd(CustomEventAdapter.this, AdRequest.ErrorCode.NO_FILL);
        }

        public void onClick() {
            C0461b.m498a(m441b() + " called onClick().");
            this.f599c.onClick(CustomEventAdapter.this);
        }

        public void onPresentScreen() {
            C0461b.m498a(m441b() + " called onPresentScreen().");
            this.f599c.onPresentScreen(CustomEventAdapter.this);
        }

        public void onDismissScreen() {
            C0461b.m498a(m441b() + " called onDismissScreen().");
            this.f599c.onDismissScreen(CustomEventAdapter.this);
        }

        public synchronized void onLeaveApplication() {
            C0461b.m498a(m441b() + " called onLeaveApplication().");
            this.f599c.onLeaveApplication(CustomEventAdapter.this);
        }

        /* renamed from: a */
        public synchronized View mo7290a() {
            return this.f598b;
        }

        /* renamed from: b */
        private String m441b() {
            return "Banner custom event labeled '" + CustomEventAdapter.this.f593a + "'";
        }
    }

    public void requestBannerAd(MediationBannerListener mediationListener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras mediationExtras) {
        C0459a.m487a((Object) this.f593a);
        this.f593a = serverParameters.label;
        String str = serverParameters.className;
        String str2 = serverParameters.parameter;
        this.f594b = (CustomEventBanner) m438a(str, CustomEventBanner.class, this.f593a);
        if (this.f594b == null) {
            mediationListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        C0459a.m487a((Object) this.f595c);
        this.f595c = new C0447a(mediationListener);
        try {
            this.f594b.requestBannerAd(this.f595c, activity, this.f593a, str2, adSize, mediationAdRequest, mediationExtras == null ? null : mediationExtras.getExtra(this.f593a));
        } catch (Throwable th) {
            m440a("", th);
            mediationListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        }
    }

    public View getBannerView() {
        C0459a.m492b((Object) this.f595c);
        return this.f595c.mo7290a();
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    private class C0448b implements CustomEventInterstitialListener {

        /* renamed from: b */
        private final MediationInterstitialListener f601b;

        public C0448b(MediationInterstitialListener mediationInterstitialListener) {
            this.f601b = mediationInterstitialListener;
        }

        public void onReceivedAd() {
            C0461b.m498a(m443a() + " called onReceivedAd.");
            this.f601b.onReceivedAd(CustomEventAdapter.this);
        }

        public void onFailedToReceiveAd() {
            C0461b.m498a(m443a() + " called onFailedToReceiveAd().");
            this.f601b.onFailedToReceiveAd(CustomEventAdapter.this, AdRequest.ErrorCode.NO_FILL);
        }

        public void onPresentScreen() {
            C0461b.m498a(m443a() + " called onPresentScreen().");
            this.f601b.onPresentScreen(CustomEventAdapter.this);
        }

        public void onDismissScreen() {
            C0461b.m498a(m443a() + " called onDismissScreen().");
            this.f601b.onDismissScreen(CustomEventAdapter.this);
        }

        public synchronized void onLeaveApplication() {
            C0461b.m498a(m443a() + " called onLeaveApplication().");
            this.f601b.onLeaveApplication(CustomEventAdapter.this);
        }

        /* renamed from: a */
        private String m443a() {
            return "Interstitial custom event labeled '" + CustomEventAdapter.this.f593a + "'";
        }
    }

    public void showInterstitial() {
        C0459a.m492b((Object) this.f596d);
        try {
            this.f596d.showInterstitial();
        } catch (Throwable th) {
            C0461b.m503b("Exception when showing custom event labeled '" + this.f593a + "'.", th);
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationListener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras mediationExtras) {
        C0459a.m487a((Object) this.f593a);
        this.f593a = serverParameters.label;
        String str = serverParameters.className;
        String str2 = serverParameters.parameter;
        this.f596d = (CustomEventInterstitial) m438a(str, CustomEventInterstitial.class, this.f593a);
        if (this.f596d == null) {
            mediationListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        try {
            this.f596d.requestInterstitialAd(new C0448b(mediationListener), activity, this.f593a, str2, mediationAdRequest, mediationExtras == null ? null : mediationExtras.getExtra(this.f593a));
        } catch (Throwable th) {
            m440a("", th);
            mediationListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void destroy() {
        if (this.f594b != null) {
            this.f594b.destroy();
        }
        if (this.f596d != null) {
            this.f596d.destroy();
        }
    }

    /* renamed from: a */
    private void m440a(String str, Throwable th) {
        C0461b.m503b("Error during processing of custom event with label: '" + this.f593a + "'. Skipping custom event. " + str, th);
    }

    /* renamed from: a */
    private <T> T m438a(String str, Class<T> cls, String str2) {
        try {
            return C0398g.m199a(str, cls);
        } catch (ClassNotFoundException e) {
            m440a("Make sure you created a visible class named: " + str + ". ", e);
        } catch (ClassCastException e2) {
            m440a("Make sure your custom event implements the " + cls.getName() + " interface.", e2);
        } catch (IllegalAccessException e3) {
            m440a("Make sure the default constructor for class " + str + " is visible. ", e3);
        } catch (InstantiationException e4) {
            m440a("Make sure the name " + str + " does not denote an abstract class or an interface.", e4);
        } catch (Throwable th) {
            m440a("", th);
        }
        return null;
    }
}
