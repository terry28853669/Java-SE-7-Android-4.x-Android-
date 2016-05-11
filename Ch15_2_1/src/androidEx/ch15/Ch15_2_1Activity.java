package androidEx.ch15;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ch15_2_1Activity extends Activity {
	// 1.�ŧi����
	Button btn1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 2.�s������
		btn1 = (Button) this.findViewById(R.id.button1);
		// 3.�إߨƥ�
		btn1.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				// TODO �۰ʲ��ͪ���k Stub
//				AlertDialog.Builder builder = new AlertDialog.Builder(Ch15_2_1Activity.this);
//				builder.setTitle("����"); // ���D��r
//				// ���w��ܤ���T����r
//				builder.setMessage("����: 1.0��\n�@��: ���|�w");
//				// �]�w���s�M�ƥ�B�z�{��
//				builder.setPositiveButton("�T�w", null);
//				builder.show(); // ��ܹ�ܤ��
				//�ΦW����
				new AlertDialog.Builder(Ch15_2_1Activity.this)
				.setTitle("����") // ���D��r
				// ���w��ܤ���T����r
				.setMessage("����: 1.0��\n�@��: ���|�w")
				// �]�w���s�M�ƥ�B�z�{��
				.setPositiveButton("�T�w", null)
				.show(); // ��ܹ�ܤ��
			}
		});

	}
}