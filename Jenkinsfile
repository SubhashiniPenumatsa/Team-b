pipeline {
agent any
stages {
stage('para') {
parallel {
stage('Build Api') {
steps {
sh 'cd spring-petclinic-rest && nohup mvn spring-boot:run &'
}
}


stage('Build Angular') {
steps {
sh 'cd spring-petclinic-angular/static-content && curl https://jcenter.bintray.com/com/athaydes/rawhttp/rawhttp-cli/1.0/rawhttp-cli-1.0-all.jar -o rawhttp.jar && nohup java -jar ./rawhttp.jar serve . -p 4200 &'
sleep(3)
}
}
stage('Robot') {
steps {
catchError {
sleep(60)
sh 'robot --variable BROWSER:headlesschrome -d Tests/Results Tests/CriticalFlow.robot'
}
}
post {
always {
script {
step(
[
$class : 'RobotPublisher',
outputPath : 'Tests/Results',
outputFileName : '**/output.xml',
reportFileName : '**/report.html',
logFileName : '**/log.html',
disableArchiveOutput : false,
passThreshold : 100,
unstableThreshold : 40,
otherFiles : "**/*.png,**/*.jpg",
]
)
}
}
}
}
}
}
}
}
