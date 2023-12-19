package cRUD_Mongo;

import java.util.Arrays;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import com.mongodb.client.result.UpdateResult;

import entity.Person;



public class CRUD_Mongo 
{
	MongoClient clients=MongoClients.create();
	
	MongoDatabase database=clients.getDatabase("Entity_Java");
	
	MongoCollection<Document> collection=database.getCollection("Person");
	
	
	public CRUD_Mongo() {
		super();
	}
	public String findAll()
	{
		Document quenry=new Document();
		
		FindIterable<Document> result=collection.find(quenry);
		StringBuilder stringBuilder=new StringBuilder();
		for(Document document:result)
		{
			stringBuilder.append(document.toJson()).append("\n");		
		}
		String jsonPerson=stringBuilder.toString();
		return jsonPerson;
	}
	public String findObject()
	{
		Document quenry=new Document();
		Gson gson=new Gson();
		String s="";
		FindIterable<Document> result=collection.find(quenry).sort(new Document("State",1));
		StringBuilder stringBuilder=new StringBuilder();
		for(Document document:result)
		{
			stringBuilder.append(document.toJson()).append(",\n");		
		}
		stringBuilder.deleteCharAt(stringBuilder.length()-2);
		String jsonArray="["+stringBuilder+"]";
		Person[] personArray=gson.fromJson(jsonArray, Person[].class);
		for(Person p: personArray)
		{
			s+=p.toString()+"\n";
		}
		return s;
	}
	//Thêm document
	public boolean insertPerson(String firstName, String lastName, int age, String streetAddress,String city, String state, int postalCode)
	{
				
		 Document insertPerson = new Document("_id", new ObjectId())
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("age", 25)
                //Thêm kiểu document con là address
                .append("address", new Document("streetAddress", streetAddress)
                        .append("city", city)
                        .append("state", state)
                        .append("postalCode", postalCode))
                //Thêm kiểu mảng document
                .append("phoneNumbers", Arrays.asList(
                        new Document("type", "personal").append("number", "123-456-7890"),
                        new Document("type", "home").append("number", "987-654-3210"),
                        new Document("type", "company").append("number", "555-555-5555")
                ));
		 
		 if(collection.insertOne(insertPerson) != null)
		 {
			 return true;
		 }
		 return false;	
	}
	//Xoá document theo tên person
	public boolean deletePerson(String firstName,String lastName)
	{
		//Dùng lớp Bson với phương thức Filters
		Bson filter = Filters.and
		(
			Filters.eq("firstName", firstName),
			Filters.eq("lastName", lastName)
		);
		if(collection.deleteMany(filter)!=null)
		{
			return true;
		}
		return false;
	}
	//Cập nhật 1 thuộc tính
	public boolean updatePerson_Age(String firstName, String lastName, int age)
	{
		//Dùng lớp Bson với phương thức Filters
		Bson filter = Filters.and
		(
			Filters.eq("firstName", firstName),
			Filters.eq("lastName", lastName)
		);	
		// Tạo các thay đổi cần áp dụng lên document
		Bson updateAge = Updates.set("age", age);

		// Cập nhật document thỏa mãn điều kiện
		UpdateResult updateResult = collection.updateMany(filter, updateAge);
		//updateResult.getModifiedCount() số document đã cập nhật
		if(updateResult!=null)
		{
			return true;
		}
		return false;
	}
	
	
	
}
