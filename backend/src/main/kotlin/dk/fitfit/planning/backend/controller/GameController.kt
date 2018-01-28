package dk.fitfit.planning.backend.controller

import dk.fitfit.planning.backend.domain.Game
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
    fun getCards(@PathVariable ownerName: String): Game {
        val player = playerService.findOrCreatePlayer(ownerName)
        val cardGroup = cardGroupRepository.findAll().first() // TODO: Should be a service
        return gameService.createGame(player, cardGroup)
    }

    // TODO: Should return Game not Story
    @PostMapping("/games/{key}/stories/{title}")
    fun addStory(@PathVariable key: String, @PathVariable title: String): Story {
        val game = gameService.findGameByKey(key)
        return storyService.save(title, game)
    }

    @GetMapping("/games/{key}")
    fun findGameByKey(@PathVariable key: String): Game {
        return gameService.findGameByKey(key)
    }
}
