package kgb.plum.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import kgb.plum.composestudy.ConstraintLayoutUpActivity.Companion.cardData
import kgb.plum.composestudy.ui.theme.ComposeStudyTheme

class ConstraintLayoutUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxWidth()){
                        CardEx(cardData)
                        CardEx(cardData)
                        CardEx(cardData)
                    }
                }
            }
        }
    }

    companion object{
        val cardData = CardData(
            imageUri = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory&fname=https://k.kakaocdn.net/dn/EShJF/btquPLT192D/SRxSvXqcWjHRTju3kHcOQK/img.png",
            imageDescription = "종",
            author = "김근범",
            description = "말풍선 안의 종"
        )
    }
}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun CardEx(cardData : CardData){
    val placeHolder = Color(0x33000000)

    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(4.dp),
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()){

            val (image, author, description) = createRefs()
            AsyncImage(
                model = cardData.imageUri,
                contentDescription = cardData.imageDescription,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(color = placeHolder),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
                    .constrainAs(image){
                        start.linkTo(parent.start, margin = 8.dp)
                        top.linkTo(parent.top, margin = 4.dp)
                        bottom.linkTo(parent.bottom, margin = 4.dp)
                    }
            )
            Text(
                text = cardData.author,
                modifier = Modifier
                    .constrainAs(author){
                        start.linkTo(image.end, margin = 8.dp)
                        top.linkTo(parent.top, margin = 4.dp)
                    }
            )
            Text(
                text = cardData.description,
                modifier = Modifier
                    .constrainAs(description){
                        start.linkTo(author.start)
                        top.linkTo(author.bottom, margin = 4.dp)
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    ComposeStudyTheme {
        CardEx(cardData)
    }
}

data class CardData(
    val imageUri : String,
    val imageDescription : String,
    val author : String,
    val description: String
)