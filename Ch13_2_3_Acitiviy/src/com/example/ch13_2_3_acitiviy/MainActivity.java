package com.example.ch13_2_3_acitiviy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	//1.宣告物件
	Button B01,B03;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//2.連結元件
		B01=(Button) this.findViewById(R.id.B01);
		B03=(Button) this.findViewById(R.id.B03);
		//3.建立事件
		B01.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動產生的方法 Stub
				finish();
			}});
		B03.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自動產生的方法 Stub
				Intent i =new Intent();
				i.setClass(MainActivity.this, Activity2.class);
				startActivity(i);
			}});
		Toast.makeText(getApplicationContext(), "onCreate", 3000).show();
	}

	@Override
	protected void onDestroy() {
		// TODO 自動產生的方法 Stub
		Toast.makeText(getApplicationContext(), "onDestroy", 3000).show();
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO 自動產生的方法 Stub
		Toast.makeText(getApplicationContext(), "onPause", 3000).show();
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO 自動產生的方法 Stub
		Toast.makeText(getApplicationContext(), "onRestart", 3000).show();
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO 自動產生的方法 Stub
		Toast.makeText(getApplicationContext(), "onResume", 3000).show();
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO 自動產生的方法 Stub
		Toast.makeText(getApplicationContext(), "onStart", 3000).show();
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO 自動產生的方法 Stub
		Toast.makeText(getApplicationContext(), "onStop", 3000).show();
		super.onStop();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
