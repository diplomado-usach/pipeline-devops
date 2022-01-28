def call(){
    stage('Compile'){
        env.STAGE = 'Compile'
        sh './mvnw clean compile -e'
    }
    stage('Test'){
        env.STAGE = 'Test'
        sh './mvnw clean test -e'
    }
    stage('Jar'){
        env.STAGE = 'Jar'
        sh './mvnw clean package -e'
    }
    stage('Run'){
        env.STAGE = 'Run'
        sh 'JENKINS_NODE_COOKIE=dontKillMe nohup bash mvnw spring-boot:run &'
    }
    stage('TestApp'){
        env.STAGE = 'TestApp'
        sh "curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing'"
    }
}
return this;