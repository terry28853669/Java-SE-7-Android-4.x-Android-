package androidEx.ch15;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ch15_2_1Activity extends Activity {
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
//				AlertDialog.Builder builder = new AlertDialog.Builder(Ch15_2_1Activity.this);
//				builder.setTitle("關於"); // 標題文字
//				// 指定對話方塊訊息文字
//				builder.setMessage("版本: 1.0版\n作者: 陳會安");
//				// 設定按鈕和事件處理程序
//				builder.setPositiveButton("確定", null);
//				builder.show(); // 顯示對話方塊
				//匿名物件
				new AlertDialog.Builder(Ch15_2_1Activity.this)
				.setTitle("關於") // 標題文字
				// 指定對話方塊訊息文字
				.setMessage("版本: 1.0版\n作者: 陳會安")
				// 設定按鈕和事件處理程序
				.setPositiveButton("確定", null)
				.show(); // 顯示對話方塊
			}
		});

	}
}