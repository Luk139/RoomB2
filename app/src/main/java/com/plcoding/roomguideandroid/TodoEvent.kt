package com.plcoding.roomguideandroid

sealed interface TodoEvent {
    object SaveTodo: TodoEvent
    data class SetTodoText(val text: String): TodoEvent
    data class SetWeight(val weight: String): TodoEvent
    object ShowDialog: TodoEvent
    object HideDialog: TodoEvent
    data class SortTodos(val sortType: SortType): TodoEvent
    data class DeleteTodo(val todo: Todo): TodoEvent
}
