package com.example.ch13_2_3_acitiviy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity2 extends Activity {
	// 1.宣告物件
	Button B02;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動產生的方法 Stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.page2);
		// 2.連結元件
		B02 = (Button) this.findViewById(R.id.B02);
		// 3.建立事件
		B02.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動產生的方法 Stub
				finish();
			}
		});
		Toast.makeText(getApplicationContext(), "onCreate(2)", 3000).show();
	}

	@Override
	protected void onDestroy() {
		// TODO 自動產生的方法 Stub
		Toast.makeText(getApplicationContext(), "onDestroy(2)", 3000).show();
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO 自動產生的方法 Stub
		Toast.makeText(getApplicationContext(), "onPause(2)", 3000).show();
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO 自動產生的方法 Stub
		Toast.makeText(getApplicationContext(), "onResume(2)", 3000).show();
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO 自動產生的方法 Stub
		Toast.makeText(getApplicationContext(), "onStart(2)", 3000).show();
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO 自動產生的方法 Stub
		Toast.makeText(getApplicationContext(), "onStop(2)", 3000).show();
		super.onStop();
	}

}
