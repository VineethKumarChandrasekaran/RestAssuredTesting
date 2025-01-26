package com.backend.pojoclass;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class POJOToJSONTest {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		ObjectMapper objectmapper = new ObjectMapper();
		Project project = objectmapper.readValue(new File("./Project.json"), Project.class);
        System.out.println(project.projectName);
        System.out.println(project.projectStatus);
        System.out.println(project.teamSize);
        System.out.println(project.teamMember);
	}

}
