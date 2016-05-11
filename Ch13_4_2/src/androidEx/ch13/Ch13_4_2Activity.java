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
        // 取得Button元件
        Button btn1 = (Button) findViewById(R.id.button1);
        // 註冊Button的傾聽者物件
        btn1.setOnClickListener(btn1Listener);
        // 取得TextView元件
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
           // 取得EditText元件
       	   txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
       	   txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
           // 取得輸入值
       	   opd1 = Integer.parseInt(txtOpd1.getText().toString());
       	   opd2 = Integer.parseInt(txtOpd2.getText().toString());
           // 取得選取的運算子
           rdbAdd = (RadioButton) findViewById(R.id.rdbAdd);
           if (rdbAdd.isChecked()) {
        	   result = opd1 + opd2; // 加
           }
           rdbSubtract = (RadioButton) findViewById(R.id.rdbSubtract);
           if (rdbSubtract.isChecked()) {
        	   result = opd1 - opd2;  // 減
           }
           rdbMultiply = (RadioButton) findViewById(R.id.rdbMultiply);
           if (rdbMultiply.isChecked()) {
        	   result = opd1 * opd2;  // 乘
           }
           rdbDivide = (RadioButton) findViewById(R.id.rdbDivide);
           chkDivide = (CheckBox) findViewById(R.id.chkDivide);
           if (rdbDivide.isChecked()) {
        	   if (chkDivide.isChecked()) 
        	      result = opd1 / opd2;  // 整數除法
        	   else
        		  result = opd1 / (double) opd2;         		   
           }
           output.setText("計算結果 = " + result);
        }
    };
}