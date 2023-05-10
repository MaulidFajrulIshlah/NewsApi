package com.geminiboy.tugasviewmodel.recylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geminiboy.tugasviewmodel.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {

    lateinit var studentVm : StudentViewModel
    lateinit var studentAdapter: StudentAdapter
    lateinit var binding : ActivityStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        studentVm = ViewModelProvider(this).get(StudentViewModel::class.java)
        initStudent()
        studentVm.getStudentList()
        studentVm.studentList.observe(this, Observer {

            studentAdapter.setStudentData(it as ArrayList<DataStudent>)
        })

    }

    fun initStudent (){
        studentAdapter = StudentAdapter(ArrayList())
        binding.rvStudent.layoutManager = GridLayoutManager(this@StudentActivity,2)
        binding.rvStudent.adapter = studentAdapter
    }

    fun setDataStudent(){

    }
}