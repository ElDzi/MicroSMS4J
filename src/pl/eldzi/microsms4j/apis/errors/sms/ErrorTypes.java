package pl.eldzi.microsms4j.apis.errors.sms;

import pl.eldzi.microsms4j.exceptions.NotFoundErrorException;

public enum ErrorTypes {
	E_0("Brak parametr�w w linku"), E_1("Nieprawid�owy format kodu"), E_2("Brak partnera b�dz us�ugi"), E_3(
			"Numer SMS nieprawid�owy");
	private String message;

	private ErrorTypes(String msg) {
		message = msg;
	}

	public String getErrorMessage() {
		return message;
	}

	public static ErrorTypes fromString(String err) throws NotFoundErrorException {
		for (ErrorTypes t : ErrorTypes.values()) {
			if (t.name().replace("_", ",").equals(err.toUpperCase())) {
				return t;
			}
		}
		throw new NotFoundErrorException("B��d nie zosta� odnaleziony");
	}
}
