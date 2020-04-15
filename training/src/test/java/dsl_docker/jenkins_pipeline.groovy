pipeline {
    agent any
    agent {
        label 'docker'
    }
    tools {
        maven '/usr/local/Cellar/maven/3.6.2/'
        docker '/var/lib/docker'
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


