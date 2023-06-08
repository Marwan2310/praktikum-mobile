package id.ac.unpas.tokoelektronik.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

import id.ac.unpas.tokoelektronik.repositories.KomputerRepository
import id.ac.unpas.tokoelektronik.networks.KomputerApi
import id.ac.unpas.tokoelektronik.persistences.KomputerDao

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideKomputerRepository(
        api: KomputerApi,
        dao: KomputerDao
    ): KomputerRepository {
        return KomputerRepository(api, dao)
    }
}
