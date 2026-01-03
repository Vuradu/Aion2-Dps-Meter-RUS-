package com.tbread

class StreamProcessor {

    data class VarIntOutput(val value:Int,val length:Int)

    fun onPacketReceived(packet: ByteArray) {
        // 패킷이 너무 짧으면 무시 (매직바이트 등 고려)

        if (packet.size <= 3) return
        val packetLengthInfo = readVarInt(packet)
        if (packet.size == packetLengthInfo.value) {
            parsePerfectPacket(packet.copyOfRange(0,packet.size-3))
            //더이상 자를필요가 없는 최종 패킷뭉치
            return
        }

        parsePerfectPacket(packet.copyOfRange(0,packetLengthInfo.value-3))
        //매직패킷이 빠져있는 패킷뭉치

        onPacketReceived(packet.copyOfRange(packetLengthInfo.value-3,packet.size))
        //남은패킷 재처리

    }

    private fun parsePerfectPacket(packet: ByteArray){
        println(toHex(packet))
    }

    private fun parsingDamage(packet:ByteArray){
        var offset = 0
        val packetLengthInfo = readVarInt(packet)
        offset += packetLengthInfo.length

        if (packet[offset] != 0x04.toByte()) return
        if (packet[offset+1] != 0x38.toByte()) return
        offset += 2
        
    }



    private fun toHex(bytes: ByteArray): String {
        //출력테스트용
        return bytes.joinToString(" ") { "%02X".format(it) }
    }

    fun readVarInt(bytes: ByteArray, offset: Int = 0): VarIntOutput {
        //구글 Protocol Buffers 라이브러리에 이미 있나? 코드 효율성에 차이있어보이면 나중에 바꾸는게 나을듯?
        var value = 0
        var shift = 0
        var count = 0

        while (true) {
            if (offset + count >= bytes.size) {
                throw IndexOutOfBoundsException("배열 범위 초과")
            }

            val byteVal = bytes[offset + count].toInt()
            count++

            value = value or (byteVal and 0x7F shl shift)

            if ((byteVal and 0x80) == 0) {
                return VarIntOutput(value, count)
            }

            shift += 7
            if (shift >= 64) throw RuntimeException("VarInt too long")
        }
    }
}
