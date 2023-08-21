package com.aamirashraf.roomdbwithmultipletable.model.relations

import androidx.room.Embedded
import com.aamirashraf.roomdbwithmultipletable.model.School

data class SchoolAndDirector(
    @Embedded val school: School   //means that the all the fields of the school class is embedded in School
    //and director class
)