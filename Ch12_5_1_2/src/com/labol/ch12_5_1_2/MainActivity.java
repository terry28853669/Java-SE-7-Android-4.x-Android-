package com.labol.ch12_5_1_2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends Activity {
	//1.宣告物件
	EditText T01,T02;
	Button B01;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//2.連結元件
		T01=(EditText) this.findViewById(R.id.ED01); 
		T02=(EditText) this.findViewById(R.id.ED02);
		B01=(Button) this.findViewById(R.id.B01); 
		//3.建立事件
		B01.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO 自動產生的方法 Stub
				double c=Double.valueOf(T01.getText().toString());
				double f=c * 9 / 5 + 32 ;
				String S=String.valueOf(f);
				T02.setText(S);
				T01.setText("");
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
