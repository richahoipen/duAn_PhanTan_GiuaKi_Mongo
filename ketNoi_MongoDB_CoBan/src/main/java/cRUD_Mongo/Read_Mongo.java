package cRUD_Mongo;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import list_DAO.List_Person_DAO;

public class Read_Mongo 
{
	/*
	 * Tìm những person đang sống tại 1 bang cho trước
	 * Tìm sđt 1 person cho trước
	 * Tính độ tuổi trung bình
	 * Tính tổng số Person
	 */
	MongoClient clients=MongoClients.create();
	
	MongoDatabase database=clients.getDatabase("Entity_Java");
	
	MongoCollection<Document> collection=database.getCollection("Person");
	
	public Read_Mongo() {
		super();
	}
	//Tìm những person đang sống 1 bang cho trước
	public String find_FromState(String state)
	{
		//Câu mongo db.Person.find("address.state":"NY")
		Document quenry=new Document("address.state",state);
		
		FindIterable<Document> result=collection.find(quenry);
		StringBuilder stringBuilder=new StringBuilder();
		for(Document document:result)
		{
			stringBuilder.append(document.toJson()).append("\n");		
		}
		String jsonPerson=stringBuilder.toString();
		return jsonPerson;
	}
	//Tìm sđt 1 person cho trước
	public String find_FromPhoneNumber(String firstName,String lastName)
	{
		Bson filter = Filters.and
				(
					Filters.eq("firstName", firstName),
					Filters.eq("lastName", lastName)
				);
		//Câu mongo db.Person.find()
		Document projection = new Document("phoneNumbers.number",1);
		//Truy vấn
		FindIterable<Document> result=collection.find(filter).projection(projection);
		//Tạo chuỗi
		StringBuilder stringBuilder=new StringBuilder();
		for(Document document:result)
		{
			stringBuilder.append(document.toJson()).append("\n");		
		}
		String jsonPerson=stringBuilder.toString();
		return jsonPerson;
	}
	//Document query = new Document("gia",new Document("$gt",10000000));
    //Document projection = new Document("tenXe", 1).append("namSanXuat", 1);
    // Thực hiện truy vấn collection "customers"
    //FindIterable<Document> result = collection.find(query).projection(projection);
	
	public String find_AverageAge_State()
	{
		Document quenry=new Document();
		Gson gson=new Gson();
		FindIterable<Document> result=collection.find(quenry).sort(new Document("State",1));
		StringBuilder stringBuilder=new StringBuilder();
		for(Document document:result)
		{
			stringBuilder.append(document.toJson()).append(",\n");		
		}
		//Chuyển đổi cho mảng động đọc vào
		stringBuilder.deleteCharAt(stringBuilder.length()-2);
		String jsonArray="{\"listPerson\":["+stringBuilder+"]}";
		//Chuyển thành mảng động
		List_Person_DAO l=gson.fromJson(jsonArray, List_Person_DAO.class);
		return l.toString_AverageAge_State();
		
	}
	public String find_Population_State()
	{
		Document quenry=new Document();
		Gson gson=new Gson();
		FindIterable<Document> result=collection.find(quenry).sort(new Document("State",1));
		StringBuilder stringBuilder=new StringBuilder();
		for(Document document:result)
		{
			stringBuilder.append(document.toJson()).append(",\n");		
		}
		//Chuyển đổi cho mảng động đọc vào
		stringBuilder.deleteCharAt(stringBuilder.length()-2);
		String jsonArray="{\"listPerson\":["+stringBuilder+"]}";
		//Chuyển thành mảng động
		List_Person_DAO l=gson.fromJson(jsonArray, List_Person_DAO.class);
		return l.toString_Population_State();
		
	}
}
