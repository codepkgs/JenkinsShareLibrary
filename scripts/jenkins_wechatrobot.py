import sys
import datetime
import wechatrobot

WECHAT_ROBOT_KEY = '<YOUR-WECHAT-ROBOT-KEY>'

wxrobot = wechatrobot.WechatRobot(WECHAT_ROBOT_KEY)

# 需要在Jenkinsfile中传递5个参数
project_name = sys.argv[1]  # ${currentBuild.projectName}
project_status = sys.argv[2]  # ${currentBuild.currentResult}
build_user = sys.argv[3]  # ${BUILD_USER}
build_number = sys.argv[4]  # ${env.BUILD_NUMBER}
build_url = sys.argv[5]  # ${env.BUILD_URL}
current_time = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')

if project_status.lower() == 'success':
    text = '# <font color="info">成功：{} </font>'
elif project_status.lower() == 'failure':
    text = '# <font color="#DC143C">失败：{}</font>'
else:
    text = '# <font color="comment">未知：{}</font>'

contents = [
    text.format(project_name),
    '> 构建用户：{}'.format(build_user),
    '> 构建时间：{}'.format(current_time),
    '> 构建版本：{}'.format(build_number),
    '> [console_log]({})'.format(build_url + 'console'),
]

wxrobot.send_markdown(contents)
