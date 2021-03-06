package com.crepus.robotserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RobotServerApplication

fun main(args: Array<String>) {
    runApplication<RobotServerApplication>(*args)
}
