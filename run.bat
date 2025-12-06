@echo off
cd /d "C:\Users\DELL\OneDrive\Desktop\Travel Management System\Tourism_Management_System"

REM Compile if needed
echo Compiling project...
mvn clean compile > nul 2>&1

REM Copy resources to target
echo Setting up resources...
if not exist target\classes\ICONS (
    xcopy src\ICONS target\classes\ICONS\ /E /I /Y > nul 2>&1
)
if not exist target\classes\Image (
    xcopy src\Image target\classes\Image\ /E /I /Y > nul 2>&1
)

REM Run the application
echo Starting Travel Management System...
mvn exec:java
pause
