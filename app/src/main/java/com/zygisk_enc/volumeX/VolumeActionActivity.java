package com.zygisk_enc.volumeX;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;

public class VolumeActionActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.adjustStreamVolume(
                AudioManager.STREAM_MUSIC, 
                AudioManager.ADJUST_SAME, 
                AudioManager.FLAG_SHOW_UI
            );
        }
        
        finish();
        overridePendingTransition(0, 0);
    }
}
