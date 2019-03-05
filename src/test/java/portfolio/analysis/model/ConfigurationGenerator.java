package portfolio.analysis.model;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationGenerator {

	public static Portfolio getValidPorfolio() {
		return new Portfolio().setAnnualReturn(1.0).setAnnualRisk(1.0).setInitialInvestment(1.0)
				.setPortfolioName("testName");
	}

	public static Portfolio getInvalidPorfolio() {
		return getValidPorfolio().setPortfolioName(null);
	}

	public static SimulationRequest getValidConfiguration() {
		List<Portfolio> portfolios = new ArrayList<Portfolio>();
		portfolios.add(getValidPorfolio());
		return new SimulationRequest().setPortfolios(portfolios);
	}

	public static SimulationRequest getInvalidConfiguration() {
		List<Portfolio> portfolios = new ArrayList<Portfolio>();
		portfolios.add(getValidPorfolio());
		portfolios.add(getInvalidPorfolio());
		return new SimulationRequest().setPortfolios(portfolios);
	}

}
