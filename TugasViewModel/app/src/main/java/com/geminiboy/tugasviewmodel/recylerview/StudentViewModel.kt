package com.geminiboy.tugasviewmodel.recylerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geminiboy.tugasviewmodel.R
import com.geminiboy.tugasviewmodel.recylerview.DataStudent

class StudentViewModel : ViewModel() {

    val list = arrayListOf(
        DataStudent("Avatar", "2.00.00",),
        DataStudent("Avatar 2", "2.30.00",),
        DataStudent("Avatar 3", "1.57.00",),
        DataStudent("Naruto 2 ", "1.40.00",),
        DataStudent("Naruto 3", "1.50.00")
    )

    val studentList : MutableLiveData<List<DataStudent>> = MutableLiveData()

    fun getStudentList(){
        var stu = list
        studentList.value = stu
    }
}