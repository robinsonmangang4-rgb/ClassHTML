package FunCartIncentive;

import java.util.Scanner;

class Incentive {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: nongmada yonba ticket performance check twba.
        System.out.print("Please Enter Your Sale Ticket In Number : ");
        int sale = sc.nextInt();
        sc.nextLine(); // anwba line after number input

        if (sale >= 60) {
            System.out.println("Great Job!");
        } else if (sale > 40) {
            System.out.println("Good job!");
        } else if (sale >= 22) {
            System.out.println("Congratulations! Target Achieved.");
        } else {
            System.out.println("Sorry Target Failed, try next time.");
        }

        // Step 2: Tha ama da employee kayana yolli moigi data collected twba.
        System.out.print("\nEnter number of persons: ");
        int persons = sc.nextInt();
        sc.nextLine(); // newline

        String[] names = new String[persons];
        float[] sales = new float[persons];
        float total = 0;

        // Input name and sales for each person (with GST adjustment)
        for (int i = 0; i < persons; i++) {
            System.out.print("\nEnter name of Person " + (i + 1) + ": ");
            names[i] = sc.nextLine();

            System.out.print("Enter sale amount for " + names[i] + ": ");
            float originalSale = sc.nextFloat();
            sc.nextLine(); // newline

            // Adjust sale (multiply by 100, divide by 1.18, then divide by 100)
            float processedSale = (originalSale * 100 / 1.18f) / 100;
            sales[i] = processedSale;
            total += processedSale;
        }

        // Step 3: Show each person's adjusted sale
        System.out.println("\n--- Individual Adjusted Sales (Excluding 18% GST) ---");
        for (int i = 0; i < persons; i++) {
            System.out.println(names[i] + " Adjusted Sale: " + sales[i]);
        }

        // Step 4: Show total adjusted sales
        System.out.println("\nTotal Adjusted Sales from " + persons + " persons: " + total);

        // Step 5: Incentive calculation
        float n = 0.75f;
        float a = 1f;
        float b = 1.25f;
        float c = 1.50f;

        float incentiveRate = 0f;
        if (total >= 2750) {
            incentiveRate = c;
        } else if (total >= 2000 && total < 2750) {
            incentiveRate = b;
        } else if (total >= 1510 && total < 2000) {
            incentiveRate = a;
        } else if (total >= 1250 && total < 1510) {
            incentiveRate = n;
        }

        if (incentiveRate > 0) {
            float totalIncentive = total * incentiveRate;
            System.out.println("\n  Congratulations! Target Achieved.");
            System.out.println("Total Incentive : " + totalIncentive);

            // magi magi incentive khangdokpa
            System.out.println("\n--- Individual Incentives ---");
            for (int i = 0; i < persons; i++) {
                float personIncentive = sales[i] * incentiveRate;
                System.out.println(names[i] + " Incentive: " + personIncentive);
            }
        } else {
            System.out.println("\n Target Failed, Try next time.");
        }

        sc.close();
    }

}