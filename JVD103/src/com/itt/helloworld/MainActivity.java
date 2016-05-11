package com.itt.helloworld;

import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	//1.宣告
	TextView T02;
	Button B01;
	EditText ED01;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//2.連結
		T02 = (TextView) this.findViewById(R.id.T02);
		B01 = (Button) this.findViewById(R.id.B01);
		ED01=(EditText) this.findViewById(R.id.ED01);
		//3.建立事件
		B01.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動產生的方法 Stub
				try {
					String S = "";
					int n=Integer.valueOf(ED01.getText().toString());
					int[] num = new int[n];
					for (int i = 0; i < num.length; i++) {
						num[i] = (int) (Math.random() * 999) + 1;
					}
					Arrays.sort(num);
					for (int tmp : num) {
						S+=tmp + "\t";
					}
					T02.setText(S);
					ED01.setText("");
				} catch (NumberFormatException e) {
					// TODO 自動產生的 catch 區塊
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
