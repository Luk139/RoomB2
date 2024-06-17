package com.plcoding.roomguideandroid.given

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.roomguideandroid.tasks.Todo
import com.plcoding.roomguideandroid.tasks.TodoRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class TodoViewModel(
    private val repository: TodoRepository
): ViewModel() {

    private val _sortType = MutableStateFlow(SortType.TODO_NAME)
    private val _todos = _sortType
        .flatMapLatest { sortType ->
            when(sortType) {
                SortType.TODO_NAME -> repository.getTodosOrderedByName()
                SortType.WEIGHT -> repository.getTodosOrderedByWeight()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(TodoState())
    val state = combine(_state, _sortType, _todos) { state, sortType, todos ->
        state.copy(
            todos = todos,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TodoState())

    fun onEvent(event: TodoEvent) {
        when(event) {
            is TodoEvent.DeleteTodo -> {
                viewModelScope.launch {
                    repository.deleteTodo(event.todo)
                }
            }
            TodoEvent.HideDialog -> {
                _state.update { it.copy(
                    isAddingTodo = false
                ) }
            }
            TodoEvent.SaveTodo -> {
                val todoText = state.value.todoText
                val weight = state.value.weight.toIntOrNull() ?: return

                if(todoText.isBlank()) {
                    return
                }

                val todo = Todo(
                    todo = todoText,
                    weight = weight
                )
                viewModelScope.launch {
                    repository.insertTodo(todo)
                }
                _state.update { it.copy(
                    isAddingTodo = false,
                    todoText = "",
                    weight = ""
                ) }
            }
            is TodoEvent.SetTodoText -> {
                _state.update { it.copy(
                    todoText = event.text
                ) }
            }
            is TodoEvent.SetWeight -> {
                _state.update { it.copy(
                    weight = event.weight
                ) }
            }
            TodoEvent.ShowDialog -> {
                _state.update { it.copy(
                    isAddingTodo = true
                ) }
            }
            is TodoEvent.SortTodos -> {
                _sortType.value = event.sortType
            }
        }
    }
}
