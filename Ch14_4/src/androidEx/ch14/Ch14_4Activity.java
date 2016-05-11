package androidEx.ch14;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ch14_4Activity extends Activity {
	// 1.宣告物件
	static final int SET_RESULT = 1;
	EditText txtOpd1, txtOpd2;
	Button btn1;
	TextView output;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 2.連結元件
		txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
		txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
		btn1 = (Button) findViewById(R.id.button1);
		output = (TextView) findViewById(R.id.lblOutput);
		// 3.建立事件
		btn1.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				// TODO 自動產生的方法 Stub
				// 建立Intent物件
				Intent intent = new Intent(Ch14_4Activity.this, Operators.class);
				// 建立傳遞資料的Bundle物件
				Bundle bundle = new Bundle();
				bundle.putString("OPERAND01", txtOpd1.getText().toString());
				bundle.putString("OPERAND02", txtOpd2.getText().toString());
				intent.putExtras(bundle); // 加上資料
				// 啟動活動且有回傳資料
				startActivityForResult(intent, SET_RESULT);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case SET_RESULT:
			if (resultCode == RESULT_OK) {
				Bundle bundle = data.getExtras();
				output.setText("計算結果: " + bundle.getDouble("RESULT"));
			}
			break;
		}
	}
}