package com.tbread

import java.util.concurrent.ConcurrentHashMap

class DataStorage {
    private val damageStorage = ConcurrentHashMap<String, ConcurrentHashMap<String, MutableSet<ParsedDamagePacket>>>()
    private val nicknameStorage = ConcurrentHashMap<Int, String>()

    fun appendDamage(pdp: ParsedDamagePacket) {
        val targetMap = damageStorage.computeIfAbsent("${pdp.getActorId()}") { ConcurrentHashMap() }
        val damageSet = targetMap.computeIfAbsent("${pdp.getTargetId()}") { hashSetOf() }

        synchronized(damageSet) {
            damageSet.add(pdp)
        }
    }

    fun appendNickname(uid: Int, nickname: String) {
        if (nicknameStorage[uid] != null && nicknameStorage[uid] == nickname) return
        nicknameStorage[uid] = nickname
        println("$uid 할당 닉네임 변경됨 이전: ${nicknameStorage[uid]} 현재: $nickname")
    }

    private fun flushDamageStorage() {
        damageStorage.clear()
    }

    private fun flushNicknameStorage() {
        nicknameStorage.clear()
    }
}