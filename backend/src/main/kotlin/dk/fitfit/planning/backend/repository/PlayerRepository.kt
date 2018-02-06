package dk.fitfit.planning.backend.repository

import dk.fitfit.planning.backend.domain.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PlayerRepository : JpaRepository<Player, Long> {
    fun findByName(owner: String): Optional<Player>
    fun findByToken(token: String): Optional<Player>
}
