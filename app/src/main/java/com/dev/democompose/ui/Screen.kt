package com.dev.democompose.ui

sealed class Screen(val route: String){
    object FirstUI: Screen("first_ui_screen")
    object SecondUI: Screen("second_ui_screen")
    object ThirdUI: Screen("third_ui_screen")
}
