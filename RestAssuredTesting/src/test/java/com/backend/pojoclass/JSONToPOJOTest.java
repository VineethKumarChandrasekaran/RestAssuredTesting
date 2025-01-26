package com.backend.pojoclass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project {
	   String projectName;
	   String projectStatus;
	   int teamSize;
	   List<String> teamMember;
	   ProjectManager projectManager;
	   
	   public Project() {}

	    public Project(String projectName, String projectStatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}
	    
		public void setProjectName(String projectName) {
	        this.projectName = projectName;
	    }
	    public String getProjectName() {
	        return projectName;
	    }
	    
	    public void setProjectStatus(String projectStatus) {
	        this.projectStatus = projectStatus;
	    }
	    public String getProjectStatus() {
	        return projectStatus;
	    }
	    
	    public void setTeamSize(int teamSize) {
	        this.teamSize = teamSize;
	    }
	    public int getTeamSize() {
	        return teamSize;
	    }
	    
	    public void setTeamMember(List<String> teamMember) {
	        this.teamMember = teamMember;
	    }
	    public List<String> getTeamMember() {
	        return teamMember;
	    }
	    
	    public void setProjectManager(ProjectManager projectManager) {
	        this.projectManager = projectManager;
	    }
	    public ProjectManager getProjectManager() {
	        return projectManager;
	    }
	    
	}

class ProjectManager {
	   String name;
	   int empID;

	   public ProjectManager() {}
	   
	    public ProjectManager(String name, int empID) {
		super();
		this.name = name;
		this.empID = empID;
	}
		public void setName(String name) {
	        this.name = name;
	    }
	    public String getName() {
	        return name;
	    }
	    
	    public void setEmpID(int empID) {
	        this.empID = empID;
	    }
	    public int getEmpID() {
	        return empID;
	    }
	    
	}

public class JSONToPOJOTest {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		List<String>teamMember = new ArrayList<String>();
		teamMember.add("John");
		teamMember.add("Thomas");
		teamMember.add("Aurthor");
		
		ProjectManager projectmanager = new ProjectManager("Shelby",1001);
		
		Project project = new Project("TEK_999","Created",10,teamMember,projectmanager);
		ObjectMapper objectmapper = new ObjectMapper();
		objectmapper.writeValue(new File("./Project.json"), project);
		System.out.println("====Done====");
	}

}
