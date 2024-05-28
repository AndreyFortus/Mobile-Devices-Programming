package com.example.lab_9


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Grades::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class GradesDB : RoomDatabase() {
    abstract fun gradesDao(): GradesDao
}
