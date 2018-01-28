package dk.fitfit.planning.backend.domain

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
class Game(
        val title: String? = null,
        val key: String = UUID.randomUUID().toString(),
        val created: LocalDateTime = LocalDateTime.now(),
        @OneToOne
        var cardGroup: CardGroup? = null, // TODO: Should be val?
        @OneToOne
        val owner: Player,
        @OneToMany(mappedBy = "game", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        val stories: MutableSet<Story>? = null,
        @OneToMany(mappedBy = "game", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        val players: Set<Player>? = null,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0
) {
    constructor() : this(owner = Player(""))
}
