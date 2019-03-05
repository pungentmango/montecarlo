package portfolio.analysis.service;

import java.util.Random;

/**
 * Used to generate a random variable from the Gaussian distribution specified in the constructor.
 * @author Jacob
 *
 */
public class GaussianRandomGenerator {

	private double mean;
	private double sd;
	private Random random;

	GaussianRandomGenerator(double mean, double sd) {
		this.mean = mean;
		this.sd = sd;
		random = new Random();
	}

	/**
	 * @return the next random number from the specified Gaussian distribution
	 */
	public double getNext() {
		return mean + random.nextGaussian() * sd;
	}

}
