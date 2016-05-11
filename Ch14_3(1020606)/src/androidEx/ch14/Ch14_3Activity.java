package androidEx.ch14;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ch14_3Activity extends Activity {
	// 1.�ŧi����
	EditText txtC;
	Button B01;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // 2.�s������
    	txtC = (EditText) findViewById(R.id.txtC);
    	B01=(Button) this.findViewById(R.id.button1); 
    	// 3.�إߨƥ�
    	B01.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				// �إ�Intent����
				Intent intent = new Intent();
				// �إ߶ǻ���ƪ�Bundle����
				Bundle bundle = new Bundle();
				bundle.putString("TEMPC", txtC.getText().toString());
				intent.putExtras(bundle); // �[�W���
				intent.setClass(Ch14_3Activity.this, FActivity.class);
				startActivity(intent); // �Ұʬ���
			}});
    }
}