package dk.fitfit.planning.backend.controller

import dk.fitfit.planning.backend.domain.Game
import dk.fitfit.planning.backend.domain.Player
import dk.fitfit.planning.backend.domain.Story
import dk.fitfit.planning.backend.repository.CardGroupRepository
import dk.fitfit.planning.backend.service.GameService
import dk.fitfit.planning.backend.service.PlayerService
import dk.fitfit.planning.backend.service.StoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController(val gameService: GameService,
                     val playerService: PlayerService,
                     val cardGroupRepository: CardGroupRepository,
                     val storyService: StoryService) {

    @PostMapping("/games/{ownerName}")
    fun createGame(@PathVariable ownerName: String): Game {
        val player = playerService.findOrCreatePlayer(ownerName)
        val cardGroup = cardGroupRepository.findAll().first() // TODO: Should be a service
        return gameService.createGame(player, cardGroup)
    }

    // TODO: Can I limit the number of queries being executed? Can I avoid reloading game
    @PostMapping("/games/{key}/stories/{title}")
    fun addStory(@PathVariable key: String, @PathVariable title: String): Game {
        val game = gameService.findGameByKey(key)
        storyService.save(title, game)
        return gameService.findGameByKey(key)
    }

    @PostMapping("/games/{key}/players/{name}")
    fun addPlayer(@PathVariable key: String, @PathVariable name: String): Game {
        val game = gameService.findGameByKey(key)
        val player = playerService.findOrCreatePlayer(name)
        game.players.add(player)
        return gameService.save(game)
    }

    @GetMapping("/games/{key}")
    fun findGameByKey(@PathVariable key: String): Game {
        return gameService.findGameByKey(key)
    }
}
