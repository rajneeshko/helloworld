pipeline {
  agent any
  stages {
    stage('Step 1') {
      parallel {
        stage('Step 1') {
          agent any
          steps {
            echo 'Starting ...'
            build 'Job1'
          }
        }
        stage('Build') {
          steps {
            build 'Maven'
          }
        }
      }
    }
  }
}