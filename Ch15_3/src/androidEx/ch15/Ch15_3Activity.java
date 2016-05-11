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
	// 1.�ŧi����
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
		// 2.�s������
		txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
		txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
		opSpin = (Spinner) findViewById(R.id.operators);
		chkDivide = (CheckBox) findViewById(R.id.chkDivide);
		btn1 = (Button) findViewById(R.id.button1);
		output = (TextView) findViewById(R.id.lblOutput);

		// �إ�ArrayAdapter���X������
		// �B��l��Spinner����
//		 ArrayAdapter<String> a = new ArrayAdapter<String>(this,
//		 android.R.layout.simple_spinner_item, operators);
//		 opSpin.setAdapter(a);
		// 3.�إߨƥ�
		opSpin.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO �۰ʲ��ͪ���k Stub
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
				// TODO �۰ʲ��ͪ���k Stub

			}
		});

		btn1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				// TODO �۰ʲ��ͪ���k Stub
				// ���o��J��
				opd1 = Integer.valueOf(txtOpd1.getText().toString());
				opd2 = Integer.parseInt(txtOpd2.getText().toString());
				// ���o������B��l
				// String op = opSpin.getSelectedItem().toString();
				if (op == "+") {
					result = opd1 + opd2; // �[
				} else if (op == "-") {
					result = opd1 - opd2; // ��
				} else if (op == "*") {
					result = opd1 * opd2; // ��
				} else if (op == "/") {

					if (chkDivide.isChecked())
						result = opd1 / opd2; // ��ư��k
					else
						result = opd1 / (double) opd2;
				}
				output.setText("�p�⵲�G = " + result);
			}
		});
	}
}