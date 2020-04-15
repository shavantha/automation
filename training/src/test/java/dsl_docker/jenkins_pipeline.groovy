pipeline {
    agent any
    tools {
        maven '/usr/local/Cellar/maven/3.6.2/'
    }
    stages {
        stage('Build Application') {
            steps {
                sh 'mvn -f training/pom.xml clean package'
            }
            post {
                success {
                    echo "Now Archiving the Artifacts...."
                    archiveArtifacts artifacts: '**/*.*'
                }
            }
        }

        stage('Create Tomcat Docker Image'){
            steps {
                sh "docker build . -t tomcatsamplewebapp:${env.BUILD_ID}"
            }
        }

    }
}


