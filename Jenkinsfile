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
        stage('Deploy') {
            steps {
                // 이전 배포 중인 프로세스를 종료합니다.
                sh 'sudo kill -9 $(sudo lsof -t -i:8080)'

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
