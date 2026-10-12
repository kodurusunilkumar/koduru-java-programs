import java.util.Scanner;

public class l1ibrary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String bookName = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter Available Copies: ");
        int availableCopies = sc.nextInt();

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Member Name: ");
        String memberName = sc.nextLine();

        System.out.print("Do you want to issue the book? (yes/no): ");
        String issue = sc.nextLine();

        if (issue.equalsIgnoreCase("yes")) {

            if (availableCopies > 0) {

                availableCopies--;

                System.out.println("\nBook issued successfully!");

                System.out.print("Enter number of overdue days: ");
                int overdueDays = sc.nextInt();

                int fine = 0;

                if (overdueDays > 0) {
                    fine = overdueDays * 5;
                }

                System.out.println("\n===== LIBRARY RECORD =====");

                System.out.println("Book ID        : " + bookId);
                System.out.println("Book Name      : " + bookName);
                System.out.println("Author         : " + author);

                System.out.println("Member ID      : " + memberId);
                System.out.println("Member Name    : " + memberName);

                System.out.println("Available Copies : " + availableCopies);

                if (overdueDays > 0) {
                    System.out.println("Overdue Days   : " + overdueDays);
                    System.out.println("Fine           : Rs." + fine);
                } else {
                    System.out.println("Overdue Days   : 0");
                    System.out.println("Fine           : Rs.0");
                }

            } else {

                System.out.println("\nSorry! Book is not available.");
            }

        } else {

            System.out.println("\nBook was not issued.");
            System.out.println("Available Copies : " + availableCopies);
        }

        sc.close();
    }
}