package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.CardGroup
import dk.fitfit.planning.backend.domain.Game
import dk.fitfit.planning.backend.domain.Player
import dk.fitfit.planning.backend.repository.GameRepository
import org.springframework.stereotype.Service

@Service
class GameServiceImpl(val gameRepository: GameRepository) : GameService {
    override fun findGameByKey(key: String): Game {
        return gameRepository.findByKey(key)
    }

    override fun createGame(owner: Player, cardGroup: CardGroup): Game {
        val game = Game(owner = owner)
        game.cardGroup = cardGroup
        return gameRepository.save(game)
    }
}
