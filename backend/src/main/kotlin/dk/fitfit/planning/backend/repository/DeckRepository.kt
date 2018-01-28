package dk.fitfit.planning.backend.repository

import dk.fitfit.planning.backend.domain.Deck
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeckRepository : JpaRepository<Deck, Long>
