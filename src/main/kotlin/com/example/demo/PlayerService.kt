package com.example.demo

import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@AllArgsConstructor
class PlayerService {

    /**
     * lateinit 은 늦은 초기화라는 의미를 가지고 있다. → 변수를 사용할 때, 초기화를 해줄 것인지 아니면 사용할 때 초기화를 해줄 것인지를 지정해준다.
     * var 변수에서만 사용이 가능하다.
     * 초기화를 해주지 않으면 에러가 나온다.
     */
    @Autowired
    private lateinit var playerRepository : PlayerRepository;

    fun getPlayerAll(): List<Player> {
        return playerRepository.findAll()
    }

    @Transactional
    fun savePlayer(player : Player) : Player {
        return playerRepository.save(player)
    }
}
