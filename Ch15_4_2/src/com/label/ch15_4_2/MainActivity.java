package com.label.ch15_4_2;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends Activity {
	// 1.宣告
	ListView LV01;
	Spinner sp01;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 2.連結
		LV01 = (ListView) this.findViewById(R.id.LV01);
		sp01 = (Spinner) this.findViewById(R.id.sp01);
		// 3.事件
		LV01.setOnItemClickListener(new ListView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO 自動產生的方法 Stub
				String links[] = getResources().getStringArray(
						R.array.portal_urls1);
				Intent i = new Intent(Intent.ACTION_VIEW, Uri
						.parse(links[arg2]));
				startActivity(i);
			}
		});
		sp01.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO 自動產生的方法 Stub
				if (arg2 == 0) {
					ArrayAdapter<CharSequence> a = ArrayAdapter
							.createFromResource(getApplicationContext(),
									R.array.portal_sites1,
									android.R.layout.simple_list_item_1);
					LV01.setAdapter(a);
				} // 指定接合器物件
				else if (arg2 == 1) {
					ArrayAdapter<CharSequence> a = ArrayAdapter
							.createFromResource(getApplicationContext(),
									R.array.portal_sites2,
									android.R.layout.simple_list_item_1);
					LV01.setAdapter(a);
				} else if (arg2 == 2) {
					ArrayAdapter<CharSequence> a = ArrayAdapter
							.createFromResource(getApplicationContext(),
									R.array.portal_sites3,
									android.R.layout.simple_list_item_1);
					LV01.setAdapter(a);
				} else if (arg2 == 3) {
					ArrayAdapter<CharSequence> a = ArrayAdapter
							.createFromResource(getApplicationContext(),
									R.array.portal_sites4,
									android.R.layout.simple_list_item_1);
					LV01.setAdapter(a);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO 自動產生的方法 Stub

			}
		});

	}
}