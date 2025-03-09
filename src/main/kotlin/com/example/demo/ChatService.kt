package com.example.demo

import org.springframework.ai.chat.messages.SystemMessage
import org.springframework.ai.chat.messages.UserMessage
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.openai.OpenAiChatModel
import org.springframework.ai.openai.OpenAiChatOptions
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ChatService(
    @Value("\${spring.ai.openai.api-key}") private val apiKey: String
) {

    fun openAichat(
        userInput: String,
        systemMessage: String,
        model: String
    ): ChatResponse? {

        val messages =
            listOf(
                UserMessage(userInput),
                SystemMessage(systemMessage),
            )

        val chatOptions =
            OpenAiChatOptions.builder()
                .model(model)
                .build()

        val prompt = Prompt(messages, chatOptions)

        val openAiApi = OpenAiApi.builder().apiKey(apiKey).build()

        val chatModel = OpenAiChatModel.builder().openAiApi(openAiApi).build()

        return chatModel.call(prompt)
    }
}
