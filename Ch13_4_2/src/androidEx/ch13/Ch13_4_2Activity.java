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
	private TextView output;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // ���oButton����
        Button btn1 = (Button) findViewById(R.id.button1);
        // ���UButton����ť�̪���
        btn1.setOnClickListener(btn1Listener);
        // ���oTextView����
        output = (TextView) findViewById(R.id.lblOutput);
    }
    View.OnClickListener btn1Listener = new View.OnClickListener() {
        public void onClick(View v) {
           int opd1, opd2;
           double result = 0.0;
           EditText txtOpd1, txtOpd2;
           RadioButton rdbAdd, rdbSubtract, 
               rdbMultiply, rdbDivide;
           CheckBox chkDivide;
           // ���oEditText����
       	   txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
       	   txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
           // ���o��J��
       	   opd1 = Integer.parseInt(txtOpd1.getText().toString());
       	   opd2 = Integer.parseInt(txtOpd2.getText().toString());
           // ���o������B��l
           rdbAdd = (RadioButton) findViewById(R.id.rdbAdd);
           if (rdbAdd.isChecked()) {
        	   result = opd1 + opd2; // �[
           }
           rdbSubtract = (RadioButton) findViewById(R.id.rdbSubtract);
           if (rdbSubtract.isChecked()) {
        	   result = opd1 - opd2;  // ��
           }
           rdbMultiply = (RadioButton) findViewById(R.id.rdbMultiply);
           if (rdbMultiply.isChecked()) {
        	   result = opd1 * opd2;  // ��
           }
           rdbDivide = (RadioButton) findViewById(R.id.rdbDivide);
           chkDivide = (CheckBox) findViewById(R.id.chkDivide);
           if (rdbDivide.isChecked()) {
        	   if (chkDivide.isChecked()) 
        	      result = opd1 / opd2;  // ��ư��k
        	   else
        		  result = opd1 / (double) opd2;         		   
           }
           output.setText("�p�⵲�G = " + result);
        }
    };
}