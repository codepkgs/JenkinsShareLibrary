import dingdingrobot
import sys

access_token = "<YOUR-DINGDING-ROBOT-ACCESS-TOKEN>"

dtrobot = dingdingrobot.DingdingRobot(access_token)

picture_url_map = {
    'success': 'https://utils.maka.im/yw/success.png',
    'failure': 'https://utils.maka.im/yw/failure.png',
    'unknown': 'https://utils.maka.im/yw/unknown.png'
}

if sys.argv[1].lower() == 'success':
    picture_url = picture_url_map['success']
    send_title = "{} 项目上线成功".format(sys.argv[2])
elif sys.argv[1].lower() == 'failure':
    picture_url = picture_url_map['failure']
    send_title = "{} 项目上线失败".format(sys.argv[2])
else:
    picture_url = picture_url_map['unknown']
    send_title = "{} 项目上线状态未知".format(sys.argv[2])


send_message_url = sys.argv[3]
send_text = '上线人: {}\n版本号: {}'.format(sys.argv[4], sys.argv[5])

send_content = {
    'title': send_title,
    'text': send_text,
    'jump_url': send_message_url,
    'picurl': picture_url
}

dtrobot.send_link(**send_content)
