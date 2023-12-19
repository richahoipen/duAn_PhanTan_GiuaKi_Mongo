package starting_MongoDB;



import cRUD_Mongo.CRUD_Mongo;


public class Test_CRUD_Person {

	public static void main(String[] args) 
	{
		CRUD_Mongo c=new CRUD_Mongo();
		System.out.println("Kết quả truy vấn Json:");
		System.out.println(c.findAll());
		System.out.println("Kết quả truy vấn Object:");
		System.out.println(c.findObject());
		System.out.println("Thêm dữ liệu tuỳ ý:");
		//insertPerson(String firstName, String lastName, int age, Address address, PhoneNumbers[] phoneNumbers)
		if(c.insertPerson("John", "Doe", 25, "123 Main Street","Anytown", "California", 34533))
		{
			System.out.println("Thêm dữ liệu thành công");
		}
		else
		{
			System.out.println("Thêm dữ liệu thất bại");
		}	
		//Xoá document
		System.out.println("Xoá tuỳ ý:");
		if(c.deletePerson("John", "Doe"))
		{
			System.out.println("Xoá thành công");
		}
		else
		{
			System.out.println("Xoá thất bại");
		}
		//Cập nhật document
		System.out.println("Cập nhật tuổi:");
		if(c.updatePerson_Age("Chirst", "Beath",70))
		{
			System.out.println("Cập nhật thành công");
		}
		else
		{
			System.out.println("Cập nhật thất bại");
		}	
		
		
		
		
	}

}
