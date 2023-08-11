package com.techfortyone.viewmodelphilip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.techfortyone.viewmodelphilip.ui.theme.ViewmodelphilipTheme
import com.techfortyone.viewmodelphilip.viewmodel.ContactsViewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewmodelphilipTheme {

                val mViewModel = viewModel<ContactsViewModel>(
                    factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return ContactsViewModel("Premila Ramalingam") as T
                        }
                    }
                )

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = mViewModel.backgroundColor
                ) {
                    Box(modifier = Modifier.size(300.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = {
                            mViewModel.changeBackgroundColor()
                        }) {
                            Text(
                                text = "Change Color",
                                fontSize = 23.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ViewmodelphilipTheme {
        Greeting("Android")
    }
}