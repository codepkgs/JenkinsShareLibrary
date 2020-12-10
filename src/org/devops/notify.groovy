package org.devops

def WechatRobot(exec_path, script_path) {
    sh """
    ${exec_path} ${script_path} \
    ${currentBuild.projectName} \
    ${currentBuild.currentResult} \
    ${env.BUILD_USER} \
    ${env.BUILD_NUMBER} \
    ${env.BUILD_URL}
    """
}

def DingTalkRobot(exec_path, script_path) {
    sh """
    ${exec_path} ${script_path} \
    ${currentBuild.projectName} \
    ${currentBuild.currentResult} \
    ${env.BUILD_USER} \
    ${env.BUILD_NUMBER} \
    ${env.BUILD_URL}
    """
}