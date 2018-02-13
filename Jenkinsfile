pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        echo 'Test'
        sh 'cd backend && ./gradlew test'
      }
    }
  }
}