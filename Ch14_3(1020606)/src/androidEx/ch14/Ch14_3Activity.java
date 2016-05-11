package androidEx.ch14;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ch14_3Activity extends Activity {
	// 1.宣告物件
	EditText txtC;
	Button B01;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // 2.連結元件
    	txtC = (EditText) findViewById(R.id.txtC);
    	B01=(Button) this.findViewById(R.id.button1); 
    	// 3.建立事件
    	B01.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				// 建立Intent物件
				Intent intent = new Intent();
				// 建立傳遞資料的Bundle物件
				Bundle bundle = new Bundle();
				bundle.putString("TEMPC", txtC.getText().toString());
				intent.putExtras(bundle); // 加上資料
				intent.setClass(Ch14_3Activity.this, FActivity.class);
				startActivity(intent); // 啟動活動
			}});
    }
}