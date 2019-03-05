package portfolio.analysis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;
import portfolio.analysis.model.SimulationRequest;

@RunWith(SpringJUnit4ClassRunner.class)
public class SimulationRequestTest extends TestCase {

	private SimulationRequest request;
	private Portfolio portfolio;
	private List<Portfolio> portfolios;
	private ValidatorFactory validatorFactory;
	private Validator validator;

	@After
	public void tearDown() {
		validatorFactory.close();
	}

	@Before
	public void setup() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();

		portfolio = ConfigurationGenerator.getValidPorfolio();
		portfolios = new ArrayList<Portfolio>();
		portfolios.add(portfolio);

		this.request = new SimulationRequest()
		.setPortfolios(portfolios);
	}

	@Test
	public void test_valid() {
		Set<ConstraintViolation<SimulationRequest>> violations = validator.validate(request);
		assertEquals(0, violations.size());
	}

	@Test
	public void test_annual_return_validation() {
		Set<ConstraintViolation<SimulationRequest>> violations;

		portfolio.setAnnualReturn(null);
		violations = validator.validate(request);
		assertEquals(1, violations.size());
	}

	@Test
	public void test_annual_risk_validation() {
		Set<ConstraintViolation<SimulationRequest>> violations;

		portfolio.setAnnualRisk(null);
		violations = validator.validate(request);
		assertEquals(1, violations.size());

		portfolio.setAnnualRisk(-0.01);
		violations = validator.validate(request);
		assertEquals(1, violations.size());
	}

	@Test
	public void test_initial_investment_validation() {
		Set<ConstraintViolation<SimulationRequest>> violations;

		portfolio.setInitialInvestment(null);
		violations = validator.validate(request);
		assertEquals(1, violations.size());

		portfolio.setInitialInvestment(0.0);
		violations = validator.validate(request);
		assertEquals(1, violations.size());
	}

}
