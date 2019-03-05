package portfolio.analysis.controller.error;

public class Violation {

	private String fieldName;
	private String errorMessage;

	public Violation(String fieldName, String errorMessage) {
		this.fieldName = fieldName;
		this.errorMessage = errorMessage;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
