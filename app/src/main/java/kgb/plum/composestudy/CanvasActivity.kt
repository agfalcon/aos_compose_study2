package kgb.plum.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.materialPath
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kgb.plum.composestudy.ui.theme.ComposeStudyTheme

class CanvasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CanvasEx()
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun CanvasEx(){
    Canvas(modifier = Modifier.size(20.dp)){
        drawLine(Color.Red, Offset(20f,10f), Offset(50f, 40f))
        drawCircle(Color.Blue, radius = 10f, Offset(20f, 20f))
        drawRect(Color.Yellow, Offset(10f, 40f), Size(10f, 10f))

//        materialPath {
//            moveTo(2.01f, 21.0f)
//            lineTo(23.0f, 12.0f)
//            lineTo(2.01f, 3.0f)
//            lineTo(2.0f, 10.0f)
//            lineToRelative(15.0f, 2.0f)
//            lineToRelative(-15.0f, 2.0f)
//            close()
//        }

        drawLine(Color.Green, Offset(2.01f, 21.0f), Offset(23.0f, 12.0f))
        drawLine(Color.Green, Offset(23.0f, 12.0f), Offset(2.01f, 3.0f))
        drawLine(Color.Green, Offset(2.01f, 3.0f), Offset(2.0f, 10.0f))
        drawLine(Color.Green, Offset(2.0f, 10.0f), Offset(17.0f, 12.0f))
        drawLine(Color.Green, Offset(17.0f, 12.0f), Offset(2.0f, 14.0f))
        drawLine(Color.Green, Offset(2.0f, 14.0f), Offset(2.01f, 21.0f))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    ComposeStudyTheme {
        CanvasEx()
    }
}