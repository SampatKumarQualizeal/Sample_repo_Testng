/**
 * 
 */
package testobjects;

/**
 * Pre-Payment Methods
 * 
 * @author aditya.joshi
 *
 */
public enum PrePaymentMethods_PublicAdmin {

	CHECK("Check"), CREDIT_CARD("Credit Card, Purchase Card");

	public enum Reciept {

		CDR2("CDR2"), COMPANY_CHECK2("COMPANY CHECK2"), CREDITCARD3("CREDITCARD3"), LOCKBOX_CHECKS("LOCKBOX CHECKS"),
		PERSONAL_CHECK2("PERSONAL CHECK2"), RECEIPT("RECEIPT"), UNIDENTIFIED_WIRE("UNIDENTIFIED WIRE"), WIRE3("WIRE3");

		private final String method;

		Reciept(String methodName) {
			method = methodName;
		}

		public String toString() {
			return this.method;
		}
	}

	private final String method;

	PrePaymentMethods_PublicAdmin(String methodName) {
		method = methodName;
	}

	public String toString() {
		return this.method;
	}

}

/*
 * enum PrePaymentReciept_PublicAdmin{
 * 
 * CDR2("CDR2"), COMPANY_CHECK2("COMPANY CHECK2"), CREDITCARD3("CREDITCARD3"),
 * LOCKBOX_CHECKS("LOCKBOX CHECKS"), PERSONAL_CHECK2("PERSONAL CHECK2"),
 * RECEIPT("RECEIPT"), UNIDENTIFIED_WIRE("UNIDENTIFIED WIRE"), WIRE3("WIRE3");
 * 
 * private final String method;
 * 
 * PrePaymentReciept_PublicAdmin(String methodName) { method = methodName; }
 * 
 * public String toString() { return this.method; } }
 */
