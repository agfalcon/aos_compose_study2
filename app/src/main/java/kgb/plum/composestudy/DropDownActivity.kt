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

class DropDownActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DropDownEx()
                }
            }
        }
    }
}

@Composable
fun Greeting7(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DropDownEx(){
    var expandDropDownMenu by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { expandDropDownMenu = true}){
            Text("드롭다운 메뉴 열기")
        }
        Text("카운터 : $counter")
    }

    if(expandDropDownMenu){
        DropdownMenu(
            expanded = expandDropDownMenu,
            onDismissRequest = {
                expandDropDownMenu = false
            }){
            DropdownMenuItem(onClick = {
                counter++
            }) {
                Text("증가")
            }
            DropdownMenuItem(onClick = {
                counter--
            }) {
                Text("감소")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
    ComposeStudyTheme {
        DropDownEx()
    }
}