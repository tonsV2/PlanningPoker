pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        dir(path: 'backend') {
          sh './gradlew test'
        }
        
      }
    }
    stage('Build jar') {
      steps {
        dir(path: 'backend') {
          sh './gradlew bootJar'
        }
        
      }
    }
    stage('Build image') {
      steps {
        dir(path: 'backend') {
          sh 'docker build -t tons/planning .'
        }
        
      }
    }
  }
}