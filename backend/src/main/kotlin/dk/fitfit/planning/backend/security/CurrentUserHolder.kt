package dk.fitfit.planning.backend.security

import dk.fitfit.planning.backend.domain.Player
import dk.fitfit.planning.backend.service.PlayerService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class CurrentUserHolder(val playerService: PlayerService) {
    val user: Player
        get() = playerService.findByToken(token).get()

    private val token: String
        get() = SecurityContextHolder.getContext().authentication.credentials.toString()
}
