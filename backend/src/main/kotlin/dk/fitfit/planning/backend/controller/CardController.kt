package dk.fitfit.planning.backend.controller

import dk.fitfit.planning.backend.domain.Card
import dk.fitfit.planning.backend.repository.CardRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CardController(val cardRepository: CardRepository) {
    @GetMapping("/cards")
    fun getCards(): MutableList<Card>? {
        return cardRepository.findAll()
    }
}
