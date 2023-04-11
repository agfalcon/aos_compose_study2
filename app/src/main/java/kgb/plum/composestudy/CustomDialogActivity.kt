package kgb.plum.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kgb.plum.composestudy.ui.theme.ComposeStudyTheme

class CustomDialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CustomDialog()
                }
            }
        }
    }
}

@Composable
fun Greeting6(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun CustomDialog(){
    var openDialog by remember {mutableStateOf(false)}
    var counter by remember { mutableStateOf(0) }

    Column{
        Button(onClick = {
            openDialog = true
        }){
            Text("다이얼로그 열기")
        }
        Text("카운터 : $counter")
    }

    if(openDialog){
        Dialog(onDismissRequest = {
            openDialog = false
        }) {
            Surface {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("버튼을 클릭해주세요.\n * +1을 누르면 값이 증가됩니다.\n * -1을 누르면 값이 감소합니다.")
                    Row(modifier = Modifier.align(Alignment.End)) {
                        Button(onClick = {
                            openDialog = false
                        }){
                            Text("취소")
                        }
                        Spacer(modifier = Modifier.size(8.dp))
                        Button(onClick = {
                            openDialog = false
                            counter--
                        }){
                            Text("-1")
                        }
                        Spacer(modifier = Modifier.size(8.dp))
                        Button(onClick = {
                            openDialog = false
                            counter++
                        }){
                            Text("+1")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    ComposeStudyTheme {
        CustomDialog()
    }
}