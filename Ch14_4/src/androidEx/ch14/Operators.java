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
	// 1.�ŧi����
	double result = 0.0;
	int opd1, opd2;
	RadioButton rdbAdd, rdbSubtract, rdbMultiply, rdbDivide;
	CheckBox chkDivide;
	Button B01;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.operators);
		// 2.�s������
		rdbAdd = (RadioButton) this.findViewById(R.id.rdbAdd);
		rdbSubtract = (RadioButton) this.findViewById(R.id.rdbSubtract);
		rdbMultiply = (RadioButton) this.findViewById(R.id.rdbMultiply);
		rdbDivide = (RadioButton) this.findViewById(R.id.rdbDivide);
		chkDivide = (CheckBox) this.findViewById(R.id.chkDivide);
		B01 = (Button) this.findViewById(R.id.button1);
		// 3.�إߨƥ�
		B01.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				// TODO �۰ʲ��ͪ���k Stub
				// ���o�ǻ������
				Bundle bundle = getIntent().getExtras();
				if (bundle == null)
					return;
				// ���o�B�⤸
				opd1 = Integer.parseInt(bundle.getString("OPERAND01"));
				opd2 = Integer.parseInt(bundle.getString("OPERAND02"));
				// ���o������B��l
				if (rdbAdd.isChecked()) {
					result = opd1 + opd2; // �[
				}
				if (rdbSubtract.isChecked()) {
					result = opd1 - opd2; // ��
				}
				if (rdbMultiply.isChecked()) {
					result = opd1 * opd2; // ��
				}
				if (rdbDivide.isChecked()) {
					if (chkDivide.isChecked())
						result = opd1 / opd2; // ��ư��k
					else
						result = opd1 / (double) opd2;
				}
				Intent rIntent = new Intent();
				// �إ߶Ǧ^��
				Bundle rbundle = new Bundle();
				rbundle.putDouble("RESULT", result);
				rIntent.putExtras(rbundle); // �[�W���
				setResult(RESULT_OK, rIntent); // �]�w�Ǧ^
				finish(); // ��������
			}
		});
	}
}
