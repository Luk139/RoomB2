package com.plcoding.roomguideandroid.tasks

import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO Refactor this class so it can be used as a Room entity
 class Todo(
    val todo: String,
    val weight: Int,
)
