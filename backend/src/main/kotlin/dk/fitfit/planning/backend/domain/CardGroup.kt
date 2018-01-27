package dk.fitfit.planning.backend.domain

import javax.persistence.*
import javax.persistence.FetchType.EAGER

@Entity
class CardGroup(
        var title: String = "",
        @OneToMany(mappedBy = "group", fetch = EAGER, cascade = [CascadeType.ALL])
        var cards: List<Card>? = null,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
)
