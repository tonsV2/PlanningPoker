package dk.fitfit.planning.backend.domain

import javax.persistence.*
import javax.persistence.FetchType.EAGER

@Entity
class Deck(
        val title: String = "",
        @OneToMany(mappedBy = "deck", fetch = EAGER, cascade = [CascadeType.ALL])
        val cards: List<Card>? = null,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0
)
