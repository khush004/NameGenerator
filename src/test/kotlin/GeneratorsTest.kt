import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

internal class GeneratorsTest {

    private val generator: Generators = Generators()

    @Test
    fun testiOSName() {
        screenName = "Splash Screen"
        assertEquals("SplashScreen", generator.getiOSName(), "names are not equal")
    }

    @Test
    fun testAndroidName() {
        screenName = "Splash Screen3223443"
        generator.removeSpecialCharacters()
        assertEquals("Splash_Screen", generator.getAndroidName(), "names are not equal")
    }

    @Test
    fun testFlutterName() {
        screenName = "###Splash Screen"
        generator.removeSpecialCharacters()
        assertEquals("splash_screen", generator.getFlutterName(), "names are not equal")
    }

    @Test
    fun testSpecialCharacterName() {
        screenName = "@#test; erert"
        generator.removeSpecialCharacters()
        assertNotEquals("test", generator.getAndroidName())
    }

    @Test
    fun testNumaricName() {
        screenName = "123test$%"
        generator.removeSpecialCharacters()
        assertEquals("test", generator.getFlutterName())
    }


}