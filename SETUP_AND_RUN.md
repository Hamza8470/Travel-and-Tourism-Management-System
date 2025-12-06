# Travel and Tourism Management System

A Java Swing-based application for managing travel packages, hotel bookings, and customer information.

## Prerequisites

- **Java 8 or higher** (`java -version`)
- **MySQL 5.7 or higher** (running and accessible)
- **Maven 3.6+** (for building)

## Database Setup

### Step 1: Ensure MySQL is Running

On Windows, start MySQL server:
```powershell
# Using MySQL as Windows service (if installed)
net start MySQL80  # or your MySQL version

# OR use MySQL Command Line directly
"C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe"
```

### Step 2: Create Database and Tables

Run the SQL setup script:

```powershell
cd "C:\Users\DELL\OneDrive\Desktop\Travel Management System\Tourism_Management_System"

# Method 1: Using MySQL Command Line
mysql -u root -p < setup_database.sql

# Method 2: Using MySQL Workbench
# 1. Open MySQL Workbench
# 2. File > Open SQL Script > select setup_database.sql
# 3. Execute (Ctrl+Shift+Enter or Execute All)
```

**Default Credentials Set:**
- **Admin Username:** `admin`
- **Admin Password:** `admin`
- **Test User Username:** `user1`
- **Test User Password:** `password123`

### Step 3: Verify Database

```powershell
mysql -u root -p -e "USE tms; SHOW TABLES; SELECT * FROM account;"
```

You should see 5 tables: `account`, `customer`, `hotel`, `bookhotel`, `bookpackage`

## Building the Project

```powershell
cd "C:\Users\DELL\OneDrive\Desktop\Travel Management System\Tourism_Management_System"

# Clean and compile
mvn clean compile
```

## Running the Application

### Method 1: Maven (Recommended)

```powershell
cd "C:\Users\DELL\OneDrive\Desktop\Travel Management System\Tourism_Management_System"

mvn clean compile exec:java
```

### Method 2: Using Batch File

```powershell
cd "C:\Users\DELL\OneDrive\Desktop\Travel Management System\Tourism_Management_System"

.\run.bat
```

### Method 3: Using PowerShell Script

```powershell
cd "C:\Users\DELL\OneDrive\Desktop\Travel Management System\Tourism_Management_System"

powershell -ExecutionPolicy Bypass -File run.ps1
```

## Login Instructions

### Admin Login
1. Start the application
2. On splash screen, wait for login form
3. Enter:
   - **Username:** `admin`
   - **Password:** `admin`
4. Click "LogIn"
5. Check the "I'm not a robot" checkbox
6. Click "Verify"

### User Registration (Sign Up)
1. On login form, click "SinUp"
2. Fill in the required fields:
   - Username
   - Name
   - Email
   - Phone
   - Address
   - Gender
3. Click "Save"

### User Login
1. Use credentials from registration
2. Check "I'm not a robot"
3. Click "Verify"

## Features

- **Dashboard** - Main navigation hub
- **Add Customer Details** - Create new customer profiles
- **View Customer Details** - Search and view customer information
- **Update Customer Details** - Modify existing customer data
- **Delete Customer** - Remove customer accounts
- **Book Hotel** - Browse and book hotels
- **View Booked Hotels** - Check booking history
- **Book Package** - Book vacation packages
- **View Packages** - View available packages
- **Check Hotels** - Browse available hotels
- **Check Packages** - Browse available packages
- **Destinations** - View travel destinations
- **Feedback** - Submit feedback
- **Payment** - Process bookings and payments

## Troubleshooting

### "Database connection failed"
- Ensure MySQL server is running: `net start MySQL80`
- Verify credentials: username is `root`, password is `root`
- Check if database `tms` exists: `mysql -u root -p -e "USE tms;"`
- Run setup_database.sql again

### "Cannot find ICONS folder"
- Ensure you're running from the correct directory
- ICONS folder should be at: `src/ICONS/`
- Images are copied to classpath during compilation

### "GUI disappears after login"
- Check console for error messages
- Ensure database tables exist
- Verify MySQL connection in Conns.java output

### "Compilation errors"
- Ensure Java 8+ is installed: `javac -version`
- Clear Maven cache: `mvn clean`
- Rebuild: `mvn clean compile`

## Project Structure

```
Tourism_Management_System/
├── src/                    # Java source files
│   ├── ImageLoader.java   # Image utility class
│   ├── Splash.java        # Splash screen
│   ├── Login.java         # Login form
│   ├── Dashboard.java     # Main dashboard
│   ├── Conns.java         # Database connection
│   └── ... (other feature classes)
├── lib/                    # MySQL connector JAR
├── target/                 # Compiled classes (after build)
├── pom.xml                 # Maven configuration
├── setup_database.sql      # Database setup script
├── README.md               # This file
└── run.bat                 # Batch runner

```

## Maven Commands Reference

```powershell
# Clean previous builds
mvn clean

# Compile source code
mvn compile

# Run the application
mvn exec:java

# Package as JAR
mvn package

# Clean, compile, and run (all in one)
mvn clean compile exec:java

# View dependencies
mvn dependency:tree
```

## Database Schema

### account table
- username (VARCHAR, PRIMARY KEY)
- password (VARCHAR)
- answer (VARCHAR) - Security question answer

### customer table
- username (VARCHAR, PRIMARY KEY)
- name (VARCHAR)
- email (VARCHAR)
- phone (VARCHAR)
- address (VARCHAR)
- gender (VARCHAR)

### hotel table
- id (INT, PRIMARY KEY)
- name (VARCHAR)
- location (VARCHAR)
- price (INT)
- image (VARCHAR)

### bookhotel table
- id (INT, PRIMARY KEY)
- username (VARCHAR, FOREIGN KEY)
- hotel_name (VARCHAR)
- persons (INT)
- checkIn (DATE)
- checkOut (DATE)
- total_price (INT)

### bookpackage table
- id (INT, PRIMARY KEY)
- username (VARCHAR, FOREIGN KEY)
- package_name (VARCHAR)
- persons (INT)
- startDate (DATE)
- endDate (DATE)
- total_price (INT)

## Support

For issues or questions:
1. Check the Troubleshooting section above
2. Review console output for error messages
3. Verify MySQL is running and accessible
4. Check that setup_database.sql was executed successfully

## Authors

- Developed by: Hamza8470
- Repository: https://github.com/Hamza8470/Travel-and-Tourism-Management-System

## License

This project is part of the Travel and Tourism Management System educational project.
