package dk.fitfit.planning.backend.repository

import dk.fitfit.planning.backend.domain.Hand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HandRepository : JpaRepository<Hand, Long>
