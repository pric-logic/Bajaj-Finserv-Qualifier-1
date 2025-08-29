# GitHub Repository Setup Guide

## 🚀 Step-by-Step Instructions to Create GitHub Repository

### Prerequisites
- GitHub account (create one at https://github.com if you don't have one)
- Git installed on your computer (download from https://git-scm.com/)

## 📋 Step 1: Create a New Repository on GitHub

1. **Go to GitHub.com** and sign in to your account
2. **Click the "+" icon** in the top-right corner
3. **Select "New repository"**
4. **Fill in the repository details**:
   - **Repository name**: `bajaj-finserv-health-qualifier`
   - **Description**: `Spring Boot application for Bajaj Finserv Health Java qualifier - Webhook automation with SQL problem solving`
   - **Visibility**: Choose Public or Private (recommended: Public for portfolio)
   - **Initialize with**: 
     - ✅ Add a README file
     - ✅ Add .gitignore (select Java)
     - ✅ Choose a license (MIT License recommended)
5. **Click "Create repository"**

## 📋 Step 2: Clone the Repository to Your Local Machine

1. **Copy the repository URL** from GitHub (it will look like):
   ```
   https://github.com/yourusername/bajaj-finserv-health-qualifier.git
   ```

2. **Open Command Prompt or PowerShell** and navigate to your desired directory:
   ```powershell
   cd C:\Users\YourUsername\Documents\Projects
   ```

3. **Clone the repository**:
   ```powershell
   git clone https://github.com/yourusername/bajaj-finserv-health-qualifier.git
   ```

4. **Navigate into the repository folder**:
   ```powershell
   cd bajaj-finserv-health-qualifier
   ```

## 📋 Step 3: Copy Your Project Files

1. **Copy all files from your current project** to the cloned repository folder:
   ```powershell
   # Navigate to your current project directory
   cd "D:\bajaj finserv"
   
   # Copy all files to the GitHub repository folder
   xcopy /E /I /H "D:\bajaj finserv\*" "C:\Users\YourUsername\Documents\Projects\bajaj-finserv-health-qualifier\"
   ```

2. **Or manually copy these files and folders**:
   - `src/` folder
   - `pom.xml`
   - `README.md`
   - `TESTING_GUIDE.md`
   - `JAR_SUBMISSION_GUIDE.md`
   - `SUBMISSION_GUIDE.md`
   - `FINAL_SUBMISSION_SUMMARY.md`
   - `build.bat`
   - `run.bat`
   - `package.bat`
   - `mvnw.cmd`
   - `.mvn/` folder
   - `.gitignore`

## 📋 Step 4: Update .gitignore File

1. **Open the .gitignore file** in your repository folder
2. **Replace the content** with our custom .gitignore:
   ```gitignore
   # Compiled class file
   *.class

   # Log file
   *.log

   # BlueJ files
   *.ctxt

   # Mobile Tools for Java (J2ME)
   .mtj.tmp/

   # Package Files #
   *.jar
   *.war
   *.nar
   *.ear
   *.zip
   *.tar.gz
   *.rar

   # virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
   hs_err_pid*
   replay_pid*

   # Maven
   target/
   pom.xml.tag
   pom.xml.releaseBackup
   pom.xml.versionsBackup
   pom.xml.next
   release.properties
   dependency-reduced-pom.xml
   buildNumber.properties
   .mvn/timing.properties
   .mvn/wrapper/maven-wrapper.jar

   # IDE
   .idea/
   *.iws
   *.iml
   *.ipr
   .vscode/
   .settings/
   .project
   .classpath

   # OS
   .DS_Store
   Thumbs.db

   # Application specific
   output.txt
   ```

## 📋 Step 5: Update README.md

1. **Open README.md** in your repository folder
2. **Replace the content** with our comprehensive README:
   ```markdown
   # Bajaj Finserv Health Java Qualifier

   This is a Spring Boot application that implements the Bajaj Finserv Health Java qualifier requirements.

   ## Task Overview

   Build a Spring Boot app that:
   1. On startup, sends a POST request to generate a webhook
   2. Based on the response, solves a SQL problem and stores the result
   3. Sends the solution (a final SQL query) to the returned webhook URL using a JWT token

   ## Features

   - **Automatic Webhook Generation**: Sends POST request to generate webhook on application startup
   - **SQL Problem Solver**: Solves SQL problems based on registration number (odd/even logic)
   - **Database Storage**: Stores solutions in H2 in-memory database
   - **JWT Authentication**: Uses JWT token for solution submission
   - **RESTful API**: Uses RestTemplate for HTTP communications

   ## Technology Stack

   - **Spring Boot 3.2.0**
   - **Java 17**
   - **Spring Data JPA**
   - **H2 Database**
   - **RestTemplate**
   - **Maven**

   ## Quick Start

   ### Prerequisites
   - Java 17 or higher
   - Maven (or use the included Maven wrapper)

   ### Run the Application
   ```bash
   # Using Maven wrapper (no Maven installation needed)
   ./mvnw spring-boot:run

   # Or using Maven
   mvn spring-boot:run

   # Or run the JAR file
   java -jar target/health-qualifier-1.0.0.jar
   ```

   ## Documentation

   - [Testing Guide](TESTING_GUIDE.md) - Detailed testing instructions
   - [JAR Submission Guide](JAR_SUBMISSION_GUIDE.md) - How to run and submit the JAR file
   - [Final Submission Summary](FINAL_SUBMISSION_SUMMARY.md) - Complete project overview

   ## Requirements Met

   ✅ **Spring Boot Application**: Complete Spring Boot 3.2.0 application  
   ✅ **RestTemplate Usage**: Uses RestTemplate for HTTP communications  
   ✅ **No Controller Trigger**: Flow triggered on application startup  
   ✅ **JWT Authorization**: Uses JWT token in Authorization header  
   ✅ **Database Storage**: Stores solutions using Spring Data JPA  
   ✅ **Automatic Execution**: Runs automatically on startup  

   ## License

   This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
   ```

## 📋 Step 6: Stage and Commit Your Files

1. **Check the status** of your repository:
   ```powershell
   git status
   ```

2. **Add all files** to the staging area:
   ```powershell
   git add .
   ```

3. **Commit your changes**:
   ```powershell
   git commit -m "Initial commit: Bajaj Finserv Health Java Qualifier

   - Complete Spring Boot application
   - Webhook automation with SQL problem solving
   - JWT authentication and database storage
   - Comprehensive documentation and build scripts
   - Maven wrapper for easy setup"
   ```

## 📋 Step 7: Push to GitHub

1. **Push your changes** to GitHub:
   ```powershell
   git push origin main
   ```

2. **If you're asked for credentials**, enter your GitHub username and password (or personal access token)

## 📋 Step 8: Verify Your Repository

1. **Go back to your GitHub repository** in the browser
2. **Verify that all files are uploaded**:
   - Source code files
   - Documentation files
   - Build scripts
   - README.md with proper formatting

## 📋 Step 9: Create a Release (Optional but Recommended)

1. **Go to your repository** on GitHub
2. **Click on "Releases"** in the right sidebar
3. **Click "Create a new release"**
4. **Fill in the release details**:
   - **Tag version**: `v1.0.0`
   - **Release title**: `Bajaj Finserv Health Java Qualifier v1.0.0`
   - **Description**:
     ```
     ## Complete Spring Boot Application for Bajaj Finserv Health Java Qualifier
     
     ### Features
     - ✅ Spring Boot 3.2.0 application
     - ✅ Automatic webhook generation on startup
     - ✅ SQL problem solving based on registration number
     - ✅ JWT authentication for solution submission
     - ✅ Database storage using Spring Data JPA
     - ✅ Comprehensive documentation and build scripts
     
     ### How to Run
     1. Clone the repository
     2. Run: `./mvnw spring-boot:run`
     3. Or run the JAR: `java -jar target/health-qualifier-1.0.0.jar`
     
     ### Documentation
     - See README.md for project overview
     - See TESTING_GUIDE.md for detailed testing instructions
     - See JAR_SUBMISSION_GUIDE.md for JAR file usage
     ```
5. **Click "Publish release"**

## 📋 Step 10: Add Repository Topics (Optional)

1. **Go to your repository** on GitHub
2. **Click on the gear icon** next to "About" section
3. **Add topics** to make your repository discoverable:
   - `spring-boot`
   - `java`
   - `webhook`
   - `jwt`
   - `sql`
   - `maven`
   - `h2-database`
   - `rest-api`

## 🎯 Repository Structure

Your GitHub repository should have this structure:

```
bajaj-finserv-health-qualifier/
├── src/
│   └── main/
│       ├── java/com/bajajfinserv/healthqualifier/
│       │   ├── HealthQualifierApplication.java
│       │   ├── config/
│       │   ├── dto/
│       │   ├── entity/
│       │   ├── repository/
│       │   └── service/
│       └── resources/
│           └── application.properties
├── .mvn/
│   └── wrapper/
├── pom.xml
├── mvnw.cmd
├── README.md
├── TESTING_GUIDE.md
├── JAR_SUBMISSION_GUIDE.md
├── SUBMISSION_GUIDE.md
├── FINAL_SUBMISSION_SUMMARY.md
├── build.bat
├── run.bat
├── package.bat
├── .gitignore
└── LICENSE
```

## 🔗 Share Your Repository

Once your repository is set up, you can share it:

1. **Copy the repository URL**: `https://github.com/yourusername/bajaj-finserv-health-qualifier`
2. **Share with others** or include in your portfolio
3. **Add to your resume** or LinkedIn profile

## 📞 Troubleshooting

### Common Issues:

1. **"Authentication failed"**
   - Use a personal access token instead of password
   - Generate token: GitHub Settings → Developer settings → Personal access tokens

2. **"Repository not found"**
   - Check the repository URL
   - Ensure you have the correct permissions

3. **"Large file" error**
   - The JAR file might be too large
   - Add `target/` to .gitignore (already done)
   - Don't commit the JAR file to Git

4. **"Permission denied"**
   - Check your Git credentials
   - Ensure you have write access to the repository

## ✅ Final Checklist

- [ ] Repository created on GitHub
- [ ] All source code files uploaded
- [ ] Documentation files included
- [ ] README.md properly formatted
- [ ] .gitignore configured correctly
- [ ] Initial commit made
- [ ] Changes pushed to GitHub
- [ ] Repository is public/private as intended
- [ ] Release created (optional)
- [ ] Topics added (optional)

---

**Congratulations! Your GitHub repository is ready!** 🎉

Your Bajaj Finserv Health Java qualifier project is now professionally hosted on GitHub with comprehensive documentation and easy setup instructions.
