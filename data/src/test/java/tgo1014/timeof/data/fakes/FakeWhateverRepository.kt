package tgo1014.timeof.data.fakes

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import tgo1014.timeof.domain.models.WhateverDomain
import tgo1014.timeof.domain.storage.WhateverRepository

class FakeWhateverRepository : WhateverRepository {

    private val items = MutableStateFlow(emptyList<WhateverDomain>())

    override fun getAllFlow(): Flow<List<WhateverDomain>> {
        return items.asStateFlow()
    }

    override fun upsert(whateverDomain: WhateverDomain) {
        val items = items.value.toMutableList()
        items.add(whateverDomain)
        this.items.update { items }
    }

    override fun delete(whateverDomain: WhateverDomain) {
        val items = items.value.toMutableList()
        items.remove(whateverDomain)
        this.items.update { items }
    }

}