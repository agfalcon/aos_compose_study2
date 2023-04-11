package kgb.plum.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kgb.plum.composestudy.ui.theme.ComposeStudyTheme
import kotlinx.coroutines.launch

class SnackBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SnackBarEx()
                }
            }
        }
    }
}

@Composable
fun SnackBarEx(){
    var counter by remember { mutableStateOf(0)}

    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState){
        Button(onClick = {
            counter++
            coroutineScope.launch{
                val result = scaffoldState.snackbarHostState.showSnackbar(
                    message = "카운터는 ${counter}입니다.",
                    actionLabel = "닫기",
                    duration = SnackbarDuration.Short
                )
            }
        }){
            Text("더하기")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
    ComposeStudyTheme {
        SnackBarEx()
    }
}