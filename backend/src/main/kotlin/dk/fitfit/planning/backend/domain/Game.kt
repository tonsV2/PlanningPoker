package dk.fitfit.planning.backend.domain

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
class Game(
        var title: String? = null,
        var key: String = UUID.randomUUID().toString(),
        var created: LocalDateTime = LocalDateTime.now(),
        @OneToOne
        var cardGroup: CardGroup? = null,
        @OneToOne
        var owner: Player,
        @OneToMany(mappedBy = "game", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        val stories: MutableSet<Story>? = null,
        @OneToMany(mappedBy = "game", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        var players: Set<Player>? = null,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
) {
    constructor() : this(owner = Player(""))
}
