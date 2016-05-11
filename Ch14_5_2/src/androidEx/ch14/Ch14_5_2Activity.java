package androidEx.ch14;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ch14_5_2Activity extends Activity {
	// 1.宣告物件
	Button btn1, btn2, btn3, btn4;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 2.連結元件
		btn1 = (Button) this.findViewById(R.id.btn1);
		btn2 = (Button) this.findViewById(R.id.btn2);
		btn3 = (Button) this.findViewById(R.id.btn3);
		btn4 = (Button) this.findViewById(R.id.btn4);
		// 3.建立事件
		btn1.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				// TODO 自動產生的方法 Stub
				Intent i = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.google.com.tw"));
				startActivity(i);
			}
		});
		btn2.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				// TODO 自動產生的方法 Stub
				Intent i = new Intent(Intent.ACTION_VIEW, Uri
						.parse("geo:25.062218,121.450764"));
				startActivity(i);
			}
		});
		btn3.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				// TODO 自動產生的方法 Stub
				Intent i = new Intent(Intent.ACTION_DIAL, Uri
						.parse("tel:+1234567"));
				startActivity(i);
			}
		});
		btn4.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				// TODO 自動產生的方法 Stub

				Intent i = new Intent(Intent.ACTION_SENDTO, Uri
						.parse("mailto:hueyan@ms2.hinet.net"));
				startActivity(i);
			}
		});
	}
}