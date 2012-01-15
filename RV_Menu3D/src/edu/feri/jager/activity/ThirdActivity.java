package edu.feri.jager.activity;

import edu.feri.jager.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TextView textView = (TextView) findViewById(R.id.textViewMain);
		textView.setText("Hello World! Tretja Aplikacija!");
	}
}