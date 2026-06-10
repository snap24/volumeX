package com.zygisk_enc.volumeX;

import android.content.Context;
import android.media.AudioManager;
import android.service.quicksettings.TileService;

public class VolumeTileService extends TileService {

    @Override
    public void onClick() {
        super.onClick();
        
        // AudioManager is used to control system sounds
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        
        if (audioManager != null) {
            // This command "adjusts" the volume by 0 (ADJUST_SAME), 
            // but the FLAG_SHOW_UI forces the system volume panel to pop up.
            audioManager.adjustStreamVolume(
                AudioManager.STREAM_MUSIC, 
                AudioManager.ADJUST_SAME, 
                AudioManager.FLAG_SHOW_UI
            );
        }
        
        // Collapse the Quick Settings panel after clicking
        // (This might require the app to be in a certain state on some Android versions)
    }
}
