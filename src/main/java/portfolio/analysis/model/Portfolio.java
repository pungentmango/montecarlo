package portfolio.analysis.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * a portfolio to analyze. Includes inputs:
 * <ul>
 * <li>initialInvestment: amount in portfolio at year
 * <li>annualReturn: expected annual return rate for the portfolio
 * <li>annualRisk: the variation in expected annual return rate for the
 * portfolio
 * </ul>
 * 
 * @author Jacob
 *
 */
public class Portfolio {

	@NotNull(message = "portfolio name must be provided")
	private String portfolioName;

	@NotNull(message = "annual return must be provided")
	private Double annualReturn;

	@NotNull(message = "annual risk must be provided")
	@DecimalMin(value = "0.00")
	private Double annualRisk;

	@NotNull(message = "initial investment amount must be provided")
	@DecimalMin(value = "0.01")
	private Double initialInvestment;

	public String getPortfolioName() {
		return portfolioName;
	}

	public Double getAnnualReturn() {
		return annualReturn;
	}

	public Double getAnnualRisk() {
		return annualRisk;
	}

	public Double getInitialInvestment() {
		return initialInvestment;
	}

	public Portfolio setAnnualReturn(Double annualReturn) {
		this.annualReturn = annualReturn;
		return this;
	}

	public Portfolio setAnnualRisk(Double annualRisk) {
		this.annualRisk = annualRisk;
		return this;
	}

	public Portfolio setInitialInvestment(Double initialInvestment) {
		this.initialInvestment = initialInvestment;
		return this;
	}

	public Portfolio setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
		return this;
	}

}
