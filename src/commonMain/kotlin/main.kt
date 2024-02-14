
import korlibs.audio.sound.Sound
import korlibs.audio.sound.readMusic
import korlibs.audio.sound.readSound
import korlibs.image.color.*
import korlibs.inject.Injector
import korlibs.korge.*
import korlibs.korge.input.onClick
import korlibs.korge.scene.*
import korlibs.korge.ui.uiButton
import korlibs.korge.ui.uiGridFill
import korlibs.korge.ui.uiVerticalStack
import korlibs.korge.view.*
import korlibs.logger.*
import korlibs.math.geom.*



const val SCREEN_WIDTH = 400
const val SCREEN_HEIGHT = 400

suspend fun main() = Korge(
  windowSize = Size(SCREEN_WIDTH, SCREEN_HEIGHT),
  virtualSize = Size(SCREEN_WIDTH, SCREEN_HEIGHT),
  backgroundColor = Colors["#2b2b2b"]
) {
  val sceneContainer = sceneContainer()
  sceneContainer.changeTo { MyScene() }
}

const val ZOOM = 1

class MyScene : PixelatedScene(SCREEN_WIDTH / ZOOM, SCREEN_HEIGHT / ZOOM) {
  override suspend fun SContainer.sceneInit() {
    width = SCREEN_WIDTH.toDouble() / ZOOM
    height = SCREEN_HEIGHT.toDouble() / ZOOM
  }

  override suspend fun SContainer.sceneMain() {
    uiVerticalStack(width = SCREEN_WIDTH.toDouble()) {
      uiButton(label = "MP3 Sound") {
        onClick { KR.sounds.mp3.__file.readSound().play() }
      }
      uiButton(label = "MP3 Music") {
        onClick { KR.sounds.mp3.__file.readMusic().play() }
      }
      uiButton(label = "WAV Sound") {
        onClick { KR.sounds.wav.__file.readSound().play() }
      }
      uiButton(label = "WAV Music") {
        onClick { KR.sounds.wav.__file.readMusic().play() }
      }
      uiButton(label = "OGG Sound") {
        onClick { KR.sounds.ogg.__file.readSound().play() }
      }
      uiButton(label = "OGG Music") {
        onClick { KR.sounds.ogg.__file.readMusic().play() }
      }
    }
  }
}


