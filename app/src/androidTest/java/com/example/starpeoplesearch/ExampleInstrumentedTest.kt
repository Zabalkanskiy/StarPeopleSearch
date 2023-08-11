package com.example.starpeoplesearch

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.starpeoplesearch.helper.Item
import com.example.starpeoplesearch.recycler.deleteFlavoredName
import com.example.starpeoplesearch.recycler.loadFlavoredName
import com.example.starpeoplesearch.recycler.saveFlavoredName

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    lateinit var appContext :Context
    @Before
    fun setUp(){
        appContext = InstrumentationRegistry.getInstrumentation().targetContext
    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.starpeoplesearch", appContext.packageName)
    }

    @Test
    fun useSaveFlavoredandLoadFlavored() {
        val testItem = Item(name = "TestName", information = "information", favourite = false)
        val testList: List<Item> = listOf(testItem)
        saveFlavoredName(appContext, testItem)
        val list: List<Item> = loadFlavoredName(appContext)
        val item =list.find{item -> item.name == "TestName" }
        assertEquals(testItem, item)
    }

    @Test
    fun useSaveFlavoredandDeleteFlavored() {
        val testItem = Item(name = "TestName", information = "information", favourite = false)
        val testList: List<Item> = listOf(testItem)
        saveFlavoredName(appContext, testItem)
        deleteFlavoredName(appContext, testItem)
        val list: List<Item> = loadFlavoredName(appContext)
        val item = list.find{item -> item.name == "TestName" }
        var trueItem = false
        if(item == null){trueItem = true}
        assertTrue(trueItem)
    }
}