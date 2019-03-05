package portfolio.analysis.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import portfolio.analysis.model.ConfigurationGenerator;
import portfolio.analysis.model.ResultsSummary;
import portfolio.analysis.model.SimulationRequest;
import portfolio.analysis.service.SimulationService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AnalysisController.class)
public class AnalysisControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	SimulationService simulationService;

	
	@Before
	public void setup() {
		Mockito.when(simulationService.run(ArgumentMatchers.any(SimulationRequest.class)))
				.thenReturn(new ArrayList<ResultsSummary>());
	}

	@Test
	public void test_valid_request() throws Exception {
		SimulationRequest configuration = ConfigurationGenerator.getValidConfiguration();

		mockMvc.perform(post("/analysis/montecarlo").contentType("application/json")
				.content(objectMapper.writeValueAsString(configuration))).andExpect(status().isOk());
	}

	@Test
	public void test_invalid_request() throws Exception {
		SimulationRequest configuration = ConfigurationGenerator.getInvalidConfiguration();

		mockMvc.perform(post("/analysis/montecarlo").contentType("application/json")
				.content(objectMapper.writeValueAsString(configuration))).andExpect(status().isBadRequest());
	}
}
