package assignments.ch1_percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_CONST = 1.96d;
    private final double numberOfExperiments;
    private final double mean;
    private final double stddev;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        numberOfExperiments = (double) trials;
        // initialize results (p*) array
        double[] results = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
                int row = StdRandom.uniform(1, n+1);
                int col = StdRandom.uniform(1, n+1);
                if (!perc.isOpen(row, col))
                    perc.open(row, col);
            }
            results[i] = (double) perc.numberOfOpenSites() / (n * n);
        }
        mean = StdStats.mean(results);
        stddev = StdStats.stddev(results);
    }

    // sample mean of assignment1_percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of assignment1_percolation threshold
    public double stddev() {
        return stddev;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - CONFIDENCE_CONST * stddev / Math.sqrt(numberOfExperiments);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + CONFIDENCE_CONST * stddev / Math.sqrt(numberOfExperiments);
    }

    // test client (described below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, trials);
        System.out.println("mean \t\t\t\t\t" + "= " + stats.mean());
        System.out.println("stddev \t\t\t\t\t" + "= " + stats.stddev());
        System.out.println("95% confidence interval " + "= [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
//        Arrays.stream(stats.results).forEach(result -> System.out.print(result + " "));
    }
}