# Planning poker

## Inspiration
* https://scrumpoker.online/
* https://pokerscrum.herokuapp.com/static/login

## TODO
* Lots of repositories should return optional... Right?
* https://thekiwee.deviantart.com/art/Poker-icon-94902263

## Api requests
* http -f POST :8080/games fingerprint=finger

# Design stuff

## UI Sections
* Story
* Votes (cards played)
* Cards
* Players
* Stories

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
