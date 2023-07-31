package com.example.buyerapp.presenter.home.tabs.main.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buyerapp.R

@Composable
fun MainCard(onClickBarCode: () -> Unit) {


    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .height(400.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20.dp))
            .background(colorResource(id = R.color.gray2))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.6f)
                .background(colorResource(id = R.color.black2))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .paint(painterResource(id = R.drawable.board), alignment = Alignment.BottomEnd)
            ) {
                Text(
                    text = buildAnnotatedString {
                        append(
                            AnnotatedString(
                                "BY!", spanStyle = SpanStyle(
                                    colorResource(id = R.color.edt_phone)
                                )
                            )
                        )
                        append(" Выход из\r\nлюбой ситуации")
                    },
                    fontFamily = FontFamily.Default,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.W800,
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    color = colorResource(id = R.color.white),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 28.dp, top = 20.dp)
                )

                Text(
                    text = "Реклама для мозга",
                    fontFamily = FontFamily.Default,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    color = colorResource(id = R.color.white).copy(0.4f),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 28.dp, top = 5.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.4f)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 22.dp, top = 24.dp, end = 27.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        Modifier
                            .size(60.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(Color.Black)
                            .clickable {
                                onClickBarCode()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.barcode_botton_nav),
                            contentDescription = "Bar Code",
                            tint = colorResource(id = R.color.white)
                        )
                    }
                    Text(
                        text = "Bar Code",
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 13.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }

                Column {
                    Box(
                        Modifier
                            .size(60.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(Color.Black.copy(alpha = 0.3f))
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.nfc_btn),
                            contentDescription = "NFC",
                            tint = colorResource(id = R.color.white)
                        )
                    }
                    Text(
                        text = "NFC",
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 13.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }

                Column {
                    Box(
                        Modifier
                            .size(60.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(Color.Black)
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.card),
                            contentDescription = "Карты",
                            tint = colorResource(id = R.color.white)
                        )
                    }

                    Text(
                        text = "Карты",
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 13.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}