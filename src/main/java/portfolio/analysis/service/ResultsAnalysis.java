package portfolio.analysis.service;

import java.util.Collections;
import java.util.List;

import portfolio.analysis.model.ResultsSummary;

public class ResultsAnalysis {

	List<Double> results;
	ResultsSummary summary;

	public void setResults(List<Double> results) {
		this.results = results;
		Collections.sort(this.results);
	}

	public Double getMedian() {
		// throw exception if empty
		return results.get(results.size() / 2);
	}

	public Double getNthPercentile(double percentile) {
		// throw exception if empty
		// validate percentile is in range
		Math.min(100,  Math.max(0, percentile));

		int index = (int) ((results.size() - 1) * percentile / 100);
		return results.get(index);
	}

	public ResultsSummary getResultSummary() {
		summary = new ResultsSummary()
				.setMedian(getMedian())
				.setBottom10thPercentile(getNthPercentile(10))
				.setTop10thPercentile(getNthPercentile(90));
		return summary;
	}

}
