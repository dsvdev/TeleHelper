package com.example.telehelper.repository

import com.example.telehelper.model.BotUser
import org.springframework.stereotype.Repository

@Repository
class InMemoryUserRepository: UserRepository {
    private val usersWarehous: MutableMap<Long, BotUser> = HashMap()
    override fun getUserById(id: Long): BotUser? {
        return usersWarehous.getOrDefault(id, null)
    }

    override fun newUser(user: BotUser): BotUser {
        if (getUserById(user.id) != null) {
            throw RuntimeException("User with id ${user.id} already exists")
        }
        usersWarehous[user.id] = user
        return user
    }
}