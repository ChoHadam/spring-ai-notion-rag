package com.example.demo

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class RunChatDemo {
    @Bean
    fun run(chatService: ChatService) = ApplicationRunner {
        val response = chatService.openAichat(userInput = "안녕?", systemMessage = "당신은 챗봇입니다.", model = "gpt-4o")
        println(response)
    }
}

fun main(args: Array<String>) {
    runApplication<RunChatDemo>(*args)
}