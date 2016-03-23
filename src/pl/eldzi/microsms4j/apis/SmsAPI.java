package pl.eldzi.microsms4j.apis;

import pl.eldzi.microsms4j.apis.builder.SmsBuilder;

public class SmsAPI {

	
	public SmsBuilder create() {
		return new SmsBuilder();
	}

}
