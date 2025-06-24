
# 💼 JobHuntManager – Java CLI Application

**JobHuntManager** is a command-line job tracking system built with Core Java and SQLite. It allows users to log, search, filter, and summarize job applications efficiently — ideal for managing your internship or job hunt process from the terminal.

---

## 🧠 Features

- ➕ Add job application details (Company, Role, Status, Date, Notes)
- 🔍 Search by company name
- 📄 View all saved applications
- 📊 View status summary (e.g., Applied, Interview, Offer, Rejected)
- ✅ Real-time filtering and modular menu system

---

## 🛠 Tech Stack

- **Language:** Java (Core, Console-based)
- **Database:** SQLite (via JDBC)
- **Tools:** javac, sqlite-jdbc-*.jar, terminal/command prompt

---

## 🗂 Folder Structure

```
JobHuntManager/
├── jobhuntmanager/
│   ├── Main.java
│   ├── DatabaseHandler.java
│   ├── Job.java
├── jobhunt.db
├── sqlite-jdbc-3.36.0.3.jar
```

---

## ▶ How to Run

### 1. Compile
```bash
javac -cp ".;sqlite-jdbc-3.36.0.3.jar" jobhuntmanager/*.java
```

### 2. Run
```bash
java -cp ".;sqlite-jdbc-3.36.0.3.jar" jobhuntmanager.Main
```

> 🔁 Make sure the SQLite JDBC jar is in the same directory and matches the name above.

---

## 🧪 Sample Output

```
=== JobHunt Manager ===
1. Add Job Application
2. View All Applications
3. Search by Company
4. View Status Summary
5. Exit
Enter choice: 
```

---

## 📌 Status Summary Example

```
Status Summary:
Applied: 2
Interview: 1
Offer: 1
Rejected: 0
```

---

## 📄 License

MIT License — free to use and extend.

---

## ✨ Author

**Tusar Kanti Bal**  
📧 tusarkantibal554@gmail.com  
🔗 [GitHub](: https://github.com/Tusarkanti) | [LinkedIn](https://www.linkedin.com/in/tusar-kanti-b32082296/)
