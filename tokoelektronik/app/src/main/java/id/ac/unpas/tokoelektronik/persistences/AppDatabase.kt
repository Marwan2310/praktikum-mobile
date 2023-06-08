package id.ac.unpas.tokoelektronik.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.tokoelektronik.model.Komputer


@Database(entities = [Komputer::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun komputerDao(): KomputerDao
}