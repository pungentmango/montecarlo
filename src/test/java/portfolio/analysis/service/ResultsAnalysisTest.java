package portfolio.analysis.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import portfolio.analysis.model.ResultsSummary;

@RunWith(SpringJUnit4ClassRunner.class)
public class ResultsAnalysisTest {

	List<Double> results = new ArrayList<>();

	private ResultsAnalysis analysis = new ResultsAnalysis();

	private int size = 19;

	@Before
	public void setup() {
		setResultsToSize(size);
	}

	private void setResultsToSize(int size) {
		for (int i = 0; i < size; i++) {
			results.add(Double.valueOf(i));
		}
	}

	@Test
	public void test_median() {
		analysis.setResults(results);
		assertEquals(Double.valueOf((size - 1) / 2), analysis.getMedian());
	}

	@Test
	public void test_nth_percentile() {
		analysis.setResults(results);
		assertEquals(new Double(0), analysis.getNthPercentile(0));
		assertEquals(new Double(0), analysis.getNthPercentile(-1));
		assertEquals(new Double(size - 1), analysis.getNthPercentile(100));
		assertEquals(new Double(size - 1), analysis.getNthPercentile(101));
		assertEquals(new Double((size - 1) / 2), analysis.getNthPercentile(50));
		assertEquals(new Double(90 * (size - 1) / 100), analysis.getNthPercentile(90));
	}

	@Test
	public void test_results_summary() {
		analysis.setResults(results);
		ResultsSummary summary = analysis.getResultSummary();
		assertEquals(new Double((size - 1) / 2), summary.getMedian());
		assertEquals(new Double(10 * (size - 1) / 100), summary.getBottom10thPercentile());
		assertEquals(new Double(90 * (size - 1) / 100), summary.getTop10thPercentile());

	}

}
