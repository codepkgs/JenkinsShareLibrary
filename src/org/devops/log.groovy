package org.devops

def Message(message, color="green") {
    colors = [
        red: "\033[31m>>>>>>>>>>>>>>>>>>>>>> ${message} >>>>>>>>>>>>>>>>>>>>>>\033[0m",
        green: "\033[32m>>>>>>>>>>>>>>>>>>>>>> ${message} >>>>>>>>>>>>>>>>>>>>>>\033[0m",
        yellow: "\033[33m>>>>>>>>>>>>>>>>>>>>>> ${message} >>>>>>>>>>>>>>>>>>>>>>\033[0m",
        blue: "\033[34m>>>>>>>>>>>>>>>>>>>>>> ${message} >>>>>>>>>>>>>>>>>>>>>>\033[0m"
    ]

    ansiColor('xterm') {
        println(colors[color])
    }
}
