package pl.eldzi.microsms4j.test;

import java.net.ConnectException;

import pl.eldzi.microsms4j.MicroSmsAPI;
import pl.eldzi.microsms4j.apis.SmsAPI;
import pl.eldzi.microsms4j.apis.errors.sms.Result;
import pl.eldzi.microsms4j.apis.sms.SMS;
import pl.eldzi.microsms4j.exceptions.NotFoundErrorException;

public class Test {

	public static void main(String[] args) {
		SmsAPI api = MicroSmsAPI.getSmsAPI();
		try {
			SMS sms = api.create().setServiceID(857).setSmsCode("s9b8w1d6").setNumber(7555).setUserID(49).build();
			try {
				Result r = sms.send();
				log(sms.getNumber(), sms.getServiceID(), sms.getSMSCode(), sms.getUserID(), r.getConnectionResult(),
						r.getProcessMessage(), r.isDone(), r.isError());
			} catch (ConnectException e) {
				e.printStackTrace();
			}
		} catch (NotFoundErrorException e) {
			e.printStackTrace();
		}
	}

	private static void log(Object... m) {
		for (Object s : m) {
			System.out.println(s);
		}
	}
}
