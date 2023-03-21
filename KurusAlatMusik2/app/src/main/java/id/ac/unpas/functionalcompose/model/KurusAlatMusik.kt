package id.ac.unpas.functionalcompose.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class KurusAlatMusik(
    @PrimaryKey val id: String,
    val tanggal: String,
    val nama: String,
    val jeniskelamin: String,
    val : String,

)
