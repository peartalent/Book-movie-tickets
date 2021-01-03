package com.sunasterisk.book_movie_tickets

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.dinhtai.retrofit.IMovieNetwork
import com.dinhtai.retrofit.RetrofitRespon
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sunasterisk.book_movie_tickets.data.local.MovieResponse
import com.sunasterisk.book_movie_tickets.ui.genres.FragmentGenres
import com.sunasterisk.book_movie_tickets.ui.popular.AdapterPopular
import com.sunasterisk.book_movie_tickets.ui.popular.FragmentPopular
import com.sunasterisk.book_movie_tickets.ui.toprate.FragmentTopRate
import com.sunasterisk.book_movie_tickets.ui.upcomming.FragmentUpComming
import com.sunasterisk.book_movie_tickets.util.addFragment
import com.sunasterisk.book_movie_tickets.util.replaceFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var retrofit: Retrofit
    lateinit var call: IMovieNetwork
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofit = RetrofitRespon.getInstance().getRetrofit()
        call = retrofit.create(IMovieNetwork::class.java)

        bottomNavigation.setOnNavigationItemSelectedListener(this)
        toolbar.title = "Popular"
        addFragment(FragmentPopular.newInstance(), R.id.frameContainer)
        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.menu_toolbar_search, menu)
        return true
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_toolbar_main, menu)
//        return true
//    }
//
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemSearch -> {
                startActivity(Intent(this, Search::class.java))
            }
        }
        return false
    }


    override fun onNavigationItemSelected(p0: MenuItem): Boolean =
        when (p0.itemId) {
            R.id.itemHome -> {
                toolbar.title = "Popular"
                replaceFragment(FragmentPopular.newInstance(), R.id.frameContainer)
                true
            }
            R.id.itemToprate -> {
                toolbar.title = "Top rate"
                replaceFragment(FragmentTopRate.newInstance(), R.id.frameContainer)
                true
            }
            R.id.itemUpcomming -> {
                toolbar.title = "Upcomming"
                replaceFragment(FragmentUpComming.newInstance(), R.id.frameContainer)
                true
            }
            R.id.itemGenres -> {
                toolbar.title = "Genres"
                replaceFragment(FragmentGenres.newInstance(), R.id.frameContainer)
                true
            }
            else -> false
        }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
