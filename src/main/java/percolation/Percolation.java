package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    // init N
    private final int n;

    // percolation matrix, false - blocked, true - opened
    private boolean[][] a;

    // number of opened sites
    private int openSites = 0;

    private final WeightedQuickUnionUF quickUnion;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        this.n = n;
        a = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = false;
            }
        }
        quickUnion = new WeightedQuickUnionUF(n * n + 2);
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row);
        validate(col);

        // mark the site as opened
        a[row][col] = true;
        // number of open sites
        openSites++;

        // union (connect) virtual top (0,0) with site from 1st row and virtual bottom (1,0) with site from the last row
        if (row == 1) quickUnion.union(xyTo1D(row, col), xyTo1D(0, 0));
        if (row == n) quickUnion.union(xyTo1D(row, col), xyTo1D(1, 0));

        // union (connect) neighbor sites
        if (row - 1 != 0 && a[row - 1][col]) quickUnion.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        if (row + 1 != n + 1 && a[row + 1][col]) quickUnion.union(xyTo1D(row, col), xyTo1D(row + 1, col));
        if (col - 1 != 0 && a[row][col - 1]) quickUnion.union(xyTo1D(row, col), xyTo1D(row, col - 1));
        if (col + 1 != n + 1 && a[row][col + 1]) quickUnion.union(xyTo1D(row, col), xyTo1D(row, col + 1));
    }

    private void validate(int i) {
        if (i <= 0 || i > n) throw new IllegalArgumentException("row index i out of bounds");
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row);
        validate(col);
        return a[row][col];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row);
        validate(col);
        return quickUnion.connected(xyTo1D(0, 0), xyTo1D(row, col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        // check if virt top connected with virtual bottom site
        return quickUnion.connected(xyTo1D(0, 0), xyTo1D(1, 0));
    }

    // convert (x,y) point to 1-D number used in quick-union
    private int xyTo1D(int row, int col) {
        if (row == 0 && col == 0) return 0;
        if (row == 1 && col == 0) return n * n + 1;
        return (row - 1) * n + col;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 1);
        System.out.println("Number of opened sites: " + percolation.numberOfOpenSites());
        System.out.println("(1, 1): " + percolation.percolates());
//        System.out.println(percolation.quickUnion.connected(percolation.xyTo1D(0, 0), percolation.xyTo1D(1, 1)));
        percolation.open(2, 1);
        System.out.println("Number of opened sites: " + percolation.numberOfOpenSites());
        System.out.println("(1, 2): " + percolation.percolates());
        percolation.open(3, 1);
        System.out.println("Number of opened sites: " + percolation.numberOfOpenSites());
        System.out.println("(1, 3): " + percolation.percolates());
    }
}
