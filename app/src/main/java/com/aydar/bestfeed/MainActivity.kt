package com.aydar.bestfeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import com.aydar.featuremain.HomeFragment
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainNavController: NavController

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setNavigationGraph()

        observeViewModel()
        viewModel.checkAuthorization()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object : VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                viewModel.onAuthorizePassed(token.accessToken)
            }

            override fun onLoginFailed(errorCode: Int) {
                Log.e("Token", "onLoginFailed: $errorCode")
            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun authorize() {
        VK.login(this, arrayListOf(VKScope.WALL, VKScope.GROUPS))
    }

    private fun observeViewModel() {
        with(viewModel) {
            eventAuthorize.observe(this@MainActivity) {
                authorize()
            }
        }
    }

    private fun setNavigationGraph() {
        with(supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment) {
            mainNavController = navController
            mainNavController.graph = createGraph(
                id = NavGraph.id,
                startDestination = NavGraph.dest.home
            ) {

                fragment<HomeFragment>(NavGraph.dest.home) {
                    label = "Che kak del"
                }

            }
        }
    }
}