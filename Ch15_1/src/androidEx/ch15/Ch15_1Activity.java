package androidEx.ch15;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Ch15_1Activity extends Activity {
	// 1.宣告物件
	TextView output;
	EditText txtTemp; 
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // 取得TextView元件
     // 2.連結元件
        output = (TextView) findViewById(R.id.lblOutput);
        txtTemp = (EditText) findViewById(R.id.txtTemp);
    }
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int tmp;
		double result;    	
      	// 取得輸入值
    	tmp = Integer.valueOf(txtTemp.getText().toString());
	    switch(item.getItemId()) { 
	    case R.id.toF: 
	    	// 攝氏轉華氏的公式
	    	result = (9.0 * tmp) / 5.0 + 32.0;
	    	output.setText("華氏溫度: " + result);
	        break; 
	    case R.id.toC:
	    	// 華氏轉攝氏的公式
	    	result = (5.0 / 9.0 ) * (tmp - 32);
	    	output.setText("攝氏溫度: " + result);
	        break; 
	    } 
	    return super.onOptionsItemSelected(item);
	}
}