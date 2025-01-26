package com.backend.serialanddeserial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Cricket implements Serializable{
	String playername;
	long score;
	int century;
	int wicket;
	public Cricket(String playername, long score, int century, int wicket) {
		super();
		this.playername = playername;
		this.score = score;
		this.century = century;
		this.wicket = wicket;
	}
}

public class ScoreboardJavaSerialization {

	public static void main(String[] args) throws IOException {
		Cricket userobj = new Cricket("Vineeth",12000,25,170);
		FileOutputStream fos = new FileOutputStream("./fos.txt");
		ObjectOutputStream obj = new ObjectOutputStream(fos);
		obj.writeObject(userobj);
		System.out.println("====Updated====");
	}
}

