package com.autotest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

/**
 * �ļ�������
 * @author emanon
 *
 */
public class FileUtil {
	//�㷨�汾�洢λ��
	public static final String FileRelativePath = "/UploadFiles/";
	public static final String FilePath = "E:\\Eclipse\\AutoTestDemo\\WebContent\\UploadFiles";
	//���Խ���洢λ��
	public static final String ResultRelativePath = "/TestResults/";
	public static final String ResultPath = "E:\\Eclipse\\AutoTestDemo\\WebContent\\TestResults";
	
	public FileUtil() {}
	
	public static boolean FileCopy(File fromFile, File toFile) {
		try {
			InputStream is = new FileInputStream(fromFile);
	        OutputStream os = new FileOutputStream(toFile);
	        byte[] buffer = new byte[1024];
	        int length = 0;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//�ļ��ϴ�
	public static boolean FileUpload(File fromFile, String fromFileFileName) {
		/*
		String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
		File dir = new File(uploadPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File tempFile = new File(uploadPath, fromFileFileName);
		boolean flag = FileCopy(fromFile, tempFile);
		File toFile = new File(FileUtil.FilePath, tempFile.getName());
		flag = FileCopy(tempFile, toFile);
		return toFile.getAbsolutePath();
		*/
		File toFile = new File(FilePath, fromFileFileName);
		boolean flag = FileCopy(fromFile, toFile);
		return flag;
	}
	
	//���ɲ��Խ��
	public static boolean GenerateTestResult(String Id) {
		File testResult = new File(ResultPath, Id+".json");
		String testResultPath = testResult.getAbsolutePath();
		if (!testResult.exists()) {
			try {
				testResult.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
