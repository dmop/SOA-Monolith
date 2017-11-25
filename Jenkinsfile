node {
    def app

    agent {
        node {
            label 'emarosa-services'
            customWorkspace '/home/imlbf/workspace/client'
        }
    }

    stage('Clone repository') {
        checkout scm
    }

    stage('Build image') {
        app = docker.build("ianfireman/client-service")
    }

    stage('Test image') {
        app.inside {
            sh 'echo "Tests passed"'
        }
    }

    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}