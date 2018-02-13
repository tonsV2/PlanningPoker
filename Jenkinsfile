pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        echo 'Test'
        dir(path: 'cd backend') {
          sh './gradlew test'
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