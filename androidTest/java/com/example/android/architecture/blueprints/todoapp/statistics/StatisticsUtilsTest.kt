package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest{
@Test
fun getActiveAndCompletedStats_noCompleted_returnsHundredZero(){
    // Create an active task
    val tasks= listOf<Task>(
            Task("title","desc",isCompleted=false)
    )
    // Call your function
val result = getActiveAndCompletedStats(tasks)
    // Check the result
    assertThat(result.completedTasksPercent,`is`(0f))
    assertThat(result.activeTasksPercent,`is`(100f))

}
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroHundred(){
        // Create an active task
        val tasks= listOf<Task>(
                Task("title","desc",isCompleted=true)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
        assertThat(result.completedTasksPercent,`is`(100f))
        assertThat(result.activeTasksPercent,`is`(0f))

    }
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsFourtySixty(){
        // Create an active task
        val tasks= listOf<Task>(
                Task("title","desc",isCompleted=true),
                Task("title2","desc",isCompleted=true),
                Task("title3","desc",isCompleted=false),
                Task("title4","desc",isCompleted=false),
                Task("title5","desc",isCompleted=false)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
        assertThat(result.completedTasksPercent,`is`(40f))
        assertThat(result.activeTasksPercent,`is`(60f))

    }

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZero(){
        // Create an active task
        val tasks= emptyList<Task>()

        // Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
        assertThat(result.completedTasksPercent,`is`(0f))
        assertThat(result.activeTasksPercent,`is`(0f))

    }
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsNull(){
        // Create an active task
        val tasks= emptyList<Task>()

        // Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
        assertThat(result.completedTasksPercent,`is`(0f))
        assertThat(result.activeTasksPercent,`is`(0f))

    }
}