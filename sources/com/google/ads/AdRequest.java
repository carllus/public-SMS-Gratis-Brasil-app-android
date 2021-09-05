package com.google.ads;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.google.ads.doubleclick.DfpExtras;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.admob.AdMobAdapterExtras;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0461b;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdRequest {
    public static final String LOGTAG = "Ads";
    public static final String TEST_EMULATOR = AdUtil.m474b("emulator");
    public static final String VERSION = "6.4.1";

    /* renamed from: a */
    private static final SimpleDateFormat f44a = new SimpleDateFormat("yyyyMMdd");

    /* renamed from: b */
    private static Method f45b;

    /* renamed from: c */
    private static Method f46c;

    /* renamed from: d */
    private Gender f47d = null;

    /* renamed from: e */
    private Date f48e = null;

    /* renamed from: f */
    private Set<String> f49f = null;

    /* renamed from: g */
    private Map<String, Object> f50g = null;

    /* renamed from: h */
    private final Map<Class<?>, NetworkExtras> f51h = new HashMap();

    /* renamed from: i */
    private Location f52i = null;

    /* renamed from: j */
    private boolean f53j = false;

    /* renamed from: k */
    private boolean f54k = false;

    /* renamed from: l */
    private Set<String> f55l = null;

    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }

    static {
        f45b = null;
        f46c = null;
        try {
            for (Method method : Class.forName("com.google.analytics.tracking.android.AdMobInfo").getMethods()) {
                if (method.getName().equals("getInstance") && method.getParameterTypes().length == 0) {
                    f45b = method;
                } else if (method.getName().equals("getJoinIds") && method.getParameterTypes().length == 0) {
                    f46c = method;
                }
            }
            if (f45b == null || f46c == null) {
                f45b = null;
                f46c = null;
                C0461b.m508e("No Google Analytics: Library Incompatible.");
            }
        } catch (ClassNotFoundException e) {
            C0461b.m498a("No Google Analytics: Library Not Found.");
        } catch (Throwable th) {
            C0461b.m498a("No Google Analytics: Error Loading Library");
        }
    }

    public enum ErrorCode {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        

        /* renamed from: a */
        private final String f57a;

        private ErrorCode(String description) {
            this.f57a = description;
        }

        public String toString() {
            return this.f57a;
        }
    }

    public AdRequest setGender(Gender gender) {
        this.f47d = gender;
        return this;
    }

    public Gender getGender() {
        return this.f47d;
    }

    @Deprecated
    public AdRequest setBirthday(String birthday) {
        if (birthday == "" || birthday == null) {
            this.f48e = null;
        } else {
            try {
                this.f48e = f44a.parse(birthday);
            } catch (ParseException e) {
                C0461b.m508e("Birthday format invalid.  Expected 'YYYYMMDD' where 'YYYY' is a 4 digit year, 'MM' is a two digit month, and 'DD' is a two digit day.  Birthday value ignored");
                this.f48e = null;
            }
        }
        return this;
    }

    public AdRequest setBirthday(Date birthday) {
        if (birthday == null) {
            this.f48e = null;
        } else {
            this.f48e = new Date(birthday.getTime());
        }
        return this;
    }

    public AdRequest setBirthday(Calendar calendar) {
        if (calendar == null) {
            this.f48e = null;
        } else {
            setBirthday(calendar.getTime());
        }
        return this;
    }

    public Date getBirthday() {
        return this.f48e;
    }

    public AdRequest clearBirthday() {
        this.f48e = null;
        return this;
    }

    @Deprecated
    public AdRequest setPlusOneOptOut(boolean plusOneOptOut) {
        m34a().setPlusOneOptOut(plusOneOptOut);
        return this;
    }

    @Deprecated
    public boolean getPlusOneOptOut() {
        return m34a().getPlusOneOptOut();
    }

    public AdRequest setKeywords(Set<String> keywords) {
        this.f49f = keywords;
        return this;
    }

    public AdRequest addKeyword(String keyword) {
        if (this.f49f == null) {
            this.f49f = new HashSet();
        }
        this.f49f.add(keyword);
        return this;
    }

    public AdRequest addKeywords(Set<String> keywords) {
        if (this.f49f == null) {
            this.f49f = new HashSet();
        }
        this.f49f.addAll(keywords);
        return this;
    }

    public Set<String> getKeywords() {
        if (this.f49f == null) {
            return null;
        }
        return Collections.unmodifiableSet(this.f49f);
    }

    /* renamed from: a */
    private synchronized AdMobAdapterExtras m34a() {
        if (getNetworkExtras(AdMobAdapterExtras.class) == null) {
            setNetworkExtras(new AdMobAdapterExtras());
        }
        return (AdMobAdapterExtras) getNetworkExtras(AdMobAdapterExtras.class);
    }

    @Deprecated
    public AdRequest setExtras(Map<String, Object> extras) {
        m34a().setExtras(extras);
        return this;
    }

    @Deprecated
    public AdRequest addExtra(String key, Object value) {
        AdMobAdapterExtras a = m34a();
        if (a.getExtras() == null) {
            a.setExtras(new HashMap());
        }
        a.getExtras().put(key, value);
        return this;
    }

    public AdRequest setNetworkExtras(NetworkExtras extras) {
        if (extras != null) {
            this.f51h.put(extras.getClass(), extras);
        }
        return this;
    }

    public AdRequest removeNetworkExtras(Class<?> extrasClass) {
        this.f51h.remove(extrasClass);
        return this;
    }

    public <T> T getNetworkExtras(Class<T> extrasClass) {
        return this.f51h.get(extrasClass);
    }

    public AdRequest setMediationExtras(Map<String, Object> mediationExtras) {
        this.f50g = mediationExtras;
        return this;
    }

    public AdRequest addMediationExtra(String key, Object value) {
        if (this.f50g == null) {
            this.f50g = new HashMap();
        }
        this.f50g.put(key, value);
        return this;
    }

    public AdRequest setLocation(Location location) {
        this.f52i = location;
        return this;
    }

    public Location getLocation() {
        return this.f52i;
    }

    @Deprecated
    public AdRequest setTesting(boolean testing) {
        this.f53j = testing;
        return this;
    }

    public Map<String, Object> getRequestMap(Context context) {
        String str;
        HashMap hashMap = new HashMap();
        if (this.f49f != null) {
            hashMap.put("kw", this.f49f);
        }
        if (this.f47d != null) {
            hashMap.put("cust_gender", Integer.valueOf(this.f47d.ordinal()));
        }
        if (this.f48e != null) {
            hashMap.put("cust_age", f44a.format(this.f48e));
        }
        if (this.f52i != null) {
            hashMap.put("uule", AdUtil.m462a(this.f52i));
        }
        if (this.f53j) {
            hashMap.put("testing", 1);
        }
        if (isTestDevice(context)) {
            hashMap.put("adtest", "on");
        } else if (!this.f54k) {
            if (AdUtil.m478c()) {
                str = "AdRequest.TEST_EMULATOR";
            } else {
                str = "\"" + AdUtil.m459a(context) + "\"";
            }
            C0461b.m504c("To get test ads on this device, call adRequest.addTestDevice(" + str + ");");
            this.f54k = true;
        }
        AdMobAdapterExtras adMobAdapterExtras = (AdMobAdapterExtras) getNetworkExtras(AdMobAdapterExtras.class);
        DfpExtras dfpExtras = (DfpExtras) getNetworkExtras(DfpExtras.class);
        if (dfpExtras != null && dfpExtras.getExtras() != null && !dfpExtras.getExtras().isEmpty()) {
            hashMap.put("extras", dfpExtras.getExtras());
        } else if (!(adMobAdapterExtras == null || adMobAdapterExtras.getExtras() == null || adMobAdapterExtras.getExtras().isEmpty())) {
            hashMap.put("extras", adMobAdapterExtras.getExtras());
        }
        if (dfpExtras != null) {
            String publisherProvidedId = dfpExtras.getPublisherProvidedId();
            if (!TextUtils.isEmpty(publisherProvidedId)) {
                hashMap.put("ppid", publisherProvidedId);
            }
        }
        if (this.f50g != null) {
            hashMap.put("mediation_extras", this.f50g);
        }
        try {
            if (f45b != null) {
                Map map = (Map) f46c.invoke(f45b.invoke((Object) null, new Object[0]), new Object[0]);
                if (map != null && map.size() > 0) {
                    hashMap.put("analytics_join_id", map);
                }
            }
        } catch (Throwable th) {
            C0461b.m505c("Internal Analytics Error:", th);
        }
        return hashMap;
    }

    public AdRequest addTestDevice(String testDevice) {
        if (this.f55l == null) {
            this.f55l = new HashSet();
        }
        this.f55l.add(testDevice);
        return this;
    }

    public AdRequest setTestDevices(Set<String> testDevices) {
        this.f55l = testDevices;
        return this;
    }

    public boolean isTestDevice(Context context) {
        String a;
        if (this.f55l == null || (a = AdUtil.m459a(context)) == null || !this.f55l.contains(a)) {
            return false;
        }
        return true;
    }
}
