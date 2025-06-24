package jobhuntmanager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private static final String URL = "jdbc:sqlite:jobhunt.db";

    public static void init() {
    try {
        Class.forName("org.sqlite.JDBC"); // 👈 Load the SQLite JDBC driver
        Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS jobs (" +
                     "company TEXT, role TEXT, status TEXT, date TEXT, notes TEXT)";
        stmt.execute(sql);
        stmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public static void insertJob(JobApplication job) {
        String sql = "INSERT INTO jobs (company, role, status, date, notes) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, job.getCompany());
            pstmt.setString(2, job.getRole());
            pstmt.setString(3, job.getStatus());
            pstmt.setString(4, job.getDate());
            pstmt.setString(5, job.getNotes());
            pstmt.executeUpdate();
            System.out.println("✔ Saving to database: " + job.getCompany());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<JobApplication> getAllJobs() {
        List<JobApplication> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                jobs.add(new JobApplication(
                    rs.getString("company"),
                    rs.getString("role"),
                    rs.getString("status"),
                    rs.getString("date"),
                    rs.getString("notes")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }
}
