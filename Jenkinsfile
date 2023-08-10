pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                cmd "mvn -DskipTests clean package"
            }
        }
        
         stage('Hello') {
            steps {
                cmd "mvn test"
            }
        }
    }
}
