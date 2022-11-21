package tgo1014.timeof.data.storage.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import tgo1014.timeof.data.models.WhateverDBO

@Dao
interface WhateverDao {

    @Query("SELECT * FROM whateverdbo")
    fun getAll(): Flow<List<WhateverDBO>>

    @Upsert
    fun upsert(whateverDBO: WhateverDBO)

    @Delete
    fun delete(whateverDBO: WhateverDBO)
}