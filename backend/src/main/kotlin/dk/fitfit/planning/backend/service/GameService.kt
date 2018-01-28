package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.CardGroup
import dk.fitfit.planning.backend.domain.Game
import dk.fitfit.planning.backend.domain.Player

interface GameService {
    fun createGame(owner: Player, cardGroup: CardGroup): Game
    fun findGameByKey(key: String): Game
}
