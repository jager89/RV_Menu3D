package edu.feri.jager.menu3d;

import com.badlogic.gdx.backends.android.AndroidApplication;

import android.os.Bundle;

public class Menu3DActivity extends AndroidApplication {
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityClass activityClass = new ActivityClass(this);
        initialize(new Meni3D(activityClass), false); 
    }
}