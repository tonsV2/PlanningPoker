pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        sh 'cd backend && ./gradlew test'
      }
    }
    stage('Build') {
      steps {
        dir(path: 'backend') {
          sh './gradlew bootJar'
        }
        
      }
    }
  }
}