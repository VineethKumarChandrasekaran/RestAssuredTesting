package com.backend.practice;

import org.testng.annotations.Test;

import com.backend.testing.StaticImport;

public class StaticImportRun {

	@Test
	public void run() {
		StaticImport.post();
		StaticImport.get();
		StaticImport.delete();
	}

}
