@echo off
REM ============================================================
REM Travel and Tourism Management System - Quick Start Guide
REM ============================================================

echo.
echo ====================================================
echo  Travel and Tourism Management System
echo  Quick Start Guide
echo ====================================================
echo.

REM Check if Maven is installed
mvn -v >nul 2>&1
if errorlevel 1 (
    echo [ERROR] Maven is not installed or not in PATH
    echo Please install Maven from https://maven.apache.org/
    pause
    exit /b 1
)

REM Check if Java is installed
javac -version >nul 2>&1
if errorlevel 1 (
    echo [ERROR] Java compiler is not installed or not in PATH
    echo Please install Java 8 or higher from https://www.oracle.com/java/
    pause
    exit /b 1
)

echo [✓] Maven is installed
echo [✓] Java is installed
echo.

echo Step 1: Setting up database...
echo.
echo Before running the application, you MUST:
echo.
echo 1. Ensure MySQL is running:
echo    - Open Command Prompt as Administrator
echo    - Run: net start MySQL80
echo.
echo 2. Run the database setup script:
echo    - Option A: mysql -u root -p ^< setup_database.sql
echo    - Option B: Open setup_database.sql in MySQL Workbench and execute
echo.
echo 3. Default login credentials:
echo    - Admin Username: admin
echo    - Admin Password: admin
echo.
echo    - Test User: user1
echo    - Test Password: password123
echo.
echo ====================================================
echo.

echo Step 2: Compiling the project...
call mvn clean compile
if errorlevel 1 (
    echo [ERROR] Compilation failed!
    pause
    exit /b 1
)

echo.
echo ====================================================
echo Step 3: Running the application...
echo ====================================================
echo.
echo Starting the Travel and Tourism Management System...
echo [Note: The first run may take a few seconds to load]
echo.

call mvn exec:java

pause
