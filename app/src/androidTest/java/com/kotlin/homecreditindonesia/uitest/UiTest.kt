package com.kotlin.homecreditindonesia.uitest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.kotlin.homecreditindonesia.MainActivity
import com.kotlin.homecreditindonesia.R
import com.kotlin.homecreditindonesia.adapter.AdapterMenuAtas
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UiTest {
    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testClick() {
        delay()
        onView(withId(R.id.list_menu_atas)).perform(
            RecyclerViewActions.actionOnItemAtPosition<AdapterMenuAtas.VH>(
                3,
                click()
            )
        )
        delay()
        delay()
    }

    private fun delay() {
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}