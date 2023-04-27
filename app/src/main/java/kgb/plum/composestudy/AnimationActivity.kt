package kgb.plum.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

class AnimationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AnimationEx()
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationEx(){
    var helloWorldVisible by remember { mutableStateOf(true)}
    var isRed by remember { mutableStateOf(true)}

    val backgroundColor by animateColorAsState(
        targetValue = if(isRed) Color.Red else Color.White
    )

    val alpha by animateFloatAsState(
        targetValue = if(isRed) 1.0f else 0.5f
    )

    //val backgroundColor = Color.LightGray

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(backgroundColor)
            .alpha(alpha)
    ){
        AnimatedVisibility(
            visible = helloWorldVisible,
            enter = slideInVertically() + expandHorizontally(),
            exit = slideOutHorizontally()
            ) {
            Text(text = "Hello World!")
        }
        Row(
            modifier = Modifier.selectable (
                selected = helloWorldVisible,
                onClick = {
                    helloWorldVisible = true
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = helloWorldVisible,
                onClick = {
                    helloWorldVisible = true
                })
            Text(text = "Hello World 보이기")
        }
        Row(
            modifier = Modifier.selectable(
                selected = !helloWorldVisible,
                onClick = {
                    helloWorldVisible = false
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !helloWorldVisible,
                onClick = {
                    helloWorldVisible = false
                })
            Text(text = "Hello World 감추기")
        }
        Text(text = "배경 색을 바꾸어봅시다.")
        Row(
            modifier = Modifier.selectable(
                selected = !isRed,
                onClick = {
                    isRed = false
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = !isRed,
                onClick = { isRed = false })
            Text(text = "흰색")
        }
        Row(
            modifier = Modifier.selectable(
                selected = isRed,
                onClick = {
                    isRed = true
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = isRed,
                onClick = {
                    isRed = true
                }
            )
            Text(text = "빨간색")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview12() {
    ComposeStudyTheme {
        AnimationEx()
    }
}