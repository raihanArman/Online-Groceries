package com.randev.online_groceries.screen.detail.components

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.util.LruCache
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.online_groceries.R
import com.randev.online_groceries.data.DummyDataProduct
import com.randev.online_groceries.data.Product
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.utils.drawableToBitmap
import com.randev.online_groceries.utils.fastblur

/**
 * @author Raihan Arman
 * @date 21/09/22
 */

@Composable
fun ProductImage(
    modifier: Modifier = Modifier,
    product: Product,
    onBack: () -> Unit = {}
) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(372.dp),
        shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = product.image),
                contentDescription = null,
                modifier = Modifier
                    .width(323.dp)
                    .height(200.dp)
            )
        }
        Row(
            modifier = Modifier
                .padding(25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            IconButton(
                modifier = Modifier
                    .size(18.dp),
                onClick = onBack
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_baseline_arrow_back_ios_new_24),
                    contentDescription = null
                )
            }
            IconButton(
                modifier = Modifier
                    .size(18.dp),
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_download),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewProductImage(){
    OnlineGroceriesTheme {
        ProductImage(
            product = DummyDataProduct.productList()[0]
        )
    }
}