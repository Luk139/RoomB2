package com.plcoding.roomguideandroid

data class TodoState(
    val todos: List<Todo> = emptyList(),
    val todoText: String = "",
    val weight: String = "",
    val isAddingTodo: Boolean = false,
    val sortType: SortType = SortType.TODO_NAME
)
