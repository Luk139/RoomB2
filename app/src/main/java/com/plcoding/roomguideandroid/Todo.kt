package com.plcoding.roomguideandroid

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    val todo: String,
    val weight: Int,
    val description: String? = null,  // Add this line
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
