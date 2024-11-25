package vn.edu.hust.studentman

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class EditStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val student = intent.getSerializableExtra("student") as StudentModel
        val studentNameEditText: EditText = findViewById(R.id.edit_student_name)
        val studentIdEditText: EditText = findViewById(R.id.edit_student_id)
        val saveButton: Button = findViewById(R.id.btn_save_student)

        studentNameEditText.setText(student.studentName)
        studentIdEditText.setText(student.studentId)

        saveButton.setOnClickListener {
            val name = studentNameEditText.text.toString()
            val studentId = studentIdEditText.text.toString()
            if (name.isNotEmpty() && studentId.isNotEmpty()) {
                val resultIntent = Intent()
                resultIntent.putExtra("studentName", name)
                resultIntent.putExtra("studentId", studentId)
                resultIntent.putExtra("position", intent.getIntExtra("position", -1))
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}
