package portfolio.analysis.service;

/**
 * annual investment adjustment for a portfolio
 * @author Jacob
 *
 */
public class InvestmentAdjustment implements AnnualAdjustment {

	GaussianRandomGenerator generator;
	
	InvestmentAdjustment( Double annualReturn, Double annualRisk) {
		generator = new GaussianRandomGenerator(annualReturn, annualRisk);
	}
	
	@Override
	public Double getValue() {
		return (100.0 + generator.getNext()) / 100.0;
	}

}
