package create_Json;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

import entity.Address;
import entity.Person;
import entity.PhoneNumbers;
import list_DAO.List_Person_DAO;

public class Create_Json 
{
	
	public static void main(String[] args) 
	{
		//Khởi tạo
		List_Person_DAO l=new List_Person_DAO();
		Gson gson =new Gson();
		Scanner scr=new Scanner(System.in);
		//Thêm dữ liệu vào mảng động
		//Person 1
		PhoneNumbers[] phoneNumbers1=new PhoneNumbers[2];
		phoneNumbers1[0] =new PhoneNumbers("home", "345 434-3244");
		phoneNumbers1[1] =new PhoneNumbers("fax", "345 324-3244");
		Address address1=new Address("21 2nd Street","New York","NY",10021);
		l.addPerson(new Person("John","Smith",25, address1,phoneNumbers1));
		//Person 2 
		PhoneNumbers[] phoneNumbers2=new PhoneNumbers[2];
		phoneNumbers2[0] =new PhoneNumbers("home", "323 434-323");
		phoneNumbers2[1] =new PhoneNumbers("fax", "423 334-321");
		Address address2=new Address("22 3nd Street","Nevada","NY",10022);
		l.addPerson(new Person("Harry","Smith",25, address2,phoneNumbers1));
		//Person 3
		PhoneNumbers[] phoneNumbers3=new PhoneNumbers[2];
		phoneNumbers3[0] =new PhoneNumbers("home", "324 323-543");
		phoneNumbers3[1] =new PhoneNumbers("fax", "323 332-222");
		Address address3=new Address("22 3nd Street","Nevada","Chicago",10122);
		l.addPerson(new Person("Harry","Joneh",30, address3,phoneNumbers3));
		//Person 4
		PhoneNumbers[] phoneNumbers4=new PhoneNumbers[2];
		phoneNumbers4[0] =new PhoneNumbers("home", "213 438-282");
		phoneNumbers4[1] =new PhoneNumbers("fax", "548 283-282");
		Address address4=new Address("Ronald34 Street","AN","Chicago",10142);
		l.addPerson(new Person("Harry","Joneh",30, address4,phoneNumbers4));
		//Person5
		PhoneNumbers[] phoneNumbers5=new PhoneNumbers[2];
		phoneNumbers5[0] =new PhoneNumbers("home", "213 348-282");
		phoneNumbers5[1] =new PhoneNumbers("fax", "234 344-232");
		Address address5=new Address("39 Miss","Rost","Chicago",10132);
		l.addPerson(new Person("Bill","Paul",30, address5,phoneNumbers4));
		//Person6
		PhoneNumbers[] phoneNumbers6=new PhoneNumbers[2];
		phoneNumbers6[0] =new PhoneNumbers("home", "213 348-282");
		phoneNumbers6[1] =new PhoneNumbers("fax", "234 344-232");
		Address address6=new Address("Yuri45 Street","Rost","Chicago",10132);
		l.addPerson(new Person("Bill","Pan",51, address6,phoneNumbers6));
		//Person 7
		PhoneNumbers[] phoneNumbers7=new PhoneNumbers[2];
		phoneNumbers7[0] =new PhoneNumbers("home", "098 344-332");
		phoneNumbers7[1] =new PhoneNumbers("fax", "343 343-322");
		Address address7=new Address("45 Khang Street","Rost","Chicago",10132);
		l.addPerson(new Person("Zne","Pan",51, address7,phoneNumbers7));
		//Person 8
		PhoneNumbers[] phoneNumbers8=new PhoneNumbers[2];
		phoneNumbers8[0] =new PhoneNumbers("home", "444 484-339");
		phoneNumbers8[1] =new PhoneNumbers("fax", "429 494-299");
		Address address8=new Address("34 LO Street","Rostdam","Dallas",32294);
		l.addPerson(new Person("Rose","Cari",51, address8,phoneNumbers8));
		//Person 9
		PhoneNumbers[] phoneNumbers9=new PhoneNumbers[2];
		phoneNumbers9[0] =new PhoneNumbers("home", "323 223-233");
		phoneNumbers9[1] =new PhoneNumbers("fax", "983 383-282");
		Address address9=new Address("22 3nd Street","Rostdam","Dallas",52294);
		l.addPerson(new Person("Rose","Cari",51, address9,phoneNumbers9));
		//Person 10
		PhoneNumbers[] phoneNumbers10=new PhoneNumbers[2];
		phoneNumbers10[0] =new PhoneNumbers("home", "344 399-292");
		phoneNumbers10[1] =new PhoneNumbers("company", "223 333-443");
		Address address10=new Address("62 3nd Street","Rostdam","Dallas",34494);
		l.addPerson(new Person("Rose","Cari",59, address10,phoneNumbers10));
		//Person 11
		PhoneNumbers[] phoneNumbers11=new PhoneNumbers[2];
		phoneNumbers11[0] =new PhoneNumbers("personal", "349 238-383");
		phoneNumbers11[1] =new PhoneNumbers("company", "793 394-293");
		Address address11=new Address("68 3nd Street","Rostdam","Dallas",49237);
		l.addPerson(new Person("John","Ben",70, address11,phoneNumbers11));
		//Person 12
		PhoneNumbers[] phoneNumbers12=new PhoneNumbers[2];
		phoneNumbers12[0] =new PhoneNumbers("personal", "349 490-283");
		phoneNumbers12[1] =new PhoneNumbers("home", "893 282-383");
		Address address12=new Address("782 Mana Street","Rostdam","Mexico New",49337);
		l.addPerson(new Person("John","Stone",71, address12,phoneNumbers12));
		//Person 13
		PhoneNumbers[] phoneNumbers13=new PhoneNumbers[2];
		phoneNumbers13[0] =new PhoneNumbers("personal", "349 490-283");
		phoneNumbers13[1] =new PhoneNumbers("home", "839 228-483");
		Address address13=new Address("893 Mana Street","Rostdam","Dallas",59237);
		l.addPerson(new Person("Mivu","Stone",71, address13,phoneNumbers13));
		//Person 14
		PhoneNumbers[] phoneNumbers14=new PhoneNumbers[2];
		phoneNumbers14[0] =new PhoneNumbers("personal", "783 292-293");
		phoneNumbers14[1] =new PhoneNumbers("home", "986 882-282");
		Address address14=new Address("89 Mono Street","Number 12","Ohio",43333);
		l.addPerson(new Person("Kai","Mark",41, address14,phoneNumbers14));
		//Person 15
		PhoneNumbers[] phoneNumbers15=new PhoneNumbers[3];
		phoneNumbers15[0] =new PhoneNumbers("personal", "783 292-293");
		phoneNumbers15[1] =new PhoneNumbers("home", "986 882-282");
		phoneNumbers15[2] =new PhoneNumbers("company", "946 882-282");
		Address address15=new Address("90 Mono Street","Number 13","Ohio",45543);
		l.addPerson(new Person("Chirst","Beath",40, address15,phoneNumbers15));
		//Thêm vào json
		System.out.println("Thư mục theo cấu trúc json:");
		String json=gson.toJson(l);
		//Xuat json
		System.out.println(json);
		//
		String fileName;
		System.out.print("Tên file json:");
		fileName=scr.nextLine();
		//tạo file json và thêm vào
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName+".json")))
		{
			 writer.write(json);
	         System.out.println("Dữ liệu đã được ghi vào tệp.");
		}catch(IOException e)
		{
			System.out.println("Đã xảy ra lỗi khi ghi dữ liệu vào tệp: " + e.getMessage());
		}
	}
}
