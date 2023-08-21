package com.aamirashraf.roomdbwithmultipletable.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aamirashraf.roomdbwithmultipletable.model.Dao
import com.aamirashraf.roomdbwithmultipletable.model.Director
import com.aamirashraf.roomdbwithmultipletable.model.School
import com.aamirashraf.roomdbwithmultipletable.model.Student
import com.aamirashraf.roomdbwithmultipletable.model.Subject
import com.aamirashraf.roomdbwithmultipletable.model.relations.StudentSubjectCrossRef

@Database(
    entities = [School::class,
    Student::class,
    Subject::class,
    Director::class,
    StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase:RoomDatabase() {
    abstract val schoolDao:Dao

    //now lets declare the singleton pattern
    companion object{
        @Volatile
        private var INSTANCE:SchoolDatabase?=null
         fun getInstance(context: Context):SchoolDatabase{
             synchronized(this){
                 return INSTANCE?: Room.databaseBuilder(
                     context.applicationContext,
                     SchoolDatabase::class.java,
                     "school_db"

                 ).build().also {
                     INSTANCE=it
                 }
             }

         }
    }
}