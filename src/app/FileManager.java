package app;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.HashMap;
import java.util.Map;


public class FileManager {

	public static void saveAnUserInFile(User temporary) {
		
//		HashMap<String, User> aux = new HashMap<String, User>();
//		
//		aux.put(temporary.getUser(), temporary);
//		
//		BufferedWriter bf = null;
		
		//Aca guardamos el usuario en el archivo
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		
		File file = new File("users.bin");
		
		try {
			
			if(!file.exists()) {
				
				fileOutputStream = new FileOutputStream(file);
				objectOutputStream = new MyObjectOutputStream(fileOutputStream);
				
			} else {
				
				fileOutputStream = new FileOutputStream(file, true);
				objectOutputStream = new MyObjectOutputStream(fileOutputStream);
			}
			
//			// create new BufferedWriter for the output file
//            bf = new BufferedWriter(new FileWriter(file));
//  
//            // iterate map entries
//            for (Map.Entry<String, User> entry : aux.entrySet()) {
//	  
//	            // put key and value separated by a colon
//	            bf.write(entry.getKey() + ":" + entry.getValue());
//	            
//	            bf.
//	  
//	            // new line
//	            bf.newLine();
//            }
//  
//            bf.flush();
			
			objectOutputStream.writeObject(temporary);
			
			
//			FileOutputStream fileOutputStream = new FileOutputStream("users.bin", true); //Con el true podemos cargar usuarios al final
//			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//			
//			objectOutputStream.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
//			try {
//				bf.close();
//			}catch(Exception e) {
//				
//			}
			
			if(objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch(IOException e) {
					System.out.println("Error al cerrar el achivo");
				}
			}
			
			if(fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch(IOException e) {
					System.out.println("Error al cerrar el achivo");
				}
			}
		}
	}
	
	public static HashMap<String, User> readAndUploadUsersFileToHashmap() throws StreamCorruptedException
	{
		 
		HashMap<String, User> temporaryHM = new HashMap<>(); //HashMap temporal
		User aux;
		
		try 
		{
			
			FileInputStream fileInputStream = new FileInputStream("users.bin");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			int lecture = 1;
			
			while(fileInputStream.available() != 0)
			{
				
				aux = (User)objectInputStream.readObject();
				System.out.println(aux);
				temporaryHM.put(aux.getUser(), aux);
				
			}
			
			objectInputStream.close();
			fileInputStream.close();

		} catch (EOFException e) {
			
			System.out.println("Fin archivo");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Error");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return temporaryHM;
	}
}
