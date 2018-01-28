package dk.fitfit.planning.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Card(
        val title: String,
        val value: Int,
        @JsonIgnore
        @ManyToOne
        val group: CardGroup,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0
) {
    constructor() : this("", 0, CardGroup("", null), 0)
}
