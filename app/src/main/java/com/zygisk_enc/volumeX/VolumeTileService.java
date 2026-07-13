package com.zygisk_enc.volumeX;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.service.quicksettings.TileService;

public class VolumeTileService extends TileService {

    @Override
    public void onClick() {
        super.onClick();
        
        if (android.os.Build.VERSION.SDK_INT >= 37) { // Android 17+
            Intent intent = new Intent(this, VolumeActionActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            
            PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
            );
            
            startActivityAndCollapse(pendingIntent);
        } else {
            // Below Android 17: direct adjustment
            AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            if (audioManager != null) {
                audioManager.adjustStreamVolume(
                    AudioManager.STREAM_MUSIC, 
                    AudioManager.ADJUST_SAME, 
                    AudioManager.FLAG_SHOW_UI
                );
            }
        }
    }
}
