package com.kuwapp.materialdesignanimationsample;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupCircularReveal();
        setupSharedElement();
    }

    private void setupCircularReveal() {
        ViewGroup parent = (ViewGroup) findViewById(R.id.circular_reveal);
        if (parent.getChildCount() != Image.values().length) {
            throw new RuntimeException();
        }
        for (Image image : Image.values()) {
            ImageView imageView = (ImageView) parent.getChildAt(image.getIndex());
            imageView.setOnClickListener(view -> executeCircularRevealAnimation(image.getResId()));
        }
    }

    private void executeCircularRevealAnimation(@DrawableRes int imageResId) {
        ImageView target = (ImageView) findViewById(R.id.main_image);
        target.setImageResource(imageResId);
        int centerX = target.getWidth() / 2;
        int centerY = target.getHeight() / 2;
        int endRadius = Math.max(target.getWidth(), target.getHeight());
        ViewAnimationUtils.createCircularReveal(target, centerX, centerY, 0, endRadius)
                .start();
    }

    private void setupSharedElement() {
        ViewGroup parent = (ViewGroup) findViewById(R.id.shared_element);
        if (parent.getChildCount() != Image.values().length) {
            throw new RuntimeException();
        }
        for (Image image : Image.values()) {
            ImageView imageView = (ImageView) parent.getChildAt(image.getIndex());
            imageView.setOnClickListener(view -> DetailActivity.startActivity(this, image, view));
        }
    }

}
