package androidEx.ch15;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ch15_2_2Activity extends Activity {
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
				new AlertDialog.Builder(Ch15_2_2Activity.this) 
		        .setTitle("�T�{")
		          .setMessage("�T�{�������{��?")
		          .setPositiveButton("�T�w", new DialogInterface.OnClickListener(){

					public void onClick(DialogInterface arg0, int arg1) {
						// TODO �۰ʲ��ͪ���k Stub
						finish();
					}})
					.setNeutralButton("���T�w", new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface dialog, int which) {
							// TODO �۰ʲ��ͪ���k Stub
							Toast.makeText(getApplicationContext(), "�z���U���T�w", 3000).show();
						}})
		          .setNegativeButton("����", null) 
		          .show();
			}
		});
    }
}