package com.google.ads.internal;

import com.google.ads.AdSize;
import com.google.ads.C0442m;
import com.google.ads.C0449n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0461b;

public class ActivationOverlay extends AdWebView {

    /* renamed from: b */
    private volatile boolean f400b = true;

    /* renamed from: c */
    private boolean f401c = true;

    /* renamed from: d */
    private int f402d = 0;

    /* renamed from: e */
    private int f403e = 0;

    /* renamed from: f */
    private final C0431i f404f;

    public ActivationOverlay(C0449n slotState) {
        super(slotState, (AdSize) null);
        if (AdUtil.f639a < slotState.f606d.mo7347a().f565b.mo7347a().f569c.mo7348a().intValue()) {
            C0461b.m498a("Disabling hardware acceleration for an activation overlay.");
            mo7079g();
        }
        this.f404f = C0431i.m417a(slotState.f604b.mo7347a(), C0409a.f425c, true, true);
        setWebViewClient(this.f404f);
    }

    public void setOverlayEnabled(boolean overlayEnabled) {
        if (!overlayEnabled) {
            C0442m.m429a().f566c.mo7347a().post(new Runnable() {
                public void run() {
                    ActivationOverlay.this.f415a.f612j.mo7347a().removeView(this);
                }
            });
        }
        this.f400b = overlayEnabled;
    }

    public void setOverlayActivated(boolean overlayActivated) {
        this.f401c = overlayActivated;
    }

    /* renamed from: a */
    public boolean mo7049a() {
        return this.f400b;
    }

    /* renamed from: b */
    public boolean mo7050b() {
        return this.f401c;
    }

    /* renamed from: c */
    public int mo7051c() {
        return this.f403e;
    }

    public void setYPosition(int yPosition) {
        this.f403e = yPosition;
    }

    /* renamed from: d */
    public int mo7054d() {
        return this.f402d;
    }

    public void setXPosition(int xPosition) {
        this.f402d = xPosition;
    }

    /* renamed from: e */
    public C0431i mo7055e() {
        return this.f404f;
    }

    public boolean canScrollHorizontally(int direction) {
        return false;
    }

    public boolean canScrollVertically(int direction) {
        return false;
    }
}
