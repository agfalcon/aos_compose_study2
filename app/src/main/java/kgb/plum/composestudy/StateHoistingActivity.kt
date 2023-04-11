package kgb.plum.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kgb.plum.composestudy.ui.theme.ComposeStudyTheme

class StateHoistingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PyeongToSquareMeter()
                }
            }
        }
    }
}

@Composable
fun PyeongToSquareMeter() {
    var pyeong by rememberSaveable {mutableStateOf("23")}
    var squaremeter by rememberSaveable { mutableStateOf((23 * 3.306).toString())}

   PyeongToSquareMeterStateless(
       pyeong = pyeong,
       squareMeter = squaremeter,
   ){
       if(it.isBlank()){
           pyeong = ""
           squaremeter = ""
           return@PyeongToSquareMeterStateless
       }
       val numericValue = it.toFloatOrNull() ?: return@PyeongToSquareMeterStateless
       pyeong = it
       squaremeter = (numericValue * 3.306).toString()
   }

}

@Composable
fun PyeongToSquareMeterStateless(pyeong: String, squareMeter: String, onPyeongChange: (String) -> Unit){
    Column(modifier = Modifier.padding(16.dp)){
        OutlinedTextField(
            value = pyeong,
            onValueChange = onPyeongChange
            , label = {
                Text("평")
            }
        )
        OutlinedTextField(
            value = squareMeter,
            onValueChange = {

            }, label = {
                Text("제곱미터")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview11() {
    ComposeStudyTheme {
        PyeongToSquareMeter()
    }
}