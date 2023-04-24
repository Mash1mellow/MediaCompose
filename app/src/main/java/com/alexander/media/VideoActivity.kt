package com.alexander.media

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.alexander.media.ui.theme.MediaTheme

class VideoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2("第二頁")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    val context = LocalContext.current
    //val link = "https://rr2---sn-o097znsd.googlevideo.com/videoplayback?expire=1682330049&ei=Yf1FZObMDtLU8wTInbWgCQ&ip=198.199.101.47&id=o-AJF11kVlVI-SNajelWURxh320pr5B5nZGayUqzlGzB9g&itag=18&source=youtube&requiressl=yes&mh=lu&mm=31,29&mn=sn-o097znsd,sn-n4v7sns7&ms=au,rdu&mv=m&mvi=2&pl=24&initcwndbps=207500&spc=qEK7Bzk3AurGYv-fKUBXBkiy0ZpNaRahlDDUv1YsEQ&vprv=1&xtags=heaudio=true&mime=video/mp4&ns=RQm0pxPl0yyXvYHTAIAzt0gN&cnr=14&ratebypass=yes&dur=260.852&lmt=1664202843187118&mt=1682308127&fvip=3&fexp=24007246&c=WEB_EMBEDDED_PLAYER&txp=1438434&n=ZbWuF8MMStr9XjS6I&sparams=expire,ei,ip,id,itag,source,requiressl,spc,vprv,xtags,mime,ns,cnr,ratebypass,dur,lmt&lsparams=mh,mm,mn,ms,mv,mvi,pl,initcwndbps&lsig=AG3C_xAwRQIhAKoy6eBKoYy0fHScXr0Yy45t1ZQgl1HjvCnXNc_0AAAaAiAy4C8wYzhtcAS9Is3wSQH4hRj2EqHIKU132162rapNaQ==&sig=AOq0QJ8wRQIgZOSTWhpd73eLAX2mMt0HEzBtlCbTm8OUwRlPkzble1sCIQCpTr0-f97d_cqjo0t33b5dGCQ680rtGBcoU3q15D5-9g==&title=I%20Love%20Taiwan%20Part%20I%20%E6%88%91%E6%84%9B%E5%8F%B0%E7%81%A3%E7%AC%AC%E4%B8%80%E9%83%A8"
    //val link = "https://www1.pu.edu.tw/~tcyang/handpan.mp4"
    val link = "https://rr1---sn-n4v7snee.googlevideo.com/videoplayback?expire=1682330175&ei=3_1FZOvbF8CJ_9EP_fG-iAs&ip=198.199.101.47&id=o-ABFDrZ3BxuGEMYFK8h0hbMXYhQqNJidnoSEnl1jCePg5&itag=18&source=youtube&requiressl=yes&mh=Md&mm=31,29&mn=sn-n4v7snee,sn-o097znzk&ms=au,rdu&mv=m&mvi=1&pl=24&initcwndbps=207500&spc=qEK7B_h8x0RmyCsXmBy-83BLe-DtXhKO7s30Rm5ocQ&vprv=1&mime=video/mp4&ns=UWOksVE5h0wzorwAgUCE168N&cnr=14&ratebypass=yes&dur=213.577&lmt=1677055189396508&mt=1682308127&fvip=1&fexp=24007246&c=WEB_EMBEDDED_PLAYER&txp=4530434&n=pfCqM0qW0Xg3UBYk4&sparams=expire,ei,ip,id,itag,source,requiressl,spc,vprv,mime,ns,cnr,ratebypass,dur,lmt&lsparams=mh,mm,mn,ms,mv,mvi,pl,initcwndbps&lsig=AG3C_xAwRQIhAPj55PFxav4EPmQNl_odlL3HhA1ZfBXTRPAa2ijzCOpsAiA2gdW-OQEdfTnpBQ8uy4pm_a-Oeb797EwMtmctC77Ekg==&sig=AOq0QJ8wRQIhAKWnmlu-8XNIQht2ucJduDY2vKMn7osiv-mQOp8FP__KAiAfW56f1ZHNDyEAzbc35Ah12NHLuAvt2xBttdGD6mSRgA==&title=NMIXX%20O.O%22%20M/V"
    val exoPlayer = ExoPlayer.Builder(context).build()
    val mediaItem = MediaItem.fromUri(android.net.Uri.parse(link))
    exoPlayer.setMediaItem(mediaItem)
    val playerView = PlayerView(context)
    playerView.player = exoPlayer
    DisposableEffect(AndroidView(factory = {playerView})){
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
        onDispose{
            exoPlayer.release()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MediaTheme {
        Greeting2("Android")
    }
}