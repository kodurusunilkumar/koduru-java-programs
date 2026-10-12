import java.util.Scanner;

public class hospital {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== HOSPITAL MANAGEMENT SYSTEM =====");

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Disease/Problem: ");
        String disease = sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();

        System.out.print("Enter Appointment Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Consultation Fee: ");
        double consultationFee = sc.nextDouble();

        System.out.print("Enter Medicine Charges: ");
        double medicineCharges = sc.nextDouble();

        System.out.print("Enter Test Charges: ");
        double testCharges = sc.nextDouble();

        double totalBill =
                consultationFee + medicineCharges + testCharges;

        System.out.println("\n================================");
        System.out.println("       PATIENT RECORD");
        System.out.println("================================");

        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Gender     : " + gender);
        System.out.println("Phone      : " + phone);
        System.out.println("Problem    : " + disease);

        System.out.println("\n===== APPOINTMENT =====");

        System.out.println("Doctor : " + doctor);
        System.out.println("Date   : " + date);

        System.out.println("\n===== BILL =====");

        System.out.println("Consultation Fee : " + consultationFee);
        System.out.println("Medicine Charges : " + medicineCharges);
        System.out.println("Test Charges     : " + testCharges);

        System.out.println("-------------------------------");
        System.out.println("Total Bill       : " + totalBill);

        System.out.println("================================");

        sc.close();
    }
}