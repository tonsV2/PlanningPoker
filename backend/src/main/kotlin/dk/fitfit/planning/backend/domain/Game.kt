package dk.fitfit.planning.backend.domain

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
class Game(
        var title: String? = null,
        var key: UUID = UUID.randomUUID(),
        var created: LocalDateTime = LocalDateTime.now(),
        @OneToOne
        var owner: Player,
        @OneToMany(mappedBy = "game", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        var players: List<Player>? = null,
        @OneToOne
        var cardGroup: CardGroup? = null,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
)
