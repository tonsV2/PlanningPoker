package dk.fitfit.planning.backend.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.Charset
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class TokenAuthenticationFilter : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest?, response: HttpServletResponse?, filterChain: FilterChain?) {
        val context = SecurityContextHolder.getContext()
        if (context.authentication == null || context?.authentication?.isAuthenticated == false) {
            val token = getToken(request)
            if (token != null) {
                val auth = TokenAuthentication(token)
                context.authentication = auth
            }
        }
        filterChain?.doFilter(request, response)
    }

    private fun getToken(request: HttpServletRequest?): String? {
        val header = request?.getHeader("Authorization")
        if (header != null && header.startsWith("Basic ")) {
            val base64Credentials = header.substring(6)
            val credentials = String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"))
            val values = credentials.split(":".toRegex(), 2).toTypedArray()
            return values[1]
        }
        return null
    }
}
