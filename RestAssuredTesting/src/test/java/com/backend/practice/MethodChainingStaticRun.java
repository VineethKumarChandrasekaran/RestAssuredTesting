package com.backend.practice;

import org.testng.annotations.Test;

import com.backend.testing.MethodChainingStatic;

public class MethodChainingStaticRun {
	
	@Test
	public void run() {
		MethodChainingStatic.post().get().delete();
	}
	
}
