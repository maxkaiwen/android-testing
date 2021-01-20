package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.Event
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.nullValue
import org.hamcrest.core.IsNot.not
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class TasksViewModelTest{
@get:Rule
var instantExecutorRule=InstantTaskExecutorRule()

    private lateinit var tasksViewModel: TasksViewModel

    @Before
    fun setupViewModel() {
        tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun addNewTask_setsNewTaskEvent() {
//tasksViewModel.addNewTask()
        // Given a fresh TasksViewModel
        //val  tasksViewModel=TasksViewModel(ApplicationProvider.getApplicationContext())


        // When adding a new task
        tasksViewModel.addNewTask()

        // Then the new task event is triggered

    val value =tasksViewModel.newTaskEvent.getOrAwaitValue ()
        assertThat(value.getContentIfNotHandled(),not(nullValue()))
        //create observer
      /*  val observer= Observer<Event<Unit>>{}
        try {
            //observe the Livedata forever
            tasksViewModel.newTaskEvent.observeForever(observer)
            //when adding a new task
            tasksViewModel.addNewTask()
            //then the new task event is triggered
            val value = tasksViewModel.newTaskEvent.value
            assertThat(value?.getContentIfNotHandled(), (not(nullValue())))
        }finally {
            //dont forget to remove observer
            tasksViewModel.newTaskEvent.removeObserver(observer)
        }*/
        }

    @Test
    fun setFilterAllTasks_tasksAddViewVisible() {

        // Given a fresh ViewModel
    //    val  tasksViewModel=TasksViewModel(ApplicationProvider.getApplicationContext())
        // When the filter type is ALL_TASKS
tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)
        // Then the "Add task" action is visible
        assertThat(tasksViewModel.tasksAddViewVisible.getOrAwaitValue(),`is`(true))
    }
    }

