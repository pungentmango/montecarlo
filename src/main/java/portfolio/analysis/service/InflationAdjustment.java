package portfolio.analysis.service;

/**
 * annual inflation adjustment for a portfolio
 * @author Jacob
 *
 */
public class InflationAdjustment implements AnnualAdjustment {

	private Double inflationRate;
	
	public InflationAdjustment(Double inflationRate) {
		this.inflationRate = inflationRate;
	}
	
	@Override
	public Double getValue() {
		return 100.0 / (100.0 + inflationRate);
	}

}
