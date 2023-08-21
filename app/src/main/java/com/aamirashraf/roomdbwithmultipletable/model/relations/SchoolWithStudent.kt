package com.aamirashraf.roomdbwithmultipletable.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.aamirashraf.roomdbwithmultipletable.model.School
import com.aamirashraf.roomdbwithmultipletable.model.Student

data class SchoolWithStudent(
    @Embedded val school: School,   //as the school contains the multiple instance of students
    //so it should be Embedded
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students:List<Student>   //since this is 1-N relation so there should be list of students
)
