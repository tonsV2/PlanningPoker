pipeline {
  agent {
    docker {
      image 'openjdk:8-jdk-alpine'
    }
    
  }
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
        sh 'echo Push image'
      }
    }
  }
}