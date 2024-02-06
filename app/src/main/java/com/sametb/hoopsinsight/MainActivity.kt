package com.sametb.hoopsinsight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sametb.hoopsinsight.nav.SetupNavGraph
import com.sametb.hoopsinsight.ui.theme.HoopsInsightTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoopsInsightTheme {

                navController = rememberNavController()
                SetupNavGraph(navController = navController)


            }
        }
    }
}
