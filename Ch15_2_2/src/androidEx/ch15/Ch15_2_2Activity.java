package androidEx.ch15;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ch15_2_2Activity extends Activity {
	// 1.宣告物件
	Button btn1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     // 2.連結元件
        btn1 = (Button) this.findViewById(R.id.button1);
		// 3.建立事件
        btn1.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				// TODO 自動產生的方法 Stub
				new AlertDialog.Builder(Ch15_2_2Activity.this) 
		        .setTitle("確認")
		          .setMessage("確認結束本程式?")
		          .setPositiveButton("確定", new DialogInterface.OnClickListener(){

					public void onClick(DialogInterface arg0, int arg1) {
						// TODO 自動產生的方法 Stub
						finish();
					}})
					.setNeutralButton("不確定", new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface dialog, int which) {
							// TODO 自動產生的方法 Stub
							Toast.makeText(getApplicationContext(), "您按下不確定", 3000).show();
						}})
		          .setNegativeButton("取消", null) 
		          .show();
			}
		});
    }
}