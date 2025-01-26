package com.backend.practice;

import org.testng.annotations.Test;

import com.backend.testing.MethodChainingNoStatic;

public class MethodChainingNonStaticRun {
	
	@Test
	public void run() {
		MethodChainingNoStatic methodchaning = new MethodChainingNoStatic();
		methodchaning.post().get().delete();
	}
	
}
