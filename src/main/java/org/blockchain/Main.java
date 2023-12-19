package org.blockchain;

import java.util.Scanner;

public class Main {
    public static Blockchain blockchain;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter blockchain difficulty: ");
        int difficulty = scanner.nextInt();
        blockchain = new Blockchain(difficulty);

        System.out.println("Starting blockchain");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a block");
            System.out.println("2. Display blockchain");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter data for the new block: ");
                    String data = scanner.nextLine();
                    blockchain.addBlock(data);
                    break;
                case 2:
                    blockchain.display();
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}