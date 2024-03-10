package com.example.telehelper.config

import com.example.telehelper.bot.TestBot
import com.example.telehelper.service.UserService
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Configuration
class BotsConfig(userService: UserService) {
    init {
        val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
        telegramBotsApi.registerBot(TestBot(
                "",
                        userService))
    }
}