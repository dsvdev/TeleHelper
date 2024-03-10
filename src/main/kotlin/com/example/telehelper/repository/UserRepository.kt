package com.example.telehelper.repository

import com.example.telehelper.model.BotUser

interface UserRepository {
    fun getUserById(id: Long): BotUser?
    fun newUser(user: BotUser): BotUser
}