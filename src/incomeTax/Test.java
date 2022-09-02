package incomeTax;

import java.util.Arrays;

public class Test {

    public void main(){
        IncomeTax tax = new IncomeTax();
        tax.menu();
        int[][] intervals = new int[][]{{0, 20000}, {20000, 40000}, {40000, 68000}};
        double[] rates = new double[]{0.20, 0.25, 0.38};
        IncomeTax tax2 = new IncomeTax(tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW, intervals, rates, 80000);
        System.out.println(tax2.getFilingStatus());
        System.out.println(Arrays.deepToString(tax2.getIntervals()));
        tax2.setFilingStatus(3);
        System.out.println(tax2.getFilingStatus());
        int[][] intervals2 = new int[][]{{0, 8945}, {8945, 39480}, {34980, 68000}};
        tax2.setIntervals(intervals2);
        System.out.println(Arrays.deepToString(tax2.getIntervals()));
        System.out.println(Arrays.toString(tax2.getRates()));
        double[] rates2 = new double[]{0.10, 0.18, 0.30};
        tax2.setRates(rates2);
        System.out.println(Arrays.toString(tax2.getRates()));
        System.out.println(tax2.getTaxableIncome());
        tax2.setTaxableIncome(100000);
        System.out.println(tax2.getTaxableIncome());
    }
}
