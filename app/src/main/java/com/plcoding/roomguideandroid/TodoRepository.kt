package com.plcoding.roomguideandroid

import kotlinx.coroutines.flow.Flow

class TodoRepository(private val dao: TodoDao) {

    suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo)
    }

    fun getTodosOrderedByName(): Flow<List<Todo>> {
        return dao.getTodosOrderedByName()
    }

    fun getTodosOrderedByWeight(): Flow<List<Todo>> {
        return dao.getTodosOrderedByWeight()
    }
}
