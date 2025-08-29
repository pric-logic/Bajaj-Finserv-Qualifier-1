# GitHub Repository Setup Script for Bajaj Finserv Health Java Qualifier
# This script helps automate the GitHub repository setup process

param(
    [Parameter(Mandatory=$true)]
    [string]$GitHubUsername,
    
    [Parameter(Mandatory=$true)]
    [string]$RepositoryName = "bajaj-finserv-health-qualifier",
    
    [Parameter(Mandatory=$false)]
    [string]$TargetDirectory = "$env:USERPROFILE\Documents\Projects"
)

Write-Host "🚀 Setting up GitHub repository for Bajaj Finserv Health Java Qualifier" -ForegroundColor Green
Write-Host ""

# Check if Git is installed
try {
    $gitVersion = git --version
    Write-Host "✅ Git is installed: $gitVersion" -ForegroundColor Green
} catch {
    Write-Host "❌ Git is not installed. Please install Git from https://git-scm.com/" -ForegroundColor Red
    exit 1
}

# Create target directory if it doesn't exist
if (!(Test-Path $TargetDirectory)) {
    Write-Host "📁 Creating target directory: $TargetDirectory" -ForegroundColor Yellow
    New-Item -ItemType Directory -Path $TargetDirectory -Force | Out-Null
}

# Navigate to target directory
Set-Location $TargetDirectory

# Clone the repository
$repoUrl = "https://github.com/$GitHubUsername/$RepositoryName.git"
$repoPath = Join-Path $TargetDirectory $RepositoryName

Write-Host "📋 Cloning repository from: $repoUrl" -ForegroundColor Yellow
try {
    git clone $repoUrl
    Write-Host "✅ Repository cloned successfully" -ForegroundColor Green
} catch {
    Write-Host "❌ Failed to clone repository. Please ensure:" -ForegroundColor Red
    Write-Host "   1. The repository exists on GitHub" -ForegroundColor Red
    Write-Host "   2. You have the correct permissions" -ForegroundColor Red
    Write-Host "   3. You're authenticated with GitHub" -ForegroundColor Red
    exit 1
}

# Navigate to repository directory
Set-Location $repoPath

# Copy project files from current location
$currentProjectPath = "D:\bajaj finserv"
if (Test-Path $currentProjectPath) {
    Write-Host "📋 Copying project files..." -ForegroundColor Yellow
    
    # Copy all files except target directory and .git
    $excludePatterns = @("target", ".git", "*.jar")
    
    Get-ChildItem -Path $currentProjectPath -Recurse | ForEach-Object {
        $relativePath = $_.FullName.Substring($currentProjectPath.Length + 1)
        $targetPath = Join-Path $repoPath $relativePath
        
        # Skip excluded patterns
        $shouldExclude = $false
        foreach ($pattern in $excludePatterns) {
            if ($_.Name -like $pattern -or $relativePath -like "*\$pattern\*") {
                $shouldExclude = $true
                break
            }
        }
        
        if (!$shouldExclude) {
            if ($_.PSIsContainer) {
                if (!(Test-Path $targetPath)) {
                    New-Item -ItemType Directory -Path $targetPath -Force | Out-Null
                }
            } else {
                $targetDir = Split-Path $targetPath -Parent
                if (!(Test-Path $targetDir)) {
                    New-Item -ItemType Directory -Path $targetDir -Force | Out-Null
                }
                Copy-Item $_.FullName $targetPath -Force
            }
        }
    }
    
    Write-Host "✅ Project files copied successfully" -ForegroundColor Green
} else {
    Write-Host "⚠️  Current project path not found: $currentProjectPath" -ForegroundColor Yellow
    Write-Host "   Please manually copy your project files to: $repoPath" -ForegroundColor Yellow
}

# Check Git status
Write-Host "📋 Checking Git status..." -ForegroundColor Yellow
git status

# Ask user if they want to commit and push
Write-Host ""
$response = Read-Host "Do you want to commit and push these changes? (y/n)"
if ($response -eq "y" -or $response -eq "Y") {
    # Add all files
    Write-Host "📋 Adding files to Git..." -ForegroundColor Yellow
    git add .
    
    # Commit changes
    Write-Host "📋 Committing changes..." -ForegroundColor Yellow
    git commit -m "Initial commit: Bajaj Finserv Health Java Qualifier

- Complete Spring Boot application
- Webhook automation with SQL problem solving
- JWT authentication and database storage
- Comprehensive documentation and build scripts
- Maven wrapper for easy setup"
    
    # Push to GitHub
    Write-Host "📋 Pushing to GitHub..." -ForegroundColor Yellow
    git push origin main
    
    Write-Host "✅ Changes pushed to GitHub successfully!" -ForegroundColor Green
} else {
    Write-Host "📋 Skipping commit and push. You can do this manually later." -ForegroundColor Yellow
}

# Display next steps
Write-Host ""
Write-Host "🎉 GitHub repository setup completed!" -ForegroundColor Green
Write-Host ""
Write-Host "📋 Next steps:" -ForegroundColor Cyan
Write-Host "1. Go to: https://github.com/$GitHubUsername/$RepositoryName" -ForegroundColor White
Write-Host "2. Verify all files are uploaded correctly" -ForegroundColor White
Write-Host "3. Create a release (optional but recommended)" -ForegroundColor White
Write-Host "4. Add repository topics for better discoverability" -ForegroundColor White
Write-Host "5. Share your repository URL with others" -ForegroundColor White
Write-Host ""
Write-Host "📁 Repository location: $repoPath" -ForegroundColor Cyan
Write-Host "🌐 Repository URL: https://github.com/$GitHubUsername/$RepositoryName" -ForegroundColor Cyan
Write-Host ""
Write-Host "For detailed instructions, see: GITHUB_SETUP_GUIDE.md" -ForegroundColor Yellow
