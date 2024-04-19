package com.yudhi.synrgyrecchall3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



val alphabets = ('A'..'Z').map { it.toString() }.toMutableList()

enum class Abjad(val huruf: String, val kata: ArrayList<String>) {
    A("A", arrayListOf("Api", "Angin", "Air")),
    B("B", arrayListOf("Bola", "Buku", "Bunga")),
    C("C", arrayListOf("Cinta", "Coklat", "Cerita")),
    D("D", arrayListOf("Domba", "Darah", "Dunia")),
    E("E", arrayListOf("Enak", "Es", "Elephant")),
    F("F", arrayListOf("Fajar", "Fisika", "Foto")),
    G("G", arrayListOf("Gajah", "Gunung", "Gula")),
    H("H", arrayListOf("Hari", "Hutan", "Hujan")),
    I("I", arrayListOf("Indah", "Ikan", "Ibu")),
    J("J", arrayListOf("Jalan", "Jagung", "Jembatan")),
    K("K", arrayListOf("Kuda", "Kereta", "Kamera")),
    L("L", arrayListOf("Lampu", "Laut", "Lukisan")),
    M("M", arrayListOf("Mobil", "Mata", "Makan")),
    N("N", arrayListOf("Nasi", "Naga", "Nama")),
    O("O", arrayListOf("Ombak", "Olahraga", "Otot")),
    P("P", arrayListOf("Pohon", "Pulau", "Pantai")),
    Q("Q", arrayListOf("Quran", "Quasar", "Quote")),
    R("R", arrayListOf("Rumah", "Roda", "Raja")),
    S("S", arrayListOf("Sapi", "Sekolah", "Surat")),
    T("T", arrayListOf("Taman", "Tali", "Tulisan")),
    U("U", arrayListOf("Ular", "Umbrella", "Utara")),
    V("V", arrayListOf("Vitamin", "Virus", "Vokal")),
    W("W", arrayListOf("Wanita", "Waktu", "Warna")),
    X("X", arrayListOf("Xenon", "Xylophone", "Xenophobia")),
    Y("Y", arrayListOf("Yoyo", "Yayasan", "Yakin")),
    Z("Z", arrayListOf("Zebra", "Zat", "Zaman"))
}
