package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.Game
import dk.fitfit.planning.backend.domain.Story

interface StoryService {
    fun save(title: String, game: Game): Story
}
