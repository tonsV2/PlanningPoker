package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.Deck
import dk.fitfit.planning.backend.domain.Game
import dk.fitfit.planning.backend.domain.Player
import dk.fitfit.planning.backend.repository.GameRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class GameServiceImpl(val gameRepository: GameRepository) : GameService {
    override fun save(game: Game): Game {
        return gameRepository.save(game)
    }

    override fun findByKey(key: String): Optional<Game> {
        return gameRepository.findByKey(key)
    }

    override fun createGame(owner: Player, deck: Deck): Game {
        val game = Game(owner = owner)
        game.deck = deck
        return gameRepository.save(game)
    }
}
