package jobhuntmanager;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final JobManager jobManager = new JobManager();

    public static void main(String[] args) {
        DatabaseHandler.init();
        while (true) {
            System.out.println("\n=== JobHunt Manager ===");
            System.out.println("1. Add Job Application");
            System.out.println("2. View All Applications");
            System.out.println("3. Search by Company");
            System.out.println("4. View Status Summary");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    addJob();
                    break;
                case 2:
                    jobManager.viewAll();
                    break;
                case 3:
                    searchJob();
                    break;
                case 4:
                    jobManager.viewStatusSummary();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private static void addJob() {
        System.out.print("Company: ");
        String company = scanner.nextLine();
        System.out.print("Role: ");
        String role = scanner.nextLine();
        System.out.print("Status (Applied/Interview/Offer/Rejected): ");
        String status = scanner.nextLine();
        System.out.print("Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Notes: ");
        String notes = scanner.nextLine();

        JobApplication job = new JobApplication(company, role, status, date, notes);
        jobManager.addJob(job);
        DatabaseHandler.insertJob(job);
        System.out.println("✔ Job added successfully!");
    }

    private static void searchJob() {
        System.out.print("Enter company name to search: ");
        String company = scanner.nextLine();
        jobManager.searchByCompany(company);
    }
}