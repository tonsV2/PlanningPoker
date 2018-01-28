package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.Player
import dk.fitfit.planning.backend.repository.PlayerRepository
import org.springframework.stereotype.Service

@Service
class PlayerServiceImpl(val playerRepository: PlayerRepository) : PlayerService {
    override fun findOrCreatePlayer(playerName: String): Player {
        val optional = playerRepository.findByName(playerName)
        return if(optional.isPresent) {
            optional.get()
        } else {
            val player = Player(playerName)
            playerRepository.save(player)
        }
    }
}
