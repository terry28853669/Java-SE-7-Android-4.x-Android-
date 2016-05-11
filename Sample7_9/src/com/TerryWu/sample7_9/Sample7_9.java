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
    /* 當按下按鈕後，開始執行緒工作 */
    B1.setOnClickListener(new Button.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        T1.setText("程式執行中");
        /* 將隱藏的ProgressBar顯示出來 */
        P1.setVisibility(View.VISIBLE);
        
        Thread thread = new Thread(Sample7_9.this);
        thread.start();
      }
    });
  }
  
  /* Handler建構之後，會聆聽傳來的訊息代碼 */
  private Handler handler = new Handler()
  {
    @Override
    public void handleMessage(Message msg)
    {
      P1.setVisibility(View.GONE);
      T1.setText("執行完畢");
    }
  };
  
  @Override
  public void run()
  {
    for (int i = 0; i < 10; i++)
    {
      /* 每執行一次迴圈，即暫停1秒 */
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