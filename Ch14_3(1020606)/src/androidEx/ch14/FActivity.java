package androidEx.ch14;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class FActivity extends Activity {
	// 1.宣告物件
	TextView o;
	Button B02;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.f);
		// 2.連結元件
		o=(TextView) this.findViewById(R.id.lblOutput);
		B02=(Button) this.findViewById(R.id.button1);
		int c;
		double f = 0.0;
		// 取得傳遞的資料
		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
		   c = Integer.valueOf(bundle.getString("TEMPC"));
		   // 攝氏轉華氏的公式
		   f = (9.0 * c) / 5.0 + 32.0;
		   // 顯示華氏溫度
		   o = (TextView) findViewById(R.id.lblOutput);
		   o.setText("華氏溫度: " + Double.toString(f));
		   // 3.建立事件
		   B02.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				// TODO 自動產生的方法 Stub
				finish();
			}});
		}
	}
}
