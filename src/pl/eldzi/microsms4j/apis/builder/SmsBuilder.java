package pl.eldzi.microsms4j.apis.builder;

import pl.eldzi.microsms4j.apis.sms.SMS;
import pl.eldzi.microsms4j.exceptions.NotFoundErrorException;

public class SmsBuilder {
	public SmsBuilder() {
	}

	private int uid, sid, nr;
	private String code;

	public SmsBuilder setUserID(int userid) {
		uid = userid;
		return this;
	}

	public SmsBuilder setServiceID(int serviceid) {
		sid = serviceid;
		return this;
	}

	public SmsBuilder setNumber(int number) {
		nr = number;
		return this;
	}

	public SmsBuilder setSmsCode(String code) {
		this.code = code;
		return this;
	}

	public SMS build() throws NotFoundErrorException {
		if (uid == 0)
			throw new NotFoundErrorException("Wartosc 'userid' jest pusta");
		if (sid == 0)
			throw new NotFoundErrorException("Wartosc 'serviceid' jest pusta");
		if (code.equals(""))
			throw new NotFoundErrorException("Wartosc 'code' jest pusta");

		if (nr == 0)
			return new SMS(uid, code, sid);
		else
			return new SMS(uid, nr, code, sid);
	}

}
