package o1.flappy

import o1.*

// This class is introduced in Chapter 2.7.

val sky        = rectangle(ViewWidth, ViewHeight,  LightBlue)
val ground     = rectangle(ViewWidth, GroundDepth, SandyBrown)
val trunk      = rectangle(30, 250, SaddleBrown)
val foliage    = circle(200, ForestGreen)
val tree       = trunk.onto(foliage, TopCenter, Center)
val rootedTree = tree.onto(ground, BottomCenter, Pos(ViewWidth / 2, 30))
val scenery    = sky.place(rootedTree, BottomLeft, BottomLeft)


val bugPic = Pic("ladybug.png")


def rockPic(obstacle: Obstacle) = circle(obstacle.radius * 2, Black)


// INSERT YOUR OWN CODE BELOW.

val myGame = Game()

object flappyView extends View(myGame, "FlappyBug" ):
  var background = scenery


  def makePic = {
    var s1 = background
    //var s1 = scenery.place(bugPic, myGame.bug.pos)
    //val s2 = s1.place( rockPic ( myGame.obstacle ), myGame.obstacle.pos )
    //s2
    for ( ob <- myGame.obstacles ) do
      s1 = s1.place( rockPic (ob), ob.pos )
    s1 = s1.place(bugPic, myGame.bug.pos)
    s1
  }

  override def onKeyDown(pressedKey: Key) =
    myGame.activateBug()


  override def onTick() = {
    this.background = this.background.shiftLeft(2)
    myGame.timePasses()
  }


  override def isDone = myGame.isLost


end flappyView

@main def launchFlappy() =
  flappyView.start()













