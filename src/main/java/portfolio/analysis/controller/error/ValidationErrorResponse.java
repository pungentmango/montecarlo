package portfolio.analysis.controller.error;

import java.util.ArrayList;
import java.util.List;

/**
 * Container class for any request validation errors
 * @author Jacob
 *
 */
public class ValidationErrorResponse {
	
	List<Violation> violations;
	
	public ValidationErrorResponse() {
		violations = new ArrayList<>();
	}
	
	public List<Violation> getViolations() {
		return this.violations;
	}

}
