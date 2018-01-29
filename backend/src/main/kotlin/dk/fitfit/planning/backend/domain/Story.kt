package dk.fitfit.planning.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(indexes = [Index(columnList = "title")])
class Story(
        val title: String,
        // TODO: Stories and hands should probably be seperated by rounds... Since we might want to replay x number of times
        @OneToMany(mappedBy = "story", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        val hands: MutableSet<Hand> = HashSet(),
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
