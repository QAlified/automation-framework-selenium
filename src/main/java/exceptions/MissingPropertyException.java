package exceptions;

public class MissingPropertyException extends Exception {


	public MissingPropertyException(String parName) {
		super("Property param not found: '" + parName + "'");
	}

}
