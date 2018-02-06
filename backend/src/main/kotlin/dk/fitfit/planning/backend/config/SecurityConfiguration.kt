package dk.fitfit.planning.backend.config

import dk.fitfit.planning.backend.security.TokenAuthenticationFilter
import dk.fitfit.planning.backend.security.TokenAuthenticationProvider
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration(val tokenFilter: TokenAuthenticationFilter, val authenticationProvider: TokenAuthenticationProvider) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http
                .addFilterBefore(tokenFilter, BasicAuthenticationFilter::class.java)
                .antMatcher("/**")
                .authorizeRequests()
                .anyRequest().authenticated()

                .and()
//                .csrf().csrfTokenRepository(HttpSessionCsrfTokenRepository())
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository())
                // TODO: Don't disable
                .csrf().disable()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider)
    }
}
