package dk.fitfit.planning.backend.repository

import dk.fitfit.planning.backend.domain.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository : JpaRepository<Card, Long>
