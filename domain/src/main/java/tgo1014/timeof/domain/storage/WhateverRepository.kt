package tgo1014.timeof.domain.storage

import kotlinx.coroutines.flow.Flow
import tgo1014.timeof.domain.models.WhateverDomain

interface WhateverRepository {
    fun getAllFlow(): Flow<List<WhateverDomain>>
    fun upsert(whateverDomain: WhateverDomain)
    fun delete(whateverDomain: WhateverDomain)
}