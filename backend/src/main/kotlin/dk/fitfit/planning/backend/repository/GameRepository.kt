package dk.fitfit.planning.backend.repository

import dk.fitfit.planning.backend.domain.Game
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GameRepository : JpaRepository<Game, Long> {
    fun findByKey(key: String): Optional<Game>
}
