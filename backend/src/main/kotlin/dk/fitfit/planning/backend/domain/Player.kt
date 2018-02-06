package dk.fitfit.planning.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(indexes = [Index(columnList = "token")])
class Player(
        val name: String,
        var token: String? = null,
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
