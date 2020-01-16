package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStream2 {
	public static void main(String[] args) throws IOException {
		File file = new File("data1.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		
		int size = (int)file.length();
		byte[] ar = new byte[size];
		
		bis.read(ar,0,size);
		System.out.println(new String(ar));
		
		bis.close();
	}
}
