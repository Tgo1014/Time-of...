package tgo1014.timeof.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import tgo1014.timeof.data.models.WhateverDBO

@Database(entities = [WhateverDBO::class], version = 1)
abstract class WhateverDb : RoomDatabase() {
    abstract fun whateverDao(): WhateverDao
}