def call(s) {
    switch(s) {
        case 'build':
            stage('Build & Test') {
                STAGE = env.STAGE_NAME
                sh './gradlew clean build'
            }
            break;
        case 'test':
            stage('Test') {
                STAGE = env.STAGE_NAME
                println "Stage: ${env.STAGE_NAME}"
            }
            break;
        case 'run':
            stage('Run') {
                STAGE = env.STAGE_NAME
                println "Stage: ${env.STAGE_NAME}"
            }
            break;
        case 'build;test':
            stage('Build & Test') {
                STAGE = env.STAGE_NAME
                sh './gradlew clean build'
            }
            stage('Test') {
                STAGE = env.STAGE_NAME
                println "Stage: ${env.STAGE_NAME}"
            }
            break;
        default:
            stage('Build & Test') {
                STAGE = env.STAGE_NAME
                sh './gradlew clean build'
            }
            stage('Test') {
                STAGE = env.STAGE_NAME
                println "Stage: ${env.STAGE_NAME}"
            }
            stage('Run') {
                STAGE = env.STAGE_NAME
                println "Stage: ${env.STAGE_NAME}"
            }

    }





}

return this;