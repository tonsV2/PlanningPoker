package dk.fitfit.planning.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Story(
        var title: String,
        @JsonIgnore
        @ManyToOne
        var game: Game,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
) {
    constructor() : this("", Game())
}
