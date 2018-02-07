package dk.fitfit.planning.backend.controller

import dk.fitfit.planning.backend.domain.Game
import dk.fitfit.planning.backend.domain.Hand
import dk.fitfit.planning.backend.repository.CardRepository
import dk.fitfit.planning.backend.repository.DeckRepository
import dk.fitfit.planning.backend.repository.HandRepository
import dk.fitfit.planning.backend.security.CurrentUserHolder
import dk.fitfit.planning.backend.service.GameService
import dk.fitfit.planning.backend.service.StoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class GameController(val gameService: GameService,
                     val deckRepository: DeckRepository,
                     val storyService: StoryService,
                     val handRepository: HandRepository,
                     val cardRepository: CardRepository,
                     val currentUserHolder: CurrentUserHolder) {

    @PostMapping("/games")
    fun createGame(): Game {
        val player = currentUserHolder.user
        val deck = deckRepository.findAll().first() // TODO: Should be a service
        return gameService.createGame(player, deck)
    }

    @PostMapping("/games/{key}/stories/{title}")
    fun addStory(@PathVariable key: String, @PathVariable title: String): ResponseEntity<Game> {
        val story = storyService.findOrCreate(title)
        return gameService.findByKey(key).map {
            story.game = it
            it.stories.add(story)
            ResponseEntity.ok().body(gameService.save(it))
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/games/{key}/players/{name}")
    fun addPlayer(@PathVariable key: String, @PathVariable name: String): ResponseEntity<Game> {
        val optional = gameService.findByKey(key)
        return if (optional.isPresent) {
            val player = currentUserHolder.user
            val game = optional.get()
// TODO: Why do I have to do this "both" ways?
            player.game = game
            game.players.add(player)
            ResponseEntity.ok().body(gameService.save(game))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/games/{key}")
    fun findGameByKey(@PathVariable key: String): ResponseEntity<Game> = gameService.findByKey(key).map {
            ResponseEntity.ok().body(it)
        }.orElse(ResponseEntity.notFound().build())

    // TODO: Use game key here? Player shouldn't be able to play on stores which he doesn't have to gameKey to
    @PostMapping("/hands")
    fun playHand(@RequestParam cardId: Long, @RequestParam storyId: Long): Hand {
        val card = cardRepository.getOne(cardId)
        val story = storyService.findById(storyId)
        val player = currentUserHolder.user
        val hand = Hand(card, story, player)
        return handRepository.save(hand)
    }
}
