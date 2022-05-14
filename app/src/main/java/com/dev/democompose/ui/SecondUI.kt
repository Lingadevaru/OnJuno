package com.dev.democompose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.democompose.viewmodel.emptyvm.CryptoEmptyViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import coil.ComponentRegistry
import coil.ImageLoader
import coil.compose.*
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.dev.democompose.R
import com.dev.democompose.viewmodel.valuevm.CryptoValueViewModel

@Composable
fun SecondUI(
    viewModelValue: CryptoValueViewModel = hiltViewModel(),
    viewModelEmpty: CryptoEmptyViewModel = hiltViewModel()
) {
    val stateEmpty = viewModelEmpty.state.value
    val stateValue = viewModelValue.state.value

    Box(modifier = Modifier.wrapContentSize()) {
        Column(modifier = Modifier.wrapContentSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    painterResource(id = R.drawable.btc),
                    //painter = rememberAsyncImagePainter("https://ibb.co/LZSmRrn"),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )

                Column {
                    Text(
                        text = "${stateEmpty.cryptoEmpty?.crypto_balance?.title}",
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "${stateEmpty.cryptoEmpty?.crypto_balance?.subtitle}",
                        style = MaterialTheme.typography.body2
                    )
                }
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterVertically),
                    border = BorderStroke(
                        width = 1.dp,
                        color = androidx.compose.ui.graphics.Color.Blue
                    )
                ) {
                    Text(text = "Deposit")
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Your Crypto Holdings",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .weight(0.5f, false)) {
                stateEmpty.cryptoEmpty?.your_crypto_holdings?.let {
                    items(it.filterNotNull()) { crypto_holding ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                        ) {
                            //AsyncImage(model = crypto_holding.logo, contentDescription = null)

                            Image(
                                painterResource(id = R.drawable.btc),
                                //painter = rememberAsyncImagePainter("https://ibb.co/LZSmRrn"),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .align(Alignment.CenterVertically)
                            )

                            Spacer(modifier = Modifier.width(10.0.dp))

                            Text(text = crypto_holding.title, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier
                                .weight(0.5f)
                                .align(Alignment.CenterVertically))

                            OutlinedButton(
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(24.dp),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .weight(0.5f)
                                    .align(Alignment.CenterVertically),
                                border = BorderStroke(
                                    width = 1.dp,
                                    color = androidx.compose.ui.graphics.Color.Blue,
                                )
                            ) {
                                Text(text = "Deposit")
                            }

//                            Spacer(modifier = Modifier.width(5.0.dp))

                            OutlinedButton(
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(24.dp),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.CenterVertically),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                            ) {
                                Text(
                                    text = "Buy",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Recent Transactions",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "View All",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End,
                    color = androidx.compose.ui.graphics.Color.Blue
                )
            }

            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f, fill = false)) {
                stateValue.cryptoValue?.all_transactions?.let {
                    items(it.filterNotNull()) { crypto_holding ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
//                            Image(
//                                painter = rememberAsyncImagePainter(crypto_holding.txn_logo),
//                                contentDescription = null
//                            )

                            Image(
                                painterResource(id = R.drawable.btc),
                                //painter = rememberAsyncImagePainter("https://ibb.co/LZSmRrn"),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .align(Alignment.CenterVertically)
                            )

                            Spacer(modifier = Modifier.width(10.0.dp))

                            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
                                Text(text = crypto_holding.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                Text(text = crypto_holding.txn_time)
                            }

                            Text(text = "$"+crypto_holding.txn_amount, color = Color.Cyan, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterVertically), textAlign = TextAlign.End)
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Current Prices",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                stateEmpty.cryptoEmpty?.crypto_prices?.let {
                    items(it.filterNotNull()) { crypto_holding ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Image(
                                painterResource(id = R.drawable.btc),
                                //painter = rememberAsyncImagePainter("https://ibb.co/LZSmRrn"),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                            )

                            Text(text = crypto_holding.title, fontSize = 16.sp)
                            Text(text = "$"+crypto_holding.current_price_in_usd, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}
