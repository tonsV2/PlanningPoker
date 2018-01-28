package dk.fitfit.planning.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Player(
        var name: String,
        @ManyToOne
        @JsonIgnore
        var game: Game? = null,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
)
