package portfolio.analysis.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import portfolio.analysis.model.Portfolio;
import portfolio.analysis.model.SimulationRequest;

@RunWith(SpringJUnit4ClassRunner.class)
public class MonteCarloSimulationServiceTest {

	@Mock
	SimulationRequest request;
	@Mock
	Portfolio portfolio;
	List<Portfolio> portfolios;

	@Mock
	SimulationConfiguration configuration;
	@Spy @InjectMocks
	private MonteCarloSimulationService simulator;

	private static final int years = 3;
	private static final int trials = 10;

	@Before
	public void setup() {

		when(portfolio.getAnnualReturn()).thenReturn(1.0);
		when(portfolio.getAnnualRisk()).thenReturn(1.0);
		when(portfolio.getInitialInvestment()).thenReturn(1000.0);
		when(portfolio.getPortfolioName()).thenReturn("test portfolio");

		portfolios = new ArrayList<>();
		portfolios.add(portfolio);
		when(request.getPortfolios()).thenReturn(portfolios);

		when(configuration.getInflationRate()).thenReturn(0.0);
		when(configuration.getNumberOfTrials()).thenReturn(trials);
		when(configuration.getNumberOfYears()).thenReturn(3);
	}

	@Test
	public void test_run() {
		simulator.run(request);
		List<Double> results = simulator.getResults();
		assertEquals(trials, results.size());

		verify(simulator, times(trials)).runTrial(anyDouble());
		verify(simulator, times(trials * years)).calculateNextYear(anyDouble());
	}

}
