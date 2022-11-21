package tgo1014.timeof.injection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import tgo1014.timeof.domain.models.CoroutineProvider
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideCoroutineProvider(): CoroutineProvider = object : CoroutineProvider {
        override val main: CoroutineContext = Dispatchers.Main
        override val io: CoroutineContext = Dispatchers.IO
    }

}