# montecarlo
This program creates a server that runs monte carlo simulations for a list of portfolios using the Spring Boot framework. The container is now containerized

### Building and running the application using Docker
When you're ready, start the application by running:
`docker compose up --build`.

Your application will be available at http://localhost:8080.

## simulation configuration
The simulation is configured to run 10,000 simulation for a 20 year period, assuming an annual inflation of 3.5%.
To change these configurations, alter the properties in the appliation.properties file.

## making requests to the server
Once the server is up, make POST requests to localhost:8080/analysis/montecarlo
An example POST request using curl is given below:

<pre>
curl -X POST \
  http://localhost:8080/analysis/montecarlo \
  -H 'Content-Type: application/json' \
  -d '{
	"portfolios":
	[
		{
			"portfolioName": "test porfolio",
			"annualReturn": 10.12,
			"annualRisk": 7.521,
			"initialInvestment": 1000
		},
    {
			"portfolioName": "test porfolio 2",
			"annualReturn": 6.5,
			"annualRisk": 5.523,
			"initialInvestment": 5000
		}
	]
}'

</pre>

The server will return the simulation output as a response.