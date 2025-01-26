package com.backend.testing;

public class MethodChainingStatic {
	
	public static MethodChainingStatic  post() {
		System.out.println("POST Method");
		return new MethodChainingStatic();
	}
	
	public static MethodChainingStatic  get() {
		System.out.println("GET Method");
		return new MethodChainingStatic();
	}
	
	public static MethodChainingStatic  delete() {
		System.out.println("DELETE Method");
		return new MethodChainingStatic();
	}

}

