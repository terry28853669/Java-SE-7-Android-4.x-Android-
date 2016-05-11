package COM.TQC.GDD01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class GDD01 extends Activity {
//1.宣告物件
	private EditText etheight;
	private EditText etweight;
	private RadioButton rb1;
	private RadioButton rb2;
	private Button b1;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		//2.連結物件
		b1 = (Button) findViewById(R.id.button1);
		
		etheight = (EditText) findViewById(R.id.height);
		etweight = (EditText) findViewById(R.id.weight);
		rb1 = (RadioButton) findViewById(R.id.male);
		rb2 = (RadioButton) findViewById(R.id.female);
		//3.建立事件
		b1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				//(1).取得身高並轉成Double可接受小數點				
				double height = Double.parseDouble(etheight.getText().toString()+"");
				//(2).取得體重並轉成Double可接受小數點				
				double weight = Double.parseDouble(etweight.getText().toString()+"");
				//(3).取得性別
				String Sex = "";				
				if (rb1.isChecked()) {
					Sex = "M";
				} else {
					Sex = "F";
				}
				//(4).切換ACTIVITY並將身高體重性別附加到Bundle中
				Intent intent = new Intent();
				intent.setClass(GDD01.this, GDD01_child.class);
				/* new一個Bundle物件，並將要傳遞的資料傳入 */
				Bundle b = new Bundle();
				b.putDouble("h", height);
				b.putDouble("w", weight);
				b.putString("Sex", Sex);
				/* 將Bundle物件assign給Intent */
				intent.putExtras(b);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (resultCode) {
		case RESULT_OK:

			Bundle bundle = data.getExtras();
			String Sex = bundle.getString("Sex");
			double height = bundle.getDouble("h");
			double weight = bundle.getDouble("w");

			etheight.setText("" + height);
			etweight.setText("" + weight);
			if (Sex.equals("M")) {
				rb1.setChecked(true);
			} else {
				rb2.setChecked(true);
			}
			break;
		default:
			break;
		}
	}
}