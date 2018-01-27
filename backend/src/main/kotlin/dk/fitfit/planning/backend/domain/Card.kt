package dk.fitfit.planning.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Card(
        var title: String = "1",
        var value: Int = 0,
        @JsonIgnore
        @ManyToOne
        var group: CardGroup,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
) {
    constructor() : this("", 0, CardGroup(), 0)
}
