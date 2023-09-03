pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Kill port') {
            steps{
                script {
                    sh "sudo kill -9 \$(lsof -t -i:8080)"
                }
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build -x test'
            }
        }
        stage('Deploy') {
            steps {
                sh 'java -jar build/libs/library-app-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev'
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed!'
        }
    }
}
