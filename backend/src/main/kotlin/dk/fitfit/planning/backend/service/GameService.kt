package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.Deck
import dk.fitfit.planning.backend.domain.Game
import dk.fitfit.planning.backend.domain.Player
import java.util.*

interface GameService {
    fun createGame(owner: Player, deck: Deck): Game
    fun findByKey(key: String): Optional<Game>
    fun save(game: Game): Game
}
