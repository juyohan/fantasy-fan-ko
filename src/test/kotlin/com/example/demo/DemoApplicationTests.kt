package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
    @Autowired
    private lateinit var playerRepository: PlayerRepository

    @Test
    fun testDb() {
//        var play = Player(id = null, playerName = "P.Mils", playerPosition = "G", playerFG = .377f)
//        var play2 = Player(id = null, playerName = "J.Harden")
//        var playList : MutableList<Player> = mutableListOf(play, play2)
//
//        playList.forEach {
//            playerRepository.save(it)
//        }
//
//        val findAll = playerRepository.findAll()
//        println("findAll = ${findAll.javaClass.name}")
//
//        findAll.forEach {
//            println("Player : ${it}")
//        }
    }
}
