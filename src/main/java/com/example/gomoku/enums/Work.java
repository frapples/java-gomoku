package com.example.gomoku.enums;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Ҫ���û�����һ���ļ�����ʹ��File�ڵ�ǰĿ¼�´���������
 * �����ļ��Ѿ����ڣ�����ʾ�û����ļ��Ѿ����ڡ����������ļ�������
 * ����:�û�����"test.txt".�����ļ��Ѵ��ڣ���ʾ�û����ں󣬴�����Ϊ��test_����1.txt ���ļ�
 * �����ļ�Ҳ�����ˣ��򴴽���Ϊ:test_����2.txt ���ļ����Դ�����
 */
public class Work {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("�������ļ�����");
		String fileName = scan.nextLine();
		File file = new File(fileName);
		if(!file.exists()){
			file.createNewFile();
			System.out.println("�ļ������ɹ�");
		}else{
			int index = 1;
			String pre = fileName.substring(0,fileName.indexOf("."));
			String last = fileName.substring(fileName.indexOf(".")+1);
			while(true){
				fileName = pre+"_����"+index+"."+last;
				file = new File(fileName);
				if(!file.exists()){
					file.createNewFile();
					break;
				}
				index++;
			}
			System.out.println("�����Ѵ�����"+file.getName());
		}
	}
}
