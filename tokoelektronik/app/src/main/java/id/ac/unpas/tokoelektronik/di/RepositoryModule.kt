package id.ac.unpas.tokoelektronik.di

import id.ac.unpas.tokoelektronik.networks.KomputerApi
import id.ac.unpas.tokoelektronik.persistences.KomputerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.ac.unpas.tokoelektronik.repositories.KomputerRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    //    Komputer
    @Provides
    @ViewModelScoped
    fun providekomputerRepository(
        api: KomputerApi,
        dao: KomputerDao
    ): KomputerRepository {
        return KomputerRepository(api, dao)
    }

}