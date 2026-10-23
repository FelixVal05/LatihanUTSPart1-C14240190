import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kegiatan(
    val gambar: String,
    val title: String,
    val subtitle: String,
    val tanggal: String,
    val jam: String,
    val lokasi: String,
    val deskripsi: String
): Parcelable
