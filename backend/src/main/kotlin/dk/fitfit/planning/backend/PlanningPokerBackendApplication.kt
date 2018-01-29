package dk.fitfit.planning.backend

import dk.fitfit.planning.backend.domain.Card
import dk.fitfit.planning.backend.domain.Deck
import dk.fitfit.planning.backend.repository.DeckRepository
import dk.fitfit.planning.backend.repository.CardRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans

@SpringBootApplication
class PlanningPokerBackendApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder()
            .sources(PlanningPokerBackendApplication::class.java)
            .initializers(beans {
                bean("Initialize deck and cards") {
                    ApplicationRunner {
                        val deckRepository = ref<DeckRepository>()
                        arrayOf("Fib100")
                                .map { Deck(title = it) }
                                .forEach { deckRepository.saveAndFlush(it) }

                        val deck = deckRepository.findAll().first()
                        val cardRepository = ref<CardRepository>()
                        arrayOf(Pair("1", 1),
                                Pair("2", 2),
                                Pair("3", 3),
                                Pair("5", 5),
                                Pair("8", 8),
                                Pair("13", 13))
                                .map { Card(title = it.first, value = it.second, deck = deck) }
                                .forEach { cardRepository.save(it) }

                        deckRepository.findAll().forEach {
                            println(it.title)
                            it.cards?.forEach {
                                println("${it.title} - ${it.value}")
                            }
                        }

                    }
                }
            })
            .run(*args)
}
