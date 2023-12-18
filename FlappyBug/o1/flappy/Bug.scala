package o1.flappy
import o1.*
class Bug(initialPos: Pos):
  val radius = BugRadius
  private var yVelocity = 0.0
  private var currentPos = initialPos
  
  
  def pos = this.currentPos
  
  
  def flap(strength: Double) =
    this.yVelocity = -strength
    
    
  def fall() =
    this.yVelocity = this.yVelocity + Gravity
    this.move(this.yVelocity)
    
    
  def move(yDiff: Double) =
    this.currentPos = this.currentPos.addY(yDiff).clampY(0, GroundY)
    
    
  override def toString = s"center at $pos, radius $radius"
  
  
  def isInBounds =
    if 0 < this.pos.y && this.pos.y < 350 then true else false
    
    
end Bug
