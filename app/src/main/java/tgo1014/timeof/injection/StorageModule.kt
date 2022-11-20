package tgo1014.timeof.injection

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tgo1014.timeof.data.storage.WhateverRepositoryImpl
import tgo1014.timeof.data.storage.database.WhateverDb
import tgo1014.timeof.domain.storage.WhateverRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    @Binds
    @Singleton
    abstract fun bind(repo: WhateverRepositoryImpl): WhateverRepository

    companion object {

        @Provides
        @Singleton
        fun provideDb(@ApplicationContext context: Context): WhateverDb {
            return Room.databaseBuilder(
                context = context,
                klass = WhateverDb::class.java,
                name = "whatever-db"
            ).build()
        }

        @Provides
        @Singleton
        fun providesWhateverDao(whateverDb: WhateverDb) = whateverDb.whateverDao()

    }

}