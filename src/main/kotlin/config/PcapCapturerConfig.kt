package com.tbread.config

import com.tbread.PropertyHandler
import java.util.*
import kotlin.system.exitProcess

data class PcapCapturerConfig(
    val deviceIdx: Int,
    val serverIp: String,
    val serverPort: String,
    val timeout: Int = 10,
    val snapshotSize: Int = 65536
) {
    companion object {
        fun loadFromProperties(): PcapCapturerConfig {
            val deviceIdx = PropertyHandler.getProperty("device")?.toInt()
                ?: run {
                    System.err.println("${this::class.java.simpleName} : [에러] 장치인덱스 에러")
                    //todo: 이부분에러나면 설정 파일에서도 제거하도록 바꾸기, 우선도 중간
                    //todo: 그냥 나중에 유틸클래스 만들어서 로그들 자동으로 클래스명 찍도록 하자, 우선도 낮음
                    exitProcess(1)
                }
            val ip = PropertyHandler.getProperty("server.ip") ?: "206.127.156.141"
            val port = PropertyHandler.getProperty("server.port") ?: "13328"
            val timeout = PropertyHandler.getProperty("server.timeout")?.toInt() ?: 10
            val snapSize = PropertyHandler.getProperty("server.maxSnapshotSize")?.toInt() ?: 65536

            return PcapCapturerConfig(deviceIdx, ip, port, timeout, snapSize)
        }
    }
}