package dk.fitfit.planning.backend.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority

class TokenAuthentication(private val token: String) : Authentication {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf()

    override fun setAuthenticated(isAuthenticated: Boolean) {
    }

    override fun getName(): String = ""

    override fun getCredentials(): Any = token

    override fun getPrincipal(): Any? = null

    override fun isAuthenticated(): Boolean = false

    override fun getDetails(): Any? = null
}
