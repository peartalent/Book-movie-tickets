package com.sunasterisk.book_movie_tickets.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dinhtai.retrofit.IMovieNetwork
import com.dinhtai.retrofit.RetrofitRespon
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.sun.homecinema.data.model.VideoResponse
import com.sunasterisk.book_movie_tickets.R
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_video_play.*
import kotlinx.android.synthetic.main.activity_video_play.toolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class VideoPlay : AppCompatActivity() {
    lateinit var retrofit: Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_play)
        val bundle: Bundle? = intent.extras
        val idMovie: Int = intent.getIntExtra("id_movie", -1)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        retrofit = RetrofitRespon.getInstance().getRetrofit()
        lifecycle.addObserver(playYoutube)
        var service = retrofit.create(IMovieNetwork::class.java)
        service.video(idMovie).enqueue(object  : Callback<VideoResponse>{
            override fun onResponse(call: Call<VideoResponse>, response: Response<VideoResponse>) {
                var videos  = response.body()!!.results
                    playYoutube.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                      override fun onReady(youTubePlayer: YouTubePlayer) {
                          if (videos.size >0)
                           youTubePlayer.loadVideo(videos.get(0)!!.key, 0F)
                      }
                  })
            }

            override fun onFailure(call: Call<VideoResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
