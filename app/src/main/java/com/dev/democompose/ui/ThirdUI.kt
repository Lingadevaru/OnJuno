package com.dev.democompose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.democompose.viewmodel.emptyvm.CryptoEmptyViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.dev.democompose.R
import com.dev.democompose.viewmodel.valuevm.CryptoValueViewModel

@Composable
fun ThirdUI(
    viewModelValue: CryptoValueViewModel = hiltViewModel(),
    viewModelEmpty: CryptoEmptyViewModel = hiltViewModel()
) {
    val stateValue = viewModelValue.state.value

    Box(modifier = Modifier.wrapContentSize()) {
        Column(modifier = Modifier.wrapContentSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
            ) {

                Image(
                    painterResource(id = R.drawable.btc),
                    //painter = rememberAsyncImagePainter("https://ibb.co/LZSmRrn"),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )

                Spacer(modifier = Modifier.width(10.0.dp))

                Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "${stateValue.cryptoValue?.crypto_balance?.title}",
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = "${stateValue.cryptoValue?.crypto_balance?.subtitle}",
                        style = MaterialTheme.typography.body2
                    )
                }

                Text(text = "$"+"${stateValue.cryptoValue?.crypto_balance?.current_bal_in_usd}", fontWeight = FontWeight.Bold, textAlign = TextAlign.End, modifier = Modifier.align(Alignment.CenterVertically))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Your Crypto Holdings",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .weight(0.5f, false)) {
                stateValue.cryptoValue?.your_crypto_holdings?.let {
                    items(it.filterNotNull()) { crypto_holding ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                        ) {
                            //AsyncImage(model = crypto_holding.logo, contentDescription = null)

                            Image(
                                painterResource(id = R.drawable.btc),
                                //painter = rememberAsyncImagePainter("https://ibb.co/LZSmRrn"),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(64.dp)
                                    .align(Alignment.CenterVertically)
                            )

                            Spacer(modifier = Modifier.width(10.0.dp))

                            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.weight(1f)) {
                                Text(text = crypto_holding.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                                Text(text = crypto_holding.current_bal_in_token + " " + crypto_holding.title)
                            }
                            Text(text = "$"+ crypto_holding.current_bal_in_usd, color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.End, modifier = Modifier.align(Alignment.CenterVertically))
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Recent Transactions",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp,
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
                                    .size(64.dp)
                                    .align(Alignment.CenterVertically)
                            )

                            Spacer(modifier = Modifier.width(10.0.dp))

                            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
                                Text(text = crypto_holding.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
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
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Current Prices",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                stateValue.cryptoValue?.crypto_prices?.let {
                    items(it.filterNotNull()) { crypto_holding ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
//                            Image(
//                                painter = rememberAsyncImagePainter(crypto_holding.logo),
//                                contentDescription = null
//                            )

                            Image(
                                painterResource(id = R.drawable.btc),
                                //painter = rememberAsyncImagePainter("https://ibb.co/LZSmRrn"),
                                contentDescription = null,
                                modifier = Modifier.size(64.dp)
                            )

                            Text(text = crypto_holding.title, )
                            Text(text = "$"+crypto_holding.current_price_in_usd, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}