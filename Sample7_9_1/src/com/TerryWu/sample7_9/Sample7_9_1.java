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
  // 1.宣告
  private TextView tv1;
  private Button bt1;
  private ProgressBar pb1;
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    // 2.連結元件
    bt1 = (Button) findViewById(R.id.B01);
    tv1 = (TextView) findViewById(R.id.T01);
    pb1 = (ProgressBar) findViewById(R.id.PB01);
    
    /* 當按下按鈕後，開始執行緒工作 */
    bt1.setOnClickListener(new Button.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        pb1.setProgress(0);
        tv1.setText("程式下載中");
        
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
      // 百分比
      int percent = (i + 1) * 10;
      Message m = new Message();
      m.obj = percent;
      handler.sendMessage(m);
    }
  }
  
  /* Handler建構之後，會聆聽傳來的訊息代碼 */
  Handler handler = new Handler()
  {
    // @Override
    public void handleMessage(Message msg)
    {
      int x = Integer.parseInt(msg.obj.toString());
      if (x == 100)
      {
        tv1.setText("下載完成!");
        pb1.setProgress(x);
      }
      else
      {
        tv1.setText("下載進度：" + x + "%");
        pb1.setProgress(x);
      }
    }
  };
}