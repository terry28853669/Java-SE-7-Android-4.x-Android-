package androidEx.ch15;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Ch15_3Activity extends Activity {
	// 1.宣告物件
	EditText txtOpd1, txtOpd2;
	Spinner opSpin;
	CheckBox chkDivide;
	Button btn1;
	TextView output;
	int opd1, opd2;
	double result = 0.0;
	String op = "";

//	String[] operators = { "+", "-", "*", "/" };
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 2.連結元件
		txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
		txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
		opSpin = (Spinner) findViewById(R.id.operators);
		chkDivide = (CheckBox) findViewById(R.id.chkDivide);
		btn1 = (Button) findViewById(R.id.button1);
		output = (TextView) findViewById(R.id.lblOutput);

		// 建立ArrayAdapter接合器物件
		// 運算子的Spinner元件
//		 ArrayAdapter<String> a = new ArrayAdapter<String>(this,
//		 android.R.layout.simple_spinner_item, operators);
//		 opSpin.setAdapter(a);
		// 3.建立事件
		opSpin.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO 自動產生的方法 Stub
				if (arg2 == 0) {
					op = "+";
				} else if (arg2 == 1) {
					op = "-";
				} else if (arg2 == 2) {
					op = "*";
				} else {
					op = "/";
				}
			}
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO 自動產生的方法 Stub

			}
		});

		btn1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				// TODO 自動產生的方法 Stub
				// 取得輸入值
				opd1 = Integer.valueOf(txtOpd1.getText().toString());
				opd2 = Integer.parseInt(txtOpd2.getText().toString());
				// 取得選取的運算子
				// String op = opSpin.getSelectedItem().toString();
				if (op == "+") {
					result = opd1 + opd2; // 加
				} else if (op == "-") {
					result = opd1 - opd2; // 減
				} else if (op == "*") {
					result = opd1 * opd2; // 乘
				} else if (op == "/") {

					if (chkDivide.isChecked())
						result = opd1 / opd2; // 整數除法
					else
						result = opd1 / (double) opd2;
				}
				output.setText("計算結果 = " + result);
			}
		});
	}
}