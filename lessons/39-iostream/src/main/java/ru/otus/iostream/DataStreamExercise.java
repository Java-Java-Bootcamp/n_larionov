package ru.otus.iostream;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipOutputStream;

public class DataStreamExercise {
	public static void main(String ... args) {
		try (DataOutputStream os = new DataOutputStream(new FileOutputStream("39-iostream/data.bin"))) {
			// запишите число, текст, еще что-нибудь
			// откройте файл hex-просмотрщиком
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
