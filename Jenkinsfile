//git凭证Id
def git_auth = "2cc74f9b-0437-4259-8ba1-ee3f5a407e79"
//git的项目地址
def git_url = "https://github.com/honeyland414/Heima-Microservice.git"
//git拉取的分支
def git_branch="master"

node{
    stage('拉取代码'){
        checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '2cc74f9b-0437-4259-8ba1-ee3f5a407e79', url: 'https://github.com/honeyland414/Heima-Microservice.git']])
    }
}