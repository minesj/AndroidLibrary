package com.example.qqz.imagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.gif.GifDrawable;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startButton,startButton2;
    private ImageView showImageView,showGifImageView;
    private String imageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addListenenr();
    }

    private void initView() {
        startButton = findViewById(R.id.start);
        showImageView = findViewById(R.id.imageview);
        startButton2 =findViewById(R.id.start1);
        showGifImageView = findViewById(R.id.imageview1);
    }

    private void addListenenr() {
        startButton.setOnClickListener(this);
        startButton2.setOnClickListener(this);

    }

    /**
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.start) {
            imageUrl = "https://www.baidu.com/img/bdlogo.png";
            Glide.with(MainActivity.this)
                    .load(imageUrl)
                    .into(showImageView);
        }

        if (id == R.id.start1) {
            imageUrl = "https://qq.yh31.com/tp/zjbq/201810281602569026.gif";

           /* Glide.with(MainActivity.this)
                    .load(imageUrl)
                    .into(showGifImageView);*/

    /*        RequestBuilder<GifDrawable> requestBuilder = Glide.with(this).asGif();
            requestBuilder.load(imageUrl);
            requestBuilder.into(showGifImageView);*/

            //过度选项,
            Glide.with(this)
                    .load(imageUrl)
                    .transition(withCrossFade())
                    .into(showGifImageView);


        }
    }
}
