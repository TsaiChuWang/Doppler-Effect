package com.example.doppler_effect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

//import androidx.webkit.WebViewAssetLoader;

public class Teach_Activity extends AppCompatActivity {
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach);

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        //YouTubePlayerTracker tracker = new YouTubePlayerTracker();
        //youTubePlayerView.addListener(tracker);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady (@NonNull YouTubePlayer youTubePlayer){
                String videoId = "E1aviRwBIys";//kwgQX809kH8
                youTubePlayer.loadVideo(videoId, 0);
            }});

        youTubePlayerView.getYouTubePlayerWhenReady(youTubePlayer -> {

        });
    }

    public void hitoryintro_button_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(Teach_Activity.this,History_Activity.class);
        startActivity(intent);
    }

    public void formulaintro_button_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(Teach_Activity.this,Formula_Activity.class);
        startActivity(intent);
    }

    public void relativemotiointro_button_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(Teach_Activity.this,Relative_Motion_Activity.class);
        startActivity(intent);
    }

    public void wavecirclestillintro_button_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(Teach_Activity.this,waveSource_static_Activity.class);
        startActivity(intent);
    }

    public void observerstillintro_button_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(Teach_Activity.this,observer_static_Activity.class);
        startActivity(intent);
    }
}