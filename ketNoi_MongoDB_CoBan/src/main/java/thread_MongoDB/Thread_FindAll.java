package thread_MongoDB;

import cRUD_Mongo.CRUD_Mongo;
import cRUD_Mongo.Read_Mongo;

public class Thread_FindAll implements Runnable
{
	
	
	public Thread_FindAll() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() 
	{
		Read_Mongo r=new Read_Mongo();
		System.out.println("1/Tìm những person đang sống tại 1 bang cho trước.");
		System.out.println("2/Tìm số điện thoại 1 person cho trước.");
		System.out.println("3/Tính độ tuổi trung bình.");
		System.out.println("4/Tính tổng số Person.");
		System.out.println("1/Kết quả tìm những person đang sống tại 1 bang Dallas cho trước:");
		System.out.println(r.find_FromState("Dallas"));
		//Tìm sđt 1 person cho trước
		System.out.println("2/Kết quả số điện thoại 1 person cho trước là John Smith:");
		System.out.println(r.find_FromPhoneNumber("John", "Smith"));
		//Tính độ tuổi trung bình cho mỗi bang
		System.out.println("3/Tính độ tuổi trung bình cho mỗi bang:");
		System.out.println(r.find_AverageAge_State());
		//Tính tổng số Person cho mỗi bang
		System.out.println("4/Tính tổng số Person cho mỗi bang:");
		System.out.println(r.find_Population_State());
		CRUD_Mongo c=new CRUD_Mongo();
		System.out.println("Kết quả truy vấn Json:");
		System.out.println(c.findAll());
		System.out.println("Kết quả truy vấn Object:");
		System.out.println(c.findObject());
	}
}
