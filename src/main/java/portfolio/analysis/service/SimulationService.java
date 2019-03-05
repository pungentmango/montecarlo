package portfolio.analysis.service;

import java.util.List;

import portfolio.analysis.model.ResultsSummary;
import portfolio.analysis.model.SimulationRequest;

public interface SimulationService {

	public List<ResultsSummary> run(SimulationRequest configuration);

}
