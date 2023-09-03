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
                        sh'''
                        if [ "$(lsof -t -i :8080 -s TCP:LISTEN)" != "" ]; then
                            kill -9 $(lsof -t -i :8080 -s TCP:LISTEN)
                            echo "$pid process kill complete"
                        else
                            echo "pid is empty"
                        fi
                    '''
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
