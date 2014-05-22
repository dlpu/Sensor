package com.example.sensor;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyActivity extends Activity{

    Button getA;
    Button getMF;
    Button getO;
    Button getL;
    Button getP;
    Button getGy;
    Button getGr;
    Button getLA;
    Button getRV;
    TextView text,text1;
    Button exit;

    private String timeString;
    private float[] values;
    private String content;
    private static int[] id= new int[]{1,1,1,1,1,1,1,1,1};
    private static String flag = "0";
    static int a = 0;
    static int[] num = new int[]{0,0,0,0,0,0,0,0,0};
    SimpleDateFormat    formatter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        formatter    =   new    SimpleDateFormat    ("MM月dd日 HH:mm:ss    ");
        getA = (Button) findViewById(R.id.getA);
        getMF = (Button) findViewById(R.id.getMF);
        getO = (Button) findViewById(R.id.getO);
        getL = (Button) findViewById(R.id.getL);
        getP = (Button) findViewById(R.id.getP);
        getLA = (Button) findViewById(R.id.getLA);
        getRV = (Button) findViewById(R.id.getRV);
        getGr = (Button) findViewById(R.id.getGr);
        getGy = (Button) findViewById(R.id.getGy);
        text = (TextView) findViewById(R.id.text);
        text1 = (TextView) findViewById(R.id.text1);
        exit = (Button) findViewById(R.id.exit);

//        MyActivity ma = new MyActivity();
//        Thread t = new Thread(ma);
//        t.start();

        getA.setBackgroundColor(Color.parseColor("#3E515F"));
        getMF.setBackgroundColor(Color.parseColor("#3E515F"));
        getO.setBackgroundColor(Color.parseColor("#3E515F"));
        getL.setBackgroundColor(Color.parseColor("#3E515F"));
        getP.setBackgroundColor(Color.parseColor("#3E515F"));
        getLA.setBackgroundColor(Color.parseColor("#3E515F"));
        getRV.setBackgroundColor(Color.parseColor("#3E515F"));
        getGr.setBackgroundColor(Color.parseColor("#3E515F"));
        getGy.setBackgroundColor(Color.parseColor("#3E515F"));


        final SensorManager sensorManager;
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // 加速度传感器
        getA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                if (a != 2) {
                    getA.setBackgroundColor(Color.parseColor("#ffcc00"));
//				time = new Time();
//				time.setToNow(); // 取得系统当前时间
//				timeString = "\n\n" + (time.month + 1) + "/" + time.monthDay
//						+ "/" + time.hour + "/" + time.minute + "/"
//						+ time.second + "\n";
                    timeString = "id,X,Y,Z,time,flag" + "\r\n";
                    FileSave.save(timeString, 0 ,num[0]);
                    sensorManager.registerListener(listener, sensorManager
                                    .getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                            SensorManager.SENSOR_DELAY_UI
                    );
                } else {
                    sensorManager.unregisterListener(listener);
                    getA.setBackgroundColor(Color.parseColor("#3E515F"));
                    a = 0;
                    num[0]++;
                }
            }

        });
        // 磁场传感器
        getMF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                if (a != 2) {
                    getMF.setBackgroundColor(Color.parseColor("#ffcc00"));
                    timeString = "id,X,Y,Z,time,flag" + "\r\n";
                    FileSave.save(timeString, 1,num[1]);
                    sensorManager.registerListener(listener, sensorManager
                                    .getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                            SensorManager.SENSOR_DELAY_UI
                    );
                } else {
                    sensorManager.unregisterListener(listener);
                    getMF.setBackgroundColor(Color.parseColor("#3E515F"));
                    a = 0;
                    num[1]++;
                }
            }
        });
        // 方向传感器
        getO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                if (a != 2) {
                    getO.setBackgroundColor(Color.parseColor("#ffcc00"));
                    timeString = "id,X,Y,Z,time,flag" + "\r\n";
                    FileSave.save(timeString, 2,num[2]);
                    sensorManager.registerListener(
                            listener,
                            sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                            SensorManager.SENSOR_DELAY_UI);
                } else {
                    sensorManager.unregisterListener(listener);
                    getO.setBackgroundColor(Color.parseColor("#3E515F"));
                    a = 0;
                    num[2]++;
                }
            }
        });

        // 光传感器
        getL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                if (a != 2) {
                    getL.setBackgroundColor(Color.parseColor("#ffcc00"));
                    timeString = "id,light,time,flag" + "\r\n";
                    FileSave.save(timeString, 3 , num[3]);
                    sensorManager.registerListener(listener,
                            sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
                            SensorManager.SENSOR_DELAY_UI);
                } else {
                    sensorManager.unregisterListener(listener);
                    getL.setBackgroundColor(Color.parseColor("#3E515F"));
                    a = 0;
                    num[3]++;
                }
            }
        });

        // 距离传感器
        getP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                if (a != 2) {
                    getP.setBackgroundColor(Color.parseColor("#ffcc00"));
                    timeString = "id,X,Y,Z,time,flag" + "\r\n";
                    FileSave.save(timeString, 4, num[4]);
                    sensorManager.registerListener(listener,
                            sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                            SensorManager.SENSOR_DELAY_UI);
                } else {
                    sensorManager.unregisterListener(listener);
                    getP.setBackgroundColor(Color.parseColor("#3E515F"));
                    a = 0;
                    num[4]++;
                }
            }
        });

        // 陀螺仪传感器
        getGy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                if(a!=2){
                    getGy.setBackgroundColor(Color.parseColor("#ffcc00"));
                    timeString = "id,X,Y,Z,time,flag" + "\r\n";
                    FileSave.save(timeString, 5, num[5]);
                    sensorManager.registerListener(listener,
                            sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
                            SensorManager.SENSOR_DELAY_UI);
                }else{
                    sensorManager.unregisterListener(listener);
                    getGy.setBackgroundColor(Color.parseColor("#3E515F"));
                    a=0;
                    num[5]++;
                }
            }
        });

        //重力传感器
        getGr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                if(a != 2){
                    getGr.setBackgroundColor(Color.parseColor("#ffcc00"));
                    timeString = "id,X,Y,Z,time,flag" + "\r\n";
                    FileSave.save(timeString, 6, num[6]);
                    sensorManager.registerListener(listener,
                            sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY),
                            SensorManager.SENSOR_DELAY_UI);
                }else{
                    sensorManager.unregisterListener(listener);
                    getGr.setBackgroundColor(Color.parseColor("#3E515F"));
                    a = 0;
                    num[6]++;
                }
            }
        });

        //线性加速度传感器
        getLA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                if(a!=2) {
                    getLA.setBackgroundColor(Color.parseColor("#ffcc00"));
                    timeString = "id,X,Y,Z,time,flag" + "\r\n";
                    FileSave.save(timeString, 7, num[7]);
                    sensorManager.registerListener(listener, sensorManager
                                    .getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),
                            SensorManager.SENSOR_DELAY_UI
                    );
                }else{
                    sensorManager.unregisterListener(listener);
                    getLA.setBackgroundColor(Color.parseColor("#3E515F"));
                    a=0;
                    num[7]++;
                }
            }
        });

        //翻转传感器
        getRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                if(a!=2) {
                    getRV.setBackgroundColor(Color.parseColor("#ffcc00"));
                    timeString = "id,X,Y,Z,time,flag" + "\r\n";
                    FileSave.save(timeString, 8,num[8]);
                    sensorManager.registerListener(listener, sensorManager
                                    .getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR),
                            SensorManager.SENSOR_DELAY_UI
                    );
                }else{
                    sensorManager.unregisterListener(listener);
                    getRV.setBackgroundColor(Color.parseColor("#3E515F"));
                    a=0;
                    num[8]++;
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

    }

SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            values = sensorEvent.values;
            switch (sensorEvent.sensor.getType()) {
                case Sensor.TYPE_ACCELEROMETER:
                    text.setText("X:" + values[0] + "\nY:" + values[1] + "\nZ:"
                            + values[2]);
                    content = id[0] +","+ values[0] + "," + values[1] + ","
                            + values[2] +","+GetTime.getTime()+","+ flag +"\r\n";
                    FileSave.save(content, 0, num[0]);
                    id[0]++;
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    text.setText("X:" + values[0] + "\nY:" + values[1] + "\nZ:"
                            + values[2]);
                    content = id[1] +","+ values[0] + "," + values[1] + ","
                            + values[2]+","+GetTime.getTime()+","+flag+"\r\n";
                    FileSave.save(content, 1, num[1]);
                    id[1]++;
                    break;
                case Sensor.TYPE_ORIENTATION:
                    text.setText("X:" + values[0] + "\nY:" + values[1] + "\nZ:"
                            + values[2]);
                    content = id[2] +","+ values[0] + "," + values[1] + ","
                            + values[2]+","+GetTime.getTime()+","+flag+"\r\n";
                    FileSave.save(content, 2, num[2]);
                    id[2]++;
                    break;
                case Sensor.TYPE_LIGHT:
                    text.setText("亮度:" + values[0]);
                    content = id[3] +","+ values[0]+","+GetTime.getTime()+","+flag+"\r\n";
                    FileSave.save(content, 3, num[3]);
                    id[3]++;
                    break;
                case Sensor.TYPE_PROXIMITY:
                    text.setText("X:" + values[0] + "\nY:" + values[1] + "\nZ:"
                            + values[2]);
                    content = id[4] +","+ values[0] + "," + values[1] + ","
                        + values[2] +","+GetTime.getTime()+","+flag+"\r\n";
                    FileSave.save(content, 4 ,num[4]);
                    id[4]++;
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    text.setText("X:" + values[0]
                    );
                    content = id[5] +","+ values[0] + "," + values[1] + ","
                            + values[2] +","+GetTime.getTime()+","+flag+"\r\n";
                    FileSave.save(content, 5, num[5]);
                    id[5]++;
                    break;
                case Sensor.TYPE_GRAVITY:
                    text.setText("X:" + values[0]
                            + "\nY:" +values[1] + "\nZ:"
                            + values[2]);
                    content = id[6] +","+ values[0] + "," + values[1] + ","
                            + values[2] +","+GetTime.getTime()+","+flag+"\r\n";
                    FileSave.save(content, 6, num[6]);
                    id[6]++;
                    break;
                case Sensor.TYPE_LINEAR_ACCELERATION:
                    text.setText("X:" + values[0] + "\nY:" + values[1] + "\nZ:"
                            + values[2]);
                    content = id[7] +","+ values[0] + "," + values[1] + ","
                            + values[2] +","+GetTime.getTime()+","+flag+"\r\n";
                    FileSave.save(content, 7, num[7]);
                    id[7]++;
                    break;
                case Sensor.TYPE_ROTATION_VECTOR:
                    text.setText("X:" + values[0] + "\nY:" + values[1] + "\nZ:"
                            + values[2]);
                    content = id[8] +","+ values[0] + "," + values[1] + ","
                            + values[2] +","+GetTime.getTime()+","+flag+"\r\n";
                    FileSave.save(content, 8, num[8]);
                    id[8]++;
                    break;
                default:
                    break;
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }

    };

//    @Override
//    public void run() {
//        try {
//            while (true) {
//                text1.setText(formatter.format(System.currentTimeMillis()));
//                Thread.sleep(1000);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}


//class MyTimerTask extends TimerTask
//{
//    private MyActivity me;
//    public MyTimerTask(MyActivity p)
//    {
//        me=p;
//    }
//    public void run()
//    {
//        me.m_nTime++;
//        me.timerHandler.sendEmptyMessage(0);
//    }
//}
//class TimerHandler extends Handler
//{
//    private MyActivity me;
//    public TimerHandler(MyActivity m)
//    {
//        me=m;
//    }
//    @Override
//    public void handleMessage(Message msg)
//    {
//        me.text1.setText(me.m_nTime+"");
//    }
//}