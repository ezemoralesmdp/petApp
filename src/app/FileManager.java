package app;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;


public class FileManager {

	public static void saveAnUserInFile(User temporary) {
		
		//Aca guardamos el usuario en el archivo
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("users.bin");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(temporary);
			objectOutputStream.close();
		
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static HashMap<String, User> readAndUploadUsersFileToHashmap()
	{
		 
		HashMap<String, User> temporaryHM = new HashMap<>();
		try {
			FileInputStream fileInputStream = new FileInputStream("users.bin");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
	
			int lecture=1;
			while(lecture==1)
			{
				User aux = (User)objectInputStream.readObject();
//				System.out.println(aux);
				
				
				temporaryHM.put(aux.getUser(), aux);
				
			}
			objectInputStream.close();

			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temporaryHM;
		
	}
	
	
	
}
