pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        build 'HelloWorld_Build'
      }
    }
    stage('Sonar') {
      steps {
        build 'HelloWorld_Sonar'
      }
    }
    stage('Deploy') {
      steps {
        build 'HelloWorld_Deploy'
      }
    }
  }
}
