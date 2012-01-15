package edu.feri.jager.kocka3d;

import com.badlogic.gdx.backends.android.AndroidApplication;

import android.os.Bundle;

public class Kocka3DActivity extends AndroidApplication {
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new Kocka3D(), false);               
    }
}