package kgb.plum.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kgb.plum.composestudy.ui.theme.ComposeStudyTheme

class DialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DialogEx()
                }
            }
        }
    }
}

@Composable
fun Greeting5(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DialogEx(){
    var openDialog by remember {mutableStateOf(false)}
    var counter by remember { mutableStateOf(0) }

    Column{
        Button(onClick = { openDialog = true}){
            Text("Open Dialog")
        }
        Text("카운터: $counter")
    }

    if(openDialog){
        AlertDialog(onDismissRequest = {
            openDialog = false
        }, confirmButton = {
            Button(onClick = {
                counter++
                openDialog = false
            }) {
                Text("더하기")
            }
        }, dismissButton = {
            Button(onClick = {
                openDialog = false
            }){
              Text("취소")
            }
        }, title = {
                   Text("더하기")
        }, text = {
            Text("더하기 버튼을 누르면 카운터를 증가시킬 수 있습니다.")
        })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    ComposeStudyTheme {
        DialogEx()
    }
}