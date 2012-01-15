package edu.feri.jager.menu3d;

import edu.feri.jager.activity.SecondActivity;
import edu.feri.jager.activity.ThirdActivity;
import edu.feri.jager.kocka3d.Kocka3DActivity;
import android.content.Context;
import android.content.Intent;

public class ActivityClass {

	private Context context;

	public ActivityClass(Context context) {
		this.setContext(context);	
	}

	public void startKocka3DActivity() {
        context.startActivity(new Intent(context, Kocka3DActivity.class));
	}
	
	public void start2Activity() {
        context.startActivity(new Intent(context, SecondActivity.class));
	}
	
	public void start3Activity() {
        context.startActivity(new Intent(context, ThirdActivity.class));
	}
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
}
