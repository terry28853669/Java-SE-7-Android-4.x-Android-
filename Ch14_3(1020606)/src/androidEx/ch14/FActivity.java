package androidEx.ch14;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class FActivity extends Activity {
	// 1.�ŧi����
	TextView o;
	Button B02;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.f);
		// 2.�s������
		o=(TextView) this.findViewById(R.id.lblOutput);
		B02=(Button) this.findViewById(R.id.button1);
		int c;
		double f = 0.0;
		// ���o�ǻ������
		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
		   c = Integer.valueOf(bundle.getString("TEMPC"));
		   // �����ؤ󪺤���
		   f = (9.0 * c) / 5.0 + 32.0;
		   // ��ܵؤ�ū�
		   o = (TextView) findViewById(R.id.lblOutput);
		   o.setText("�ؤ�ū�: " + Double.toString(f));
		   // 3.�إߨƥ�
		   B02.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				// TODO �۰ʲ��ͪ���k Stub
				finish();
			}});
		}
	}
}
