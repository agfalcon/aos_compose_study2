package kgb.plum.composestudy

import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kgb.plum.composestudy.ui.theme.ComposeStudyTheme

class Animation2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Animation2Ex()
                }
            }
        }
    }
}

@Composable
fun Animation2Ex(){
    var isDarkMode by remember { mutableStateOf(false)}

    val transition = updateTransition(targetState = isDarkMode, label = "다크 모드 트랜지션")

    val background by transition.animateColor(label = "다크 모드 배경") { state ->
        when(state){
            false -> Color.White
            true -> Color.Black
        }
    }

    val wordColor by transition.animateColor(label = "다크 모드 글자색") { state ->
        when(state){
            false -> Color.Black
            true -> Color.White
        }
    }

    val alpha by transition.animateFloat(label = "다크 모드 알파") { state ->
        when(state) {
            false -> 0.7f
            true -> 1.0f
        }
    }

    Column(modifier = Modifier
        .background(background)
        .alpha(alpha)
    ) {
        RadioButtonWithText(text = "일반 모드", color = wordColor, selected = !isDarkMode) {
            isDarkMode = false
        }
        RadioButtonWithText(text = "다크 모드", color = wordColor, selected = isDarkMode) {
            isDarkMode = true
        }

        Crossfade(targetState = isDarkMode) { state ->
            when(state) {
                false -> {
                    Row{
                        Box(modifier = Modifier
                            .background(Color.Red)
                            .size(20.dp)){
                            Text("1")
                        }
                        Box(modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)){
                            Text("2")
                        }
                        Box(modifier = Modifier
                            .background(Color.Green)
                            .size(20.dp)){
                            Text("3")
                        }
                    }
                }
                true -> {
                    Column{
                        Box(modifier = Modifier
                            .background(Color.Red)
                            .size(20.dp)){
                            Text("A")
                        }
                        Box(modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)){
                            Text("B")
                        }
                        Box(modifier = Modifier
                            .background(Color.Green)
                            .size(20.dp)){
                            Text("C")
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun RadioButtonWithText(
    text: String,
    color: Color = Color.Black,
    selected : Boolean,
    onClick: () -> Unit
){
    Row(
        modifier = Modifier.selectable(
            selected = selected,
            onClick = onClick
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Text(text= text, color = color)
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview13() {
    ComposeStudyTheme {
        Animation2Ex()
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonWithTextView(){
    ComposeStudyTheme {
        RadioButtonWithText(
            text = "라디오 버튼",
            color = Color.Red,
            selected = true,
            onClick = {}
        )
    }
}