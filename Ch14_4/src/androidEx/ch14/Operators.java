package androidEx.ch14;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Operators extends Activity {
	// 1.宣告物件
	double result = 0.0;
	int opd1, opd2;
	RadioButton rdbAdd, rdbSubtract, rdbMultiply, rdbDivide;
	CheckBox chkDivide;
	Button B01;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.operators);
		// 2.連結元件
		rdbAdd = (RadioButton) this.findViewById(R.id.rdbAdd);
		rdbSubtract = (RadioButton) this.findViewById(R.id.rdbSubtract);
		rdbMultiply = (RadioButton) this.findViewById(R.id.rdbMultiply);
		rdbDivide = (RadioButton) this.findViewById(R.id.rdbDivide);
		chkDivide = (CheckBox) this.findViewById(R.id.chkDivide);
		B01 = (Button) this.findViewById(R.id.button1);
		// 3.建立事件
		B01.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				// TODO 自動產生的方法 Stub
				// 取得傳遞的資料
				Bundle bundle = getIntent().getExtras();
				if (bundle == null)
					return;
				// 取得運算元
				opd1 = Integer.parseInt(bundle.getString("OPERAND01"));
				opd2 = Integer.parseInt(bundle.getString("OPERAND02"));
				// 取得選取的運算子
				if (rdbAdd.isChecked()) {
					result = opd1 + opd2; // 加
				}
				if (rdbSubtract.isChecked()) {
					result = opd1 - opd2; // 減
				}
				if (rdbMultiply.isChecked()) {
					result = opd1 * opd2; // 乘
				}
				if (rdbDivide.isChecked()) {
					if (chkDivide.isChecked())
						result = opd1 / opd2; // 整數除法
					else
						result = opd1 / (double) opd2;
				}
				Intent rIntent = new Intent();
				// 建立傳回值
				Bundle rbundle = new Bundle();
				rbundle.putDouble("RESULT", result);
				rIntent.putExtras(rbundle); // 加上資料
				setResult(RESULT_OK, rIntent); // 設定傳回
				finish(); // 結束活動
			}
		});
	}
}
