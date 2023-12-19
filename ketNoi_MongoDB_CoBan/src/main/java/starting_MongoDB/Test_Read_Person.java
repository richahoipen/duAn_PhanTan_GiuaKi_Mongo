package starting_MongoDB;

import cRUD_Mongo.Read_Mongo;


public class Test_Read_Person 
{

	public static void main(String[] args) 
	{
		/*
		 * Tìm những person đang sống tại 1 bang cho trước
		 * Tìm sđt 1 person cho trước
		 * Tính độ tuổi trung bình cho mỗi bang
		 * Tính tổng số Person
		 */
		//Khởi tạo
		Read_Mongo r=new Read_Mongo();
		//Tìm những person đang sống tại 1 bang cho trước
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
	}

}
