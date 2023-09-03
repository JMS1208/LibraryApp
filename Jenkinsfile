pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build -x test'
            }
        }
        stage('Stop Current Application') {
            steps {
                script {
                    try {
                        sh "fuser -k 8080/tcp"
                    } catch (Exception e) {
                        echo "No process found on port 8080"
                    }
                }
            }
        }
        stage('Deploy') {
            steps {

                // 새로운 어플리케이션 실행
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
