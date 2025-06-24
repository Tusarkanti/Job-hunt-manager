package jobhuntmanager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobManager {
    public void addJob(JobApplication job) {
        // In-memory list removed since persistence is now handled with DB
    }

    public void viewAll() {
        List<JobApplication> jobs = DatabaseHandler.getAllJobs();
        if (jobs.isEmpty()) {
            System.out.println("No job applications found.");
        } else {
            for (JobApplication job : jobs) {
                System.out.println(job);
            }
        }
    }

    public void searchByCompany(String company) {
        List<JobApplication> jobs = DatabaseHandler.getAllJobs();
        boolean found = false;
        for (JobApplication job : jobs) {
            if (job.getCompany().equalsIgnoreCase(company)) {
                System.out.println(job);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No applications found for: " + company);
        }
    }

    public void viewStatusSummary() {
        List<JobApplication> jobs = DatabaseHandler.getAllJobs();
        Map<String, Integer> statusCount = new HashMap<>();
        for (JobApplication job : jobs) {
            statusCount.put(job.getStatus(), statusCount.getOrDefault(job.getStatus(), 0) + 1);
        }

        int total = jobs.size();
        System.out.println("\n=== Application Status Summary ===");
        System.out.println("Total Applications: " + total);
        for (String status : statusCount.keySet()) {
            System.out.println(status + ": " + statusCount.get(status));
        }
    }
}

