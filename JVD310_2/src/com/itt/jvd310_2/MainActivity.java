package com.itt.jvd310_2;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	// 1.宣告物件
	EditText ED01, ED02, ED03;
	Button B01;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 2.連結元件
		ED01 = (EditText) this.findViewById(R.id.ED01);
		ED02 = (EditText) this.findViewById(R.id.ED01);
		ED03 = (EditText) this.findViewById(R.id.ED01);
		B01 = (Button) this.findViewById(R.id.B01);
		// 3.建立事件
		B01.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動產生的方法 Stub
				int yearNow, monthNow, dayNow;
				int year, month, day, result = 0;
				// 求得目前系統日期
				Calendar cal = Calendar.getInstance(); //
				// 求得目前系統的西元年
				yearNow = cal.get(Calendar.YEAR);//
				// 求得目前系統的月份(一月會回傳0,故加1後才是真正的月份)
				monthNow = cal.get(Calendar.MONTH) + 1;//
				// 求得目前系統的日期
				dayNow = cal.get(Calendar.DAY_OF_MONTH);//

				// String[] d = new String[3];
				// String S = JOptionPane.showInputDialog("請輸入出生年月日!");
				// d = S.split("/");

				year = Integer.parseInt(ED01.getText().toString());
				month = Integer.parseInt(ED02.getText().toString());
				day = Integer.parseInt(ED03.getText().toString());

				if (monthNow >= month) {
					if (dayNow >= day) {
						result = yearNow - year;
					} else {
						result = yearNow - year - 1;
					}
				} else {
					result = yearNow - year - 1;
				}

				// JOptionPane.showMessageDialog(null,"您現在實際的年齡為" +
				// String.valueOf(result) + "歲", "計算年齡", 2);
//				Toast.makeText(getApplicationContext(),
//						"您現在實際的年齡為" + String.valueOf(result) + "歲", 3000)
//						.show();
//				Toast.makeText(getApplicationContext(),getString(R.string.str6) + String.valueOf(result) + getString(R.string.str7), 3000)
//						.show();
//				Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.str6) + 
//						String.valueOf(result) + getString(R.string.str7), 3000);
//				toast.setGravity(Gravity.CENTER, 100,100);
//										toast.show();
				new AlertDialog.Builder(MainActivity.this)
				.setTitle(getString(R.string.app_name))
				.setMessage(getString(R.string.str6) + String.valueOf(result) + getString(R.string.str7))
				.setPositiveButton("確定",null)
				.show();
				
				
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
