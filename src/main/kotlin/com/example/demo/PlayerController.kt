package com.example.demo

import lombok.AllArgsConstructor
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/player")
class PlayerController {

    @Autowired
    private lateinit var playerService: PlayerService

    @GetMapping("/all")
    fun allPlayer(): ResponseEntity<List<Player>> {
        val playerAll = playerService.getPlayerAll()

        return ResponseEntity<List<Player>>(playerAll, HttpStatus.OK)
    }

    @GetMapping("/crawling")
    fun getCrawling(): String {
        var document: Document = Jsoup.connect("http://localhost:8080/static/nba.html").get()
        var elements: Elements = document.select("table tbody tr")

        for (element: Element in elements) {
            var playerNameElements: Elements = element.select("td.player a.Nowrap")
            var playerPositionElement: Elements = element.select("td.player span.Fz-xxs")
            var splits: List<String> = playerPositionElement.text().split(" ").toList()
            var playerData : String = element.select("td.Ta-end").text()
            if (playerData.length > 1) {
                val split: List<String> = playerData.split(" ")
                var player = Player(key = null,
                    playerName = playerNameElements.text(),
                    playerPosition = splits.elementAt(2),
                    playerFG = split.elementAt(6).toFloat(),
                    playerFT = split.elementAt(8).toFloat(),
                    player3PT = split.elementAt(10).toFloat(),
                    playerPTS = split.elementAt(11).toInt(),
                    playerREB = split.elementAt(12).toInt(),
                    playerAST = split.elementAt(13).toInt(),
                    playerST = split.elementAt(14).toInt(),
                    playerBLK = split.elementAt(15).toInt(),
                    playerTO = split.elementAt(16).toInt(),
                    playerTD = split.elementAt(17).toInt()
                )

                var play : Player = playerService.savePlayer(player)
                println(play)
            }
        }

        return "hi"
    }
}
