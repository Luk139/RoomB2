package com.plcoding.roomguideandroid

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    val todo: String,
    val weight: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
