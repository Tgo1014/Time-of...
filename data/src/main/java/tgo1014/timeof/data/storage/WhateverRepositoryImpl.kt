package tgo1014.timeof.data.storage

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import tgo1014.timeof.data.models.mappers.toDbo
import tgo1014.timeof.data.models.mappers.toDomain
import tgo1014.timeof.data.storage.database.WhateverDao
import tgo1014.timeof.domain.models.WhateverDomain
import tgo1014.timeof.domain.storage.WhateverRepository
import javax.inject.Inject

class WhateverRepositoryImpl @Inject constructor(
    private val whateverDao: WhateverDao,
) : WhateverRepository {

    private val items = MutableStateFlow(emptyList<WhateverDomain>())

    override fun getAllFlow() = whateverDao.getAll()
        .map { list -> list.map { it.toDomain() } }

    override fun upsert(whateverDomain: WhateverDomain) {
        whateverDao.upsert(whateverDomain.toDbo())
    }

    override fun delete(whateverDomain: WhateverDomain) {
        whateverDao.delete(whateverDomain.toDbo())
    }

}