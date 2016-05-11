package androidEx.ch13;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Ch13_4_2Activity extends Activity {
	// 1.宣告物件
	Button btn1;
	EditText txtOpd1, txtOpd2;
	RadioButton rdb1, rdb2, rdb3, rdb4;
	CheckBox chk1;
	TextView output;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 2.連結元件
		btn1 = (Button) findViewById(R.id.button1);
		output = (TextView) findViewById(R.id.lblOutput);
		txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
		txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
		rdb1 = (RadioButton) this.findViewById(R.id.rdbAdd);
		rdb2 = (RadioButton) this.findViewById(R.id.rdbSubtract);
		rdb3 = (RadioButton) this.findViewById(R.id.rdbMultiply);
		rdb4 = (RadioButton) this.findViewById(R.id.rdbDivide);
		chk1 = (CheckBox) this.findViewById(R.id.chkDivide);
		output = (TextView) this.findViewById(R.id.lblOutput);
		// 3.建立事件
		btn1.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				// TODO 自動產生的方法 Stub
				double result = 0.0;
				double opd1, opd2;
				// 取得輸入值
				opd1 = Double.valueOf(txtOpd1.getText().toString());
				opd2 = Double.valueOf(txtOpd2.getText().toString());
				// 取得選取的運算子
				if (rdb1.isChecked()) {
					result = opd1 + opd2; // 加
				}
				if (rdb2.isChecked()) {
					result = opd1 - opd2; // 減
				}
				if (rdb3.isChecked()) {
					result = opd1 * opd2; // 乘
				}
				if (rdb4.isChecked()) {
					if (chk1.isChecked())
						result = opd1 / (int) opd2; // 整數除法
					else
						result = opd1 / opd2;
				}
				output.setText("計算結果 = " + result);
				result = 0.0;
			}
		});

	}
}