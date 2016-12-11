package com.kuwapp.materialdesignanimationsample;

import android.support.annotation.DrawableRes;

enum Image {
    Ice(0, R.drawable.image0),
    Bird(1, R.drawable.image1),
    Natural(2, R.drawable.image2),
    StarrySky(3, R.drawable.image3);

    private final int index;
    private
    @DrawableRes
    final int resId;

    Image(int index, @DrawableRes int resId) {
        this.index = index;
        this.resId = resId;
    }

    public int getIndex() {
        return index;
    }

    public int getResId() {
        return resId;
    }

}