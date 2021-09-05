package com.google.ads;

import android.content.Context;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "mb");
    public static final int FULL_WIDTH = -1;
    public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
    public static final AdSize IAB_MRECT = new AdSize(300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "as");
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");

    /* renamed from: a */
    private final int f59a;

    /* renamed from: b */
    private final int f60b;

    /* renamed from: c */
    private boolean f61c;

    /* renamed from: d */
    private boolean f62d;

    /* renamed from: e */
    private boolean f63e;

    /* renamed from: f */
    private String f64f;

    public AdSize(int width, int height) {
        this(width, height, (String) null);
        if (m36a()) {
            this.f63e = false;
            this.f64f = "mb";
            return;
        }
        this.f63e = true;
    }

    private AdSize(int width, int height, String type) {
        boolean z;
        boolean z2 = true;
        this.f59a = width;
        this.f60b = height;
        this.f64f = type;
        if (width == -1) {
            z = true;
        } else {
            z = false;
        }
        this.f61c = z;
        this.f62d = height != -2 ? false : z2;
        this.f63e = false;
    }

    public static AdSize createAdSize(AdSize adSize, Context context) {
        if (context == null || !adSize.m36a()) {
            return adSize.m36a() ? BANNER : adSize;
        }
        AdSize adSize2 = new AdSize(adSize.f61c ? m35a(context) : adSize.getWidth(), adSize.f62d ? m37b(context) : adSize.getHeight(), adSize.f64f);
        adSize2.f62d = adSize.f62d;
        adSize2.f61c = adSize.f61c;
        adSize2.f63e = adSize.f63e;
        return adSize2;
    }

    public boolean equals(Object other) {
        if (!(other instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) other;
        if (this.f59a == adSize.f59a && this.f60b == adSize.f60b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f59a).hashCode() << 16) | (Integer.valueOf(this.f60b).hashCode() & SupportMenu.USER_MASK);
    }

    public int getWidth() {
        if (this.f59a >= 0) {
            return this.f59a;
        }
        throw new UnsupportedOperationException("Ad size was not set before getWidth() was called.");
    }

    public int getHeight() {
        if (this.f60b >= 0) {
            return this.f60b;
        }
        throw new UnsupportedOperationException("Ad size was not set before getHeight() was called.");
    }

    /* renamed from: a */
    private boolean m36a() {
        return this.f59a < 0 || this.f60b < 0;
    }

    public boolean isFullWidth() {
        return this.f61c;
    }

    public boolean isAutoHeight() {
        return this.f62d;
    }

    public boolean isCustomAdSize() {
        return this.f63e;
    }

    public String toString() {
        return getWidth() + "x" + getHeight() + (this.f64f == null ? "" : "_" + this.f64f);
    }

    public int getWidthInPixels(Context context) {
        return (int) TypedValue.applyDimension(1, (float) this.f59a, context.getResources().getDisplayMetrics());
    }

    public int getHeightInPixels(Context context) {
        return (int) TypedValue.applyDimension(1, (float) this.f60b, context.getResources().getDisplayMetrics());
    }

    public boolean isSizeAppropriate(int width, int height) {
        return ((double) width) <= ((double) this.f59a) * 1.25d && ((double) width) >= ((double) this.f59a) * 0.8d && ((double) height) <= ((double) this.f60b) * 1.25d && ((double) height) >= ((double) this.f60b) * 0.8d;
    }

    public AdSize findBestSize(AdSize... options) {
        double d;
        AdSize adSize;
        AdSize adSize2 = null;
        double d2 = 0.0d;
        if (options != null) {
            int length = options.length;
            int i = 0;
            while (i < length) {
                AdSize adSize3 = options[i];
                if (isSizeAppropriate(adSize3.f59a, adSize3.f60b)) {
                    d = (((double) adSize3.f59a) * ((double) adSize3.f60b)) / (((double) this.f59a) * ((double) this.f60b));
                    if (d > 1.0d) {
                        d = 1.0d / d;
                    }
                    if (d > d2) {
                        adSize = adSize3;
                        i++;
                        adSize2 = adSize;
                        d2 = d;
                    }
                }
                d = d2;
                adSize = adSize2;
                i++;
                adSize2 = adSize;
                d2 = d;
            }
        }
        return adSize2;
    }

    /* renamed from: a */
    private static int m35a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    /* renamed from: b */
    private static int m37b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        if (i <= 720) {
            return 50;
        }
        return 90;
    }
}
