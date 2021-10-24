package com.example.demo

import javax.persistence.*

@Entity
data class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PLAYER_ID")
    val key: Long?,
    val playerName: String,
    val playerPosition: String,
    val player3PT: Float,
    val playerFG: Float,
    val playerFT: Float,
    val playerPTS: Int,
    val playerREB: Int,
    val playerAST: Int,
    val playerST: Int,
    val playerBLK: Int,
    val playerTO: Int,
//     val : 수정 불가 즉, final과 비슷하다고 생각하면 됨. 읽기만 가능
//     var : 수정 가능
    val playerTD: Int
) {
}
