package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.Game
import dk.fitfit.planning.backend.domain.Story
import dk.fitfit.planning.backend.repository.GameRepository
import dk.fitfit.planning.backend.repository.StoryRepository
import org.springframework.stereotype.Service

@Service
class StoryServiceImpl(val storyRepository: StoryRepository, val gameRepository: GameRepository) : StoryService {
    override fun save(title: String, game: Game): Story {
        val story = Story(title, game)
        return storyRepository.save(story)
    }
}
