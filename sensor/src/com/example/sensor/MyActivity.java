package com.example.sensor;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {
    

    Button getA;
    Button getMF;
    Button getO;
    Button getL;
    Button getP;
    Button getGy;
    Button getGr;
    Button getLA;
    Button getRV;
    TextView text;
    Button exit;

    private Time time;
    private String timeString;
    private float[] values;
    private String content;
    private static int[] id= new int[]{1,1,1,1,1,1,1,1,1};
    private static String flag = "0";
    static int a = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
        exit = (Button) findViewById(R.id.exit);

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
                    FileSave.save(timeString, 0);
                    sensorManager.registerListener(listener, sensorManager
                                    .getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                            SensorManager.SENSOR_DELAY_UI
                    );
                } else {
                    sensorManager.unregisterListener(listener);
                    getA.setBackgroundColor(Color.parseColor("#3E515F"));
                    a = 0;
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
                    FileSave.save(timeString, 1);
                    sensorManager.registerListener(listener, sensorManager
                                    .getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                            SensorManager.SENSOR_DELAY_UI
                    );
                } else {
                    getMF.setBackgroundColor(Color.parseColor("#3E515F"));
                    sensorManager.unregisterListener(listener);
                    a = 0;
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
                    FileSave.save(timeString, 2);
                    sensorManager.registerListener(
                            listener,
                            sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                            SensorManager.SENSOR_DELAY_UI);
                } else {
                    sensorManager.unregisterListener(listener);
                    getO.setBackgroundColor(Color.parseColor("#3E515F"));
                    a = 0;
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
                    FileSave.save(timeString, 3);
                    sensorManager.registerListener(listener,
                            sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
                            SensorManager.SENSOR_DELAY_UI);
                } else {
                    sensorManager.unregisterListener(listener);
                    getL.setBackgroundColor(Color.parseColor("#3E515F"));
                    a = 0;
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
                    FileSave.save(timeString, 4);
                    sensorManager.registerListener(listener,
                            sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                            SensorManager.SENSOR_DELAY_UI);
                } else {
                    sensorManager.unregisterListener(listener);
                    getP.setBackgroundColor(Color.parseColor("#3E515F"));
                    a = 0;
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
				       FileSave.save(timeString, 5);
				       sensorManager.registerListener(listener,
					   sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
						SensorManager.SENSOR_DELAY_UI);
                 }else{
                     getGy.setBackgroundColor(Color.parseColor("#3E515F"));
                     a=0;
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
				FileSave.save(timeString, 6);
				sensorManager.registerListener(listener,
						sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY),
						SensorManager.SENSOR_DELAY_UI);
              }else{
                  getGr.setBackgroundColor(Color.parseColor("#3E515F"));
                  a = 0;
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
                    FileSave.save(timeString, 7);
                    sensorManager.registerListener(listener, sensorManager
                                    .getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),
                            SensorManager.SENSOR_DELAY_UI
                    );
                }else{
                    getLA.setBackgroundColor(Color.parseColor("#3E515F"));
                    sensorManager.unregisterListener(listener);
                    a=0;
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
                    FileSave.save(timeString, 8);
                    sensorManager.registerListener(listener, sensorManager
                                    .getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR),
                            SensorManager.SENSOR_DELAY_UI
                    );
                }else{
                    getRV.setBackgroundColor(Color.parseColor("#3E515F"));
                    a=0;
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
                    FileSave.save(content, 0);
                    id[0]++;
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    text.setText("X:" + values[0] + "\nY:" + values[1] + "\nZ:"
                            + values[2]);
                    content = id[1] +","+ values[0] + "," + values[1] + ","
                            + values[2]+","+GetTime.getTime()+","+flag+"\r\n";
                    FileSave.save(content, 1);
                    break;
                case Sensor.TYPE_ORIENTATION:
                    text.setText("X:" + values[0] + "\nY:" + values[1] + "\nZ:"
                            + values[2]);
                    content = id[2] +","+ values[0] + "," + values[1] + ","
                            + values[2]+","+GetTime.getTime()+","+flag+"\r\n";
                    FileSave.save(content, 2);
                    break;
                case Sensor.TYPE_LIGHT:
                    text.setText("亮度:" + values[0]);
                    content = id[3] +","+ values[0]+","+GetTime.getTime()+","+flag+"\r\n";
                    FileSave.save(content, 3);
                    break;
                case Sensor.TYPE_PROXIMITY:
                    text.setText("X:" + values[0] + "\nY:" + values[1] + "\nZ:"
                            + values[2]);
                    content = "X:" + values[0] + "Y:" + values[1] + "Z:"
                            + values[2] +"\n";
                    FileSave.save(content, 4);
                    break;
                // case Sensor.TYPE_GYROSCOPE:
                // text.setText("X:" + values[0]
                // );
                // content="X:"+values[0]+"Y:"+values[1]+"Z:"+values[2]+"\n";
                // FileSave.save(content,5);
                // break;
                // case Sensor.TYPE_GRAVITY:
                // text.setText("X:" + values[0]
                // + "\nY:" +values[1] + "\nZ:"
                // + values[2]);
                // content="X:"+values[0]+"Y:"+values[1]+"Z:"+values[2]+"\n";
                // FileSave.save(content,6);
                // break;
                case Sensor.TYPE_LINEAR_ACCELERATION:
                    text.setText("X:" + values[0] + "\nY:" + values[1] + "\nZ:"
                            + values[2]);
                    content = "X:" + values[0] + "Y:" + values[1] + "Z:"
                            + values[2]+"\n";
                    FileSave.save(content, 7);
                    break;
                case Sensor.TYPE_ROTATION_VECTOR:
                    text.setText("X:" + values[0] + "\nY:" + values[1] + "\nZ:"
                            + values[2]);
                    content = "X:" + values[0] + "Y:" + values[1] + "Z:"
                            + values[2]+"\n";
                    FileSave.save(content, 8);
                    break;
                default:
                    break;
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }

    };

}