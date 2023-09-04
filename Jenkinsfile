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
                    sh '''
                    jenkins_lsof=$(sudo -u jenkins lsof -t -i:8080)
                    if [ -n "$jenkins_lsof" ]; then
                        sudo kill -9 $jenkins_lsof
                    else
                        echo "No process is running on port 8080"
                    fi
                    '''
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
