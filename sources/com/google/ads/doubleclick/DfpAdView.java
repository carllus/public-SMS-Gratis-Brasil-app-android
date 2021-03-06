package com.google.ads.doubleclick;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.AppEventListener;

public class DfpAdView extends AdView {
    public DfpAdView(Activity activity, AdSize adSize, String adUnitId) {
        super(activity, adSize, adUnitId);
    }

    public DfpAdView(Activity activity, AdSize[] adSizes, String adUnitId) {
        super(activity, adSizes, adUnitId);
    }

    public DfpAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DfpAdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        super.setAppEventListener(appEventListener);
    }

    public void setSupportedAdSizes(AdSize... adSizes) {
        super.setSupportedAdSizes(adSizes);
    }

    public void enableManualImpressions(boolean useManualImpressions) {
        this.f66a.mo7172i().f622t.mo7349a(Boolean.valueOf(useManualImpressions));
    }

    public void recordImpression() {
        this.f66a.mo7189z();
    }

    public void resize(AdSize adSize) {
        this.f66a.mo7175l().setAdSize(adSize);
        this.f66a.mo7172i().f609g.mo7347a().mo7232b(adSize);
    }
}
