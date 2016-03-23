package pl.eldzi.microsms4j.apis.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;
import java.nio.Buffer;

import pl.eldzi.microsms4j.apis.errors.sms.Result;

public class SMS {
	private int uID, sID, num;
	private String code;
	private String url1, url2;
	private String resultCode;

	public SMS(int userid, int number, String code, int serviceid) {
		uID = userid;
		num = number;
		sID = serviceid;
		this.code = code;
		url1 = "http://microsms.pl/api/check.php?userid=?userid?&number=?number?&code=?code?&serviceid=?serviceid?";
		url2 = "http://microsms.pl/api/check_multi.php?userid=?userid?&code=?code?&serviceid=?serviceid?";
	}

	public int getUserID() {
		return uID;
	}

	public int getServiceID() {
		return sID;
	}

	public int getNumber() {
		return num;
	}

	public String getSMSCode() {
		return code;
	}

	public SMS(int userid, String code, int serviceid) {
		uID = userid;
		sID = serviceid;
		this.code = code;
		url1 = "http://microsms.pl/api/check.php?userid=?userid?&number=?number?&code=?code?&serviceid=?serviceid?";
		url2 = "http://microsms.pl/api/check_multi.php?userid=?userid?&code=?code?&serviceid=?serviceid?";
	}

	public void setUserID(int userID) {
		uID = userID;
	}

	public void setServiceID(int serviceID) {
		sID = serviceID;
	}

	public void setNumber(int number) {
		num = number;
	}

	public void setSMSCode(String code) {
		this.code = code;
	}

	public Result send() throws ConnectException {
		try {
			URL url;
			if (num == 0)
				url = new URL(url2.replace("?userid?", String.valueOf(getUserID()))
						.replace("?serviceid?", String.valueOf(getServiceID())).replace("?code?", getSMSCode()));
			else
				url = new URL(url1.replace("?userid?", String.valueOf(getUserID()))
						.replace("?number?", String.valueOf(getNumber()))
						.replace("?serviceid?", String.valueOf(getServiceID())).replace("?code?", getSMSCode()));

			BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()));
			String tt = r.readLine().toUpperCase().replaceAll("\\s", "");
			Result result = new Result(tt);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ConnectException("B³ad po³¹czenia");
		}
	}
}
