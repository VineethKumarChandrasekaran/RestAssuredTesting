package com.backend.testing;

public class MethodChainingNoStatic {
	
	public MethodChainingNoStatic  post() {
		System.out.println("POST Method");
		return new MethodChainingNoStatic();
	}
	
	public MethodChainingNoStatic  get() {
		System.out.println("GET Method");
		return new MethodChainingNoStatic();
	}
	
	public MethodChainingNoStatic  delete() {
		System.out.println("DELETE Method");
		return new MethodChainingNoStatic();
	}

}

