package com.google.ads.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.p000v4.p002os.EnvironmentCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.webkit.WebView;
import com.google.ads.AdActivity;
import com.google.ads.AdRequest;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AdUtil {

    /* renamed from: a */
    public static final int f639a = m457a(Build.VERSION.SDK);

    /* renamed from: b */
    private static Boolean f640b = null;

    /* renamed from: c */
    private static String f641c = null;

    /* renamed from: d */
    private static String f642d;

    /* renamed from: e */
    private static String f643e = null;

    /* renamed from: f */
    private static AudioManager f644f;

    /* renamed from: g */
    private static boolean f645g = true;

    /* renamed from: h */
    private static boolean f646h = false;

    /* renamed from: i */
    private static String f647i = null;

    /* renamed from: com.google.ads.util.AdUtil$a */
    public enum C0457a {
        INVALID,
        SPEAKER,
        HEADPHONES,
        VIBRATE,
        EMULATOR,
        OTHER
    }

    /* renamed from: a */
    public static boolean m469a(Intent intent, Context context) {
        return context.getPackageManager().resolveActivity(intent, 65536) != null;
    }

    /* renamed from: a */
    public static String m460a(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        CharBuffer allocate = CharBuffer.allocate(2048);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return sb.toString();
            }
            allocate.flip();
            sb.append(allocate, 0, read);
        }
    }

    /* renamed from: a */
    public static int m457a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C0461b.m508e("The Android SDK version couldn't be parsed to an int: " + Build.VERSION.SDK);
            C0461b.m508e("Defaulting to Android SDK version 3.");
            return 3;
        }
    }

    /* renamed from: a */
    public static String m459a(Context context) {
        String str;
        if (f641c == null) {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string == null || m478c()) {
                str = m474b("emulator");
            } else {
                str = m474b(string);
            }
            if (str == null) {
                return null;
            }
            f641c = str.toUpperCase(Locale.US);
        }
        return f641c;
    }

    /* renamed from: a */
    public static int m454a() {
        if (f639a >= 9) {
            return 6;
        }
        return 0;
    }

    /* renamed from: b */
    public static int m472b() {
        if (f639a >= 9) {
            return 7;
        }
        return 1;
    }

    /* renamed from: a */
    public static int m456a(Context context, DisplayMetrics displayMetrics) {
        if (f639a >= 4) {
            return C0468e.m516a(context, displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    /* renamed from: b */
    public static int m473b(Context context, DisplayMetrics displayMetrics) {
        if (f639a >= 4) {
            return C0468e.m518b(context, displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    /* renamed from: b */
    public static boolean m477b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager.checkPermission("android.permission.INTERNET", packageName) == -1) {
            C0461b.m502b("INTERNET permissions must be enabled in AndroidManifest.xml.");
            return false;
        } else if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", packageName) != -1) {
            return true;
        } else {
            C0461b.m502b("ACCESS_NETWORK_STATE permissions must be enabled in AndroidManifest.xml.");
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m467a(int i, int i2, String str) {
        if ((i & i2) != 0) {
            return true;
        }
        C0461b.m502b("The android:configChanges value of the com.google.ads.AdActivity must include " + str + ".");
        return false;
    }

    /* renamed from: c */
    public static boolean m479c(Context context) {
        if (f640b != null) {
            return f640b.booleanValue();
        }
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(new Intent(context, AdActivity.class), 65536);
        f640b = true;
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            C0461b.m502b("Could not find com.google.ads.AdActivity, please make sure it is registered in AndroidManifest.xml.");
            f640b = false;
        } else {
            if (!m467a(resolveActivity.activityInfo.configChanges, 16, "keyboard")) {
                f640b = false;
            }
            if (!m467a(resolveActivity.activityInfo.configChanges, 32, "keyboardHidden")) {
                f640b = false;
            }
            if (!m467a(resolveActivity.activityInfo.configChanges, 128, "orientation")) {
                f640b = false;
            }
            if (!m467a(resolveActivity.activityInfo.configChanges, 256, "screenLayout")) {
                f640b = false;
            }
            if (!m467a(resolveActivity.activityInfo.configChanges, 512, "uiMode")) {
                f640b = false;
            }
            if (!m467a(resolveActivity.activityInfo.configChanges, 1024, "screenSize")) {
                f640b = false;
            }
            if (!m467a(resolveActivity.activityInfo.configChanges, 2048, "smallestScreenSize")) {
                f640b = false;
            }
        }
        return f640b.booleanValue();
    }

    /* renamed from: c */
    public static boolean m478c() {
        return m471a((C0467d) null);
    }

    /* renamed from: a */
    static boolean m471a(C0467d dVar) {
        if (dVar == null) {
            dVar = C0467d.f673d;
        }
        return dVar.equals(C0467d.f674e) || dVar.equals(C0467d.f675f);
    }

    /* renamed from: a */
    public static boolean m470a(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static String m474b(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(), 0, str.length());
            return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, instance.digest())});
        } catch (NoSuchAlgorithmException e) {
            return str.substring(0, 32);
        }
    }

    /* renamed from: d */
    public static String m480d(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
                return "ed";
            case 1:
                return "wi";
            default:
                return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    /* renamed from: e */
    public static String m482e(Context context) {
        if (f642d == null) {
            StringBuilder sb = new StringBuilder();
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=donuts")), 65536);
            if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
                sb.append(AdActivity.TYPE_PARAM);
            }
            List<ResolveInfo> queryIntentActivities2 = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.google")), 65536);
            if (queryIntentActivities2 == null || queryIntentActivities2.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append("a");
            }
            f642d = sb.toString();
        }
        return f642d;
    }

    /* renamed from: a */
    public static boolean m468a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: f */
    public static String m483f(Context context) {
        ActivityInfo activityInfo;
        PackageInfo packageInfo;
        if (f643e != null) {
            return f643e;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ads")), 65536);
            if (resolveActivity == null || (activityInfo = resolveActivity.activityInfo) == null || (packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0)) == null) {
                return null;
            }
            f643e = packageInfo.versionCode + "." + activityInfo.packageName;
            return f643e;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /* renamed from: g */
    public static C0457a m484g(Context context) {
        if (f644f == null) {
            f644f = (AudioManager) context.getSystemService("audio");
        }
        C0457a aVar = C0457a.OTHER;
        int mode = f644f.getMode();
        if (m478c()) {
            return C0457a.EMULATOR;
        }
        if (f644f.isMusicActive() || f644f.isSpeakerphoneOn() || mode == 2 || mode == 1) {
            return C0457a.VIBRATE;
        }
        int ringerMode = f644f.getRingerMode();
        if (ringerMode == 0 || ringerMode == 1) {
            return C0457a.VIBRATE;
        }
        return C0457a.SPEAKER;
    }

    /* renamed from: a */
    public static DisplayMetrics m458a(Activity activity) {
        if (activity.getWindowManager() == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: a */
    public static HashMap<String, Object> m462a(Location location) {
        if (location == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("time", Long.valueOf(location.getTime() * 1000));
        hashMap.put("lat", Long.valueOf((long) (location.getLatitude() * 1.0E7d)));
        hashMap.put("long", Long.valueOf((long) (location.getLongitude() * 1.0E7d)));
        hashMap.put("radius", Long.valueOf((long) (location.getAccuracy() * 1000.0f)));
        return hashMap;
    }

    /* renamed from: b */
    public static HashMap<String, String> m475b(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery != null) {
            for (String str : encodedQuery.split("&")) {
                int indexOf = str.indexOf("=");
                if (indexOf < 0) {
                    hashMap.put(Uri.decode(str), (Object) null);
                } else {
                    hashMap.put(Uri.decode(str.substring(0, indexOf)), Uri.decode(str.substring(indexOf + 1, str.length())));
                }
            }
        }
        return hashMap;
    }

    /* renamed from: d */
    public static boolean m481d() {
        return f645g;
    }

    /* renamed from: a */
    public static void m466a(boolean z) {
        f645g = z;
    }

    /* renamed from: h */
    public static void m485h(Context context) {
        if (!f646h) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new UserActivityReceiver(), intentFilter);
            f646h = true;
        }
    }

    public static class UserActivityReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
                AdUtil.m466a(true);
            } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                AdUtil.m466a(false);
            }
        }
    }

    /* renamed from: i */
    public static String m486i(Context context) {
        if (f647i == null) {
            String userAgentString = new WebView(context).getSettings().getUserAgentString();
            if (userAgentString == null || userAgentString.length() == 0 || userAgentString.equals("Java0")) {
                String property = System.getProperty("os.name", "Linux");
                String str = "Android " + Build.VERSION.RELEASE;
                Locale locale = Locale.getDefault();
                String lowerCase = locale.getLanguage().toLowerCase(Locale.US);
                if (lowerCase.length() == 0) {
                    lowerCase = "en";
                }
                String lowerCase2 = locale.getCountry().toLowerCase(Locale.US);
                if (lowerCase2.length() > 0) {
                    lowerCase = lowerCase + "-" + lowerCase2;
                }
                userAgentString = "Mozilla/5.0 (" + property + "; U; " + str + "; " + lowerCase + "; " + (Build.MODEL + " Build/" + Build.ID) + ") AppleWebKit/0.0 (KHTML, like " + "Gecko) Version/0.0 Mobile Safari/0.0";
            }
            f647i = userAgentString + " (Mobile; " + "afma-sdk-a-v" + AdRequest.VERSION + ")";
        }
        return f647i;
    }

    /* renamed from: a */
    public static void m464a(WebView webView) {
        webView.getSettings().setUserAgentString(m486i(webView.getContext().getApplicationContext()));
    }

    /* renamed from: a */
    public static void m465a(HttpURLConnection httpURLConnection, Context context) {
        httpURLConnection.setRequestProperty("User-Agent", m486i(context));
    }

    /* renamed from: a */
    public static String m461a(Map<String, Object> map) {
        try {
            return m476b(map).toString();
        } catch (JSONException e) {
            C0461b.m507d("JsonException in serialization: ", e);
            return null;
        }
    }

    /* renamed from: b */
    public static JSONObject m476b(Map<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.isEmpty()) {
            return jSONObject;
        }
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Long) || (obj instanceof Float)) {
                jSONObject.put(next, obj);
            } else if (obj instanceof Map) {
                try {
                    jSONObject.put(next, m476b((Map<String, Object>) (Map) obj));
                } catch (ClassCastException e) {
                    C0461b.m507d("Unknown map type in json serialization: ", e);
                }
            } else if (obj instanceof Set) {
                try {
                    jSONObject.put(next, m463a((Set<Object>) (Set) obj));
                } catch (ClassCastException e2) {
                    C0461b.m507d("Unknown map type in json serialization: ", e2);
                }
            } else {
                C0461b.m508e("Unknown value in json serialization: " + obj);
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONArray m463a(Set<Object> set) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (set == null || set.isEmpty()) {
            return jSONArray;
        }
        for (Object next : set) {
            if ((next instanceof String) || (next instanceof Integer) || (next instanceof Double) || (next instanceof Long) || (next instanceof Float)) {
                jSONArray.put(next);
            } else if (next instanceof Map) {
                try {
                    jSONArray.put(m476b((Map<String, Object>) (Map) next));
                } catch (ClassCastException e) {
                    C0461b.m507d("Unknown map type in json serialization: ", e);
                }
            } else if (next instanceof Set) {
                try {
                    jSONArray.put(m463a((Set<Object>) (Set) next));
                } catch (ClassCastException e2) {
                    C0461b.m507d("Unknown map type in json serialization: ", e2);
                }
            } else {
                C0461b.m508e("Unknown value in json serialization: " + next);
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static int m455a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }
}
