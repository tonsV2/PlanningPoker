pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        echo 'Test'
        sh 'cd backend && ./gradlew test'
        dir(path: 'cd backend') {
          sh './gradle test'
        }
        
      }
    }
    stage('Build') {
      steps {
        dir(path: 'backend') {
          sh './gradlew test'
        }
        
      }
    }
  }
}