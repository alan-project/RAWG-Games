package net.alanproject.rawg_private

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import dagger.hilt.android.AndroidEntryPoint
import net.alanproject.rawg_private.ui.navigation.nav_graph.SetupNavGraph
import net.alanproject.rawg_private.ui.theme.Rawg_privateTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rawg_privateTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SetupNavGraph()
                }
            }
        }
    }
}


