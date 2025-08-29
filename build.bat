@echo off
echo Building Bajaj Finserv Health Qualifier...

REM Check if Maven is installed or use wrapper
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Maven not found in PATH, using Maven wrapper...
    set MAVEN_CMD=mvnw.cmd
) else (
    set MAVEN_CMD=mvn
)

REM Clean and compile
echo Cleaning previous build...
%MAVEN_CMD% clean

echo Compiling project...
%MAVEN_CMD% compile

if %errorlevel% equ 0 (
    echo Build successful!
    echo.
    echo To run the application:
    echo %MAVEN_CMD% spring-boot:run
    echo.
    echo To create JAR file:
    echo %MAVEN_CMD% package
) else (
    echo Build failed!
)

pause
