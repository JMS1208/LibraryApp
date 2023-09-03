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
        stage('Stop Existing Process') {
                    steps {
                        script {
                            // 이전 배포 중인 어플리케이션 프로세스 종료
                            def oldProcessPid = sh(script: "lsof -t -i:8080", returnStdout: true).trim()
                            if (oldProcessPid) {
                                sh "kill -9 ${oldProcessPid}"
                            }
                        }
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
