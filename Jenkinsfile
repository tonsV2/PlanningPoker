pipeline {
  agent {
    dockerfile true
  }
  stages {
    stage('Test') {
      steps {
        sh 'node --version'
      }
    }
    stage('Test2') {
      steps {
        echo 'Test'
      }
    }
  }
}