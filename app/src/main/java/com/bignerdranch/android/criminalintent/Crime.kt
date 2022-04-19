package com.bignerdranch.android.criminalintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat
import java.util.*

@Entity
data class Crime(@PrimaryKey val id: UUID = UUID.randomUUID(),
                 var title: String = "",
                 var date: String = DateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH).format(Date()),
                 var isSolved: Boolean = false) {
}