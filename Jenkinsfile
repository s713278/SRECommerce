pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                cmd 'mvn -DskipTests clean package'
            }
        }
        
         stage('Zipkin') {
            steps {
                cmd 'java -jar ./zipkin_server/zipkin-server-2.24.2-exec.jar'
            }
        }
    }
}
