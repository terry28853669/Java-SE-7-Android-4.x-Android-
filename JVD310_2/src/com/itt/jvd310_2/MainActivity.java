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
	// 1.�ŧi����
	EditText ED01, ED02, ED03;
	Button B01;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 2.�s������
		ED01 = (EditText) this.findViewById(R.id.ED01);
		ED02 = (EditText) this.findViewById(R.id.ED01);
		ED03 = (EditText) this.findViewById(R.id.ED01);
		B01 = (Button) this.findViewById(R.id.B01);
		// 3.�إߨƥ�
		B01.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO �۰ʲ��ͪ���k Stub
				int yearNow, monthNow, dayNow;
				int year, month, day, result = 0;
				// �D�o�ثe�t�Τ��
				Calendar cal = Calendar.getInstance(); //
				// �D�o�ثe�t�Ϊ��褸�~
				yearNow = cal.get(Calendar.YEAR);//
				// �D�o�ثe�t�Ϊ����(�@��|�^��0,�G�[1��~�O�u�������)
				monthNow = cal.get(Calendar.MONTH) + 1;//
				// �D�o�ثe�t�Ϊ����
				dayNow = cal.get(Calendar.DAY_OF_MONTH);//

				// String[] d = new String[3];
				// String S = JOptionPane.showInputDialog("�п�J�X�ͦ~���!");
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

				// JOptionPane.showMessageDialog(null,"�z�{�b��ڪ��~�֬�" +
				// String.valueOf(result) + "��", "�p��~��", 2);
//				Toast.makeText(getApplicationContext(),
//						"�z�{�b��ڪ��~�֬�" + String.valueOf(result) + "��", 3000)
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
				.setPositiveButton("�T�w",null)
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
