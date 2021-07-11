pipeline {
	agent any
		
	stages {
		stage('Build') {
			steps {
				sh 'echo "Building.."'
				sh './gradlew build'
			}
		}
		stage('Test') {
			steps {
				sh 'echo "Testing.."'
				sh './gradlew test'
			}
		}
		stage('Document') {
			steps {
				sh 'echo "Documenting"'
				sh './javadocs.sh'
			}
		}
		stage('Pack') {
			steps {
				sh 'echo "Packing"'
				sh 'zip -r project_package.zip docs src/main/java/myproject src/test/java/myprojecttests build/libs/bank_system.jar build/libs/ProfessionalVersion.jar readme.md' 
			}
		}
		stage('Upload to download server') {
			steps {
				sh 'echo "Uploading"'	
				script {
					response = sh(script: 'curl -X POST "https://file.io/" -H  "accept: application/json" -H  "Authorization: Bearer 3EAL7UG.CZJ8SDR-S514XJP-M5NPK94-55HBRR2" -H  "Content-Type: multipart/form-data" -F "expires=2021-08-31" -F "maxDownloads=1" -F "autoDelete=true" -F "file=@project_package.zip" | -r '.link' ', returnStdout: true).trim()
					echo "curl response: ${response}"		
					currentBuild.displayName = "Bank system build"
					currentBuild.description = response
				}				
			}
		}
	}
}
