package incomeTax;

import java.text.DecimalFormat;
import java.util.Scanner;

public class IncomeTax {
    private static final Scanner sc = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private int filingStatus;
    public final int SINGLE_FILER = 0;
    public final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
    public final int MARRIED_SEPARATELY = 2;
    public final int HEAD_OF_HOUSEHOLD = 3;
    private int[][] intervals;
    private double[] rates;
    private double taxableIncome;

    public IncomeTax() {
    }

    public IncomeTax(int filingStatus, int[][] intervals, double[] rates, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.intervals = intervals;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }

    public int getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public int[][] getIntervals() {
        return intervals;
    }

    public void setIntervals(int[][] intervals) {
        this.intervals = intervals;
    }

    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public int menu() {
        int choice;

        System.out.println("-----------------------Menu-----------------------\n\n");
        System.out.println("1. Compute personal income Tax");
        System.out.println("2. Print the tax tables for taxable incomes (with range)");
        System.out.println("3. Exit");
        System.out.print("\n\nEnter your choice: ");
        choice = sc.nextInt();
        if (choice == 1) {
            double tax = getIncomeTax();
            System.out.println("Tax is: $" + df.format(tax));
        }
        if (choice == 2) {
            getIncomeTaxTable();
        }
        if (choice == 3) {
            return 0;
        } else {
            System.out.println();
            System.out.println();
            menu();
        }
        return 0;
    }

    public double getIncomeTax() {
        int status;
        double tax = 0;
        System.out.println("0 - single filer");
        System.out.println("1 - married jointly or qualifying widow(er)");
        System.out.println("2 - married separately");
        System.out.println("3 - head of household");
        System.out.print("Enter the filing status: ");
        status = sc.nextInt();

        switch (status) {
            case 0 -> {
                System.out.print("Enter the Taxable Income: ");
                int income = sc.nextInt();
                this.rates = new double[]{0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
                this.intervals = new int[][]{{0, 8350}, {8350, 33950}, {33950, 82250}, {82250, 171550}, {171550, 372950}, {0, 372950}};
                for (int i = 0; i < this.rates.length; i++) {
                    int j = 0;
                    int k = 0;
                    if (intervals[i][j] > income) {
                        break;
                    }
                    tax += calculateTax(income, rates[i], intervals[i][j], intervals[i][k + 1]);

                }

            }
            case 1 -> {
                System.out.print("Enter the Taxable Income: ");
                int income = sc.nextInt();
                this.rates = new double[]{0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
                this.intervals = new int[][]{{0, 16700}, {16700, 67900}, {67901, 137050}, {137050, 208850}, {208850, 372950}, {0, 372950}};
                for (int i = 0; i < this.rates.length; i++) {
                    int j = 0;
                    int k = 0;
                    if (intervals[i][j] > income) {
                        break;
                    }
                    tax += calculateTax(income, rates[i], intervals[i][j], intervals[i][k + 1]);

                }

            }
            case 2 -> {
                System.out.print("Enter the Taxable Income: ");
                int income = sc.nextInt();
                this.rates = new double[]{0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
                this.intervals = new int[][]{{0, 8350}, {8350, 33950}, {33950, 68525}, {68525, 104425}, {104425, 186475}, {0, 186475}};
                for (int i = 0; i < this.rates.length; i++) {
                    int j = 0;
                    int k = 0;
                    if (intervals[i][j] > income) {
                        break;
                    }
                    tax += calculateTax(income, rates[i], intervals[i][j], intervals[i][k + 1]);

                }

            }
            case 3 -> {
                System.out.print("Enter the Taxable Income: ");
                int income = sc.nextInt();
                this.rates = new double[]{0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
                this.intervals = new int[][]{{0, 11950}, {11950, 45500}, {45500, 117450}, {117450, 190200}, {190200, 372950}, {0, 372950}};
                for (int i = 0; i < this.rates.length; i++) {
                    int j = 0;
                    int k = 0;
                    if (intervals[i][j] > income) {
                        break;
                    }
                    tax += calculateTax(income, rates[i], intervals[i][j], intervals[i][k + 1]);

                }

            }
            default -> getIncomeTax();
        }
        return tax;
    }

    public void getIncomeTaxTable() {

        double amountFrom;
        double amountTo;
        System.out.print("Enter the amount From: ");
        amountFrom = sc.nextInt();
        double initialAmount = amountFrom;
        System.out.println();
        System.out.print("Enter the amount To: ");
        amountTo = sc.nextInt();
        System.out.println();
        System.out.println("2001 tax tables for taxable income from " + (int) amountFrom + " to " + (int) amountTo);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Taxable      Single      Married Joint      Married      Head of\n");
        System.out.println("Income                    or Qualifying      Separate     a House ");
        System.out.println("                            Widow(er)                             ");
        System.out.println("----------------------------------------------------------------------------------");
        while (initialAmount <= amountTo) {
            this.rates = new double[]{0.15, 0.275, 0.305, 0.355, 0.391};
            this.intervals = new int[][]{{0, 27050}, {27050, 65550}, {65550, 136750}, {136750, 297350}, {0, 297350}};
            double sumTaxSingle = 0;
            double sumTaxMarriedJoint = 0;
            double sumTaxMarriedSeparate = 0;
            double sumTaxHeadHouse = 0;
            for (int i = 0; i < this.rates.length; i++) {
                int j = 0;
                int k = 0;
                if (intervals[i][j] > initialAmount) {
                    break;
                }
                sumTaxSingle += calculateTax(initialAmount, rates[i], intervals[i][j], intervals[i][k + 1]);

            }

            this.intervals = new int[][]{{0, 45200}, {45200, 109250}, {109250, 166500}, {166500, 297350}, {0, 297350}};
            for (int i = 0; i < this.rates.length; i++) {
                int j = 0;
                int k = 0;
                if (intervals[i][j] > initialAmount) {
                    break;
                }
                sumTaxMarriedJoint += calculateTax(initialAmount, rates[i], intervals[i][j], intervals[i][k + 1]);

            }

            this.intervals = new int[][]{{0, 22600}, {22600, 54625}, {54625, 83250}, {83250, 148675}, {0, 148675}};
            for (int i = 0; i < this.rates.length; i++) {
                int j = 0;
                int k = 0;
                if (intervals[i][j] > initialAmount) {
                    break;
                }
                sumTaxMarriedSeparate += calculateTax(initialAmount, rates[i], intervals[i][j], intervals[i][k + 1]);

            }
            this.intervals = new int[][]{{0, 36250}, {36250, 93650}, {93650, 151650}, {151650, 297350}, {0, 297350}};
            for (int i = 0; i < this.rates.length; i++) {
                int j = 0;
                int k = 0;
                if (intervals[i][j] > initialAmount) {
                    break;
                }
                sumTaxHeadHouse += calculateTax(initialAmount, rates[i], intervals[i][j], intervals[i][k + 1]);

            }
            System.out.println((int) initialAmount + "       " + df.format(sumTaxSingle) + "        " + df.format(sumTaxMarriedJoint) + "          " + df.format(sumTaxMarriedSeparate) + "       " + df.format(sumTaxHeadHouse));

            initialAmount += 1000;
        }
        System.out.println();
        System.out.println();
        System.out.println("2009 tax tables for taxable income from " + (int) amountFrom + " to " + (int) amountTo);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Taxable      Single      Married Joint      Married      Head of\n");
        System.out.println("Income                    or Qualifying      Separate     a House ");
        System.out.println("                            Widow(er)                             ");
        System.out.println("----------------------------------------------------------------------------------");
        initialAmount = amountFrom;
        while (initialAmount <= amountTo) {
            this.rates = new double[]{0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
            this.intervals = new int[][]{{0, 8350}, {8350, 33950}, {33950, 82250}, {82250, 171550}, {171550, 372950}, {0, 372950}};
            double sumTaxSingle = 0;
            double sumTaxMarriedJoint = 0;
            double sumTaxMarriedSeparate = 0;
            double sumTaxHeadHouse = 0;
            for (int i = 0; i < this.rates.length; i++) {
                int j = 0;
                int k = 0;
                if (intervals[i][j] > initialAmount) {
                    break;
                }
                sumTaxSingle += calculateTax(initialAmount, rates[i], intervals[i][j], intervals[i][k + 1]);

            }

            this.intervals = new int[][]{{0, 16700}, {16700, 67900}, {67901, 137050}, {137050, 208850}, {208850, 372950}, {0, 372950}};
            for (int i = 0; i < this.rates.length; i++) {
                int j = 0;
                int k = 0;
                if (intervals[i][j] > initialAmount) {
                    break;
                }
                sumTaxMarriedJoint += calculateTax(initialAmount, rates[i], intervals[i][j], intervals[i][k + 1]);

            }

            this.intervals = new int[][]{{0, 8350}, {8350, 33950}, {33950, 68525}, {68525, 104425}, {104425, 186475}, {0, 186475}};
            for (int i = 0; i < this.rates.length; i++) {
                int j = 0;
                int k = 0;
                if (intervals[i][j] > initialAmount) {
                    break;
                }
                sumTaxMarriedSeparate += calculateTax(initialAmount, rates[i], intervals[i][j], intervals[i][k + 1]);

            }
            this.intervals = new int[][]{{0, 11950}, {11950, 45500}, {45500, 117450}, {117450, 190200}, {190200, 372950}, {0, 372950}};
            for (int i = 0; i < this.rates.length; i++) {
                int j = 0;
                int k = 0;
                if (intervals[i][j] > initialAmount) {
                    break;
                }
                sumTaxHeadHouse += calculateTax(initialAmount, rates[i], intervals[i][j], intervals[i][k + 1]);

            }
            System.out.println((int) initialAmount + "       " + df.format(sumTaxSingle) + "        " + df.format(sumTaxMarriedJoint) + "          " + df.format(sumTaxMarriedSeparate) + "       " + df.format(sumTaxHeadHouse));

            initialAmount += 1000;
        }

    }

    static double calculateTax(double income, double rate, double bracketFrom, double bracketTo) {

        if (income >= bracketFrom && income >= bracketTo) {

            return (bracketTo - bracketFrom) * rate;
        }
        if (income > bracketFrom) {

            return (income - bracketFrom) * rate;
        }
        if (bracketFrom > income) {
            return 0;
        }

        return 0;
    }
}
