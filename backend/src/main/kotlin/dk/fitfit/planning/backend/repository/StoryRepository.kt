package dk.fitfit.planning.backend.repository

import dk.fitfit.planning.backend.domain.Story
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StoryRepository : JpaRepository<Story, Long> {
    fun findByTitle(storyTitle: String): Optional<Story>
}
