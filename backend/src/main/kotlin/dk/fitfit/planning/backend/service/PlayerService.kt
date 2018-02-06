package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.Player
import java.util.*

interface PlayerService {
    fun findOrCreate(playerName: String): Player
    // TODO: Should this method return Optional<Player>?
    fun findById(playerId: Long): Player
    fun findOrCreateByToken(token: String): Player

    fun findByToken(token: String): Optional<Player>
}
