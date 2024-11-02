package com.example.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.dashboard.ui.theme.DashBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashBoardTheme {
               dashboard()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Preview(showBackground = true)
@Composable
fun dashboard() {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = colorResource(R.color.P3)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(

            Modifier
                .fillMaxWidth()
                .height(245.dp)
                .background(
                    color = colorResource(R.color.purple_500),
                    shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
                )
        )
        {
        Row(
            modifier = Modifier
                .padding(top = 40.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .height(100.dp)
                    .padding(14.dp)
                    .weight(0.7f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Hello",
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(fontSize = 22.sp,
                    text ="David Friedman ",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top=14.dp))


            }
            Image(contentDescription = null, painter = painterResource(R.drawable.profile), modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .clickable { })
        }
        }

        }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 180.dp, start = 24.dp, end = 24.dp)
            .shadow(3.dp, shape = RoundedCornerShape(20.dp))
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )) {
        Column(modifier = Modifier
            .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
            .height(90.dp)
            .width(90.dp)
            .background(
                color = colorResource(R.color.P1), shape = RoundedCornerShape(20.dp)
            )
            , horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(R.drawable.video_call), contentDescription = null,Modifier.padding(top = 8.dp, bottom = 4.dp))
            Text(text = "Video Call", fontSize = 14.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, color = colorResource(R.color.P2))

        }
        Column(modifier = Modifier
            .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
            .height(90.dp)
            .width(90.dp)
            .background(
                color = colorResource(R.color.P1), shape = RoundedCornerShape(20.dp)
            )
            , horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(R.drawable.voice_call), contentDescription = null,Modifier.padding(top = 8.dp, bottom = 4.dp))
            Text(text = "Voice Call", fontSize = 14.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, color = colorResource(R.color.P2))

        }
        Column(modifier = Modifier
            .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
            .height(90.dp)
            .width(90.dp)
            .background(
                color = colorResource(R.color.P1), shape = RoundedCornerShape(20.dp)
            )
            , horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(R.drawable.notification), contentDescription = null,Modifier.padding(top = 8.dp, bottom = 4.dp))
            Text(text = "Notification", fontSize = 14.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, color = colorResource(R.color.P2))

        }



    }
    var text by rememberSaveable { mutableStateOf("") }
    TextField(value = text, onValueChange = {text=it}, modifier = Modifier
        .padding(top = 310.dp, start = 24.dp, end = 24.dp)
        .fillMaxWidth()
        .shadow(3.dp, shape = RoundedCornerShape(50.dp)), label = { Text(text="Searching For...") }, trailingIcon = { Image(painter = painterResource(id=R.drawable.search_icon), contentDescription = null, modifier = Modifier
        .size(43.dp)
        .padding(end = 6.dp))},
        shape = RoundedCornerShape(50.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent)
    )
    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 394.dp, end = 24.dp, start = 24.dp)
        .shadow(3.dp, shape = RoundedCornerShape(25.dp))
        .height(145.dp)
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    colorResource(R.color.purple_500),
                    colorResource(R.color.p5)
                )
            ), shape = RoundedCornerShape(24.dp)
        )) {
        val (img,text1,text2)= createRefs()
        Image(modifier = Modifier.constrainAs(img){
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)

        },
            painter = painterResource(R.drawable.logo),
            contentDescription = ""
        )
        Text(text="To get Unlimited", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White,
            modifier = Modifier
                .padding(top = 32.dp)
                .constrainAs(text1) {
                    top.linkTo(parent.top)
                    end.linkTo(img.start)
                    start.linkTo(parent.start)
                })
        Text(text="Upgrade Your Account", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White,
            modifier = Modifier
                .padding(top = 32.dp)
                .constrainAs(text2) {
                    top.linkTo(text1.bottom)
                    end.linkTo(text1.end)
                    start.linkTo(text1.start)
                })


    }
    ConstraintLayout() {


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 570.dp)
        ) {
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_1),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Inbox", fontWeight = FontWeight.Bold, fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(R.color.p6)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_2),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Maps", fontWeight = FontWeight.Bold, fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(R.color.p6)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_4),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Reports", fontWeight = FontWeight.Bold, fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(R.color.p6)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_3),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Chats", fontWeight = FontWeight.Bold, fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(R.color.p6)
                )
            }

        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 690.dp)
        ) {
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_5),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Calendar", fontWeight = FontWeight.Bold, fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(R.color.p6)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_6),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Feedback", fontWeight = FontWeight.Bold, fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(R.color.p6)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_7),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Settings", fontWeight = FontWeight.Bold, fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(R.color.p6)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_8),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "More", fontWeight = FontWeight.Bold, fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(R.color.p6)
                )
            }
    }
        }


}





