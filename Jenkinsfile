pipeline {
	agent any
	
	stages {
	   stage('Build') {
	      steps {
		sh -x test ./gradlew build
	      }
	   }
	   stage('Test') {
	      steps {
	        sh ./gradlew build
	      }
	   }
	}

}
