package com.example.kalimba;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.res.TypedArray;

public class KalimbaActivity extends Activity implements OnClickListener {

	MediaPlayer[] mp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalimba);
        
        TypedArray notes = getResources().obtainTypedArray(R.array.notes);
        TypedArray buttons = getResources().obtainTypedArray(R.array.buttons);
        mp = new MediaPlayer[notes.length()];
        
        for (int i = 0;i < notes.length();i++) {
        	mp[i] = MediaPlayer.create(this, notes.getResourceId(i, -1));
        }
        
        for (int i = 0;i < buttons.length();i++) {
        	findViewById(buttons.getResourceId(i, -1)).setOnClickListener(this);
        }
    }

	@Override
	public void onClick(View view) {
		// TODO 自動生成されたメソッド・スタブ
		TypedArray buttons = getResources().obtainTypedArray(R.array.buttons);
		
		for (int i = 0;i < buttons.length();i++) {
			if (buttons.getResourceId(i, -1) == view.getId()) {
				mp[i].seekTo(0);
				mp[i].start();
				break;
			}
		}
	}
   
}
