package com.google.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.p000v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0409a;
import com.google.ads.internal.C0424d;
import com.google.ads.internal.C0425e;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0461b;
import com.google.ads.util.C0468e;
import com.google.ads.util.C0470g;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdActivity extends Activity implements View.OnClickListener {
    public static final String BASE_URL_PARAM = "baseurl";
    public static final String COMPONENT_NAME_PARAM = "c";
    public static final String CUSTOM_CLOSE_PARAM = "custom_close";
    public static final String HTML_PARAM = "html";
    public static final String INTENT_ACTION_PARAM = "i";
    public static final String INTENT_EXTRAS_PARAM = "e";
    public static final String INTENT_FLAGS_PARAM = "f";
    public static final String ORIENTATION_PARAM = "o";
    public static final String PACKAGE_NAME_PARAM = "p";
    public static final String TYPE_PARAM = "m";
    public static final String URL_PARAM = "u";

    /* renamed from: a */
    private static final C0409a f24a = C0409a.f423a.mo7106b();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Object f25b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static AdActivity f26c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static C0424d f27d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static AdActivity f28e = null;

    /* renamed from: f */
    private static AdActivity f29f = null;

    /* renamed from: g */
    private static final StaticMethodWrapper f30g = new StaticMethodWrapper();

    /* renamed from: h */
    private AdWebView f31h;

    /* renamed from: i */
    private FrameLayout f32i;

    /* renamed from: j */
    private int f33j;

    /* renamed from: k */
    private ViewGroup f34k = null;

    /* renamed from: l */
    private boolean f35l;

    /* renamed from: m */
    private long f36m;

    /* renamed from: n */
    private RelativeLayout f37n;

    /* renamed from: o */
    private AdActivity f38o = null;

    /* renamed from: p */
    private boolean f39p;

    /* renamed from: q */
    private boolean f40q;

    /* renamed from: r */
    private boolean f41r;

    /* renamed from: s */
    private boolean f42s;

    /* renamed from: t */
    private AdVideoView f43t;

    public static class StaticMethodWrapper {
        public boolean isShowing() {
            boolean z;
            synchronized (AdActivity.f25b) {
                z = AdActivity.f28e != null;
            }
            return z;
        }

        public boolean leftApplication() {
            boolean z;
            synchronized (AdActivity.f25b) {
                z = AdActivity.f26c != null;
            }
            return z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
            r1 = new android.content.Intent(r0.getApplicationContext(), com.google.ads.AdActivity.class);
            r1.putExtra("com.google.ads.AdOpener", r6.mo7190a());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            com.google.ads.util.C0461b.m498a("Launching AdActivity.");
            r0.startActivity(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
            com.google.ads.util.C0461b.m503b("Activity not found.", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
            r0 = r5.mo7172i().f605c.mo7350a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
            if (r0 != null) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
            com.google.ads.util.C0461b.m508e("activity was null while launching an AdActivity.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void launchAdActivity(com.google.ads.internal.C0424d r5, com.google.ads.internal.C0425e r6) {
            /*
                r4 = this;
                java.lang.Object r1 = com.google.ads.AdActivity.f25b
                monitor-enter(r1)
                com.google.ads.internal.d r0 = com.google.ads.AdActivity.f27d     // Catch:{ all -> 0x0030 }
                if (r0 != 0) goto L_0x0023
                com.google.ads.internal.C0424d unused = com.google.ads.AdActivity.f27d = r5     // Catch:{ all -> 0x0030 }
            L_0x000e:
                monitor-exit(r1)     // Catch:{ all -> 0x0030 }
                com.google.ads.n r0 = r5.mo7172i()
                com.google.ads.util.i$d<android.app.Activity> r0 = r0.f605c
                java.lang.Object r0 = r0.mo7350a()
                android.app.Activity r0 = (android.app.Activity) r0
                if (r0 != 0) goto L_0x0033
                java.lang.String r0 = "activity was null while launching an AdActivity."
                com.google.ads.util.C0461b.m508e(r0)
            L_0x0022:
                return
            L_0x0023:
                com.google.ads.internal.d r0 = com.google.ads.AdActivity.f27d     // Catch:{ all -> 0x0030 }
                if (r0 == r5) goto L_0x000e
                java.lang.String r0 = "Tried to launch a new AdActivity with a different AdManager."
                com.google.ads.util.C0461b.m502b(r0)     // Catch:{ all -> 0x0030 }
                monitor-exit(r1)     // Catch:{ all -> 0x0030 }
                goto L_0x0022
            L_0x0030:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0030 }
                throw r0
            L_0x0033:
                android.content.Intent r1 = new android.content.Intent
                android.content.Context r2 = r0.getApplicationContext()
                java.lang.Class<com.google.ads.AdActivity> r3 = com.google.ads.AdActivity.class
                r1.<init>(r2, r3)
                java.lang.String r2 = "com.google.ads.AdOpener"
                android.os.Bundle r3 = r6.mo7190a()
                r1.putExtra(r2, r3)
                java.lang.String r2 = "Launching AdActivity."
                com.google.ads.util.C0461b.m498a((java.lang.String) r2)     // Catch:{ ActivityNotFoundException -> 0x0050 }
                r0.startActivity(r1)     // Catch:{ ActivityNotFoundException -> 0x0050 }
                goto L_0x0022
            L_0x0050:
                r0 = move-exception
                java.lang.String r1 = "Activity not found."
                com.google.ads.util.C0461b.m503b(r1, r0)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.StaticMethodWrapper.launchAdActivity(com.google.ads.internal.d, com.google.ads.internal.e):void");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo6870a(int i, boolean z) {
        this.f33j = (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
        this.f32i = new FrameLayout(getApplicationContext());
        this.f32i.setMinimumWidth(this.f33j);
        this.f32i.setMinimumHeight(this.f33j);
        this.f32i.setOnClickListener(this);
        setCustomClose(z);
        return this.f32i;
    }

    /* renamed from: a */
    private void m22a(String str) {
        C0461b.m502b(str);
        finish();
    }

    /* renamed from: a */
    private void m23a(String str, Throwable th) {
        C0461b.m503b(str, th);
        finish();
    }

    public AdVideoView getAdVideoView() {
        return this.f43t;
    }

    public AdWebView getOpeningAdWebView() {
        if (this.f38o != null) {
            return this.f38o.f31h;
        }
        synchronized (f25b) {
            if (f27d == null) {
                C0461b.m508e("currentAdManager was null while trying to get the opening AdWebView.");
                return null;
            }
            AdWebView l = f27d.mo7175l();
            if (l != this.f31h) {
                return l;
            }
            return null;
        }
    }

    public static boolean isShowing() {
        return f30g.isShowing();
    }

    public static boolean leftApplication() {
        return f30g.leftApplication();
    }

    public static void launchAdActivity(C0424d adManager, C0425e adOpener) {
        f30g.launchAdActivity(adManager, adOpener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6874a(HashMap<String, String> hashMap, C0424d dVar) {
        boolean z;
        int i;
        if (hashMap == null) {
            m22a("Could not get the paramMap in launchIntent()");
            return;
        }
        Intent intent = new Intent();
        String str = hashMap.get(URL_PARAM);
        String str2 = hashMap.get(TYPE_PARAM);
        String str3 = hashMap.get(INTENT_ACTION_PARAM);
        String str4 = hashMap.get(PACKAGE_NAME_PARAM);
        String str5 = hashMap.get(COMPONENT_NAME_PARAM);
        String str6 = hashMap.get(INTENT_FLAGS_PARAM);
        String str7 = hashMap.get(INTENT_EXTRAS_PARAM);
        boolean z2 = !TextUtils.isEmpty(str);
        if (!TextUtils.isEmpty(str2)) {
            z = true;
        } else {
            z = false;
        }
        if (z2 && z) {
            intent.setDataAndType(Uri.parse(str), str2);
        } else if (z2) {
            intent.setData(Uri.parse(str));
        } else if (z) {
            intent.setType(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.setAction(str3);
        } else if (z2) {
            intent.setAction("android.intent.action.VIEW");
        }
        if (!TextUtils.isEmpty(str4) && AdUtil.f639a >= 4) {
            C0468e.m517a(intent, str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            String[] split = str5.split("/");
            if (split.length < 2) {
                C0461b.m508e("Warning: Could not parse component name from open GMSG: " + str5);
            }
            intent.setClassName(split[0], split[1]);
        }
        if (!TextUtils.isEmpty(str6)) {
            try {
                i = Integer.parseInt(str6);
            } catch (NumberFormatException e) {
                C0461b.m508e("Warning: Could not parse flags from open GMSG: " + str6);
                i = 0;
            }
            intent.addFlags(i);
        }
        if (!TextUtils.isEmpty(str7)) {
            try {
                JSONObject jSONObject = new JSONObject(str7);
                JSONArray names = jSONObject.names();
                for (int i2 = 0; i2 < names.length(); i2++) {
                    String string = names.getString(i2);
                    JSONObject jSONObject2 = jSONObject.getJSONObject(string);
                    int i3 = jSONObject2.getInt("t");
                    switch (i3) {
                        case 1:
                            intent.putExtra(string, jSONObject2.getBoolean("v"));
                            break;
                        case 2:
                            intent.putExtra(string, jSONObject2.getDouble("v"));
                            break;
                        case 3:
                            intent.putExtra(string, jSONObject2.getInt("v"));
                            break;
                        case 4:
                            intent.putExtra(string, jSONObject2.getLong("v"));
                            break;
                        case 5:
                            intent.putExtra(string, jSONObject2.getString("v"));
                            break;
                        default:
                            C0461b.m508e("Warning: Unknown type in extras from open GMSG: " + string + " (type: " + i3 + ")");
                            break;
                    }
                }
            } catch (JSONException e2) {
                C0461b.m508e("Warning: Could not parse extras from open GMSG: " + str7);
            }
        }
        if (intent.filterEquals(new Intent())) {
            m22a("Tried to launch empty intent.");
            return;
        }
        try {
            C0461b.m498a("Launching an intent from AdActivity: " + intent);
            startActivity(intent);
            mo6873a(dVar);
        } catch (ActivityNotFoundException e3) {
            m23a(e3.getMessage(), (Throwable) e3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6873a(C0424d dVar) {
        this.f31h = null;
        this.f36m = SystemClock.elapsedRealtime();
        this.f39p = true;
        synchronized (f25b) {
            if (f26c == null) {
                f26c = this;
                dVar.mo7186w();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AdVideoView mo6871a(Activity activity) {
        return new AdVideoView(activity, this.f31h);
    }

    public void moveAdVideoView(int x, int y, int width, int height) {
        if (this.f43t != null) {
            this.f43t.setLayoutParams(m20a(x, y, width, height));
            this.f43t.requestLayout();
        }
    }

    public void newAdVideoView(int x, int y, int width, int height) {
        if (this.f43t == null) {
            this.f43t = mo6871a((Activity) this);
            this.f37n.addView(this.f43t, 0, m20a(x, y, width, height));
            synchronized (f25b) {
                if (f27d == null) {
                    C0461b.m508e("currentAdManager was null while trying to get the opening AdWebView.");
                } else {
                    f27d.mo7176m().mo7237b(false);
                }
            }
        }
    }

    /* renamed from: a */
    private RelativeLayout.LayoutParams m20a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    public void onClick(View v) {
        finish();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0088, code lost:
        r11.f37n = null;
        r11.f39p = false;
        r11.f40q = true;
        r11.f43t = null;
        r0 = getIntent().getBundleExtra("com.google.ads.AdOpener");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
        if (r0 != null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        m22a("Could not get the Bundle used to create AdActivity.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b0, code lost:
        r1 = new com.google.ads.internal.C0425e(r0);
        r0 = r1.mo7191b();
        r10 = r1.mo7192c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c3, code lost:
        if (r0.equals("intent") == false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c5, code lost:
        mo6874a(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c9, code lost:
        r11.f37n = new android.widget.RelativeLayout(getApplicationContext());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00da, code lost:
        if (r0.equals("webapp") == false) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00dc, code lost:
        r11.f31h = new com.google.ads.internal.AdWebView(r8.mo7172i(), (com.google.ads.AdSize) null);
        r1 = com.google.ads.internal.C0409a.f426d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e9, code lost:
        if (r9 != false) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00eb, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ec, code lost:
        r0 = com.google.ads.internal.C0431i.m417a(r8, r1, true, r0);
        r0.mo7239d(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f3, code lost:
        if (r9 == false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f5, code lost:
        r0.mo7235a(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f8, code lost:
        r11.f31h.setWebViewClient(r0);
        r0 = r10.get(URL_PARAM);
        r1 = r10.get(BASE_URL_PARAM);
        r2 = r10.get(HTML_PARAM);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0115, code lost:
        if (r0 == null) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0117, code lost:
        r11.f31h.loadUrl(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011c, code lost:
        r0 = r10.get(ORIENTATION_PARAM);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012a, code lost:
        if (PACKAGE_NAME_PARAM.equals(r0) == false) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012c, code lost:
        r3 = com.google.ads.util.AdUtil.m472b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0130, code lost:
        r1 = r11.f31h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0132, code lost:
        if (r10 == null) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0140, code lost:
        if ("1".equals(r10.get(CUSTOM_CLOSE_PARAM)) == false) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0142, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0143, code lost:
        mo6872a(r1, false, r3, r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014b, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014d, code lost:
        if (r2 == null) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014f, code lost:
        r11.f31h.loadDataWithBaseURL(r1, r2, "text/html", "utf-8", (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0159, code lost:
        m22a("Could not get the URL or HTML parameter to show a web app.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0166, code lost:
        if ("l".equals(r0) == false) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0168, code lost:
        r3 = com.google.ads.util.AdUtil.m454a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x016f, code lost:
        if (r11 != f28e) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0171, code lost:
        r3 = r8.mo7178o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0176, code lost:
        r3 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0178, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0180, code lost:
        if (r0.equals("interstitial") != false) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0188, code lost:
        if (r0.equals("expand") == false) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x018a, code lost:
        r11.f31h = r8.mo7175l();
        r3 = r8.mo7178o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x019a, code lost:
        if (r0.equals("expand") == false) goto L_0x01d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x019c, code lost:
        r11.f31h.setIsExpandedMraid(true);
        r11.f40q = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01a3, code lost:
        if (r10 == null) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b1, code lost:
        if ("1".equals(r10.get(CUSTOM_CLOSE_PARAM)) == false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01b3, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01b6, code lost:
        if (r11.f41r == false) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01ba, code lost:
        if (r11.f42s != false) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01bc, code lost:
        com.google.ads.util.C0461b.m498a("Re-enabling hardware acceleration on expanding MRAID WebView.");
        r11.f31h.mo7080h();
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01c7, code lost:
        mo6872a(r11.f31h, true, r3, r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01d1, code lost:
        r5 = r11.f31h.mo7082j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01d9, code lost:
        m22a("Unknown AdOpener, <action: " + r0 + ">");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f7, code lost:
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            r5 = 0
            r7 = 0
            r6 = 1
            super.onCreate(r12)
            r11.f35l = r7
            java.lang.Object r2 = f25b
            monitor-enter(r2)
            com.google.ads.internal.d r0 = f27d     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x00a2
            com.google.ads.internal.d r8 = f27d     // Catch:{ all -> 0x00a9 }
            com.google.ads.AdActivity r0 = f28e     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x001a
            f28e = r11     // Catch:{ all -> 0x00a9 }
            r8.mo7185v()     // Catch:{ all -> 0x00a9 }
        L_0x001a:
            com.google.ads.AdActivity r0 = r11.f38o     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x0026
            com.google.ads.AdActivity r0 = f29f     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0026
            com.google.ads.AdActivity r0 = f29f     // Catch:{ all -> 0x00a9 }
            r11.f38o = r0     // Catch:{ all -> 0x00a9 }
        L_0x0026:
            f29f = r11     // Catch:{ all -> 0x00a9 }
            com.google.ads.n r0 = r8.mo7172i()     // Catch:{ all -> 0x00a9 }
            boolean r0 = r0.mo7305a()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0036
            com.google.ads.AdActivity r0 = f28e     // Catch:{ all -> 0x00a9 }
            if (r0 == r11) goto L_0x0046
        L_0x0036:
            com.google.ads.n r0 = r8.mo7172i()     // Catch:{ all -> 0x00a9 }
            boolean r0 = r0.mo7306b()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0049
            com.google.ads.AdActivity r0 = r11.f38o     // Catch:{ all -> 0x00a9 }
            com.google.ads.AdActivity r1 = f28e     // Catch:{ all -> 0x00a9 }
            if (r0 != r1) goto L_0x0049
        L_0x0046:
            r8.mo7187x()     // Catch:{ all -> 0x00a9 }
        L_0x0049:
            boolean r9 = r8.mo7181r()     // Catch:{ all -> 0x00a9 }
            com.google.ads.n r0 = r8.mo7172i()     // Catch:{ all -> 0x00a9 }
            com.google.ads.util.i$b<com.google.ads.m> r0 = r0.f606d     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r0.mo7347a()     // Catch:{ all -> 0x00a9 }
            com.google.ads.m r0 = (com.google.ads.C0442m) r0     // Catch:{ all -> 0x00a9 }
            com.google.ads.util.i$b<com.google.ads.m$a> r0 = r0.f565b     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r0.mo7347a()     // Catch:{ all -> 0x00a9 }
            com.google.ads.m$a r0 = (com.google.ads.C0442m.C0443a) r0     // Catch:{ all -> 0x00a9 }
            int r3 = com.google.ads.util.AdUtil.f639a     // Catch:{ all -> 0x00a9 }
            com.google.ads.util.i$c<java.lang.Integer> r1 = r0.f568b     // Catch:{ all -> 0x00a9 }
            java.lang.Object r1 = r1.mo7348a()     // Catch:{ all -> 0x00a9 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x00a9 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00a9 }
            if (r3 < r1) goto L_0x00ac
            r1 = r6
        L_0x0072:
            r11.f42s = r1     // Catch:{ all -> 0x00a9 }
            int r1 = com.google.ads.util.AdUtil.f639a     // Catch:{ all -> 0x00a9 }
            com.google.ads.util.i$c<java.lang.Integer> r0 = r0.f570d     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r0.mo7348a()     // Catch:{ all -> 0x00a9 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x00a9 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x00a9 }
            if (r1 < r0) goto L_0x00ae
            r0 = r6
        L_0x0085:
            r11.f41r = r0     // Catch:{ all -> 0x00a9 }
            monitor-exit(r2)     // Catch:{ all -> 0x00a9 }
            r11.f37n = r5
            r11.f39p = r7
            r11.f40q = r6
            r11.f43t = r5
            android.content.Intent r0 = r11.getIntent()
            java.lang.String r1 = "com.google.ads.AdOpener"
            android.os.Bundle r0 = r0.getBundleExtra(r1)
            if (r0 != 0) goto L_0x00b0
            java.lang.String r0 = "Could not get the Bundle used to create AdActivity."
            r11.m22a((java.lang.String) r0)
        L_0x00a1:
            return
        L_0x00a2:
            java.lang.String r0 = "Could not get currentAdManager."
            r11.m22a((java.lang.String) r0)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r2)     // Catch:{ all -> 0x00a9 }
            goto L_0x00a1
        L_0x00a9:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00a9 }
            throw r0
        L_0x00ac:
            r1 = r7
            goto L_0x0072
        L_0x00ae:
            r0 = r7
            goto L_0x0085
        L_0x00b0:
            com.google.ads.internal.e r1 = new com.google.ads.internal.e
            r1.<init>((android.os.Bundle) r0)
            java.lang.String r0 = r1.mo7191b()
            java.util.HashMap r10 = r1.mo7192c()
            java.lang.String r1 = "intent"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00c9
            r11.mo6874a((java.util.HashMap<java.lang.String, java.lang.String>) r10, (com.google.ads.internal.C0424d) r8)
            goto L_0x00a1
        L_0x00c9:
            android.widget.RelativeLayout r1 = new android.widget.RelativeLayout
            android.content.Context r2 = r11.getApplicationContext()
            r1.<init>(r2)
            r11.f37n = r1
            java.lang.String r1 = "webapp"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x017a
            com.google.ads.internal.AdWebView r0 = new com.google.ads.internal.AdWebView
            com.google.ads.n r1 = r8.mo7172i()
            r0.<init>(r1, r5)
            r11.f31h = r0
            java.util.Map<java.lang.String, com.google.ads.o> r1 = com.google.ads.internal.C0409a.f426d
            if (r9 != 0) goto L_0x014b
            r0 = r6
        L_0x00ec:
            com.google.ads.internal.i r0 = com.google.ads.internal.C0431i.m417a(r8, r1, r6, r0)
            r0.mo7239d(r6)
            if (r9 == 0) goto L_0x00f8
            r0.mo7235a(r6)
        L_0x00f8:
            com.google.ads.internal.AdWebView r1 = r11.f31h
            r1.setWebViewClient(r0)
            java.lang.String r0 = "u"
            java.lang.Object r0 = r10.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "baseurl"
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "html"
            java.lang.Object r2 = r10.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r0 == 0) goto L_0x014d
            com.google.ads.internal.AdWebView r1 = r11.f31h
            r1.loadUrl(r0)
        L_0x011c:
            java.lang.String r0 = "o"
            java.lang.Object r0 = r10.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "p"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0160
            int r3 = com.google.ads.util.AdUtil.m472b()
        L_0x0130:
            com.google.ads.internal.AdWebView r1 = r11.f31h
            if (r10 == 0) goto L_0x0178
            java.lang.String r0 = "1"
            java.lang.String r2 = "custom_close"
            java.lang.Object r2 = r10.get(r2)
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0178
            r5 = r6
        L_0x0143:
            r0 = r11
            r2 = r7
            r4 = r9
            r0.mo6872a(r1, r2, r3, r4, r5)
            goto L_0x00a1
        L_0x014b:
            r0 = r7
            goto L_0x00ec
        L_0x014d:
            if (r2 == 0) goto L_0x0159
            com.google.ads.internal.AdWebView r0 = r11.f31h
            java.lang.String r3 = "text/html"
            java.lang.String r4 = "utf-8"
            r0.loadDataWithBaseURL(r1, r2, r3, r4, r5)
            goto L_0x011c
        L_0x0159:
            java.lang.String r0 = "Could not get the URL or HTML parameter to show a web app."
            r11.m22a((java.lang.String) r0)
            goto L_0x00a1
        L_0x0160:
            java.lang.String r1 = "l"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x016d
            int r3 = com.google.ads.util.AdUtil.m454a()
            goto L_0x0130
        L_0x016d:
            com.google.ads.AdActivity r0 = f28e
            if (r11 != r0) goto L_0x0176
            int r3 = r8.mo7178o()
            goto L_0x0130
        L_0x0176:
            r3 = -1
            goto L_0x0130
        L_0x0178:
            r5 = r7
            goto L_0x0143
        L_0x017a:
            java.lang.String r1 = "interstitial"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x018a
            java.lang.String r1 = "expand"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01d9
        L_0x018a:
            com.google.ads.internal.AdWebView r1 = r8.mo7175l()
            r11.f31h = r1
            int r3 = r8.mo7178o()
            java.lang.String r1 = "expand"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01d1
            com.google.ads.internal.AdWebView r0 = r11.f31h
            r0.setIsExpandedMraid(r6)
            r11.f40q = r7
            if (r10 == 0) goto L_0x01b4
            java.lang.String r0 = "1"
            java.lang.String r1 = "custom_close"
            java.lang.Object r1 = r10.get(r1)
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01b4
            r7 = r6
        L_0x01b4:
            boolean r0 = r11.f41r
            if (r0 == 0) goto L_0x01f7
            boolean r0 = r11.f42s
            if (r0 != 0) goto L_0x01f7
            java.lang.String r0 = "Re-enabling hardware acceleration on expanding MRAID WebView."
            com.google.ads.util.C0461b.m498a((java.lang.String) r0)
            com.google.ads.internal.AdWebView r0 = r11.f31h
            r0.mo7080h()
            r5 = r7
        L_0x01c7:
            com.google.ads.internal.AdWebView r1 = r11.f31h
            r0 = r11
            r2 = r6
            r4 = r9
            r0.mo6872a(r1, r2, r3, r4, r5)
            goto L_0x00a1
        L_0x01d1:
            com.google.ads.internal.AdWebView r0 = r11.f31h
            boolean r7 = r0.mo7082j()
            r5 = r7
            goto L_0x01c7
        L_0x01d9:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown AdOpener, <action: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = ">"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.m22a((java.lang.String) r0)
            goto L_0x00a1
        L_0x01f7:
            r5 = r7
            goto L_0x01c7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6872a(AdWebView adWebView, boolean z, int i, boolean z2, boolean z3) {
        requestWindowFeature(1);
        Window window = getWindow();
        window.setFlags(1024, 1024);
        if (AdUtil.f639a >= 11) {
            if (this.f41r) {
                C0461b.m498a("Enabling hardware acceleration on the AdActivity window.");
                C0470g.m521a(window);
            } else {
                C0461b.m498a("Disabling hardware acceleration on the AdActivity WebView.");
                adWebView.mo7079g();
            }
        }
        ViewParent parent = adWebView.getParent();
        if (parent != null) {
            if (!z2) {
                m22a("Interstitial created with an AdWebView that has a parent.");
                return;
            } else if (parent instanceof ViewGroup) {
                this.f34k = (ViewGroup) parent;
                this.f34k.removeView(adWebView);
            } else {
                m22a("MRAID banner was not a child of a ViewGroup.");
                return;
            }
        }
        if (adWebView.mo7081i() != null) {
            m22a("Interstitial created with an AdWebView that is already in use by another AdActivity.");
            return;
        }
        setRequestedOrientation(i);
        adWebView.setAdActivity(this);
        View a = mo6870a(z2 ? 50 : 32, z3);
        this.f37n.addView(adWebView, -1, -1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (z2) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        }
        this.f37n.addView(a, layoutParams);
        this.f37n.setKeepScreenOn(true);
        setContentView(this.f37n);
        this.f37n.getRootView().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        if (z) {
            f24a.mo7096a((WebView) adWebView);
        }
    }

    public void onDestroy() {
        if (this.f37n != null) {
            this.f37n.removeAllViews();
        }
        if (isFinishing()) {
            m28e();
            if (this.f40q && this.f31h != null) {
                this.f31h.stopLoading();
                this.f31h.destroy();
                this.f31h = null;
            }
        }
        super.onDestroy();
    }

    public void onPause() {
        if (isFinishing()) {
            m28e();
        }
        super.onPause();
    }

    /* renamed from: e */
    private void m28e() {
        if (!this.f35l) {
            if (this.f31h != null) {
                f24a.mo7102b((WebView) this.f31h);
                this.f31h.setAdActivity((AdActivity) null);
                this.f31h.setIsExpandedMraid(false);
                if (!(this.f40q || this.f37n == null || this.f34k == null)) {
                    if (this.f41r && !this.f42s) {
                        C0461b.m498a("Disabling hardware acceleration on collapsing MRAID WebView.");
                        this.f31h.mo7079g();
                    } else if (!this.f41r && this.f42s) {
                        C0461b.m498a("Re-enabling hardware acceleration on collapsing MRAID WebView.");
                        this.f31h.mo7080h();
                    }
                    this.f37n.removeView(this.f31h);
                    this.f34k.addView(this.f31h);
                }
            }
            if (this.f43t != null) {
                this.f43t.mo7067e();
                this.f43t = null;
            }
            if (this == f26c) {
                f26c = null;
            }
            f29f = this.f38o;
            synchronized (f25b) {
                if (!(f27d == null || !this.f40q || this.f31h == null)) {
                    if (this.f31h == f27d.mo7175l()) {
                        f27d.mo7144a();
                    }
                    this.f31h.stopLoading();
                }
                if (this == f28e) {
                    f28e = null;
                    if (f27d != null) {
                        f27d.mo7184u();
                        f27d = null;
                    } else {
                        C0461b.m508e("currentAdManager is null while trying to destroy AdActivity.");
                    }
                }
            }
            this.f35l = true;
            C0461b.m498a("AdActivity is closing.");
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        if (this.f39p && hasFocus && SystemClock.elapsedRealtime() - this.f36m > 250) {
            C0461b.m506d("Launcher AdActivity got focus and is closing.");
            finish();
        }
        super.onWindowFocusChanged(hasFocus);
    }

    public void setCustomClose(boolean useCustomClose) {
        if (this.f32i != null) {
            this.f32i.removeAllViews();
            if (!useCustomClose) {
                ImageButton imageButton = new ImageButton(this);
                imageButton.setImageResource(17301527);
                imageButton.setBackgroundColor(0);
                imageButton.setOnClickListener(this);
                imageButton.setPadding(0, 0, 0, 0);
                this.f32i.addView(imageButton, new FrameLayout.LayoutParams(this.f33j, this.f33j, 17));
            }
        }
    }
}
