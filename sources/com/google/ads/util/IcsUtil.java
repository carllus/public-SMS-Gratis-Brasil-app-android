package com.google.ads.util;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient;
import com.google.ads.AdSize;
import com.google.ads.C0449n;
import com.google.ads.internal.AdWebView;
import com.google.ads.util.C0470g;

@TargetApi(14)
public class IcsUtil {

    /* renamed from: com.google.ads.util.IcsUtil$a */
    public static class C0458a extends C0470g.C0472a {
        public C0458a(C0449n nVar) {
            super(nVar);
        }

        public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
            callback.onCustomViewHidden();
        }
    }

    public static class IcsAdWebView extends AdWebView {
        public IcsAdWebView(C0449n slotState, AdSize adSize) {
            super(slotState, adSize);
        }

        public boolean canScrollHorizontally(int direction) {
            if (this.f415a.f607e.mo7347a() != null) {
                return !this.f415a.f607e.mo7347a().mo7050b();
            }
            return super.canScrollHorizontally(direction);
        }

        public boolean canScrollVertically(int direction) {
            if (this.f415a.f607e.mo7347a() != null) {
                return !this.f415a.f607e.mo7347a().mo7050b();
            }
            return super.canScrollVertically(direction);
        }
    }
}
