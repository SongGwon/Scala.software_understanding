package o1.flappy
import o1.*
class Game:
  val bug      = Bug(Pos(ViewWidth / 10, ViewHeight / 10))
  //val obstacle = Obstacle(70)
  val obstacles = Vector( Obstacle(70), Obstacle(30), Obstacle(20))
  
  
  def activateBug() =
    this.bug.flap(FlapStrength)
    
    
  def timePasses() =
    //this.obstacle.approach()
    //for (obstacle <- obstacles) do
    //  obstacle.approach()
    obstacles.foreach( x => x.approach() )
    this.bug.fall()
      
      
  def isLost =
    var flag = false
    for (obstacle <- this.obstacles) do
      if obstacle.touches(this.bug) then flag = true
    flag || !this.bug.isInBounds
    
    
end Game


