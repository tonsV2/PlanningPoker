pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        sh 'cd backend && ./gradlew test'
      }
    }
    stage('Build jar') {
      steps {
        dir(path: 'backend') {
          sh './gradlew bootJar'
        }
        
      }
    }
    stage('Build docker image') {
      steps {
        echo 'Docker image'
      }
    }
    stage('Test docker image') {
      steps {
        echo 'Test image'
      }
    }
    stage('Push image') {
      steps {
        sh 'Push image'
      }
    }
  }
}