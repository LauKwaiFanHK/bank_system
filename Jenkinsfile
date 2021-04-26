pipeline {
	agent any
	
	stages {
	   stage('Build') {
	      steps {
		sh 'echo Building..'
	      }
	   }
	   stage('Test') {
	      steps {
	        sh './gradlew build'
	      }
	   }
	}

}
