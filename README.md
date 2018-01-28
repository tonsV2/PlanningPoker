# Planning poker

## TODO
* Lots of repositories should return optional... Right?



# Design stuff

## Create game
* Generate uuid for game
* Pick cards (nth)
* Add stories

## Join game
* Add player to game
* Get list of players
* Get list of stories

## Show game 
* Show current story
* Pick card


## Entities
### Game
* key - uuid
* datetime
* owner (playerId)
* cardGroupId

### Story
* title
* gameId

### Player
* name
* gameId

### Card
* title
* value
* cardGroupId

### CardGroup
* title
