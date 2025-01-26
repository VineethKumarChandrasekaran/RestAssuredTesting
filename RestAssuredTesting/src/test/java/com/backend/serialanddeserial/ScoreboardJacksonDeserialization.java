package com.backend.serialanddeserial;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScoreboardJacksonDeserialization {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
	
		ObjectMapper objectmapper = new ObjectMapper();
		CricketScore cobj = objectmapper.readValue(new File("./fos.json"), CricketScore.class);
        System.out.println(cobj.getPlayername());
        System.out.println(cobj.getScore());
        System.out.println(cobj.getCentury());
        System.out.println(cobj.getWicket());
	}

}
