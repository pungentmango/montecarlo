package portfolio.analysis.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portfolio.analysis.model.Portfolio;
import portfolio.analysis.model.ResultsSummary;
import portfolio.analysis.model.SimulationRequest;

/**
 * MonteCarloSimulationService runs the simulation for the input portfolio based
 * on the input request and simulation configuration
 * 
 * @author Jacob
 *
 */
@Service
public class MonteCarloSimulationService implements SimulationService {

	List<Double> simulationResults;
	List<AnnualAdjustment> adjustments;
	@Autowired @Valid SimulationConfiguration configuration;

	/**
	 * performs the simulations for a given portfolio configuration and runs the
	 * analysis on the results
	 */
	@Override
	public List<ResultsSummary> run(SimulationRequest request) {
		List<ResultsSummary> summary = new ArrayList<ResultsSummary>();
		for (Portfolio portfolio : request.getPortfolios()) {
			List<Double> results = runSimulation(portfolio, request).getResults();
			ResultsAnalysis analysis = new ResultsAnalysis();
			analysis.setResults(results);
			summary.add(analysis.getResultSummary().setPortfolioName(portfolio.getPortfolioName()));
		}
		return summary;
	}

	/**
	 * Initializes the annual adjustments for the simulation, which includes the
	 * investment return with the given distribution, as well as the annual
	 * inflation adjustment. and runs the specified number of trials, adding each
	 * trial to the simulation results.
	 * 
	 * The trial uses a normalized simulation, then multiplies the normalized result
	 * by the initial amount.
	 * 
	 * @param portfolio
	 * 
	 * @param configuration
	 * @return
	 */
	public MonteCarloSimulationService runSimulation(Portfolio portfolio, SimulationRequest request) {
		this.adjustments = new ArrayList<>();
		adjustments.add(new InvestmentAdjustment(portfolio.getAnnualReturn(), portfolio.getAnnualReturn()));
		adjustments.add(new InflationAdjustment(configuration.getInflationRate()));

		int numberOfTrials = configuration.getNumberOfTrials();
		simulationResults = new ArrayList<>(numberOfTrials);

		for (int trial = 0; trial < numberOfTrials; trial++) {
			simulationResults.add(portfolio.getInitialInvestment() * runTrial(new Double(1.0)));
		}
		return this;
	}

	/**
	 * run a single trial for the number of years specified multiplies the initial
	 * amount by all of the adjustments for the year that is, gains and losses due
	 * to investment returns and inflation
	 * 
	 * @param input: the initial value of the portfolio
	 * @return
	 */
	double runTrial(double input) {
		for (int year = 0; year < configuration.getNumberOfYears(); year++) {
			input = calculateNextYear(input);
		}
		return input;
	}

	/**
	 * calculates a year of the simulation
	 * 
	 * @param startValue: the value of the portfolio at the start of the year
	 * @return endValue: the value of the portfolio at the end of the year
	 */
	double calculateNextYear(double startValue) {
		double endValue = startValue;
		for (AnnualAdjustment adjustment : adjustments) {
			endValue *= adjustment.getValue();
		}
		return endValue;
	}

	public List<Double> getResults() {
		return this.simulationResults;
	}

}
