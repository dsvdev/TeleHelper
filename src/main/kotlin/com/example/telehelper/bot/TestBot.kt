package com.example.telehelper.bot

import com.example.telehelper.converter.toBotUser
import com.example.telehelper.service.UserService
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class TestBot(botToken: String, private val userService: UserService) : TelegramLongPollingBot(botToken) {
    override fun getBotUsername(): String = ""

    override fun onUpdateReceived(update: Update?) {
        if (update == null) return
        val userId = update.message.from.id
        val chatID = update.message.chatId.toString()
        val message = SendMessage()
        message.chatId = chatID
        if (!userService.isUserRegistered(userId)) {
            message.text = "New user"
            println("New user - ${update.message.from.userName}")
            userService.saveUser(update.message.from.toBotUser())
        } else {
            message.text = "Old user"
            println("Old user - ${update.message.from.userName}")
        }
        execute(message)
    }

}