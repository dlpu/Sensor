package com.example.sensor;

import java.io.File;
import java.io.FileOutputStream;
import android.os.Environment;

public class FileSave {
	private static String name;
	//private static String name1;

	public static void save(String content, int id ,int num) {

		switch (id) {
		case 0:
			name = "加速度传感器"+num+".txt";
			break;

		case 1:
			name = "磁场传感器"+num+".txt";
			break;

		case 2:
			name = "方向传感器"+num+".txt";
			break;

		case 3:
			name = "光传感器"+num+".txt";
			break;

		case 4:
			name = "距离传感器"+num+".txt";
			break;

		case 5:
			name = "陀螺仪传感器"+num+".txt";
			break;
			
		case 6:
			name = "重力传感器"+num+".txt";
			break;
			
		case 7:
			name = "线性加速度传感器"+num+".txt";
			break;
			
		case 8:
			name = "翻转传感器"+num+".txt";
			break;
		default:
			break;
		}
		
		
		try {
			File file = new File(Environment.getExternalStorageDirectory(),
					name);
			FileOutputStream outStream = new FileOutputStream(file, true);
			outStream.write(content.getBytes());
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
