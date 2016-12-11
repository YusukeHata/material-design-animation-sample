package com.kuwapp.materialdesignanimationsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String KEY_IMAGE = "key_image";

    public static void startActivity(AppCompatActivity activity, Image image, View sharedElement) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(KEY_IMAGE, image);
        Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, sharedElement, activity.getString(R.string.transition_image))
                .toBundle();
        activity.startActivity(intent, bundle);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Image image = (Image) getIntent().getSerializableExtra(KEY_IMAGE);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(image.getResId());
        TextView textView = (TextView) findViewById(R.id.name);
        textView.setText(image.toString());
    }

}
