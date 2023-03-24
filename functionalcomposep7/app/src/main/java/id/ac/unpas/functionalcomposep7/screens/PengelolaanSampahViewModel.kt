package id.ac.unpas.functionalcomposep7.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.ac.unpas.functionalcomposep7.model.SetoranSampah
import id.ac.unpas.functionalcomposep7.persistences.SetoranSampahDao
import javax.inject.Inject
@HiltViewModel
class PengelolaanSampahViewModel @Inject constructor(private val
                                                     setoranSampahDao: SetoranSampahDao) : ViewModel() {
    val list : LiveData<List<SetoranSampah>> = setoranSampahDao.loadAll()
    suspend fun insert(id: String,
                       tanggal: String,
                       nama: String,
                       berat: String){
        val item = SetoranSampah(id, tanggal, nama, berat)
        setoranSampahDao.insertAll(item)
    }
}