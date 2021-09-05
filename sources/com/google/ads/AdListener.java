package com.google.ads;

import com.google.ads.AdRequest;

public interface AdListener {
    void onDismissScreen(C0342Ad ad);

    void onFailedToReceiveAd(C0342Ad ad, AdRequest.ErrorCode errorCode);

    void onLeaveApplication(C0342Ad ad);

    void onPresentScreen(C0342Ad ad);

    void onReceiveAd(C0342Ad ad);
}
