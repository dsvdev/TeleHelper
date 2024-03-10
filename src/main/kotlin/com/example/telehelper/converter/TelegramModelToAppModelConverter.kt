package com.example.telehelper.converter

import com.example.telehelper.model.BotUser
import com.example.telehelper.model.UserStatus
import org.telegram.telegrambots.meta.api.objects.User

fun User.toBotUser(): BotUser =
        BotUser(this.id, this.userName, UserStatus.FREE)