package dk.fitfit.planning.backend.service

import dk.fitfit.planning.backend.domain.Story

interface StoryService {
    fun findOrCreate(storyTitle: String): Story
    fun findById(storyId: Long): Story
}
