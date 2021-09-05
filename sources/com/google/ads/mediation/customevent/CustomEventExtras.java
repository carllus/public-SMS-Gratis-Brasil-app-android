package com.google.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

public class CustomEventExtras implements NetworkExtras {

    /* renamed from: a */
    private final HashMap<String, Object> f602a = new HashMap<>();

    public CustomEventExtras addExtra(String label, Object value) {
        this.f602a.put(label, value);
        return this;
    }

    public CustomEventExtras clearExtras() {
        this.f602a.clear();
        return this;
    }

    public Object getExtra(String label) {
        return this.f602a.get(label);
    }

    public Object removeExtra(String label) {
        return this.f602a.remove(label);
    }
}
