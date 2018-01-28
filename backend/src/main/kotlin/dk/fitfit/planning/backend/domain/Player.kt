package dk.fitfit.planning.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Player(
        // TODO: Should be indexed
        val name: String,
        @ManyToOne
        @JsonIgnore
        // TODO: Could this be val?
        // dk/fitfit/planning/backend/controller/GameController.kt:44
        var game: Game? = null,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0
) {
    constructor() : this(name = "")
}
