package com.TerryWu.sample7_9;

import irdc.sample7_9_1.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Sample7_9_1 extends Activity implements Runnable
{
  // 1.�ŧi
  private TextView tv1;
  private Button bt1;
  private ProgressBar pb1;
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    // 2.�s������
    bt1 = (Button) findViewById(R.id.B01);
    tv1 = (TextView) findViewById(R.id.T01);
    pb1 = (ProgressBar) findViewById(R.id.PB01);
    
    /* ����U���s��A�}�l������u�@ */
    bt1.setOnClickListener(new Button.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        pb1.setProgress(0);
        tv1.setText("�{���U����");
        
        Thread thread = new Thread(Sample7_9_1.this);
        thread.start();
      }
    });
  }
  
  @Override
  public void run()
  {
    // TODO Auto-generated method stub
    for (int i = 0; i < 10; i++)
    {
      /* �C����@���j��A�Y�Ȱ�1�� */
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      // �ʤ���
      int percent = (i + 1) * 10;
      Message m = new Message();
      m.obj = percent;
      handler.sendMessage(m);
    }
  }
  
  /* Handler�غc����A�|��ť�ǨӪ��T���N�X */
  Handler handler = new Handler()
  {
    // @Override
    public void handleMessage(Message msg)
    {
      int x = Integer.parseInt(msg.obj.toString());
      if (x == 100)
      {
        tv1.setText("�U������!");
        pb1.setProgress(x);
      }
      else
      {
        tv1.setText("�U���i�סG" + x + "%");
        pb1.setProgress(x);
      }
    }
  };
}