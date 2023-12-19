package create_Json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

import list_DAO.List_Person_DAO;



public class Read_Json {

	public static void main(String[] args) 
	{
		
		Scanner scr=new Scanner(System.in);
		String fileName;
		System.out.print("Tên file json cần đọc:");
		fileName=scr.nextLine();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName+".json")))
		{
			StringBuilder stringBuilder=new StringBuilder();
			String line;
			Gson gson=new Gson();
			while((line=reader.readLine())!=null)
			{
				stringBuilder.append(line+"\n");
			}
			String json=stringBuilder.toString();
			
			System.out.println("Ket qua json");
			System.out.println(json);
			//Xuat object
			List_Person_DAO l=gson.fromJson(json, List_Person_DAO.class);
			System.out.println("Ket qua Object:");
			System.out.println(l.toString());
			
		}catch(IOException e)
		{
			System.out.println("Đã xảy ra lỗi khi ghi dữ liệu vào tệp: " + e.getMessage());
		}

	}

}
