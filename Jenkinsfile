pipeline {
    agent any

    stages {
        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        success {
            echo '✅ BUILD SUCCESS'
        }
        failure {
            echo '❌ BUILD FAILED'
        }
    }
}
