# montecarlo
This program creates a server that runs monte carlo simulations for a list of portfolios using the Spring Boot framework.


## prerequisites:
In order to build this project, it is suggested that you have [Apache Maven](https://maven.apache.org/) installed.
You will also need [jdk version 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or later installed 

## compilation/running:
In order to compile and run the program, perform the following steps:
1. navigate to the project in cmd/bash
2. execute `mvn clean install`
3. execute `java -jar target/analysis-0.0.1-SNAPSHOT.jar`

## simulation configuration
The simulation is configured to run 10,000 simulation for a 20 year period, assuming an annual inflation of 3.5%.
To change these configurations, alter the properties in the appliation.properties file.

## making requests to the server
Once the server is up, make POST requests to localhost:8080/analysis/montecarlo
In order to make a valid POST request, you may need a utility such as [Postman](https://www.getpostman.com/)
requests must have header 'Content-type' set to 'application/json' and request body in the form:

<pre>
{
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
}
</pre>

the server will return the simulation output as a response.



