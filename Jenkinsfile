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
				sh 'zip project_package.zip docs src/main/java/myproject build/libs/bank_system.jar build/libs/ProfessionalVersion.jar' 
			}
		}
		stage('Upload to download server') {
			steps {
				sh 'echo "Uploading"'
				sh 'apt install jq'
				sh 'curl -F "file=@project_package.zip" https://file.io -o "readme.md" | jq -r ".link"'
			}
		}
	}
}
