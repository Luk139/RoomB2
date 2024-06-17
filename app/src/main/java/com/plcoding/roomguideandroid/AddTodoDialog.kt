package com.plcoding.roomguideandroid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.roomguideandroid.given.TodoEvent
import com.plcoding.roomguideandroid.given.TodoState

@Composable
fun AddTodoDialog(
    state: TodoState,
    onEvent: (TodoEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onEvent(TodoEvent.HideDialog)
        },
        title = { Text(text = "Add Todo") },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = state.todoText,
                    onValueChange = {
                        onEvent(TodoEvent.SetTodoText(it))
                    },
                    placeholder = {
                        Text(text = "Todo")
                    }
                )
                TextField(
                    value = state.weight,
                    onValueChange = {
                        onEvent(TodoEvent.SetWeight(it))
                    },
                    placeholder = {
                        Text(text = "Weight")
                    }
                )
            }
        },
        buttons = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button(onClick = {
                    onEvent(TodoEvent.SaveTodo)
                }) {
                    Text(text = "Save")
                }
            }
        }
    )
}
