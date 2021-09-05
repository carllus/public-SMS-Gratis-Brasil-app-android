package com.google.ads.internal;

import android.app.Activity;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.ads.C0442m;
import com.google.ads.util.C0461b;
import java.lang.ref.WeakReference;

public class AdVideoView extends FrameLayout implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {

    /* renamed from: b */
    private static final C0409a f407b = C0409a.f423a.mo7106b();

    /* renamed from: a */
    public MediaController f408a = null;

    /* renamed from: c */
    private final WeakReference<Activity> f409c;

    /* renamed from: d */
    private final AdWebView f410d;

    /* renamed from: e */
    private long f411e = 0;

    /* renamed from: f */
    private final VideoView f412f;

    /* renamed from: g */
    private String f413g = null;

    /* renamed from: com.google.ads.internal.AdVideoView$a */
    private static class C0406a implements Runnable {

        /* renamed from: a */
        private final WeakReference<AdVideoView> f414a;

        public C0406a(AdVideoView adVideoView) {
            this.f414a = new WeakReference<>(adVideoView);
        }

        public void run() {
            AdVideoView adVideoView = (AdVideoView) this.f414a.get();
            if (adVideoView == null) {
                C0461b.m506d("The video must be gone, so cancelling the timeupdate task.");
                return;
            }
            adVideoView.mo7068f();
            C0442m.m429a().f566c.mo7347a().postDelayed(this, 250);
        }

        /* renamed from: a */
        public void mo7074a() {
            C0442m.m429a().f566c.mo7347a().postDelayed(this, 250);
        }
    }

    public AdVideoView(Activity adActivity, AdWebView adWebView) {
        super(adActivity);
        this.f409c = new WeakReference<>(adActivity);
        this.f410d = adWebView;
        this.f412f = new VideoView(adActivity);
        addView(this.f412f, new FrameLayout.LayoutParams(-1, -1, 17));
        mo7061a();
        this.f412f.setOnCompletionListener(this);
        this.f412f.setOnPreparedListener(this);
        this.f412f.setOnErrorListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7061a() {
        new C0406a(this).mo7074a();
    }

    /* renamed from: b */
    public void mo7064b() {
        if (!TextUtils.isEmpty(this.f413g)) {
            this.f412f.setVideoPath(this.f413g);
        } else {
            f407b.mo7098a(this.f410d, "onVideoEvent", "{'event': 'error', 'what': 'no_src'}");
        }
    }

    public void setMediaControllerEnabled(boolean enabled) {
        Activity activity = (Activity) this.f409c.get();
        if (activity == null) {
            C0461b.m508e("adActivity was null while trying to enable controls on a video.");
        } else if (enabled) {
            if (this.f408a == null) {
                this.f408a = new MediaController(activity);
            }
            this.f412f.setMediaController(this.f408a);
        } else {
            if (this.f408a != null) {
                this.f408a.hide();
            }
            this.f412f.setMediaController((MediaController) null);
        }
    }

    public void setSrc(String src) {
        this.f413g = src;
    }

    public void onCompletion(MediaPlayer mp) {
        f407b.mo7098a(this.f410d, "onVideoEvent", "{'event': 'ended'}");
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        C0461b.m508e("Video threw error! <what:" + what + ", extra:" + extra + ">");
        f407b.mo7098a(this.f410d, "onVideoEvent", "{'event': 'error', 'what': '" + what + "', 'extra': '" + extra + "'}");
        return true;
    }

    public void onPrepared(MediaPlayer mp) {
        f407b.mo7098a(this.f410d, "onVideoEvent", "{'event': 'canplaythrough', 'duration': '" + (((float) this.f412f.getDuration()) / 1000.0f) + "'}");
    }

    /* renamed from: c */
    public void mo7065c() {
        this.f412f.pause();
    }

    /* renamed from: d */
    public void mo7066d() {
        this.f412f.start();
    }

    /* renamed from: a */
    public void mo7062a(int i) {
        this.f412f.seekTo(i);
    }

    /* renamed from: a */
    public void mo7063a(MotionEvent motionEvent) {
        this.f412f.onTouchEvent(motionEvent);
    }

    /* renamed from: e */
    public void mo7067e() {
        this.f412f.stopPlayback();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo7068f() {
        long currentPosition = (long) this.f412f.getCurrentPosition();
        if (this.f411e != currentPosition) {
            f407b.mo7098a(this.f410d, "onVideoEvent", "{'event': 'timeupdate', 'time': " + (((float) currentPosition) / 1000.0f) + "}");
            this.f411e = currentPosition;
        }
    }
}
