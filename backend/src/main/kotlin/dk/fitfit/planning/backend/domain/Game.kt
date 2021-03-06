package dk.fitfit.planning.backend.domain

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
@Table(indexes = [Index(columnList = "key")])
class Game(
        val title: String? = null,
        val key: String = UUID.randomUUID().toString(),
        val created: LocalDateTime = LocalDateTime.now(),
        @OneToOne
        var deck: Deck? = null, // TODO: Should be val?
        @OneToOne
        val owner: Player,
        @OneToMany(mappedBy = "game", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        val stories: MutableSet<Story> = HashSet(),
        @OneToMany(mappedBy = "game", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        val players: MutableSet<Player> = HashSet(),
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0
) {
    constructor() : this(owner = Player(""))
}
