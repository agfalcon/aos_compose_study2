package kgb.plum.composestudy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kgb.plum.composestudy.ui.theme.ComposeStudyTheme

class SideEffectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SideEffectEx()
                }
            }
        }
    }
}

@Composable
fun SideEffectEx(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current){
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(scaffoldState.snackbarHostState){
        scaffoldState.snackbarHostState.showSnackbar("LaunchedEffect")
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when(event) {
                Lifecycle.Event.ON_START -> {
                    Log.d("이펙트", "ON_START")
                }
                Lifecycle.Event.ON_STOP -> {
                    Log.d("이펙트", "ON_STOPT")
                }
                Lifecycle.Event.ON_PAUSE -> {
                    Log.d("이펙트", "ON_PAUSE")
                }
                Lifecycle.Event.ON_RESUME -> {
                    Log.d("이펙트", "ON_RESUME")
                }
                else-> {
                   Log.d("이펙트", "그 외!!")
                }
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) {

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview14() {
    ComposeStudyTheme {
        SideEffectEx()
    }
}