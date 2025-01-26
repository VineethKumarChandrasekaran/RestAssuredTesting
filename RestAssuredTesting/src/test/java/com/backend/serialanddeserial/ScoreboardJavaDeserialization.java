package com.backend.serialanddeserial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ScoreboardJavaDeserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
	FileInputStream fis = new FileInputStream("./fos.txt");
	ObjectInputStream obj = new ObjectInputStream(fis);
	Cricket userobj = (Cricket) obj.readObject();
     System.out.println(userobj.playername);
     System.out.println(userobj.score);
     System.out.println(userobj.century);
     System.out.println(userobj.wicket);
	}

}
