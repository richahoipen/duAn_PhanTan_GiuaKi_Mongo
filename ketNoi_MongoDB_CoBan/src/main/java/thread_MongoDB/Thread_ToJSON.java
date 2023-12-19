package thread_MongoDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

import list_DAO.List_Person_DAO;

public class Thread_ToJSON implements Runnable
{
	
	public Thread_ToJSON() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() 
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
			String jsonCauLacBo=stringBuilder.toString();
			
			System.out.println("Ket qua json");
			System.out.println(jsonCauLacBo);
			//Xuat object
			List_Person_DAO l=gson.fromJson(jsonCauLacBo, List_Person_DAO.class);
			System.out.println("Ket qua Object:");
			System.out.println(l.toString());
			
		}catch(IOException e)
		{
			System.out.println("Đã xảy ra lỗi khi ghi dữ liệu vào tệp: " + e.getMessage());
		}
		
	}

}
