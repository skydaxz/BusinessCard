package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Design(fullname = stringResource(R.string.fullname), grade = stringResource(R.string.grade),
                        colour = Color(0xFF3ddc84),
                        img1 = painterResource(id = R.drawable.logo),img2 = painterResource(id = R.drawable.phone_icon), phone = stringResource(id = R.string.phonenum), img3 = painterResource(
                            id = R.drawable.mail), img4 = painterResource(id = R.drawable.location) , email = stringResource(
                            id = R.string.email
                        ) )
                }
            }
        }
    }
}
@Composable
fun Design(fullname: String, grade: String, colour: Color, img1: Painter,img2: Painter, phone: String,img3: Painter,img4: Painter, email: String, modifier: Modifier = Modifier){
    Column (
        modifier = modifier
            .background(colour)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = img1, contentDescription = null
        )
        Text(
            text = fullname,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 50.dp, bottom = 15.dp),
            )
        Text(
            text = grade,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 5.dp, bottom = 50.dp)
        )
        Row(
            modifier = Modifier.size(width = 350.dp, height = 90.dp)
        ) {
            Image(
                painter = img2, contentDescription = null, Modifier.height(50.dp))
            Text(
                text =  phone,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
        }
        Row(
            modifier = Modifier.size(width = 350.dp, height = 90.dp)
        ) {
            Image(painter = img3, contentDescription = null, Modifier.height(50.dp))
            Text(
                text =  email,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
        }
        Row (
            modifier = Modifier.size(width = 350.dp, height = 90.dp)
        ) {
            Image(painter = img4, contentDescription = null, Modifier.height(50.dp))
            ClickableLinkText("palomafp", "https://www.palomafp.org/", Modifier.padding(top = 50.dp))
        }
    }
}
@Composable
fun ClickableLinkText(linkText: String, url: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Text(
        text = linkText,
        color = Color.Blue,
        fontStyle = FontStyle.Italic,
        fontSize = 16.sp,
        modifier = Modifier.clickable {
            val webPage = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webPage)
            context.startActivity(intent)
        }
    )
}
@Preview(showBackground = true)
@Composable
fun Preview() {
    BusinessCardTheme {
        Design(fullname = stringResource(R.string.fullname), grade = stringResource(R.string.grade),
            colour = Color(0xFF3ddc84),
            img1 = painterResource(id = R.drawable.logo),img2 = painterResource(id = R.drawable.phone_icon), phone = stringResource(id = R.string.phonenum), img3 = painterResource(
                  id = R.drawable.mail), img4 = painterResource(id = R.drawable.location) , email = stringResource(
                id = R.string.email
                ) )

    }
}