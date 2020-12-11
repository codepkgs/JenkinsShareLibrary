package org.devops

def GetBuildUser() {
    wrap([$class: 'BuildUser']) {
        script {
            BUILD_USER_ID = "${env.BUILD_USER_ID}"
            BUILD_USER = "${env.BUILD_USER}"
            BUILD_USER_EMAIL = "${env.BUILD_USER_EMAIL}"
        }
    }
    env.BUILD_USER = BUILD_USER
}

/* 
1. 该方法用于从 Git Parameters 插件获取用户指定的分支后，去掉 origin 前缀
2. 将新的分支传递给方法 CheckoutCodeFromGit 来拉取代码
*/
def GetBranch(branch) {
    branch_list = branch.split('/').toList()
    if (branch_list[0] == 'origin') {
        branch_list.remove(0)
    }
    
    return branch_list.join('/').toString()
}

def CheckoutCodeFromGit(git_url, git_branch, jenkins_credentials_id) {
    git url: "${git_url}",
        branch: "${git_branch}",
        credentialsId: "${jenkins_credentials_id}"
}
