pipeline {
  agent any
      stages {
          stage ('Compile Stage'){
		            steps {
			            withMaven(maven : 'apache-maven-3.5.2') {
				          sh 'mvn clean compile'
			            }
		            }
	        }
      }
}
