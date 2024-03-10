package com.example.telehelper.service

import com.example.telehelper.model.BotUser
import com.example.telehelper.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository): UserService {

    override fun isUserRegistered(id: Long): Boolean {
        return userRepository.getUserById(id) != null
    }

    override fun saveUser(user: BotUser): BotUser {
        return userRepository.newUser(user)
    }
}