package kgb.plum.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kgb.plum.composestudy.ui.theme.ComposeStudyTheme
import kotlinx.coroutines.launch

class BottomAppBarActivitiy : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BottomAppBarEx()
                }
            }
        }
    }
}

@Composable
fun Greeting8(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun BottomAppBarEx(){
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    var counter by remember {mutableStateOf(0)}

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomAppBar(){
                Text("헬로")
                Button(onClick = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("안녕하세요")
                    }
                }){
                    Text("인사하기")
                }
                Button(onClick = {
                    counter++
                    coroutineScope.launch{
                        scaffoldState.snackbarHostState.showSnackbar("${counter}입니다.")
                    }
                }){
                    Text("더하기")
                }
                Button(onClick = {
                    counter--
                    coroutineScope.launch{
                        scaffoldState.snackbarHostState.showSnackbar("${counter}입니다.")
                    }
                }){
                    Text("빼기")
                }
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Text(
                text = "카운터는 ${counter}회입니다.",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    ComposeStudyTheme {
        BottomAppBarEx()
    }
}