package id.ac.unpas.tokoelektronik.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.ac.unpas.tokoelektronik.persistences.AppDatabase
import id.ac.unpas.tokoelektronik.persistences.KomputerDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "tokoelektronik"
            )
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideKomputerDao(appDatabase: AppDatabase): KomputerDao {
        return appDatabase.komputerDao()
    }
}