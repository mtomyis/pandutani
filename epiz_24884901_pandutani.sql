-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: sql201.epizy.com
-- Waktu pembuatan: 26 Jan 2020 pada 19.56
-- Versi server: 5.6.45-86.1
-- Versi PHP: 7.2.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `epiz_24884901_pandutani`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'tomy', 'tomy');

-- --------------------------------------------------------

--
-- Struktur dari tabel `hama`
--

CREATE TABLE `hama` (
  `idhama` int(3) NOT NULL,
  `nama_hama` varchar(50) DEFAULT NULL,
  `uraian_hama` varchar(500) DEFAULT NULL,
  `gambar_hama` varchar(100) DEFAULT NULL,
  `penanggulangan` varchar(500) DEFAULT NULL,
  `fk_idtanaman_pangan` int(3) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `hama`
--

INSERT INTO `hama` (`idhama`, `nama_hama`, `uraian_hama`, `gambar_hama`, `penanggulangan`, `fk_idtanaman_pangan`) VALUES
(1, 'Keong Mas', 'Waktu kritis untuk pengendalian keong mas adalah pada saat 10 HST pindah, atau 21 HSS benih (semai basah).', 'keong_mas.jpg', 'Pratanam: Ambil keong mas dan musnahkan sebagai cara mekanis.\r\nPersemaian: Ambil keong mas dan musnahkan, sebar benih lebih banyak untuk sulaman dan bersihkan saluran air dari tanaman air seperti kangkung.\r\nStadia vegetatif: Tanam bibit yang agak tua (>21 hari) dan jumlah bibit lebih banyak, keringkan sawah sampai 7 HST, tidak aplikasi herbisida sampai 7 HST, ambil keong mas dan musnahkan.\r\nStadia generatif dan setelah panen: Ambil keong mas dan musnahkan, dan gembalakan itik setelah padi panen', 1),
(2, 'Wereng Coklat', 'Wereng coklat menyukai pertanaman yang dipupuk nitrogen tinggi dengan jarak tanam rapat. Ambang ekonomi hama ini adalah 15 ekor per rumpun. Siklus hidupnya 21-33 hari', 'wereng_coklat.jpg', 'Gunakan varietas tahan wereng coklat, seperti: Ciherang, Kalimas, Bondoyudo, Sintanur, dan Batang gadis.\r\nBerikan pupuk K untuk mengurangi kerusakan\r\nMonitor pertanaman paling lambat 2 minggu sekali.\r\nBila populasi hama di bawah ambang ekonomi gunakan insektisida botani\r\nBila populasi hama di atas ambang ekonomi gunakan insektisida kimiawi yang direkomendasi.', 1),
(3, 'Penggerek batang', 'Stadia tanaman yang rentan terhadap serangan pengerek batang adalah pembibitan samapai pembentukan malai.\r\nMengakibatkan anakan coati yang disebut sundep pada tanaman stadia vegetatif, dan beluk (malai hampa) pada tanaman stadia generatif. Siklus hidupnya 40-70 hari.', 'pengerek_batang.jpg', 'Bila populasi tinggi (di atas ambang ekonomi) aplikasikan insektisida. Bila genangan air dangkal aplikasikan insektisida butiran seperti karbofuran dan fipronil, dan bila genangan air tinggi aplikasikan insektisida cair seperti dimehipo, bensultap, amitraz dan fipronil.', 1),
(4, 'Tikus', 'Pengendalian hama tikus terpadu (PHTT) didasarkan pada pemahaman ekologi jenis tikus, dilakukan secara dini, intensif dan terus menerus (berkelanjutan) dengan memanfaatkan teknologi pengendalian yang sesuai dan tepat waktu.', 'tikus.jpg', 'Pengendalian tikus ditekankan pada awal musim tanam untuk menekan populasi awal tikus sejak awal pertanaman sebelum tikus memasuki masa reproduksi. Kegiatan tersebut meliputi gropyok masal, sanitasi habitat, pemasangan TBS (Trap Barrier System) dan LTBS (tinier Trap Barrier System).', 1),
(5, 'Walang Sangit', 'Walang sangit merupakan hama yang umum merusak bulir padi pada fase pemasakan. Fase pertumbuhan tanaman padi yang rentan terhadap serangan walang sangit keluarnya malai sampai matang susu.', 'walang_sangit.jpg', 'Kendalikan gulma di sawah dan di sekitar pertanaman.\r\nPupuk lahan secara merata agar pertumbuhan tanaman seragam.\r\nTangkap walang sangit dengan menggunakan faring sebelum stadia pembungaan.\r\nUmpan walang sangit dengan menggunakan ikan yang sudah busuk, daging yang sudah rusak, atau dengan kotoran ayam.\r\nApabila serangan suclang mencapai ambang ekonomi, lakukan penyemprotan insektisida.\r\nLakukan penyemprotan pada pagi sekali atau sore hari ketika walang sangit berada di kanopi.', 1),
(6, 'Penyakit Hawar Daun Bakteri (HDB)', 'Penyakit HDB disebabkan oleh bakteri Xanthomonas campesti-is pv oryzae dengan gejala penyakit berupa bercak berwarna kuning sampai putih berawal dari terbentuknya gars lebam berair pada bagian tepi daun.', 'Penyakit_Hawar_Daun_Bakteri_(HDB)_.jpg', 'Gunakan varietas tahan seperti Conde dan Angke\r\nGunakan pupuk nitrogen sesuai dengan kebutuhan tanaman\r\nBersihkan tunggul-tunggul dan jerami-jerami yang terinfeksi\r\nJarak tanam jangan terlalu rapat\r\nGunakan benih atau bibit yang sehat.', 1),
(7, 'Penyakit Blast', 'Blast dapat menginfeksi tanaman padi pada semua stadia pertumbuhan. Gejala khas pada daun yaitu bercak berbentuk belah ketupat – lebar ditengah dan meruncing di kedua ujungnya. Ukuran bercak kira-kira 1-1,5 x 0,3-0,5 cm berkembang menjadi berwarna abu-abu pada bagian tengahnya. Bila infeksi terjadi pada ruas batang dan leher malai (neck blast), akan merubah leher malai yang terinfeksi menjadi kehitam-hitaman dan patah, mirip gejala beluk oleh penggerek batang.', 'Penyakit_Blast_.jpg', 'Gunakan varietas tahan blast secara bergantian.\r\nGunakan pupuk nitrogen sesuai anjuran.\r\nUpayakan waktu tanam yang tepat, agar waktu awal pembungaan tidak banyak embun dan hujan terus menerus.\r\nGunakan fungisida yang berbahan aktif metil tiofanat atau fosdifen dan kasugamisin.', 1),
(8, 'Lalat bibit', 'Lalat bibit berukuran kecil, telur berbentuk memanjang dan diletakkan pada daun termuda. Tempayak lalat bibit\r\nmenggerek pucuk tanaman dan masuk sampai ke dalam batang. Lalat bibit menyukai tanaman muda yang berumur antara 6 sampai 9 hari setelah tanam', 'lalat_buah.png', 'Siklus hidupnya berkisar 15 - 25 hari. Seekor lalat bibit betina mampu bertelur 20 - 25 butir. gunakan varietas tahan dan seeds treatment melalui tanah pada waktu tanam atau diberikan pada kuncup daun pada umur tanaman satu minggu dengan dosis 0.24 kg b.a/ha.', 2),
(9, 'Ulat tanah', 'Ngengat Agrotis ipsilon meletakkan telur satu persatu dalam barisan atau diletakkan rapat pada salah satu permukaan daun pada bagian tanaman dekat dengan permukaan tanah. Larva muda bersifat fototaksis, sedang larva yang lebih tua bersifat geotaksis sehingga\r\npada siang hari bersembunyi di dalam tanah dan muncul kembali untuk makan pada malam hari. Satu generasi dapat berlangsung 4-6 minggu.', 'Ulat_tanah.jpg', 'Pengendalian : tanam serentak, dapat pula dilakukan penggenangan.', 2),
(10, 'Lundi (uret)', 'Kumbang muncul atau terbang setelah ada hujan pertama yang cukup\r\nlebat sehingga menyebabkan tanah cukup lembab. Telur diletakkan satu\r\npersatu di dalam tanah. Stadium telur 10 - 11 hari. Stadium larva aktif 5,5 bulan dan larva tidak aktif sekitar 40 hari.', 'Lundi_(uret)3.jpg', 'Pengendalian : pergiliran tanaman atau mengolah tanah dengan baik untuk mematikan larva.', 2),
(11, 'Penyakit bulai', 'Gejala penyakit bulai ini, daun berklorosis sebagian atau seluruh daun,\r\nbila tanaman terinfeksi lebih awal akan menyebabkan tanaman kerdil, tidak\r\nberbuah, tetapi bila bertongkol, tongkolnya tidak normal dan dapat pula menyebabkan tanaman mati.', 'Penyakit_bulai.jpg', 'benih yang akan ditanam dilakukan seeds treatment terlebih dahulu dengan menggunakan bahan aktif metalaksil, atau disemprotkan fungisida Nordox 56WP pada tanaman dimulai pada umur 5 hari setelah tanam sampai tidak ada lagi gutasi ditanaman', 2),
(13, 'Penggerek batang', 'Pada umumnya telur Ostrinia furnacalis yang mencapai 90 butir diletakkan pada tulang daun bagian bawah dari tiga daun teratas. Ulat yang keluar dari telur menuju bunga jantan dan menyebar bersama angin.', 'pengerek_batang_jagung.jpg', 'Pengendalian : dengan menggunakan insektisida Carbofuran 3% di pucuk tanaman sebanyak 2-3 g pertanaman.', 2),
(14, 'Wereng Jagung', 'Bentuk dan ukuran serangga dewasa mirip dengan hama wereng coklat dewasa yang meyerang padi. Siklus hidup 25 hari, masa telur 8 hari, telurnya berbentuk bulat panjang dan agak membengkok', 'Wereng_Jagung.jpg', 'waktu tanam serempak, waktu tanam dilakukan pada akhir musim hujan dan bila menggunakan insektisida gunakan insektisida Carbofuran 3%.', 2),
(17, 'Penyakit bulai', 'Gejala penyakit bulai ini, daun berklorosis sebagian atau seluruh daun,\r\nbila tanaman terinfeksi lebih awal akan menyebabkan tanaman kerdil, tidak\r\nberbuah, tetapi bila bertongkol, tongkolnya tidak normal dan dapat pula menyebabkan tanaman mati.', 'Penyakit_bulai1.jpg', 'benih yang akan ditanam dilakukan seeds treatment terlebih dahulu dengan menggunakan bahan aktif metalaksil, atau disemprotkan fungisida Nordox 56WP pada tanaman dimulai pada umur 5 hari setelah tanam sampai tidak ada lagi gutasi ditanaman', 2),
(21, 'Lalat bibit', 'populasi lalat bibit pada tanaman kedelai bila ditemukan 1 ekor imago/ 5 (lima) baris atau 1 ekor/ 50 rumpun pada umur 6-10 hari.', 'lalat_buah1.png', 'ilakukan tindakan pengendalian dengan menggunakan insektisida Spontan. Untuk mengurangi serangan hama tersebut, benih diberi perlakuan insektisida Marshal 25 ST.', 3),
(23, 'Hama penggerek polong', 'Jika sudah mencapai ambang kendali yaitu kerusakan polong 2,5% atau ditemui 2 ekor ulat/rumpun pada umur lebih dari 45 hari, tanaman disemprot insektisida efektif.', 'polong.jpg', 'Tanam serempak dalam kurun 10 hari, Penyemprotan NPV 180 ulat/500 It/ha, Tanaman perangkap jagung umur genjah, sedang dan dalam pada pematang', 3),
(24, 'Penyakit hawar batang', 'Gejala layu mendadak, daun-daun yang terinfeksi mulamula bercak berwarna merah, kemudian mengering.', 'hawara_baang.png', 'Untuk penyakit hawar batang pengendaliannya dengan melakukan perawatan benih dengan fungisida mankozeb.', 3),
(25, 'Penyakit karat daun', 'Gejala serangan terjadi pada daun timbul bercak-bercak berwarna klorotik sampai coklat kemerahan', 'karat.jpg', 'Penyakit ini dapat dikendalikan dengan fungisida mancozeb.', 3),
(26, 'Penyakit virus kerdil mosaik kedelai', 'Penyebabnya adalah virus SMV (Soybean Mosaic Virus). Gejala serangan penyakit virus SMV seperti bintik - bintik terbakar', 'mosaik.jpg', 'Untuk penyakit yang disebabkan oleh virus dapat dilakukan dengan upaya pencegahan dengan rotasi tanaman, pembakaran tanaman inang, pemberantasan serangga vektor, penggunaan benih sehat dan pembuangan tanaman sakit.', 3),
(27, 'Tungau Merah', 'Diawali dengan terlihatnya bercak kuning sepanjang tulang daun pada daun - daun bawah dan tengah. kemudian menyebar keseluruh permukaan daun sehingga daun berwarna kemerahan, coklat atau karat.', 'tungau_merah.png', 'menanama varietas tahan : adira-4. menyemprotkan air beberapa kali agar tungau larut tercuci bersama air. menanam seawal mungkin pada musim penghujan.', 4),
(28, 'Kepinding tepung', 'merupakan hama penghisap cairan daun dan batang tanaman. air liur dari hama tersebut mengakibatkan kerdil, ruas jadi pendek dan daun menjadi kerut', 'tepung.png', 'penanaman seawal mungkin pada musim penghujan. stek yang sehat dengan pencelupan air panas 10 menit.', 4),
(29, 'Kutu perisai', 'Daunnya akan menunjukan gejala kuning dan rontok. pada serangan yang parah tanaman bisa menjadi kerdil, pangkal dan pucuk menjadi mati.', 'perisai.png', 'Gunakan bibit tahan kutu perisai, potong bagian tanaman yang terinfeksi,', 4),
(30, 'Kutu Putih Pembentuk Spiral', 'Mengakibatkan sel - sel mengalami kematian dan menampakkan gejala berupa bercak keputihan pada permukaan daun.', 'spiral.png', 'Gunakan stek yang ditanam diberi insektisida dan tanaman yang sehat harus ditanam berjauhan dengan tanaman yang terserang.', 4),
(31, 'Kutu Kebul', 'Serangga penghisap daun. tidak menimbulakn kerusakan, namun jika mengandung virus maka akan menularkan virus mosaik.', 'kebul.png', 'Stek dilakukan dengan penambahan insektisida. tanaman yang sehat harus ditanam berjauhan.', 4),
(32, 'Lundi / uret', 'Menyerang akar sehingga tanaman menjadi layu dan mati. dapat mencapai 50 %.', 'Lundi_(uret)5.jpg', 'rendam lahan selama 48 jam dapat mematikan uret yang ada didalam tanah', 4),
(33, 'Rayap', 'Memakan batang bibit sehingga pertumbuhan stek terganggu bahkan mati.', 'rayap.png', 'Membajak sawah untuk menghancurkan sarang rayap, sanitasi dan membersihkan lahan dari sisa tanaman sebelumnya, rotasi tanaman.', 4),
(34, 'Belalang', 'Kerusakan berupa gerekan pada daun yagn tidak teratur, juga memakan daun hingga dapat merusak tanaman.', 'bela.png', 'Membajak lahan agar telur belalang terpapar dan dimakan predator', 4),
(35, 'Ulat Keket', 'Serangga ini dapat mengakibatkan defoliasi total terhadap daun dan rendahnya kualitas umbi kayu. mengakibatkan tanamh kurang subur dan tanaman menjadi rapuh.', 'keket.png', 'gunakan insektisida biologi yang efektif pada stadia 3 instar pertama.', 4),
(36, 'Ulat', 'Memakan epidermis daun bagian atas, sedang ulat tua makan seluruh bagian daun kecuali tulang daun, sehingga daun - daun yang terserang dari jauh terlihat berwarna putih.', 'ulat.png', 'Sanitasi gulma inang ulat, pupa ulat grayak diletakkan dalam tanah, dengan pengolahan tanah akan membalik tanah dan membinasakan pupa yang ada didalam tanah.', 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengingat`
--

CREATE TABLE `pengingat` (
  `idpengingat` int(3) NOT NULL,
  `nama_pengingat` varchar(50) DEFAULT NULL,
  `jarak_hst` int(10) DEFAULT NULL,
  `tanggal_mulai` datetime DEFAULT NULL,
  `tanggal_akhir` datetime DEFAULT NULL,
  `ciri_tanaman` varchar(500) DEFAULT NULL,
  `ciri_lahan` varchar(500) DEFAULT NULL,
  `fk_idtanaman_pangan` int(3) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengingat`
--

INSERT INTO `pengingat` (`idpengingat`, `nama_pengingat`, `jarak_hst`, `tanggal_mulai`, `tanggal_akhir`, `ciri_tanaman`, `ciri_lahan`, `fk_idtanaman_pangan`) VALUES
(1, 'Pengolahan Lahan', 19, NULL, NULL, 'Pengolahan tanah terdiri pembajakan, garu, dan perataan. Tanah ringan 1x bajak, 2x garu; tanah berat 2x bajak, 2x garu; kemudian perataan.\r\nKedalaman pembajakan 15-20 cm, tujuannya untuk memberikan media pertumbuhan padi optimal dan gulma dapat dibenamkan sempurna.', NULL, 1),
(2, 'Penanaman', 21, NULL, NULL, 'Bibit siap tanam berumur 3-4 minggu/memiliki minimal 4 daun.\r\nJarak tanam: 25 cm x 25 cm/30 cm x 15 cm atau menggunakan jarak tanam jejer legowo yaitu 40 cm x 20 cm x 20 cm.\r\nDengan kondisi tanah macak-macak', NULL, 1),
(3, 'Pengairan', 25, NULL, NULL, 'Diairi setinggi 2- 5 cm.\r\nApabila ketersediaan air selama satu musim tanam kurang mencukupi, pengairan bergilir dapat dilakukan dengan selang 5 hari. Pada sawah-sawah yang sulit dikeringkan (drainase jelek), pengairan berselang tidak perlu dipraktekkan.', NULL, 1),
(4, 'Pengairan Tahap 2', 32, NULL, NULL, 'Air di petakan dibiarkan mengering sendiri (5-6 hari). Setelah kering, petakan diairi setinggi 5 cm dan kemudian dibiarkan lagi mengering sendiri.\r\nApabila ketersediaan air selama satu musim tanam kurang mencukupi, pengairan bergilir dapat dilakukan dengan selang 5 hari. Pada sawah-sawah yang sulit dikeringkan (drainase jelek), pengairan berselang tidak perlu dipraktekkan.', NULL, 1),
(5, 'Monitor Hama', 35, NULL, NULL, 'Cek kondisi tanaman anda dengan sistem pakar', NULL, 1),
(6, 'Pemupukan', 36, NULL, NULL, 'Berikan 50 - 70 kg urea / ha untuk pupuk dasarnya atau pemupukan N pertama.', NULL, 1),
(7, 'Monitor Hama Tahap 2', 41, NULL, NULL, 'Cek kondisi tanaman anda menggunakan Sistem Pakar', NULL, 1),
(8, 'Pemupukan Menggunakan BWD', 42, NULL, NULL, 'Cek kondisi tanaman menggunakan bagan warna daun', NULL, 1),
(9, 'Monitor Hama Tahap 3', 55, NULL, NULL, 'Cek kondisi tanaman menggunakan sistem pakar', NULL, 1),
(10, 'Pemupukan Menggunakan BWD Tahap 2', 56, NULL, NULL, 'Cek kondisi tanaman menggunakan Bagan Warna Daun', NULL, 1),
(11, 'Monitor Hama Tahap 4', 65, NULL, NULL, 'Cek kondisi tanaman anda menggunakan Sistem Pakar ', NULL, 1),
(12, 'Pemupukan Menggunakan BWD Tahap 3', 66, NULL, NULL, 'Cek kondisi tanaman menggunakan Bagan Warna Daun ', NULL, 1),
(13, 'Pengairan Tahap 3', 70, NULL, NULL, 'Diairi terus menerus setinggi 5 cm. \r\nApabila ketersediaan air selama satu musim tanam kurang mencukupi, pengairan bergilir dapat dilakukan dengan selang 5 hari. Pada sawah-sawah yang sulit dikeringkan (drainase jelek), pengairan berselang tidak perlu dipraktekkan.', NULL, 1),
(14, 'Pengairan Tahap 4', 112, NULL, NULL, 'Petakan dikeringkan', NULL, 1),
(15, 'Panen', 121, NULL, NULL, 'Stadia masak susu, tandanya tanaman padi masih berwarna hijau tetapi malainya sudah terkulai; gabah bila dipijit dengan kuku keluar cairan seperti susu; terjadi pada saat 10 hari setelah fase berbunga merata. \r\nStadia masak kuning, terjadi 7 hari setelah stadia masak susu. \r\nStadia masak penuh, terjadi 7 hari setelah stadia masak kuning.\r\nSaat panen untuk gabah konsumsi sebaiknya dilakukan pada stadia masak kuning sedang gabah untuk benih, dipanen pada stadia masak penuh', NULL, 1),
(16, 'Penanaman', 1, NULL, NULL, 'Penanaman pada perlakuan TOT bisa dilakukan langsung dicangkul/koak tempat menugal benih sesuai dengan jarak tanam lalu beri\r\npupuk kandang atau kompos 1-2 genggam (+ 50 gr) tiap cangkulan/koakan.', NULL, 2),
(17, 'Pemupukan', 7, NULL, NULL, 'Cara pemberian pupuk, ditugal sedalam 5 cm dengan jarak 10 cm dari batang tanaman dan ditutup dengan tanah. dengan takaran Urea 100 (kg/ha), SP-36 150 (kg/ha), KCI 100 (kg/ha)', NULL, 2),
(18, 'Penyiangan', 14, NULL, NULL, 'penyiangan dapat dilakukan bersamaan dengan pembumbunan (mencangkul tanah diantara, barisan lalu ditimbunkan\r\nkebagian barisan tanaman sehingga membentuk guludan yang memanjang).', NULL, 2),
(19, 'Pengairan', 15, NULL, NULL, 'Berikan air secukupnya', NULL, 2),
(20, 'Pemupukan Tahap 2', 28, NULL, NULL, 'Gunakan Urea 150 (kg/ha)', NULL, 2),
(21, 'Monitor Hama', 29, NULL, NULL, 'Cek kondisi tanaman', NULL, 2),
(22, 'Pengairan', 30, NULL, NULL, 'Berikan air secukupnya ', NULL, 2),
(23, 'Pemupukan Menggunakan BWD', 45, NULL, NULL, 'Gunakan Bagan Warna Daun', NULL, 2),
(24, 'Monitor Hama Tahap 2', 46, NULL, NULL, 'Cek kondisi tanaman menggunakan sistem pakar', NULL, 2),
(25, 'Pengairan', 47, NULL, NULL, ' Berikan air secukupnya ', NULL, 2),
(26, 'Pengairan', 60, NULL, NULL, ' Berikan air secukupnya ', NULL, 2),
(27, 'Pengairan', 75, NULL, NULL, ' Berikan air secukupnya ', NULL, 2),
(28, 'Panen', 100, NULL, NULL, 'Jagung yang telah siap panen atau sering disebut masak fisiolologis ditandai dengan daun jagung/klobot telah kering, berwarna kekuning-kuningan, dan ada tanda hitam di bagian pangkal tempat melekatnya biji pada tongkol.', NULL, 2),
(29, 'Penanaman', 1, NULL, NULL, 'Pada penanaman kedelai, biji atau benih ditanam secara langsung. Lubang tanam dibuat dengan tugal sedalam 3 cm hingga 4 cm dengan jarak tanam sesuai dengan kondisi lahan. Dalam tiap lubang tanam dimasukkan 2 hingga 3 butir benih, kemudian ditutup dengan tanah tipis.', NULL, 3),
(30, 'Pengairan', 2, NULL, NULL, 'Pengairan sebaiknya dilakukan pada pagi atau sore hari. Tanaman kedelai sangat memerlukan air saat perkecambahan (0 hingga 5 hari setelah tanam). Pengairan dilakukan jangan sampai tanah terlalu becek atau bahkan kekeringan.', NULL, 3),
(31, 'Penyulaman', 7, NULL, NULL, 'Penyulaman perlu dilakukan yaitu pada 1 minggu setelah penanaman, tujuan penyulaman yaitu untuk mengganti benih kedelai yang mati atau tidak tumbuh. Penyulaman dilakukan jangan sampai terlambat karena dapat mengakibatkan tingkat pertumbuhan tanaman jauh berbeda.', NULL, 3),
(32, 'Pengairan Tahap 2', 13, NULL, NULL, 'Pengairan sebaiknya dilakukan pada pagi atau sore hari. Tanaman kedelai sangat memerlukan air saat perkecambahan stadium awal vegetatif (15 hingga 20 hari), Pengairan dilakukan jangan sampai tanah terlalu becek atau bahkan kekeringan.', NULL, 3),
(33, 'Pemupukan', 14, NULL, NULL, 'Untuk lahan kering masam, dosis pupuk yang diberikan 75 kg Urea + 100 kg SP36 + 100 kg KCl/ha + 500 kg CaCO3/ha (setara 1500 kg dolomit). Pupuk urea, SP36 dan KCI. Pupuk diberikan dengan cara ditugal atau dilarik 5-7 cm dari tanaman, kemudian ditutup tanah.', NULL, 3),
(34, 'Penyiangan', 15, NULL, NULL, 'Penyiangan dilakukan pra maupun pasca tumbuh dengan cara pemantauan baik secara mekanik – konvensional atau manual maupun secara kimia dengan menggunakan herbisida. Bila rumput masih banyak, maka penyiangan dilakukan lagi pada umur 55 hari.', NULL, 3),
(35, 'Pemupukan Tahap 2', 28, NULL, NULL, 'Pemberian pupuk susulan hanya dilakukan pada tanah yang kurang subur saja. Pupuk yang digunakan berupa Urea dengan dosis 50 kg/hektar, selanjutnya ditutup dengan tanah dan meningkatkan hasil produksi kedelai, dapat digunakan pula ZPT (Zat Pengatur Tumbuh) dan PPC (Pupuk Pelengkap Cair), dosis yang digunakan sesuaikan dengan dosis anjuran. Tambahkan pupuk urea dan KCL sebesar 50 kg/ha', NULL, 3),
(36, 'Penyiangan', 30, NULL, NULL, 'Penyiangan dilakukan pada saat tanaman berumur sekitar 20 – 30 hari setelah tanam. Penyiangan pertama dilakukan bersamaan dengan pemupukan susulan. Penyiangan kedua dilakukan setelah tanaman selesai berbunga. Selain itu, lakukan pula penggemburan tanah. Penggemburan dilakukan secara hati-hati agar tidak mernsak akaran tanaman.', NULL, 3),
(37, 'Pengairan Tahap 3', 35, NULL, NULL, 'Pengairan sebaiknya dilakukan pada pagi atau sore hari. Tanaman kedelai sangat memerlukan air saat masa pembungaan dan pembentukan biji (35 -hingga 65 hari). Pengairan dilakukan jangan sampai tanah terlalu becek atau bahkan kekeringan.', NULL, 3),
(38, 'Monitor Hama', 45, NULL, NULL, 'Periksa tanaman kedelai menggunakan sistem pakar', NULL, 3),
(39, 'Penyiangan', 55, NULL, NULL, 'Apabila masih terdapat rumput lakukan pemeriksaan pada tanaman dengan cara pemantauan baik secara mekanik – konvensional atau manual maupun secara kimia dengan menggunakan herbisida.', NULL, 3),
(40, 'Pengairan Tahap 4', 65, NULL, NULL, 'Pengairan dikurangi hingga waktu panen datang tanah dalam kondisi kering', NULL, 3),
(41, 'Panen', 75, NULL, NULL, 'Masa panen dari tanaman kedelai adalah umur 80 - 110. Tapi juga bisa dipanen pada usia 75 - 100 hari apabila kedelai akan digunakan untuk komsumsi. dan umur 100 - 110 apabila kedelai ingin digunakan sebagai bakal bibit. memiliki ciri - ciri buah menguning kecoklatan, daunnya kering dan buah polong terlihat sudah tua. panen dilakukan dengan mencabut semua batang dan kemudian menjemurnya hingga kering.', NULL, 3),
(42, 'Penanaman', 1, NULL, NULL, 'Pilihlah tanaman singkong yang cukup tua dengan usia 10-12 bulan, untuk dijadikan sebagai induk bibit tanaman singkong.\r\nPenanaman singkong sangat dianjurkan untuk dilakukan saat awal musim hujan, mengingat sifat bibit yang masih memerlukan pasokan air yang cukup banyak untuk pertumbuhan awal.\r\nBibit singkong yang ditanam sangat rentan dengan cuaca panas atau kondisi tanah yang kering sehingga penyiraman harus dilakukan dengan teratur.', NULL, 4),
(43, 'Pengairan', 2, NULL, NULL, 'Penyiraman perlu dilakukan untuk menjaga kelembapan tanah serta pasokan air yang diserap oleh tanaman singkong. Berikan air secukupnya', NULL, 4),
(44, 'Penyulaman', 7, NULL, NULL, 'enyulaman ini dilakukan dengan memeriksa apakah terdapat tanaman singkong yang mati atau gagal tumbuh. Jika terdapat tanaman singkong yang tidak tumbuh atau mati, segeralah bersihkan dari lahan tanam. ', NULL, 4),
(45, 'Penyiangan', 15, NULL, NULL, 'Lakukanlah penyiangan atau pemberantasan terhadap gulma atau tanaman pengganggu yang terdapat di sekitar tanaman singkong. Penyiangan dapat dilakukan manual dalam skala kecil yaitu dengan mencabut tanaman tersebut. Solusi penyiangan dalam skala besar dapat dilakukan dengan menyemprotkan herbisida di lahan sekitar tanaman singkong.', NULL, 4),
(46, 'Pengairan', 21, NULL, NULL, 'Penyiraman perlu dilakukan untuk menjaga kelembapan tanah serta pasokan air yang diserap oleh tanaman singkong.', NULL, 4),
(47, 'Monitor Hama', 30, NULL, NULL, 'Cek tanaman singkong menggunakan sistem pakar', NULL, 4),
(48, 'Pemupukan', 60, NULL, NULL, 'Taburkanlah pupuk dengan jarak 25-30 cm dari batang singkong. Pemupukan pertama berfungsi untuk agar singkong cepat tumbuh besar', NULL, 4),
(49, 'Penyiangan', 75, NULL, NULL, 'Penyiangan dapat dilakukan manual dalam skala kecil yaitu dengan mencabut tanaman tersebut. Solusi penyiangan dalam skala besar dapat dilakukan dengan menyemprotkan herbisida di lahan sekitar tanaman singkong.', NULL, 4),
(50, 'Pemupukan Tahap 2', 150, NULL, NULL, 'Taburkanlah pupuk dengan jarak 25-30 cm dari batang singkong. Pemupukan kedua dilakukan untuk agar buah yang dihasilkan dapat lebih lebat dan besar.', NULL, 4),
(51, 'Panen', 180, NULL, NULL, 'usia panen singkong berkisar 6 sampai 12 bulan. Secara spesifik kalian juga dapat melihat beberapa karakteristiknya seperti pertumbuhan daun di bagian bawah yang sudah mulai berkurang dan warna daun yang menguning dan banyak rontok.', NULL, 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesan`
--

CREATE TABLE `pesan` (
  `idpesan` int(100) NOT NULL,
  `isi_pesan` varchar(100) DEFAULT NULL,
  `gambar` blob,
  `waktu_pesan` datetime DEFAULT NULL,
  `fk_idpetani` int(100) NOT NULL,
  `fk_idtopik` int(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktur dari tabel `petani`
--

CREATE TABLE `petani` (
  `idpetani` int(100) NOT NULL,
  `nama_petani` varchar(20) DEFAULT NULL,
  `nama_belakang` varchar(45) DEFAULT NULL,
  `password_petani` varchar(10) DEFAULT NULL,
  `alamat` varchar(20) DEFAULT NULL,
  `photo` text,
  `enkripsi` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `petani`
--

INSERT INTO `petani` (`idpetani`, `nama_petani`, `nama_belakang`, `password_petani`, `alamat`, `photo`, `enkripsi`) VALUES
(2, 'tomtom', 'is', 'tomy', 'Tegaldlimo', 'http://magehsuntoto.epizy.com/hubungkanke/profile_image/2.jpeg', 'BJ7D89'),
(3, 'Muhammad Tomy', 'Iskandar', 'iskandar', 'Tegaldlimo', 'http://magehsuntoto.epizy.com/hubungkanke/profile_image/3.jpeg', 'YV6EF8'),
(4, 'ahmad', 'wildan jauhari', '12345678', 'Kecamatan Rogojampi', NULL, 'RZPHAI'),
(6, 'sopo', 'jarwo', 'hahaha', 'Kecamatan Rogojampi', NULL, 'S7LVO2'),
(9, 'tomy', 'iskandar', 'qwertyuiop', 'Tegaldlimo', NULL, '3P4GR7');

-- --------------------------------------------------------

--
-- Struktur dari tabel `prosedur`
--

CREATE TABLE `prosedur` (
  `idprosedur` int(3) NOT NULL,
  `nama_prosedur` varchar(50) DEFAULT NULL,
  `uraian_prosedur` varchar(500) DEFAULT NULL,
  `gambar_prosedur` varchar(200) DEFAULT NULL,
  `fk_idtanaman_pangan` int(3) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `prosedur`
--

INSERT INTO `prosedur` (`idprosedur`, `nama_prosedur`, `uraian_prosedur`, `gambar_prosedur`, `fk_idtanaman_pangan`) VALUES
(1, 'Persemaian', 'Untuk keperluan penanaman seluas 1 ha, benih yang dibutuhkan sebanyak 20 kg. Benih bernas (yang tenggelam) dibilas dengan air bersih dan kemudian direndam dalam air selama 24 jam. Selanjutnya diperam dalam karung selama 48 jam dan dijaga kelembabannya dengan cara membasahi karung dengan air.\r\nUntuk benih hibrida langsung direndam dalam air dan selanjutnya diperam. Luas persemaian sebaiknya 400 m 2 /ha (4% dari luas tanam). Lebar bedengan pembibitan 1,0-1,2 m dan diberi campuran pupuk kandang.', 'persemaian_padi.jpg', 1),
(2, 'Persiapan Lahan', 'Pengolahan tanah dapat dilakukan secara sempurna (2 kali bajak dan 1 kali garu) atau minimal atau tanpa olah tanah sesuai keperluan dan kondisi. Faktor yang menentukan adalah kemarau panjang, pola tanam, jenis/tekstur tanah. Dua minggu sebelum pengolahan tanah taburkan bahan organik secara merata di atas hamparan sawah.\r\nBahan organik yang digunakan dapat berupa pupuk kandang sebanyak 2 ton/ha atau kompos jerami sebanyak 5 ton/ha.', 'olah_lahan_padi.jpg', 1),
(3, 'Penanaman', 'Tanam bibit muda <21 HSS (hari setelah sebar), sebanyak 1-3 bibit/rumpun. Bibit lebih muda (14 HSS) dengan 1 bibit/rumpun akan menghasilkan anakan lebih banyak, hanya pada daerah endemis keong mas gunakan benih 18 HSS dengan 3 bibit/rumpun. Penyulaman dilakukan sebelum tanaman berumur 14 HST (hari setelah tanam). Pada saat bibit ditanam, tanah dalam kondisi jenuh air.\r\nPenanaman disarankan dengan sistem jejer legowo 2 :1 atau 4 : 1 (40x(20x10) cm atau (50x(25x12,5) cm.', 'penanaman_padi.jpg', 1),
(4, 'Pengairan Berselang', 'Cara pemberian air yaitu saat tanaman berumur 3 hari, petakan sawah diairi dengan tinggi genangan 3 cm dan selama 2 hari berikutnya tidak  ada penambahan air. Pada hari ke-4 lahan sawah diari kembali dengan tinggi genangan 3 cm. Cara ini dilakukan terus sampai fase anakan maksimal. Mulai fase pembentukan malai sampai pengisian biji, petakan sawah digenangi terus. Sejak 10 -15 hari sebelum panen sampai saat panen tanah dikeringkan.', 'pengairan_padi.jpg', 1),
(5, 'Pemupukan', 'Pemberian berbagai unsur hara dalam bentuk pupuk untuk memenuhi kekurangan hara yang dibutuhkan tanaman berdasarkan tingkat hasil yang ingin dicapai dan hara yang tersedia dalam tanah. Untuk setiap ton gabah yang dihasilkan, tanaman padi membutuhkan hara N sekitar 17,5 kg, P sebanyak 3 kg clan K sebanyak 17 kg.\r\nPupuk disesuaikan dengan kebutuhan tanaman dan ketersediaan hara dalam tanah. Kebutuhan N tanaman dapat diketahui dengan cara mengukur tingkat kehijauan warna daun padi menggunakan BWD', 'pemupukan_padi.jpg', 1),
(6, 'Pengendalian Gulma Secara Terpadu', 'Gulma dikendalikan dengan cara pengolahan tanah sempurna, mengatur air dipetakan sawah, menggunakan benih padi bersertifikat, hanya menggunakan kompos sisa tanaman dan kompos pupuk kandang, dan menggunakan herbisida apabila infestasi gulma sudah tinggi.\r\nDengan menggunakan kosrok(landak) sangat dianjurkan, karena cara ini sinergis dengan pengelolaan lainnya. Pengendalian gulma secara manual hanya efektif dilakukan apabila kondisi air di petakan sawah macak-macak atau tanah jenuh air.', 'pengendalian_hama_padi1.jpg', 1),
(7, 'Pengendalian Hama dan Penyakit Terpadu', 'Pengendalian hama dan penyakit terpadu (PHT) merupakan pendekatan pengendalian yang memperhitungkan faktor ekologi sehingga pengendalian dilakukan agar tidak terlalu mengganggu keseimbangan alami dan tidak menimbulkan kerugian besar. PHT merupakan paduan berbagai cara pengendalian hama dan penyakit, diantaranya melakukan monitoring populasi hama dan kerusakan tanaman sehingga penggunaan teknologi pengendalian dapat lebih tepat.', 'pengendalian_hama_padi.jpg', 1),
(8, 'Panen', 'Lakukan panen saat gabah telah menguning, tetapi malai masih segar. Potong padi dengan sabit gerigi, 30-40 cm di atas permukaan tanah. Gunakan plastik atau terpal sebagai alas tanaman padi yang baru dipotong dan ditumpuk sebelum dirontok. Sebaiknya panen padi dilakukan oleh kelompok pemanen dan gabah dirontokan dengan power tresher. Apabila panen dilakukan pada waktu pagi hari sebaiknya pada sore harinya langsung dirontokan. Perontokan lebih dari 2 hari menyebabkan kerusakan', 'panen_padi.jpg', 1),
(9, 'Pasca Panen', 'Jemur gabah di atas lantai jemur dengan ketebalan 5-7 cm. Lakukan pembalikan setiap 2 jam sekali. Gabah yang sudah kering dapat digiling dan disimpan. Hal penting yang perlu diperhatikan dalam penggilingan dan penyimpanan adalah:\r\nSimpan gabah/beras dalam wadah yang bersih dalam lumbung/gudang, bebas hama, dan memiliki sirkulasi udara yang baik.\r\nSebelum digiling, gabah yang dikeringkan tersebut diangin-anginkan terlebih dahulu untuk menghindari butir pecah.', 'penjemuran_padi.jpg', 1),
(10, 'Benih Bermutu', 'Sebelum ditanam hendaknya dilakukan pengujian daya kecambah benih. Benih yang baik adalah yang mempunyai daya tumbuh lebih dari 90%. Hal ini penting karena dalam budidaya jagung tidak dianjurkan melakukan\r\npenyulaman tanaman yang tidak tumbuh dengan menanam ulang benih pada tempat tanaman yang tidak tumbuh. Pertumbuhan tanaman sulaman biasanya tidak normal karena adanya persaingan untuk tumbuh, dan biji yang terbentuk dalam tongkol tidak penuh akibat penyerbukan', 'benih_jagung.jpg', 2),
(11, 'Penyiapan Lahan', 'Pengolahan tanah untuk penanaman jagung dapat dilakukan dengan 2 cara yaitu olah tanah sempurna (OTS) dan tanpa olah tanah (TOT) bila lahan gembur. Namun bila tanah berkadar Hat tinggi sebaiknya dilakukan pengolahan tanah sempurna (intensify. Pada lahan yang ditanami jagung dua kali setahun, penanaman pada musim penghujan (rendeng) tanah diolah sempurna dan pada musim\r\ntanam berikutnya dilakukan dengan tanpa olah tanah untuk mempercepat waktu tanam.', 'olah_lahan_jagung.jpg', 2),
(12, 'Penanaman', 'Penanaman pada perlakuan TOT bisa dilakukan langsung dicangkul/koak tempat menugal benih sesuai dengan jarak tanam lalu beri pupuk kandang atau kompos 1-2 genggam (+ 50 gr) tiap cangkulan/koakan. Penanaman pada lahan OTS cukup ditugal untuk dibuat lubang tanam benih sesuai dengan jarak tanam, selanjutnya diberikan pupuk kandang atau kompos 1-2 genggam (+ 50 gr).', 'penanaman_jagung.jpg', 2),
(13, 'Pemupukan', 'takaran pupuk untuk tanaman jagung berdasarkan target hasil adalah 350-400 kg urea/ha, 100-150 kg SP-36/ha, dan 100-150 kg KCl/ha. Cara pemberian pupuk, ditugal sedalam 5 cm dengan jarak\r\n10 cm dari batang tanaman dan ditutup dengan tanah. Bagan warna daun hanya digunakan pada waktu pemberian pupuk ketiga.', 'pemupukan_jagung.jpg', 2),
(14, 'Penyiangan', 'Penyiangan sebaiknya dilakukan dua minggu sekali selama masa pertumbuhan tanaman jagung, yaitu pertama pada umur 15 hst hingga pada umur 6 minggu hst . penyiangan dapat dilakukan bersama dengan pembumbunan (mencangkul tanah diantara, barisan lalu ditimbunkan kebagian barisan tanaman sehingga membentuk\r\nguludan yang memanjang).', 'penyiangan_jagung.jpg', 2),
(15, 'Pengendalian Hama dan Penyakit', 'Hama yang umum mengganggu pertanaman jagung adalah lalat bibit, penggerek batang dan tongkol. Lalat bibit umumnya mengganggu pada saat awal pertumbuhan tanaman, oleh karena itu pengendaliannya dilakukan mulai saat tanam menggunakan insektisida carbofuran utamanya pada daerah-daerah endemik serangan lalat bibit.', 'pengendalian_hama_jagung.jpg', 2),
(16, 'Pengairan', 'Setelah benih ditanam, penyiraman dilakukan secukupnya, kecuali bila tanah telah lembab. Namun menjelang tanaman berbunga, air yang diperlukan lebih besar sehingga perlu penyiraman yang lebih intensif. Bila musim kemarau pengairan perlu dilakukan pengaturan antara lain umur pertumbuhan, 15 hst, 30 hst, 45 hst,\r\n60 hst, dan 75 hst.', 'pengairan_jagung.jpg', 2),
(17, 'Penyimpanan Jagung', 'Penyimpanan jagung untuk benih harus menggunakan wadah yang\r\ntertutup rapat sehingga kedap udara dan tidak terjadi\r\nkontak dengan udara yang menyebabkan biji jagung menjadi rusak dan menurun daya tumbuhnya. Jagung untuk benih dapat menggunakan wadah logam yang dilengkapi dengan absorban/penyerap (biasanya digunakan abu sekam). Penyimpanan jagung untuk konsumsi, dapat dalam karung', 'penyimpanan_jagung.jpg', 2),
(18, 'Panen', 'Jagung yang telah siap panen atau sering disebut masak fisiolologis ditandai dengan daun jagung/klobot telah kering, berwarna kekuning-kuningan, dan ada tanda hitam di bagian pangkal tempat melekatnya biji pada tongkol. ', 'panen_jagung.jpg', 2),
(19, 'Pembibitan Singkong', 'Bibit dengan kualitas baik akan menghasilkan produksi yang tinggi dan kualitas singkong yang tinggi pula. Pengembangbiakan tanaman singkong dilakukan dengan cara stek. Batang tanaman singkong yang akan digunakan untuk stek dipilih berdasarkan umur kurang lebih 7-12 bulan, diameter 2,5 - 3 cm, telah berkayu, lurus dan masih segar, panjang stek 20 - 25 cm. Stek dalam ikatan di bagian pangkal diruncingi agar memudahkan penanaman, kulit stek tidak terkelupas terutama pada bakal tunas.', 'penanaman_singkong.jpg', 4),
(20, 'Pengolahan Lahan', 'Pengolahan tanah dapat dilakukan dengan dibajak atau di cangkul 1-2 kali sedalam kurang lebih 20 cm, diratakan atau di buat bedengan-bedengan atau guludan dan juga dibuat saluran drainase. Setelah itu dibuat coklakan (lubang tanam kecil sebesar cangkul) lalu diisi media tanam (kompos plus) yang berisi campuran kompos/pupuk organik', 'olah_lahan_singkong.jpg', 4),
(21, 'Penanaman', 'Penanaman bibit singkong dapat dilakukan setelah stek dan tanah disiapkan. Stek dalam ikatan direndam dalam air yang mengandung biostimulan Citorin. Cara menanam singkong sebaiknya stek tegak lurus atau minimal membentuk sudut 60 derajat dengan tanah dan kedalaman stek 10 - 15 cm.', 'penanaman_singkong1.jpg', 4),
(22, 'Pemupukan', 'Pupuk an-organik diberikan adalah pupuk NPK (14 : 6 : 23). Pada umumnya dosis pupuk anjuran untuk tanaman singkong adalah 300 Kg pupuk NPK per ha. Cara pemberian pupuk adalah s e b a g a i p upuk dasar: 1/3 bagian dosis diberikan pada saat tanam, d a n pupuk susulan: 2/3 bagian dari dosis pada saat tanaman berumur 3 - 4 bulan.', 'Lundi_(uret).jpg', 4),
(23, 'Pemeliharaan', 'Pemeliharaan tanaman perlu dilakukan untuk mendapatkan tanaman yang sehat, baik, seragam dan memperoleh hasil yang tinggi. Penyiangan dilakukan apabila sudah mulai tampak adanya gulma. Penyiangan kedua dilakukan pada saat singkong berumur 2-3 bulan sekaligus dengan melakukan pembumbunan.', 'Lundi_(uret)1.jpg', 4),
(24, 'Panen', 'Beberapa tips proses panen singkong yang baik ialah sebagai berikut :\r\nCabutlah batang tanaman singking hingga ke umbinya.\r\nJika masih ada umbi yang tertinggal di tanah, ambillah dengan garpu tanah atau cangkul.\r\nKumpulkan singkong hasil panen di tempat yang strategis.\r\nLakukanlah penyortiran atau pemilihan terhadap singkong berdasarkan ukuran dan kualitas umbinya.\r\nPisahkan singkong yang cacat atau busuk dengan singkong yang segar.', 'panen_singkong.jpg', 4),
(25, 'Bahan tanaman', 'Berdasarkan warna bijinya dikenal kedelai kuning dan kedelai hitam. Pemeliharaan kedelai hitam umumnya lebih mudah dari pada kedelai kuning. kedelai kuning membutuhkan tanah yang lebih subur, serta memerlukan pengairan dan pemeliharaan lebih balk dari pada kedelai hitam. Kedelai hitam umumnya hanya digunakan untuk bahan baku kecap, sedangkan kedelai kuning untuk bahan baku tempe', 'olah_lahan_kedelai.jpg', 3),
(26, 'Persiapan lahan', 'Pada lahan kering, tanah dibajak 2 kali sedalam 30 cm, sedangkan pada lahan sawah dengan tanaman monokultur, tanah ditersihkan dari jerami, kemudian tanah diolah satu kalli. Kemudian dibuat saluran drainase setiap 4 m, sedalam 20-25 cm, lebar 20 cm. Pembuatan saluran drainase dimaksudkan untuk mencegah terjadinya penggenangan air, karena tanaman kedelai tidak tahan terhadap genangan.', 'olah_lahan_kedelai1.jpg', 3),
(27, 'Penanaman', 'Pilihlah waktu yang tepat, sehingga tidak mengalami kebanjiran atau sebaliknya kekeringan. Penanaman dilakukan dengan tugal, dengan jarak tanam 40 cm x 15 cm atau 40 cm x 20 cm, dua biji per lubang. Populasi tanaman kisarannya 350,000 - 500.000/ha Semakin subur lahan, sebaiknya jarak tanam semakin lebar.', 'penanaman_kedelai.jpg', 3),
(28, 'Pemupukan', 'Untuk lahan kering masam, dosis pupuk yang diberikan 75 kg Urea + 100 kg SP36 + 100 kg KCl/ha + 500 kg CaCO3/ha (setara 1500 kg dolomit). Pupuk urea, SP36 dan KCI diberikan paling lambat saat tanaman berumur 14 hari. Pupuk diberikan dengan cara ditugal atau dilarik 5-7 cm dari tanaman, kemudian ditutup tanah. Sedangkan kapur (dolomit) ditebar sebelum tanam saat pengolahan lahan kedua. Untuk lahan sawah, dosis pupuk 50 kg Urea + 50 kg SP36 + 100 kg KCl/ha.', 'pemupukan_kedelai.jpg', 3),
(29, 'Penyiangan', 'Penyiangan dilakukan pra maupun pasca tumbuh dengan cara pemantauan baik secara mekanik – konvensional atau manual maupun secara kimia dengan menggunakan herbisida. Penyiangan dilakukan pada umur 15 dan 30 hari. Bila rumput masih banyak, maka penyiangan dilakukan lagi pada umur 55 hari.', 'pengendalian_hama_kedelai.jpg', 3),
(30, 'Pengendalian Hama', 'Pergiliran tanaman dengan tanaman bukan kedelai atau bukan kacang- kacangan. Pergiliran kedelai dengan padi, jagung, atau ubijalar, merupakan salah satu cara dalam pengendalian hama kedelai. Tanam seawal mungkin dan serempak dengan beda waktu tanam kurang dari 10 hari dalam satu hamparan/wilayah. Penggunaan varietas berumur genjah agar tanaman tidak terlalu lama menjadi sasaran hama.', 'pengendalian_hama_kedelai1.jpg', 3),
(31, 'Panen.', 'Panen dilakukan apabila semua daun rontok, polong berwarna kuning/coklat dan mengering. Panen dimulai sekitar pukul 09.00 pagi. Pada saat ini air embun sudah hilang. Pangkal batang tanaman dipotong menggunakan sabit bergerigi atau sabit tajam.', 'panen_kedelai.jpg', 3),
(32, 'Pasca panen', 'erdiri dan penjemuran brangkasan tanaman, pembijian, pengeringan, pembersihan, dan penyimpanan biji perlu mendapat perhatian yang cukup. Sebab, kegiatan ini mempengaruhi kualitas biji atau benih yang dihasilkan. Kedelai sebagai bahan konsumsi dipetik pada umur 75 - 100 hari, sedangkan untuk benih umur 100 - 110 hari', 'panen_kedelai1.jpg', 3),
(33, 'Penyimpanan', 'Biji disimpan dalam kantong plastik berukuran 30-40 kg, ketebalan 0,2 mm dan kedap udara. Kantong-kantong yang telah berisi biji-biji kedelai tersebut, kemudian dimasukan ke dalam karung plastik (seperti karung pupuk), dan bagian atas karung diikat dengan tali rafia. Kemudian disusun rapi ditempat penyimpanan/gudang.', 'panen_kedelai2.jpg', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tanamanpangan`
--

CREATE TABLE `tanamanpangan` (
  `idtanaman_pangan` int(3) NOT NULL,
  `nama_tanaman` varchar(20) DEFAULT NULL,
  `uraian_tanaman` varchar(500) DEFAULT NULL,
  `gambar_tanaman` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tanamanpangan`
--

INSERT INTO `tanamanpangan` (`idtanaman_pangan`, `nama_tanaman`, `uraian_tanaman`, `gambar_tanaman`) VALUES
(1, 'Padi', 'PADI (Oryza sativa L.) merupakan tanaman yang dimanfaatkan sebagai bahan pangan pokok (sumber karbohidrat). Memiliki batang padi berbuku dan berongga dengan akar tanaman serabut, efektif dalam penyeraan hara, tetapi peka terhadap kekeringan. Akar padi terkonsentrasi pada kedalaman 10-20 cm.\r\nPadi dapat beradaptasi pada lingkungan tergenang (anaerob) karena pada akar terdapat saluran aerenchyma (struktur seperti pipa yang memanjang hingga ujung daun, berfungsi sebagai penyedia oksigen bagi daerah', 'padi1.jpg'),
(2, 'Jagung', 'Tanaman jagung dapat dibudidayakan di dataran rendah maupun dataran tinggi, pada lahan sawah atau tegalan. Suhu optimal antara\r\n21-34 derajat c. Tanaman jagung membutuhkan air sekitar 100- 140 mm/bulan. Oleh karena itu waktu penanaman harus memperhatikan curah hujan dan penyebarannya. Penanaman dimulai bila curah hujan sudah mencapai 100 mm/bulan.', 'jagung.jpg'),
(3, 'Kedelai', 'Pengembangan kedelai dapat dilakukan di lahan sawah maupun di lahan kering, bergantung kepada iklim dan kebutuhan petani setempat. Tanaman Kedelai dapat tumbuh pada berbagai jenis tanah asal drainase (tata air) dan aerasi (tata udara) tanah cukup baik, curah hujan 100-400 mm/bulan, suhu udara 23-30 derajat C, kelembaban 60-70%, pH tanah 5,8-7 dan ketinggian kurang dari 600 m dpl.', 'kedelai.jpg'),
(4, 'Singkong', 'Singkong merupakan bahan baku aneka industri antara lain; tepung mocaf, tapioka, keripik, gula cair, bioetanol, makanan camilan, dan lain- lain. Agar kebutuhan industri berbasis singkong terpenuhi dalam jumlah besar dan kontinu, maka penting sekali melakukan budidaya tanaman singkong secara baik.', 'singkong.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `topik`
--

CREATE TABLE `topik` (
  `idtopik` int(100) NOT NULL,
  `nama_topik` varchar(50) DEFAULT NULL,
  `waktu_topik` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `hama`
--
ALTER TABLE `hama`
  ADD PRIMARY KEY (`idhama`);

--
-- Indeks untuk tabel `pengingat`
--
ALTER TABLE `pengingat`
  ADD PRIMARY KEY (`idpengingat`);

--
-- Indeks untuk tabel `pesan`
--
ALTER TABLE `pesan`
  ADD PRIMARY KEY (`idpesan`,`fk_idpetani`,`fk_idtopik`),
  ADD KEY `fk_pesan_petani1_idx` (`fk_idpetani`),
  ADD KEY `fk_pesan_topik1_idx` (`fk_idtopik`);

--
-- Indeks untuk tabel `petani`
--
ALTER TABLE `petani`
  ADD PRIMARY KEY (`idpetani`);

--
-- Indeks untuk tabel `prosedur`
--
ALTER TABLE `prosedur`
  ADD PRIMARY KEY (`idprosedur`);

--
-- Indeks untuk tabel `tanamanpangan`
--
ALTER TABLE `tanamanpangan`
  ADD PRIMARY KEY (`idtanaman_pangan`);

--
-- Indeks untuk tabel `topik`
--
ALTER TABLE `topik`
  ADD PRIMARY KEY (`idtopik`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `hama`
--
ALTER TABLE `hama`
  MODIFY `idhama` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT untuk tabel `pengingat`
--
ALTER TABLE `pengingat`
  MODIFY `idpengingat` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT untuk tabel `pesan`
--
ALTER TABLE `pesan`
  MODIFY `idpesan` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `petani`
--
ALTER TABLE `petani`
  MODIFY `idpetani` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `prosedur`
--
ALTER TABLE `prosedur`
  MODIFY `idprosedur` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT untuk tabel `tanamanpangan`
--
ALTER TABLE `tanamanpangan`
  MODIFY `idtanaman_pangan` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `topik`
--
ALTER TABLE `topik`
  MODIFY `idtopik` int(100) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
