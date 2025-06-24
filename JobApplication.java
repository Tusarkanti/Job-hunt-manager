package jobhuntmanager;
public class JobApplication {
    private final String company;
    private final String role;
    private final String status;
    private final String date;
    private final String notes;

    public JobApplication(String company, String role, String status, String date, String notes) {
        this.company = company;
        this.role = role;
        this.status = status;
        this.date = date;
        this.notes = notes;
    }

    public String getCompany() { return company; }
    public String getRole() { return role; }
    public String getStatus() { return status; }
    public String getDate() { return date; }
    public String getNotes() { return notes; }

    @Override
    public String toString() {
        return String.format("Company: %s | Role: %s | Status: %s | Date: %s\nNotes: %s\n",
                company, role, status, date, notes);
    }
}