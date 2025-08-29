@echo off
echo Packaging Bajaj Finserv Health Qualifier...

REM Check if Maven is installed or use wrapper
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Maven not found in PATH, using Maven wrapper...
    set MAVEN_CMD=mvnw.cmd
) else (
    set MAVEN_CMD=mvn
)

echo Creating JAR package...
%MAVEN_CMD% clean package -DskipTests

if %errorlevel% equ 0 (
    echo Package created successfully!
    echo.
    echo JAR file location: target\health-qualifier-1.0.0.jar
    echo.
    echo To run the JAR file:
    echo java -jar target\health-qualifier-1.0.0.jar
    echo.
    echo The application will automatically execute the webhook flow on startup.
) else (
    echo Package creation failed!
)

pause
