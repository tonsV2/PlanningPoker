package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.Player
import dk.fitfit.planning.backend.repository.PlayerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PlayerServiceImpl(val playerRepository: PlayerRepository) : PlayerService {
    override fun findByToken(token: String): Optional<Player> {
        return playerRepository.findByToken(token)
    }

    override fun findOrCreateByToken(token: String): Player {
        val optional = playerRepository.findByToken(token)
        return if (optional.isPresent) {
            optional.get()
        } else {
            val player = Player()
            player.token = token
            playerRepository.save(player)
        }
    }

    override fun findById(playerId: Long): Player {
        return playerRepository.getOne(playerId)
    }

    override fun findOrCreate(playerName: String): Player {
        val optional = playerRepository.findByName(playerName)
        return if (optional.isPresent) {
            optional.get()
        } else {
            val player = Player(playerName)
            playerRepository.save(player)
        }
    }
}
