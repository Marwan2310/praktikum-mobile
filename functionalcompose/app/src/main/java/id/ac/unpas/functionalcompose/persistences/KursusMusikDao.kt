package id.ac.unpas.functionalcompose.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.functionalcompose.model.KursusMusik

@Dao
interface KursusMusikDao {
    @Query("SELECT * FROM KursusMusik")
    fun loadAll(): LiveData<List<KursusMusik>>

    @Query("SELECT * FROM KursusMusik WHERE id = :id")
    fun find(id: String): KursusMusik?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: KursusMusik)

    @Delete
    fun delete(item: KursusMusik)
}