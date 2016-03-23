package pl.eldzi.microsms4j;

import pl.eldzi.microsms4j.apis.PaySafeCardAPI;
import pl.eldzi.microsms4j.apis.SmsAPI;

public class MicroSmsAPI {
	private static SmsAPI smsapi;
	private static PaySafeCardAPI pscapi;

	/**
	 * Returns an SmsAPI class where we can build sms connection
	 * <p>
	 * Default method of this API
	 * 
	 * @see SmsAPI
	 * 
	 * @return SmsAPI class
	 */
	public static SmsAPI getSmsAPI() {
		return smsapi;
	}

	/**
	 * NOT-SUPPORTED
	 * 
	 * @return PaySafeCardAPI
	 */
	@Deprecated
	public static PaySafeCardAPI getPaySafeCardAPI() {
		return pscapi;
	}

	static {
		smsapi = new SmsAPI();
		pscapi = new PaySafeCardAPI();
	}
}
