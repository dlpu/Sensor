package com.example.sensor;

import java.io.File;
import java.io.FileOutputStream;
import android.os.Environment;

public class FileSave {
	private static String name;

	public static void save(String content, int id) {

		switch (id) {
		case 0:
			name = System.currentTimeMillis()+"加速度传感器.txt";
			break;

		case 1:
			name = System.currentTimeMillis()+"磁场传感器.txt";
			break;

		case 2:
			name = System.currentTimeMillis()+"方向传感器.txt";
			break;

		case 3:
			name = System.currentTimeMillis()+"光传感器.txt";
			break;

		case 4:
			name = System.currentTimeMillis()+"距离传感器.txt";
			break;

		case 5:
			name = System.currentTimeMillis()+"陀螺仪传感器.txt";
			break;
			
		case 6:
			name = System.currentTimeMillis()+"重力传感器.txt";
			break;
			
		case 7:
			name = System.currentTimeMillis()+"线性加速度传感器.txt";
			break;
			
		case 8:
			name = System.currentTimeMillis()+"翻转传感器.txt";
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
