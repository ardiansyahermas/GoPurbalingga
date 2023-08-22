package com.application.wisataapp

object WisataData {
    private val idPlace = arrayOf(
        0,
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9
    )

    private val wisataPlace = arrayOf(
        "Goa Lawa",
        "Sanggaluri Park",
        "Owabong",
        "Purbasari Pancuran Mas",
        "Telaga Situ Tirta Marta",
        "Lembah Asri Serang",
        "Curug Sumba",
        "Curug Nini",
        "Kutabawa Flower Garden",
        "Alun-Alun Purbalingga"
    )

    private val wisataLocation = arrayOf(
        "Desa Siwarak, Kecamatan Karangreja, Kabupaten Purbalingga, Provinsi Jawa Tengah",
        "Jl. Raya Taman Reptil, Dusun II, Desa Kutasari, Kecamatan Kutasari.",
        "Jl. Raya Owabong No. 1, Kecamatan Bojongsari",
        "Jl. Raya Purbayasa, Desa Purbayasa, Kecamatan Padamara, Kabupaten Purbalingga, Provinsi Jawa Tengah",
        "Desa Karangcegak, Kecamatan Kutasari, Kabupaten Purbalingga, Provinsi Jawa Tengah",
        "Jl. Serang, Dusun Krajan, Desa Serang, Kecamatan Karangreja",
        "Desa Tlahab Kidul, Kecamatan Karangreja",
        "Dusun IV, Desa Pager Andong, Kecamatan Mrebet",
        "Desa Kutabawa, Kecamatan Karangreja, Kabupaten Purbalingga, Provinsi Jawa Tengah",
        "Jl. Jend. Sudirman, Kecamatan Purbalingga, Kabupaten Purbalingga, Provinsi Jawa Tengah"
    )

    private val wisataPrice = arrayOf(
        "Rp 20.000",
        "Rp 15.000",
        "Rp 25.000",
        "Rp 25.000",
        "Rp 5.000",
        "Rp 10.000(per orang)",
        "Rp 8.000(per orang)",
        "Gratis",
        "Rp 5.000",
        "Gratis"
    )

    private val wisataDetails = arrayOf(
        "Goa Lawa adalah tempat wisata di Purbalingga yang memiliki karakteristik yang berbeda dengan gua-gua pada umumnya. Goa Lawa terbentuk akibat lava dari Gunung Slamet, pada jaman purbakala.\n" +
                "\n" +
                "Goa Lawa sebetulnya adalah diksi umum yang menunjuk kepada sebuah gua yang dihuni banyak kelelawar. Dan di beberapa daerah di Indonesia banyak yang memiliki Goa Lawa.",
        "Sanggaluri Park tempat wisata keluarga di Purbalingga yang selalu ramai dikunjungi, karena menyajikan konsep wisata yang lengkap ditambah lokasinya yang berada di pusat kota.\n" +
                "\n" +
                "Lengkap karena menyajikan beragam spot wisata mulai dari wahana permainan untuk anak, museum, kolam renang, hingga spot foto ala-ala Jepang. Bahkan Sanggaluri Park juga bisa dijadikan lokasi peragaan manasik haji untuk anak usia dini.",
        "Owabong Purbalingga memiliki banyak ragam wisata, maka sering disebut sebagai tempat wisata terlengkap dan terbesar di Kabupaten Purbalingga.\n" +
                "\n" +
                "Yang menjadi daya tarik utamanya ialah kehadiran dari Owabong Waterpark, yang memiliki banyak kolam renang disertai pula dengan wahana permainan airnya.\n" +
                "\n" +
                "Tak hanya itu, di Owabong Purbalingga ada wahana flying fox, theater 4D, gokart, zipline coaster, hingga anjungan dirgantara.",
        "Tempat wisata di Purbalingga juga menyajikan wisata modern, edukatif, yang dilengkapi dengan fasilitas, dan wahana wisata yang modern, dan instagramable.\n" +
                "\n" +
                "Maka wajar saja jika Purbasari Pancuran Mas selalu dipadati oleh pengunjung saat akhir pekan, maupun saat libur nasional. Terutama wisata keluarga.",
        "Suka dengan dunia fotografi? Atau eksis di media sosial, tetapi dengan konten yang nggak biasa? Maka jawabannya anda harus mengunjungi Telaga Situ Tirta Marta.\n" +
                "\n" +
                "Telaga Situ Tirta Marta menyajikan pengalaman selfie di bawah air, atau dilengkapi dengan spot selfie underwater. Hal itu, dikarenakan airnya yang sangat jernih.",
        "Lembah Asri atau jika di google maps tertulis D’Las Lembah Asri Serang merupakan tempat wisata keluarga di Purbalingga yang menyajikan wahana yang sangat lengkap, dari mulai wahana air hingga wahana darat.\n" +
                "\n" +
                "Luas dari Lembah Asri lebih dari 10 hektar, so pasti bisa menampung banyak spot wisata yang akan memanjakan setiap pengunjung yang datang. Hmmm kayaknya nggak cukup sehari deh.\n" +
                "\n" +
                "Hadirnya hutan pinus yang cukup rindang, banyak dimanfaatkan pengunjung untuk bersantai sambil menikmati suasana alam yang tersaji. Apalagi tak jauh dari hutan pinus terdapat Taman Salju.",
        "Curug Sumba menjadi lokasi wisata air terjun selanjutnya di Purbalingga yang nggak boleh dilewatkan, akses jalannya yang mudah serta dekat dari pusat kota menjadi salah satu alasannya.\n" +
                "\n" +
                "Curug di Purbalingga cukup banyak, nggak heran jika kabupaten di Jawa Tengah yang satu ini dijuluki sebagai kota seribu air terjun.\n" +
                "\n" +
                "Di kawasan Curug Sumba kamu dapat menikmati dua buah air terjun dalam satu waktu, yang pertama ialah tak lain dan tak bukan Curug Sumba itu sendiri yang memiliki dua liran air terjun.",
        "Wisata Purbalingga yang satu ini bisa banget untuk dijadikan lokasi self healing atau kami biasa menyebutnya hulang – healing, tempat melepas penat setelah jenuh dengan keseharian.\n" +
                "\n" +
                "Curug Nini sama seperti Curug Nagasari belum mendapatkan pengelolaan yang sempurna dari pemerintah setempat. Meskipun tidak memiliki aliran air yang begitu tinggi, tetapi pesona alam yang disuguhkan sangatlah mempesona.",
        "Kutabawa Flower Garden, atau Kutabawa Rainbow Garden adalah wisata Purbalingga yang memiliki daya tarik berupa hamparan lautan bunga yang cantik, tertata secara baik, sehingga menyajikan area yang instagramable.\n" +
                "\n" +
                "\n" +
                "Selain itu, Kutabawa Flower Garden juga dilengkapi dengan beragam fasilitas wisata lainnya, seperti area bermain anak, serta gazebo. Ada juga fasilitas warung penjual makan, dan minuman.",
        "Wisata yang cocok untuk semua usia, sekaligus ikon Kabupaten, adalah Alun-Alun Purbalingga. Saat ini, penataan kawasan Alun-Alun Purbalingga sangat baik sekali. Bahkan mampu menjadi wisata malam di Purbalingga yang instagramable, dan romantis.\n" +
                "\n" +
                "Suasana saat siang dengan malam di Alun-Alun Purbalingga tentu saja sangat berbeda sekali. Saat malam tiba, spot instagramable berpadu dengan warna-warni lampu malam yang sangat indah.\n" +
                "\n" +
                "\n" +
                "Selain itu, Alun-Alun Purbalingga bisa dijadikan tempat nongkrong yang nyaman. Karena lokasinya juga sangat strategis, berada di pusat perkotaan."
    )

    private val wisataImages = intArrayOf(
        R.drawable.goa_lawa,
        R.drawable.sanggaluri,
        R.drawable.owabong,
        R.drawable.purbasari_pancuranmas,
        R.drawable.telaga_situ_marta,
        R.drawable.lembah_asri,
        R.drawable.curug_sumba,
        R.drawable.curug_nini,
        R.drawable.kutabawa_flower_garden,
        R.drawable.alun_alun
    )

    val listData: ArrayList<Wisata>
        get(){
            val list = arrayListOf<Wisata>()
            for (position in wisataPlace.indices){
                val wisata = Wisata()
                wisata.id = idPlace[position]
                wisata.place = wisataPlace[position]
                wisata.location = wisataLocation[position]
                wisata.price = wisataPrice[position]
                wisata.detail = wisataDetails[position]
                wisata.photo = wisataImages[position]
                list.add(wisata)
            }
            return list
        }
}