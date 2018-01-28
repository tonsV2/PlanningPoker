package dk.fitfit.planning.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Story(
        // TODO: Should be indexed
        val title: String,
        @JsonIgnore
        @ManyToOne
        // TODO: Could this be val?
        // dk/fitfit/planning/backend/controller/GameController.kt:31
        var game: Game? = null,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0
) {
    constructor() : this(title = "")
}
