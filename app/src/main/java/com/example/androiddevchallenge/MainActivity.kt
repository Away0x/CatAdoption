/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.constants.Routes
import com.example.androiddevchallenge.ui.components.MainScaffold
import com.example.androiddevchallenge.ui.pages.Add
import com.example.androiddevchallenge.ui.pages.List
import com.example.androiddevchallenge.ui.pages.Detail
import com.example.androiddevchallenge.ui.pages.My
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewModels.CatListViewModel
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val listViewModel by viewModels<CatListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                ProvideWindowInsets(consumeWindowInsets = false) {
                    val scaffoldState = rememberScaffoldState()
                    val scope = rememberCoroutineScope()
                    val navController = rememberNavController()

                    MainScaffold(
                        scaffoldState = scaffoldState,
                        onNavButtonClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        },
                        onNavigate = {
                            navController.navigate(it)
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        },
                        onFloatingActionButtonClick = {
                            navController.navigate(Routes.Add)
                        },
                    ) {
                        NavHost(navController = navController, startDestination = Routes.List) {
                            composable(Routes.List) {
                                List(
                                    onItemClick = {
                                        navController.navigate(Routes.detailPath(it))
                                    }
                                )
                            }
                            composable(Routes.Detail) {
                                val id = it.arguments?.getString("id")
                                if (id != null) {
                                    Detail(id.toInt())
                                } else {
                                    Text(text = "detail error")
                                }

                            }
                            composable(Routes.Add) {
                                Add()
                            }
                            composable(Routes.My) {
                                My()
                            }
                        }
                    }
                }
            }
        }
    }
}
