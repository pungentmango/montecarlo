package portfolio.analysis.model;

/**
 * Container class for simulation results
 * 
 * @author Jacob
 *
 */
public class ResultsSummary {
	String portfolioName;
	Double median;
	Double top10thPercentile;
	Double bottom10thPercentile;

	public Double getMedian() {
		return median;
	}

	public Double getTop10thPercentile() {
		return top10thPercentile;
	}

	public Double getBottom10thPercentile() {
		return bottom10thPercentile;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public ResultsSummary setMedian(Double median) {
		this.median = median;
		return this;
	}

	public ResultsSummary setTop10thPercentile(Double top10thPercentile) {
		this.top10thPercentile = top10thPercentile;
		return this;
	}

	public ResultsSummary setBottom10thPercentile(Double bottom10thPercentile) {
		this.bottom10thPercentile = bottom10thPercentile;
		return this;
	}

	public ResultsSummary setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
		return this;
	}

}
