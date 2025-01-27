package com.backend.mocking;

import org.mockito.Mockito;

class PanCard {
	public String pancardValidation(String pancard) {
		if(pancard.matches("[A-Z] {4}[0-9] {4}[A-Z]")==true) {
			return "It is a Valid PanCard";
		}else {
			return "It is an InValid PanCard";
		}
	}
	
	public static PanCard mockTest() {
		PanCard pobj = Mockito.mock(PanCard.class);
		Mockito.when(pobj.pancardValidation("ABCD1234A")).thenReturn("It is a Valid PanCard");
		Mockito.when(pobj.pancardValidation("ABCD1234A")).thenReturn("It is a Valid PanCard");
		Mockito.when(pobj.pancardValidation("ABCD1234C")).thenReturn("It is an InValid PanCard");
		 return pobj;
	}
}

public class PANCardMockTest {

	public static void main(String[] args) {
		PanCard obj = PanCard.mockTest();
		System.out.println(obj.pancardValidation("ABCD1234C"));
	}

}
