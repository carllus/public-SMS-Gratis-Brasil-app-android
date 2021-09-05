package com.google.ads.searchads;

import android.content.Context;
import android.graphics.Color;
import com.google.ads.AdRequest;
import com.google.ads.mediation.admob.AdMobAdapterExtras;
import java.util.Locale;
import java.util.Map;

public class SearchAdRequest extends AdRequest {

    /* renamed from: a */
    private String f624a;

    /* renamed from: b */
    private int f625b;

    /* renamed from: c */
    private int f626c;

    /* renamed from: d */
    private int f627d;

    /* renamed from: e */
    private int f628e;

    /* renamed from: f */
    private int f629f;

    /* renamed from: g */
    private int f630g;

    /* renamed from: h */
    private String f631h;

    /* renamed from: i */
    private int f632i;

    /* renamed from: j */
    private int f633j;

    /* renamed from: k */
    private BorderType f634k;

    /* renamed from: l */
    private int f635l;

    /* renamed from: m */
    private String f636m;

    public enum BorderType {
        NONE("none"),
        DASHED("dashed"),
        DOTTED("dotted"),
        SOLID("solid");
        

        /* renamed from: a */
        private String f638a;

        private BorderType(String param) {
            this.f638a = param;
        }

        public String toString() {
            return this.f638a;
        }
    }

    public void setQuery(String query) {
        this.f624a = query;
    }

    public void setBackgroundColor(int backgroundColor) {
        if (Color.alpha(backgroundColor) == 255) {
            this.f625b = backgroundColor;
            this.f626c = 0;
            this.f627d = 0;
        }
    }

    public void setBackgroundGradient(int from, int to) {
        if (Color.alpha(from) == 255 && Color.alpha(to) == 255) {
            this.f625b = Color.argb(0, 0, 0, 0);
            this.f626c = from;
            this.f627d = to;
        }
    }

    public void setHeaderTextColor(int headerTextColor) {
        this.f628e = headerTextColor;
    }

    public void setDescriptionTextColor(int descriptionTextColor) {
        this.f629f = descriptionTextColor;
    }

    public void setAnchorTextColor(int anchorTextColor) {
        this.f630g = anchorTextColor;
    }

    public void setFontFace(String fontFace) {
        this.f631h = fontFace;
    }

    public void setHeaderTextSize(int headerTextSize) {
        this.f632i = headerTextSize;
    }

    public void setBorderColor(int borderColor) {
        this.f633j = borderColor;
    }

    public void setBorderType(BorderType borderType) {
        this.f634k = borderType;
    }

    public void setBorderThickness(int borderThickness) {
        this.f635l = borderThickness;
    }

    public void setCustomChannels(String channelIds) {
        this.f636m = channelIds;
    }

    public Map<String, Object> getRequestMap(Context context) {
        AdMobAdapterExtras adMobAdapterExtras = (AdMobAdapterExtras) getNetworkExtras(AdMobAdapterExtras.class);
        if (adMobAdapterExtras == null) {
            adMobAdapterExtras = new AdMobAdapterExtras();
            setNetworkExtras(adMobAdapterExtras);
        }
        if (this.f624a != null) {
            adMobAdapterExtras.getExtras().put("q", this.f624a);
        }
        if (Color.alpha(this.f625b) != 0) {
            adMobAdapterExtras.getExtras().put("bgcolor", m451a(this.f625b));
        }
        if (Color.alpha(this.f626c) == 255 && Color.alpha(this.f627d) == 255) {
            adMobAdapterExtras.getExtras().put("gradientfrom", m451a(this.f626c));
            adMobAdapterExtras.getExtras().put("gradientto", m451a(this.f627d));
        }
        if (Color.alpha(this.f628e) != 0) {
            adMobAdapterExtras.getExtras().put("hcolor", m451a(this.f628e));
        }
        if (Color.alpha(this.f629f) != 0) {
            adMobAdapterExtras.getExtras().put("dcolor", m451a(this.f629f));
        }
        if (Color.alpha(this.f630g) != 0) {
            adMobAdapterExtras.getExtras().put("acolor", m451a(this.f630g));
        }
        if (this.f631h != null) {
            adMobAdapterExtras.getExtras().put("font", this.f631h);
        }
        adMobAdapterExtras.getExtras().put("headersize", Integer.toString(this.f632i));
        if (Color.alpha(this.f633j) != 0) {
            adMobAdapterExtras.getExtras().put("bcolor", m451a(this.f633j));
        }
        if (this.f634k != null) {
            adMobAdapterExtras.getExtras().put("btype", this.f634k.toString());
        }
        adMobAdapterExtras.getExtras().put("bthick", Integer.toString(this.f635l));
        if (this.f636m != null) {
            adMobAdapterExtras.getExtras().put("channel", this.f636m);
        }
        return super.getRequestMap(context);
    }

    /* renamed from: a */
    private String m451a(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }
}
