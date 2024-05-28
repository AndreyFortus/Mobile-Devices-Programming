package com.example.lab_9

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GradesDao {
    @Query("SELECT * FROM grades")
    fun getAll(): List<Grades>

    @Insert
    fun insertAll(vararg grades: Grades)

    @Query("DELETE FROM grades WHERE id = :id")
    suspend fun deleteById(id: Int)
}