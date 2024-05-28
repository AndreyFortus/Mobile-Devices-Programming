package com.example.lab_9

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.lab_9.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            GradesDB::class.java, "database-name").build()
        val gradesDao = db.gradesDao()

        binding.buttonSave.setOnClickListener {
            val data = binding.editTextGrade.text.toString()
            val gradeInfo = data.split(' ')
            if (gradeInfo.size != 3) {
                Toast.makeText(applicationContext, "Please enter valid grade information", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val subjectName = gradeInfo[0]
            val grade = gradeInfo[1].toIntOrNull()
            val createdAt = parseDate(gradeInfo[2])

            if (grade == null || createdAt == null) {
                Toast.makeText(applicationContext, "Please enter valid grade and date", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val gradeEntry = Grades(subjectName = subjectName, grade = grade, createdAt = createdAt)
            GlobalScope.launch {
                gradesDao.insertAll(gradeEntry)
            }

            Toast.makeText(applicationContext, "Grade inserted", Toast.LENGTH_LONG).show()
        }

        binding.buttonRead.setOnClickListener {
            GlobalScope.launch {
                val grades = gradesDao.getAll()
                var gradesInfo = ""
                grades.forEach {
                    gradesInfo += "${it.id} ${it.subjectName} ${it.grade} ${formatDate(it.createdAt)}\n"
                }
                runOnUiThread {
                    binding.textView.text = gradesInfo
                }
            }
        }

        binding.buttonDelete.setOnClickListener {
            val idToDelete = binding.editTextDeleteId.text.toString().toIntOrNull()
            if (idToDelete != null) {
                GlobalScope.launch {
                    gradesDao.deleteById(idToDelete)
                    runOnUiThread {
                        Toast.makeText(applicationContext, "Grade deleted", Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                Toast.makeText(applicationContext, "Please enter a valid ID", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun parseDate(dateString: String): Date? {
        return try {
            val format = SimpleDateFormat("dd-MM-yyyy", Locale.US)
            format.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }

    private fun formatDate(date: Date): String {
        val format = SimpleDateFormat("dd-MM-yyyy", Locale.US)
        return format.format(date)
    }
}
