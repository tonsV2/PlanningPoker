package dk.fitfit.planning.backend.repository

import dk.fitfit.planning.backend.domain.CardGroup
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardGroupRepository : JpaRepository<CardGroup, Long>
