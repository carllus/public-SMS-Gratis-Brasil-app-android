package com.google.ads.mediation.admob;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;
import java.util.Map;

public class AdMobAdapterExtras implements NetworkExtras {

    /* renamed from: a */
    private boolean f591a;

    /* renamed from: b */
    private Map<String, Object> f592b;

    public AdMobAdapterExtras() {
        this.f591a = false;
        clearExtras();
    }

    public AdMobAdapterExtras(AdMobAdapterExtras original) {
        this();
        if (original != null) {
            this.f591a = original.f591a;
            this.f592b.putAll(original.f592b);
        }
    }

    @Deprecated
    public AdMobAdapterExtras setPlusOneOptOut(boolean plusOneOptOut) {
        return this;
    }

    @Deprecated
    public boolean getPlusOneOptOut() {
        return false;
    }

    public AdMobAdapterExtras setUseExactAdSize(boolean useExactAdSize) {
        this.f591a = useExactAdSize;
        return this;
    }

    public boolean getUseExactAdSize() {
        return this.f591a;
    }

    public Map<String, Object> getExtras() {
        return this.f592b;
    }

    public AdMobAdapterExtras setExtras(Map<String, Object> extras) {
        if (extras == null) {
            throw new IllegalArgumentException("Argument 'extras' may not be null");
        }
        this.f592b = extras;
        return this;
    }

    public AdMobAdapterExtras clearExtras() {
        this.f592b = new HashMap();
        return this;
    }

    public AdMobAdapterExtras addExtra(String key, Object value) {
        this.f592b.put(key, value);
        return this;
    }
}
