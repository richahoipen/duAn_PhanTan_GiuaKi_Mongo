package starting_Thread;

import thread_MongoDB.Thread_FindAll;
import thread_MongoDB.Thread_ToJSON;

public class Thread_Testing {

	public static void main(String[] args) 
	{
		Thread_ToJSON readToJson=new Thread_ToJSON();
        Thread threadToJson = new Thread(readToJson);
        threadToJson.start();
		
		Thread_FindAll findAll=new Thread_FindAll();
		Thread threadMongGo = new Thread(findAll);
		threadMongGo.run();
        
	}

}
