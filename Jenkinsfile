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
                            sh '''
                                                PORT=8080
                                                PID=$(lsof -t -i:$PORT)
                                                if [ -n "$PID" ]; then
                                                    echo "Killing process $PID using port $PORT"
                                                    kill -9 $PID
                                                else
                                                    echo "No process found using port $PORT"
                                                fi
                                                '''
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
