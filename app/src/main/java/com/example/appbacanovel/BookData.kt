package com.example.appbacanovel
import java.text.SimpleDateFormat
import java.util.Date

object BookData {
    fun getBookList(): List<Book> {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")

        return listOf(
            Book(1, "Legend Of Exorcism", "Fei Tian Ye Xiang",
                "Di tengah kota yang sunyi, seorang detektif bernama Arka menerima kasus yang tak biasa. Sebuah pembunuhan misterius terjadi di sebuah rumah tua yang konon katanya berhantu. Dalam penyelidikannya, Arka bertemu dengan Rani, seorang wanita yang memiliki hubungan masa lalu dengan korban. Mereka berdua bekerja sama untuk mengungkap siapa pelaku di balik kejadian ini, meskipun mereka tahu bahwa mereka sedang diawasi. Setiap petunjuk yang mereka temui membawa mereka ke masa lalu yang penuh dengan rahasia kelam. Sementara itu, suasana kota yang semakin gelap semakin menambah ketegangan dalam pencarian mereka. Semakin dalam Arka menggali, semakin banyak penghalang yang menguji ketangguhan dirinya. Namun, satu hal yang dia tahu pasti: kasus ini lebih rumit dari yang dia bayangkan. Apa yang sebenarnya terjadi di malam itu, dan apakah mereka akan berhasil mengungkapnya? \"Malam di Kota Tua\" adalah sebuah kisah yang penuh misteri, pengkhianatan, dan pembalasan.",
                "Alya, seorang wanita muda yang tumbuh di kota besar, merasa terjebak antara dua dunia: dunia nyata yang penuh dengan kesibukan dan dunia mimpi yang ia ciptakan sendiri. Sejak kecil, ia memiliki kemampuan untuk melihat dunia paralel yang hanya bisa ia masuki saat tidur. Di dunia paralel itu, Alya bertemu dengan seseorang yang sangat berbeda dari kehidupan nyata, seorang pria bernama Raka. Meskipun mereka hanya bertemu dalam mimpi, hubungan mereka terasa begitu nyata. Namun, semakin lama Alya semakin bingung tentang mana yang lebih penting: hidupnya di dunia nyata atau perasaannya yang tumbuh di dunia mimpi. Dilema ini memaksanya untuk membuat pilihan besar yang akan mengubah hidupnya selamanya. Di tengah ketegangan ini, Alya harus menghadapi kenyataan tentang siapa dirinya sebenarnya dan apakah cinta sejati bisa bertahan di antara dua dunia yang berbeda. Buku ini adalah sebuah perjalanan emosional tentang memilih antara kenyataan dan impian, serta bagaimana kita menemukan kekuatan dalam diri untuk menghadapi takdir.Tiba-tiba saja, seorang penulis terkenal bernama Galih menghilang tanpa jejak. Karya-karyanya yang mendunia meninggalkan tanda tanya besar di kalangan para penggemarnya. Seorang jurnalis muda, Sari, mendapat tugas untuk menyelidiki hilangnya penulis tersebut. Dalam pencariannya, Sari menemukan petunjuk-petunjuk aneh yang mengarah pada sebuah kota kecil di pedalaman. Kota tersebut memiliki hubungan erat dengan masa lalu Galih, yang ternyata menyimpan banyak misteri yang tidak pernah ia tulis dalam bukunya. Sari harus menggali lebih dalam tentang kehidupan penulis itu, sambil menghadapi kenyataan pahit tentang dunia sastra yang penuh dengan intrik. Sari mulai bertanya-tanya, apakah Galih benar-benar menghilang atau ada sesuatu yang lebih besar yang ia sembunyikan. Sebuah kisah yang menggali tentang seni, kebenaran, dan ketenaran, serta bagaimana seseorang bisa mengorbankan dirinya demi nama besar.",
                R.drawable.cover1,
                "Gramedia",
                "2023",
                System.currentTimeMillis(), genre.FICTION), // Parse the date string into Date
            Book(2,
                "Spineless",
                "Samantha dan Rachel",
                "\"Spineless\" adalah sebuah novel yang menggali tema ketakutan, keberanian, dan identitas diri melalui perspektif seorang wanita muda yang terjebak dalam kehidupan yang penuh tekanan dan harapan yang bertentangan. Cerita ini berfokus pada Sienna, seorang gadis yang sejak kecil telah dipaksa untuk mengikuti ekspektasi sosial dan keluarga yang mengekang dirinya. Di luar penampilan sempurna yang ditunjukkan pada dunia, Sienna merasa seperti tidak punya kendali atas hidupnya.\n" +
                    "\n" +
                    "Saat ia tumbuh dewasa, perasaan hampa dan kebingungannya semakin mendalam. Ia merasa seolah-olah tidak memiliki \"tulang belakang\", sebuah metafora untuk menggambarkan ketidakmampuannya untuk mengambil keputusan yang benar-benar untuk dirinya sendiri. Hidupnya penuh dengan kompromi, dan ia terus-menerus mengikuti arahan dari orang lain, apakah itu orang tuanya yang ambisius, teman-temannya yang manipulatif, atau masyarakat yang selalu menuntut kesempurnaan.\n" +
                    "\n" +
                    "Namun, suatu hari, Sienna terlibat dalam sebuah kecelakaan yang merubah segalanya. Insiden itu memaksanya untuk menghadapi kenyataan hidupnya yang rapuh dan mulai mempertanyakan segala hal yang telah ia terima tanpa banyak bertanya. Dalam perjalanan pemulihan fisik dan emosionalnya, ia mulai bertemu dengan orang-orang yang membantunya menyadari bahwa ia tidak perlu hidup sesuai dengan harapan orang lain. Sienna memulai perjalanan untuk mencari siapa dirinya sebenarnya, berani untuk mengambil keputusan yang sulit, dan menemukan \"tulang belakang\" dalam dirinya yang selama ini ia abaikan.\n" +
                    "\n" +
                    "\"Spineless\" adalah kisah yang mendalam dan emosional tentang pencarian diri, keberanian untuk melawan norma, dan akhirnya menjadi seseorang yang berani hidup dengan keputusan dan pilihan sendiri. Novel ini menyentuh tentang bagaimana seringkali kita kehilangan diri kita dalam upaya untuk menyenankan orang lain dan bagaimana proses menemukan kembali kekuatan pribadi itu adalah perjalanan yang penuh dengan tantangan.",
                "\"Spineless\" mengisahkan perjalanan hidup Sienna, seorang wanita muda yang terperangkap dalam ekspektasi dan tekanan dari orang-orang di sekitarnya, terutama keluarganya yang ambisius. Sejak kecil, Sienna merasa terjebak dalam kehidupan yang selalu dikendalikan oleh harapan orang tua, teman-temannya, dan bahkan masyarakat. Meskipun di luar tampak seperti seorang yang sukses—berprestasi di sekolah, memiliki hubungan sosial yang baik, dan diterima di universitas bergengsi—Sienna merasa hidupnya hampa. Ia merasa tidak punya kendali atas dirinya sendiri dan selalu hidup untuk memenuhi keinginan orang lain. Hal ini membuatnya merasa kehilangan identitas dan tujuan hidup yang sejati. Suatu hari, Sienna mengalami kecelakaan yang mengubah hidupnya, baik secara fisik maupun emosional. Kecelakaan tersebut memaksanya untuk menghadapi kenyataan pahit bahwa ia telah mengabaikan dirinya sendiri demi memenuhi tuntutan orang lain selama ini. Dalam proses pemulihan, Sienna mulai merenung dan menyadari bahwa ia harus menghadapi ketakutannya, melawan pengaruh eksternal, dan mencari tahu siapa dirinya sebenarnya. Ia bertemu dengan orang-orang baru yang memperkenalkan cara pandang yang berbeda, yang membantu Sienna memahami pentingnya menjadi diri sendiri dan mengikuti jalan hidupnya tanpa terikat oleh ekspektasi orang lain. Seiring berjalannya waktu, Sienna mulai berani mengambil keputusan-keputusan besar yang selama ini ia hindari, mulai dari memilih karier yang lebih sesuai dengan passion-nya hingga merombak lingkaran sosialnya. Ia mulai belajar untuk menghadapi ketakutan akan penilaian orang lain, dan menemukan kekuatan untuk berdiri di atas kakinya sendiri. \"Spineless\" adalah kisah tentang pencarian diri, keberanian untuk melawan norma-norma yang mengekang, dan bagaimana seseorang bisa menemukan kekuatan dalam dirinya untuk hidup sesuai dengan keinginan dan impian pribadi, meskipun itu berarti berjuang melawan ketakutan dan keraguan yang ada di dalam diri. Buku ini mengajak pembaca untuk merenung tentang pentingnya menjalani hidup yang autentik dan berani membuat keputusan yang benar-benar untuk diri sendiri.",
                R.drawable.cover2,
                "Elex Media",
                "2022",
                System.currentTimeMillis(),
                genre.NON_FICTION),
            Book(3,
                "Herald",
                "Gaenei Ryl",
                "\"Herald\" adalah sebuah novel yang mengisahkan tentang perjalanan seorang pria muda bernama Ezra yang tiba-tiba terjebak dalam sebuah dunia yang penuh dengan kekacauan dan rahasia. Ezra, seorang jurnalis muda yang tinggal di kota besar, merasa hidupnya monoton dan tidak memiliki arah yang jelas. Namun, segalanya berubah ketika ia mendapatkan tawaran untuk meliput sebuah kisah misterius yang melibatkan sebuah organisasi rahasia yang dikenal sebagai \"Herald\". Organisasi ini memiliki tujuan yang lebih besar dari yang terlihat di permukaan, dan Ezra terjerat dalam konspirasi besar yang melibatkan kekuatan gelap yang berusaha menguasai dunia.\n" +
                        "\n" +
                        "Sementara Ezra menggali lebih dalam tentang Herald, ia mulai menemukan kenyataan yang jauh lebih menakutkan dari yang ia bayangkan. Di balik organisasi tersebut, ada kekuatan yang mampu mengubah takdir umat manusia. Bersama beberapa individu yang memiliki kemampuan luar biasa, Ezra terpaksa memutuskan apakah ia akan melawan organisasi yang menakutkan ini atau bergabung untuk memahami lebih jauh rahasia yang tersembunyi di baliknya. Dalam perjalanannya, Ezra juga menghadapi konflik internal yang besar, tentang apakah ia akan tetap setia pada prinsipnya atau menyerah pada godaan kekuasaan yang ditawarkan oleh Herald.\n" +
                        "\n" +
                        "Cerita ini menggali tema-tema besar tentang kuasa, moralitas, dan pilihan. \"Herald\" adalah kisah yang penuh dengan ketegangan, pengkhianatan, dan pencarian identitas yang menggugah pembaca untuk mempertanyakan garis tipis antara kebaikan dan kejahatan, serta apa yang sebenarnya harus diperjuangkan dalam kehidupan ini.",
                "\"Herald\" dimulai dengan Ezra, seorang jurnalis muda yang merasa kehidupannya mulai kehilangan makna. Suatu hari, ia mendapatkan tugas untuk meliput sebuah cerita tentang sebuah organisasi misterius yang dikenal sebagai \"Herald\". Organisasi ini, meskipun tampaknya berfokus pada tujuan yang baik, menyimpan banyak rahasia kelam di baliknya. Saat menggali lebih dalam, Ezra menemukan bahwa Herald terlibat dalam permainan kekuasaan global yang melibatkan teknologi canggih dan kemampuan manusia luar biasa.\n" +
                        "\n" +
                        "Ezra bertemu dengan sejumlah karakter yang memiliki kemampuan super, yang ternyata juga terjebak dalam konspirasi yang lebih besar. Setiap langkah yang diambil Ezra membawanya lebih dekat kepada pengungkapan rahasia besar tentang organisasi ini dan pengaruhnya terhadap dunia. Namun, Ezra juga mulai meragukan prinsip dan moralitas yang selama ini ia pegang, karena semakin banyak godaan yang datang untuk bergabung dengan kekuatan Herald.\n" +
                        "\n" +
                        "Dengan bantuan sekutu-sekutu yang tidak dapat dipercaya dan menghadapi ancaman dari dalam dan luar organisasi, Ezra berusaha menemukan jalan untuk menghentikan Herald, namun ia mulai menyadari bahwa melawan kekuatan yang begitu besar bukanlah hal yang mudah. Novel ini berfokus pada pertarungan antara keinginan untuk melakukan yang benar dan godaan untuk meraih kekuasaan demi tujuan yang lebih besar, sambil menggali tema tentang identitas, pengorbanan, dan takdir.\n" +
                        "\n" +
                        "Kisah Ezra menjadi perjalanan pencarian jati diri, di mana ia harus menghadapi ketakutannya, berhadapan dengan kekuatan besar yang mengancam dunia, dan akhirnya memilih apakah ia akan tetap menjadi orang yang ia inginkan atau menyerah pada godaan kekuasaan dan kontrol yang ditawarkan oleh Herald.",
                R.drawable.cover3,
                "Gramedia",
                "2021",
                dateFormat.parse("2021-03-15") ?: Date(),
                genre.COMIC),
            Book(4,
                "The Crimes Of Steamfield",
                "Alberto Goncalves",
                "\"The Crimes of Steamfield\" adalah sebuah novel thriller misteri yang berlatar belakang di kota fiksi bernama Steamfield, sebuah tempat yang terkenal karena kemajuan teknologinya dan industri berbasis uap yang mendominasi kehidupan sehari-hari. Kota ini terlihat berkembang pesat, namun di balik kemewahan dan kemajuan, tersembunyi banyak rahasia gelap dan kejahatan yang tidak terlihat oleh mata publik. Cerita ini mengikuti perjalanan seorang detektif bernama Clara Thompson, seorang wanita muda yang cerdas dan berani, yang ditugaskan untuk menyelidiki serangkaian pembunuhan misterius yang terjadi di kota tersebut.\n" +
                        "\n" +
                        "Pembunuhan-pembunuhan ini tampaknya terkait dengan teknologi uap yang digunakan di Steamfield, tetapi tidak ada yang dapat menjelaskan bagaimana dan mengapa teknologi tersebut bisa terlibat dalam kejahatan-kejahatan tersebut. Selama penyelidikannya, Clara menemukan bahwa korban-korban tersebut memiliki hubungan dengan perusahaan-perusahaan besar yang mengendalikan industri uap, dan dia segera menyadari bahwa ada konspirasi besar yang bersembunyi di balik kota yang tampaknya sempurna ini.\n" +
                        "\n" +
                        "Sementara Clara semakin dekat dengan kebenaran, ia harus menghadapi bahaya dari pihak-pihak yang ingin menghentikan penyelidikannya. Dalam usahanya untuk mengungkap kejahatan yang telah lama disembunyikan, Clara menghadapi pertarungan antara moralitas dan kekuasaan, serta risiko besar yang dapat mengancam keselamatan dirinya dan orang-orang yang ia cintai. \"The Crimes of Steamfield\" adalah sebuah kisah yang penuh ketegangan, intrik, dan konspirasi yang menggali tema tentang teknologi, kekuasaan, dan apa yang terjadi ketika kemajuan berbahaya digunakan untuk tujuan gelap.",
                "Kota Steamfield dikenal dengan kemajuan teknologinya, terutama dalam penggunaan mesin uap yang telah mengubah cara hidup penduduknya. Namun, di balik kemajuan ini, mulai terjadi serangkaian pembunuhan yang tampaknya tidak terkait satu sama lain, meskipun semuanya melibatkan individu-individu yang memiliki hubungan dengan perusahaan-perusahaan raksasa yang mengendalikan industri uap. Clara Thompson, seorang detektif muda dan berani, ditugaskan untuk menyelidiki kasus ini. Ia segera menemukan bahwa kota yang tampaknya sempurna ini menyembunyikan banyak rahasia kelam.\n" +
                        "\n" +
                        "Penyelidikan Clara membawanya ke dalam dunia konspirasi yang melibatkan pejabat tinggi, perusahaan besar, dan individu-individu dengan kepentingan tersembunyi. Semakin dalam ia menggali, semakin banyak kecurigaan bahwa kejahatan-kejahatan ini berkaitan dengan eksperimen berbahaya yang menggunakan teknologi uap untuk keuntungan pribadi. Clara menemukan bukti-bukti yang mengarah ke kekuatan besar yang berusaha untuk menyembunyikan kebenaran dengan cara apapun, bahkan dengan cara yang mengancam nyawa.\n" +
                        "\n" +
                        "Saat Clara semakin dekat dengan pengungkapan kebenaran, ia menghadapi bahaya yang semakin besar. Keputusan-keputusan sulit harus diambil, dan Clara harus memilih antara melanjutkan penyelidikan atau melindungi dirinya sendiri dan orang-orang yang ia cintai. Dalam perjuangannya, Clara juga menemukan bahwa kemajuan teknologi yang seharusnya memperbaiki kehidupan manusia, bisa juga menjadi alat untuk penyalahgunaan kekuasaan dan pengendalian. \"The Crimes of Steamfield\" adalah kisah tentang kejahatan, konspirasi, dan bahaya yang tersembunyi di balik kemajuan, dengan pertanyaan moral tentang apakah teknologi yang begitu kuat harus dikendalikan atau dibatasi demi kebaikan umat manusia.",
                R.drawable.cover4,
                "Elex Media",
                "2020",
                dateFormat.parse("2020-07-20") ?: Date(),
                genre.HISTORY),

            Book(5, "Buku Orang Korea ",
                "Gayso Mocho Neh",
                "Di sebuah kota kecil yang damai, seorang saksi diam menjadi kunci dalam mengungkap kejahatan besar. Kisah ini mengikuti Olivia, seorang wanita muda yang menemukan diri terjebak dalam sebuah kasus pembunuhan yang rumit. Saat menemukan petunjuk yang hilang dari mata publik, Olivia harus melawan ketakutannya untuk mengungkap kebenaran, meskipun hal itu berarti membuka pintu bagi ancaman yang datang dari berbagai pihak. Dengan sangat sedikit orang yang percaya padanya, Olivia harus membuktikan bahwa saksi diam yang ia temui bisa mengubah arah penyelidikan. Cerita ini menggali tentang keberanian dalam menghadapi ketidakadilan dan kebenaran yang sering kali tersembunyi",
                "Dalam sebuah dunia yang telah lama dilupakan, Alaric, seorang petualang, menemukan peta kuno yang mengarah pada tempat yang hilang. Dunia itu dipercaya tidak pernah ada, tetapi peta itu membawanya pada petualangan epik di tempat yang dipenuhi dengan makhluk aneh dan teknologi misterius. Seiring dengan teman-temannya yang setia, Alaric menjelajahi kerajaan yang hilang tersebut untuk mengungkapkan rahasia besar yang dapat mengubah dunia mereka selamanya. Namun, semakin dalam mereka menyelidiki, semakin jelas bahwa mereka bukan satu-satunya yang mencari tempat ini, dan musuh yang kuat siap menahan mereka. \"The Forgotten Realm\" adalah kisah petualangan yang penuh misteri, magis, dan pengorbanan.",
                R.drawable.cover5,
                "Gramedia",
                "2019",
                dateFormat.parse("2019-12-10") ?: Date(),
                genre.SCIENCE),

            Book(6, "Buku Orang Korea ",
                "Gayso Mocho Neh",
                "Di masa depan yang penuh dengan kemajuan teknologi, Elena adalah seorang ilmuwan yang menemukan cara untuk mendengar suara-suara dari masa depan. Dengan kemampuan ini, ia berusaha mencegah bencana besar yang akan datang, tetapi setiap usaha yang dilakukan justru membawa konsekuensi yang tidak terduga. Seiring waktu, Elena mulai meragukan apakah ia sedang melawan takdir atau malah memperburuk keadaan. Dalam pencariannya untuk memahami bagaimana masa depan dapat diprediksi dan diubah, ia menemukan bahwa terkadang, apa yang kita dengar dari masa depan, bisa menjadi ancaman terbesar bagi masa kini. \"Echoes of Tomorrow\" adalah kisah tentang keinginan manusia untuk mengubah nasib dan bagaimana suara masa depan dapat memengaruhi setiap keputusan kita.",
                "Setelah kematian misterius ayahnya, Isabella menemukan dirinya terjerat dalam dunia penuh dengan kebohongan dan intrik. Ayahnya yang seorang pengusaha sukses meninggalkan warisan yang penuh dengan rahasia, dan Isabella merasa dipaksa untuk mengungkap kebenaran di balik bisnis keluarganya yang tampaknya sempurna. Dalam perjalanannya, ia berhadapan dengan sekutu-sekutu yang tampaknya membantu, namun memiliki agenda tersendiri. Setiap langkah yang diambil Isabella membuka lebih banyak lapisan kebohongan, dan ia mulai meragukan siapa yang bisa dipercaya. \"The Shadows of Deception\" adalah kisah tentang pengkhianatan, kepercayaan, dan pencarian kebenaran di dunia yang penuh dengan kepalsuan.", R.drawable.cover5,
                "Gramedia",
                "2019",
                dateFormat.parse("2019-12-10") ?: Date(),
                genre.SCIENCE),

            Book(7, "Buku Orang Korea ",
                "Gayso Mocho Neh",
                "Di sebuah desa terpencil yang terletak di kaki gunung, seorang pemuda bernama Kiran mendapati dirinya terlibat dalam konflik yang mengancam keberadaan desanya. Saat badai besar menghantam wilayah tersebut, Kiran menemukan bahwa bencana alam tersebut bukan hanya akibat dari cuaca buruk, tetapi juga sebuah pertanda bahwa sesuatu yang lebih besar akan terjadi. Bersama dengan seorang penyihir tua dan seorang pejuang yang berani, Kiran berusaha mencari tahu asal usul kekuatan gelap yang sedang mengancam desa mereka. \"Winds of Fate\" adalah kisah penuh dengan pertempuran antara kebaikan dan kejahatan, takdir dan pilihan, yang berpusat pada keberanian dan pengorbanan demi melindungi yang mereka cintai.",
                "awokawk", R.drawable.cover5,
                "Gramedia",
                "2019",
                dateFormat.parse("2019-12-10") ?: Date(),
                genre.SCIENCE),

            Book(8, "Buku Orang Korea ",
                "Gayso Mocho Neh",
                "Deskripsi Novel 5",
                "awokawk", R.drawable.cover5,
                "Gramedia",
                "2019",
                dateFormat.parse("2019-12-10") ?: Date(),
                genre.SCIENCE),

            Book(9, "Buku Orang Korea ",
                "Gayso Mocho Neh",
                "Deskripsi Novel 5",
                "awokawk", R.drawable.cover5,
                "Gramedia",
                "2019",
                dateFormat.parse("2019-12-10") ?: Date(),
                genre.SCIENCE),

            Book(10, "Buku Orang Korea ",
                "Gayso Mocho Neh",
                "Deskripsi Novel 5",
                "awokawk", R.drawable.cover5,
                "Gramedia",
                "2019",
                dateFormat.parse("2019-12-10") ?: Date(),
                genre.SCIENCE),

        )
    }
}