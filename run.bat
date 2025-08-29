@echo off
echo Running Bajaj Finserv Health Qualifier...

REM Check if Maven is installed or use wrapper
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Maven not found in PATH, using Maven wrapper...
    set MAVEN_CMD=mvnw.cmd
) else (
    set MAVEN_CMD=mvn
)

REM Check if target directory exists
if not exist "target\classes" (
    echo Project not built. Building first...
    call build.bat
    if %errorlevel% neq 0 (
        echo Build failed! Cannot run application.
        pause
        exit /b 1
    )
)

echo Starting Spring Boot application...
echo The application will automatically:
echo 1. Generate a webhook
echo 2. Solve the SQL problem
echo 3. Store the solution
echo 4. Submit the final query
echo.
echo Press Ctrl+C to stop the application
echo.

%MAVEN_CMD% spring-boot:run

pause
