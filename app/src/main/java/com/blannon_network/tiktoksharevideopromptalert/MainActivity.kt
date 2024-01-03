package com.blannon_network.tiktoksharevideopromptalert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blannon_network.tiktoksharevideopromptalert.ui.theme.TiktokShareVideoPromptAlertTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiktokShareVideoPromptAlertTheme {
                var showDialog by remember{ mutableStateOf(false) }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    MyAlertDialog(showDialog = showDialog,
                        closeDialog = {showDialog = false})

                    Button(onClick = {showDialog = true }) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription =null)

                    }

                }
            }
        }
    }
}

@Composable
fun MyAlertDialog(
    showDialog: Boolean,
    closeDialog:() -> Unit
){
    if (showDialog){
        androidx.compose.material3.AlertDialog(
            icon = {
                   Icon(
                       modifier =Modifier
                           .size(60.dp),
                       imageVector = Icons.Default.Warning,
                       contentDescription = null,
                       tint = Color.Black
                   )
            },
            title = {
                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp),
                        fontWeight = FontWeight.Bold,
                        text = stringResource(R.string.alert_message1),
                        textAlign = TextAlign.Center
                    )
            },
            text = {

                Text(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp),
                    text =  stringResource(R.string.alert_message2),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )

            },

            onDismissRequest = { closeDialog() },
            confirmButton = {
                Column (
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                ){
                    Button(onClick = { closeDialog()},
                        modifier = Modifier
                            .padding(start = 30.dp, end = 30.dp)
                            .size(width = 200.dp, height = 50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        )
                        ){
                        Text(
                            text = "Cancel",
                            fontSize = 26.sp
                        )
                    }
                    Text(
                        modifier = Modifier
                            .padding(15.dp)
                            .clickable(onClick = {
                                closeDialog()
                            }),
                        text = stringResource(R.string.share),
                        fontSize = 20.sp,
                        color = Color.Black,

                    )

                }

            },)

    }
}



@Preview
@Composable
fun DialogPreview(){
    TiktokShareVideoPromptAlertTheme {
        MyAlertDialog(showDialog = true) {

        }

        }
    }


