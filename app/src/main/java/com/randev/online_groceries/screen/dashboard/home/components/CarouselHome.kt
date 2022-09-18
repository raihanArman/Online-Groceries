package com.randev.online_groceries.screen.dashboard.home.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.randev.online_groceries.R
import com.randev.online_groceries.data.Banner
import com.randev.online_groceries.data.DummyDataBanner
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme
import com.randev.online_groceries.ui.theme.Shapes

/**
 * @author Raihan Arman
 * @date 17/09/22
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CarouselHome(
    modifier: Modifier = Modifier,
    bannerList: List<Banner>,
) {
    val pagerState = rememberPagerState(bannerList.size)
    Card(
        shape = Shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .height(115.dp),
        elevation = 0.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){
            HorizontalPager(
                modifier = Modifier
                    .fillMaxSize(),
                count = bannerList.size,
                state = pagerState,
            ) { page ->
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(id = bannerList[page].image),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                repeat(bannerList.size){
                    Indicator(isSelected = it == pagerState.currentPage)
                }
            }
            
        }
    }
}

@Composable
fun Indicator(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
) {
    val width = animateDpAsState(
        targetValue = if(isSelected) 17.dp else 8.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    Box(
        modifier = modifier
            .height(8.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground.copy(
                    alpha = 0.5f
                )
            )
    )
}

@Preview
@Composable
fun previewCarouselHome(){
    OnlineGroceriesTheme() {
        CarouselHome(bannerList = DummyDataBanner.bannerList())
    }
}