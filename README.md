# Pacman Kata (in Kotlin)

## Responsibilities

  * Grid
  	* size
  	* paths[]
  	* bonus[]
  		* x,y
  * Pacman
  	* x,y, direction
  	* state (dead/alive/eating)
  * Monsters
  	* x,y, direction
  	* state (dead/alive/being eaten)
  	* movement strategy
  * Statistics
  	* level
  	* score
  	* max_score

## Order of implementation

  * MVP: small grid, no monsters, dots, move the pacman
  * add monsters (without bonus)
  * add bonus (to kill monsters)
  * add more monsters
  * add walls
  * statistics
