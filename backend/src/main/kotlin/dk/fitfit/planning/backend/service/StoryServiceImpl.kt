package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.Story
import dk.fitfit.planning.backend.repository.StoryRepository
import org.springframework.stereotype.Service

@Service
class StoryServiceImpl(val storyRepository: StoryRepository) : StoryService {
    override fun findOrCreate(storyTitle: String): Story {
        val optional = storyRepository.findByTitle(storyTitle)
        return if (optional.isPresent) {
            optional.get()
        } else {
            val story = Story(storyTitle)
            storyRepository.save(story)
        }
    }
}
