package com.TerryWu.sample7_9;

import irdc.sample7_9.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Sample7_9 extends Activity implements Runnable
// implements Runnable

{
  private TextView T1;
  private Button B1;
  private ProgressBar P1;
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    B1 = (Button) findViewById(R.id.myButton1);
    T1 = (TextView) findViewById(R.id.myTextView1);
    P1 = (ProgressBar) findViewById(R.id.myProgressBar1);
    /* ����U���s��A�}�l������u�@ */
    B1.setOnClickListener(new Button.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        T1.setText("�{�����椤");
        /* �N���ê�ProgressBar��ܥX�� */
        P1.setVisibility(View.VISIBLE);
        
        Thread thread = new Thread(Sample7_9.this);
        thread.start();
      }
    });
  }
  
  /* Handler�غc����A�|��ť�ǨӪ��T���N�X */
  private Handler handler = new Handler()
  {
    @Override
    public void handleMessage(Message msg)
    {
      P1.setVisibility(View.GONE);
      T1.setText("���槹��");
    }
  };
  
  @Override
  public void run()
  {
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
    }
    handler.sendEmptyMessage(0);
  }
}