package com.crepus.robotserver

import kotlinx.serialization.Serializable

@Serializable
data class MotorState(val id: Int, val mode: Int, val value: Double)