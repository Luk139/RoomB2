package com.plcoding.roomguideandroid.tasks

import com.plcoding.roomguideandroid.given.TodoDao
import kotlinx.coroutines.flow.Flow

class TodoRepository(private val dao: TodoDao) {

    suspend fun insertTodo(todo: Todo) {
    }

    suspend fun deleteTodo(todo: Todo) {
    }

    fun getTodosOrderedByName(): Flow<List<Todo>> {
        return
    }

    fun getTodosOrderedByWeight(): Flow<List<Todo>> {
        return
    }
}
