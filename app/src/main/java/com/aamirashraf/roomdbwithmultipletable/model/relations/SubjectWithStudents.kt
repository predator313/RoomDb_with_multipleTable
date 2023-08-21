package com.aamirashraf.roomdbwithmultipletable.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.aamirashraf.roomdbwithmultipletable.model.Student
import com.aamirashraf.roomdbwithmultipletable.model.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students:List<Student>
)
