package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class MediationAdRequest {

    /* renamed from: a */
    private AdRequest f582a;

    /* renamed from: b */
    private boolean f583b;

    /* renamed from: c */
    private boolean f584c;

    public MediationAdRequest(AdRequest request, Context context, boolean shareLocation) {
        this.f582a = request;
        this.f584c = shareLocation;
        if (context == null) {
            this.f583b = true;
        } else {
            this.f583b = request.isTestDevice(context);
        }
    }

    public AdRequest.Gender getGender() {
        return this.f582a.getGender();
    }

    public Date getBirthday() {
        return this.f582a.getBirthday();
    }

    public Integer getAgeInYears() {
        if (this.f582a.getBirthday() == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.f582a.getBirthday());
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        if (instance2.get(6) < instance.get(6)) {
            return Integer.valueOf(valueOf.intValue() - 1);
        }
        return valueOf;
    }

    public Set<String> getKeywords() {
        if (this.f582a.getKeywords() == null) {
            return null;
        }
        return Collections.unmodifiableSet(this.f582a.getKeywords());
    }

    public Location getLocation() {
        if (this.f582a.getLocation() == null || !this.f584c) {
            return null;
        }
        return new Location(this.f582a.getLocation());
    }

    public boolean isTesting() {
        return this.f583b;
    }
}
