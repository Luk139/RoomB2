package com.plcoding.roomguideandroid

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM todo ORDER BY todo ASC")
    fun getTodosOrderedByName(): Flow<List<Todo>>

    @Query("SELECT * FROM todo ORDER BY weight ASC")
    fun getTodosOrderedByWeight(): Flow<List<Todo>>
}
