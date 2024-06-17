package com.plcoding.roomguideandroid.tasks

import kotlinx.coroutines.flow.Flow

//Aufgbae 4
//TODO add the respective dao calls
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
