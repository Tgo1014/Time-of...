package tgo1014.timeof.data.usecases

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import tgo1014.timeof.data.fakes.FakeWhateverRepository
import tgo1014.timeof.domain.models.WhateverDomain
import kotlin.time.Duration.Companion.seconds

class GetWhateverFlowListUseCaseImplTest {

    private lateinit var fakeWhateverRepository: FakeWhateverRepository
    private lateinit var getWhateverFlowListUseCaseImpl: GetWhateverFlowListUseCaseImpl

    @Before
    fun setUp() {
        fakeWhateverRepository = FakeWhateverRepository()
        getWhateverFlowListUseCaseImpl = GetWhateverFlowListUseCaseImpl(fakeWhateverRepository)
    }

    @Test
    fun `GIVEN initial list WHEN requesting flow THEN receive the data back`() = runTest {
        val dummyList = List(5) { WhateverDomain("Foobar", 5.seconds) }
        dummyList.forEach(fakeWhateverRepository::upsert)
        val flowResult = getWhateverFlowListUseCaseImpl().first()
        assert(flowResult == dummyList)
    }
}