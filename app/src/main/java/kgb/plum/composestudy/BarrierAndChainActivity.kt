package kgb.plum.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import kgb.plum.composestudy.ui.theme.ComposeStudyTheme

class BarrierAndChainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ConstrainEx()
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ConstrainEx(){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ){
        val (redBox, yellowBox, magentaBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox){
                    top.linkTo(parent.top, margin = 18.dp)
                }
        )
        Box(
            modifier =  Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox){
                    top.linkTo(parent.top, margin = 32.dp)
                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox){
                    top.linkTo(parent.top, margin = 20.dp)
                }
        )

        //createVerticalChain(redBox, yellowBox, magentaBox)
        createHorizontalChain(redBox, magentaBox, yellowBox, chainStyle = ChainStyle.SpreadInside)

        val bottomBarrier = createBottomBarrier(redBox, yellowBox, magentaBox)
        Text(
            text = "I loved you so mush, and I still miss you... Come back to me. I loved you so mush, and I still miss you... Come back to me.",
            modifier = Modifier.constrainAs(text){
                top.linkTo(bottomBarrier)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeStudyTheme {
        ConstrainEx()
    }
}