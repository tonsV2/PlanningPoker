package dk.fitfit.planning.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
// TODO: What about replay? A player is allowed to play the same card on the same story again
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["card_id", "story_id", "player_id"])])
class Hand(
        @ManyToOne
        var card: Card? = null,
        @ManyToOne
        @JsonIgnore
        var story: Story? = null,
        @ManyToOne
        var player: Player? = null,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0
)
