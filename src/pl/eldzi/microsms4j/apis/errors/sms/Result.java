package pl.eldzi.microsms4j.apis.errors.sms;

import pl.eldzi.microsms4j.exceptions.NotFoundErrorException;

public class Result {

	public enum ResultType {
		DENY, ALLOW;
	}

	private ResultType rType;
	private String reCode;
	private String pMsg;

	public Result(String resultCode) {
		reCode = resultCode;
		pMsg = "";
		setup();
	}

	public boolean isDone() {
		return rType == ResultType.ALLOW;
	}

	public boolean isError() {
		return pMsg != "Kod prawid³owy";
	}

	public String getProcessMessage() {
		return pMsg;
	}

	public String getConnectionResult() {
		return reCode;
	}

	private void setup() {
		String[] s = reCode.split(",");
		if (s.length == 3) {
			int f = Integer.parseInt(s[0]);
			if (f == 1) {
				rType = ResultType.ALLOW;
				pMsg = "Kod prawid³owy";
			} else {
				pMsg = "Kod nieprawid³owy";
			}
		} else if (s.length == 2) {
			try {
				ErrorTypes type = ErrorTypes.fromString(reCode);
				pMsg = type.getErrorMessage();
			} catch (NotFoundErrorException e) {
				pMsg = "B³¹d nieznany";
			}
		} else {
			pMsg = "B³¹d nieznany";

		}
		if (isError())
			rType = ResultType.DENY;

	}

}
