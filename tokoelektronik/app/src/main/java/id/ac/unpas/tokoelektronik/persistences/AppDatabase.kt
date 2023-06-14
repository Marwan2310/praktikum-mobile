package id.ac.unpas.tokoelektronik.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.tokoelektronik.model.Komputer
import id.ac.unpas.tokoelektronik.model.Periferal

@Database(entities = [Komputer::class, Periferal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun komputerDao(): KomputerDao

    abstract fun PeriferalDao(): PeriferalDao
}