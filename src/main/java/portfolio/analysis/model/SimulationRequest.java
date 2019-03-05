package portfolio.analysis.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Input configuration request for a Monte Carlo Simulation:
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
public class SimulationRequest {

	@Valid
	List<Portfolio> portfolios;

	public List<Portfolio> getPortfolios() {
		return portfolios;
	}

	public SimulationRequest setPortfolios(List<Portfolio> portfolios) {
		this.portfolios = portfolios;
		return this;
	}

}
