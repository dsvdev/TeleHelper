package com.example.telehelper.service

import com.example.telehelper.model.BotUser

interface UserService {
    fun isUserRegistered(id: Long): Boolean
    fun saveUser(user: BotUser): BotUser
}