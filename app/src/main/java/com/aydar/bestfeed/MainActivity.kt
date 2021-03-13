package com.aydar.bestfeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import com.aydar.featuremain.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mainNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        navigator.setNavigationGraph()
        setNavigationGraph()

    }

    private fun setNavigationGraph() {
        with(supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment) {
            mainNavController = navController
            mainNavController.graph = createGraph(
                id = NavGraph.id,
                startDestination = NavGraph.dest.home
            ) {

                fragment<HomeFragment>(NavGraph.dest.home){
                    label="Che kak del"
                }

            }
        }
    }
}