package com.backend.encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncodedAndDecoded {
	
	@Test
	public void encodeanddecode() {
		String encodeddata = new String(Base64.getEncoder().encode("Vineeth Kumar C".getBytes()));
		System.out.println(encodeddata);
		String decodedata = new String(Base64.getDecoder().decode(encodeddata.getBytes()));
		System.out.println(decodedata);
	}

}
