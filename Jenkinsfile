pipeline {
	agent { dockerfile true }
	
	stages {
		stage('compile') {
			steps {
				checkout scm
				sh 'mvn package'
			}
		}
	}

}
