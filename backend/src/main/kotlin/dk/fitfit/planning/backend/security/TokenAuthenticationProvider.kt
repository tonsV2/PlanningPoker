package dk.fitfit.planning.backend.security

import dk.fitfit.planning.backend.service.PlayerService
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.stereotype.Component

@Component
class TokenAuthenticationProvider(val playerService: PlayerService) : AuthenticationProvider {
    override fun authenticate(authentication: Authentication): Authentication {
        if (authentication.isAuthenticated) {
            return authentication
        }
        val token = authentication.credentials.toString()
        val player = playerService.findOrCreateByToken(token)
        val preAuth = PreAuthenticatedAuthenticationToken(player, token)
        preAuth.isAuthenticated = true
        return preAuth
    }

    override fun supports(authentication: Class<*>?): Boolean = TokenAuthentication::class.java.isAssignableFrom(authentication)
}
