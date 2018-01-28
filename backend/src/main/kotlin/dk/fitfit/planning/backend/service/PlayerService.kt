package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.Player

interface PlayerService {
    fun findOrCreate(playerName: String): Player
}
