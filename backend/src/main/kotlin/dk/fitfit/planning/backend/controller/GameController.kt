package dk.fitfit.planning.backend.controller

import dk.fitfit.planning.backend.domain.Game
import dk.fitfit.planning.backend.repository.CardGroupRepository
import dk.fitfit.planning.backend.service.GameService
import dk.fitfit.planning.backend.service.PlayerService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController(val gameService: GameService, val playerService: PlayerService, val cardGroupRepository: CardGroupRepository) {
    @PostMapping("/games/{ownerName}")
    fun getCards(@PathVariable ownerName: String): Game {
        val player = playerService.findOrCreatePlayer(ownerName)
        val cardGroup = cardGroupRepository.findAll().first()
        val game = gameService.createGame(player, cardGroup)
        return game
    }
}
