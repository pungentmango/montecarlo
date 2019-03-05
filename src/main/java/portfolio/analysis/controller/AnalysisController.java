package portfolio.analysis.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import portfolio.analysis.model.ResultsSummary;
import portfolio.analysis.model.SimulationRequest;
import portfolio.analysis.service.SimulationService;

@RestController
public class AnalysisController {

	@Autowired SimulationService simulationService;
	
	/**
	 * runs a Monte Carlo simulation on the given input portfolio
	 * @param configuration specifies the properties
	 * @see SimulationRequest
	 * @return a summary of the simulation
	 */
	@RequestMapping(method=RequestMethod.POST, value="/analysis/montecarlo")
	public List<ResultsSummary> analyzeMonteCarlo(@RequestBody @Valid SimulationRequest configuration) {
		return simulationService.run(configuration);
	}
	
	
}
