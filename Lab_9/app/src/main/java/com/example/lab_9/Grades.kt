package com.example.lab_9

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Grades(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "subject_name") val subjectName: String?,
    @ColumnInfo(name = "grade") val grade: Int,
    @ColumnInfo(name = "created_at") val createdAt: Date,
)
