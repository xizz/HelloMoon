package xizz.hellomoon;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;


public class HelloMoonActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_moon);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_hello_moon, menu);
		return true;
	}
}
