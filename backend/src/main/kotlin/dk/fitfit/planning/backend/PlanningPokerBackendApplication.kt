package dk.fitfit.planning.backend

import dk.fitfit.planning.backend.domain.Card
import dk.fitfit.planning.backend.domain.CardGroup
import dk.fitfit.planning.backend.repository.CardGroupRepository
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
                bean("Initialize cards and card groups") {
                    ApplicationRunner {
                        val cardGroupRepository = ref<CardGroupRepository>()
                        arrayOf("Fib100")
                                .map { CardGroup(title = it) }
                                .forEach { cardGroupRepository.saveAndFlush(it) }

                        val cardGroup = cardGroupRepository.findAll().first()
                        val cardRepository = ref<CardRepository>()
                        arrayOf(Pair("1", 1),
                                Pair("2", 2),
                                Pair("3", 3),
                                Pair("5", 5))
                                .map { Card(title = it.first, value = it.second, group = cardGroup) }
                                .forEach { cardRepository.save(it) }

                        cardGroupRepository.findAll().forEach {
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
