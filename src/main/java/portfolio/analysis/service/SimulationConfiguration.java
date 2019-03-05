package portfolio.analysis.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * configuration for the monte carlo simulator. 
 * values are configured in application.properties file
 * @author Jacob
 *
 */
@Configuration
public class SimulationConfiguration {
	@NotNull(message = "inflation rate must be provided.")
	@Value("${default.inflation.rate}")
	private Double inflationRate;

	@NotNull(message = "number of years for the simulation must be provided")
	@Min(value = 1, message = "must simulate for at least one year")
	@Max(value = 1000, message = "simulation can only run for up to 100 years")
	@Value("${default.simulation.years}")
	private Integer numberOfYears;

	@NotNull(message = "number of trials must be provided.")
	@Min(value = 1, message = "must simulate for at least one trial")
	@Max(value = 1000000, message = "simulation can only run up to 1,000,000 trials")
	@Value("${default.simulation.trials}")
	private Integer numberOfTrials;

	public Integer getNumberOfYears() {
		return numberOfYears;
	}

	public Double getInflationRate() {
		return inflationRate;
	}

	public Integer getNumberOfTrials() {
		return numberOfTrials;
	}

	public SimulationConfiguration setInflationRate(Double inflationRate) {
		this.inflationRate = inflationRate;
		return this;
	}

	public SimulationConfiguration setNumberOfYears(Integer numberOfYears) {
		this.numberOfYears = numberOfYears;
		return this;
	}

	public SimulationConfiguration setNumberOfTrials(Integer numberOfTrials) {
		this.numberOfTrials = numberOfTrials;
		return this;
	}

}
