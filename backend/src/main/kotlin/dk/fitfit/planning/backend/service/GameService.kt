package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.CardGroup
import dk.fitfit.planning.backend.domain.Game
import dk.fitfit.planning.backend.domain.Player
import java.util.*

interface GameService {
    fun createGame(owner: Player, cardGroup: CardGroup): Game
    fun findByKey(key: String): Optional<Game>
    fun save(game: Game): Game
}
