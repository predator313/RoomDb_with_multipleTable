package com.aamirashraf.roomdbwithmultipletable.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.aamirashraf.roomdbwithmultipletable.model.relations.SchoolAndDirector
import com.aamirashraf.roomdbwithmultipletable.model.relations.SchoolWithStudent
import com.aamirashraf.roomdbwithmultipletable.model.relations.StudentSubjectCrossRef
import com.aamirashraf.roomdbwithmultipletable.model.relations.StudentWithSubjects
import com.aamirashraf.roomdbwithmultipletable.model.relations.SubjectWithStudents
@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction  //we annotate with @Transaction for the thread safe approach
    @Query("select * from school where schoolName=:schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName:String):List<SchoolAndDirector>
    @Transaction
    @Query("select* from school where schoolName=:schoolName")
    suspend fun getSchoolWithStudents(schoolName: String):List<SchoolWithStudent>

    @Transaction
    @Query("select * from subject where subjectName=:subjectName")
    suspend fun  getStudentsOfSubject(subjectName:String):List<SubjectWithStudents>

    @Transaction
    @Query("select * from student where studentName=:studentName")
    suspend fun getSubjectsOfStudent(studentName:String):List<StudentWithSubjects>
}