def call() {
    pipeline {
        agent any
        environment {
            STAGE = ''
        }
        parameters {
            choice(name: 'buildTool', choices: ['gradle', 'maven'], description: 'indicar build tools')
            string(name: 'stage', defaultValue: 'indicar stage')

        }
        stages {
            stage('Pipeline') {
                steps {
                    script {
                        println params.buildTool
                        if (params.buildTool == 'gradle') {
                            gradle(stage)
                        } else {
                            maven(stage)
                        }
                    }
                }
            }
        }
        post {
            success {
                slackSend(color: "#008000", message: "[Ricardo Quiroga] [${env.JOB_NAME}] [${params.buildTool}] Ejecución exitosa")
            }
            failure {
                slackSend(color: "#FF0000", message: "[Ricardo Quiroga] [${env.JOB_NAME}] [${params.buildTool}] Ejecución fallida en stage ${STAGE}")
            }
        }
    }
}

return this;