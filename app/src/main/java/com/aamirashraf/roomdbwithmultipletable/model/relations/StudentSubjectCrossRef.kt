package com.aamirashraf.roomdbwithmultipletable.model.relations

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["studentName","subjectName"])
data class StudentSubjectCrossRef(
    val studentName:String,    //as we know that in one to many non of the attribute is the primary key so we takes the combination
    val subjectName:String
    //so here in this relation table
    //we need to do something different like we need to annotate this table as the entity table
    //and then we perform the particular relation in this this is something else to do so
    //so for this we need to makes two more data class

)