package com.example.demo.test

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CrawlingTests {

    @Test
    fun testCrawling() {
        var document : Document = Jsoup.connect("https://localhost:8080/static/nba.html").get()
        var elements : Elements = document.select("tbody tr")

        println(elements)
    }
}
