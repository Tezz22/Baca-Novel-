package com.example.appbacanovel

object BookData {
    fun getBookList(): List<Book> {
        return listOf(
            Book(1,"Judul Novel 1", "Author Novel 1", "Deskripsi Novel 1", "awokawk", "lorem", R.drawable.cover1, "Grammedia", "2023", "Novel"),
            Book(2,"Judul Novel 2", "Author Novel 2", "Deskripsi Novel 2","awokawk", "lorem", R.drawable.cover2, "Elex Media", "2022", "Novel"),
            Book(3,"Judul Novel 3", "Author Novel 3", "Deskripsi Novel 3","awokawk", "lorem", R.drawable.cover3, "Gramedia", "2021", "Novel"),
            Book(4,"Judul Novel 4", "Author Novel 4", "Deskripsi Novel 4","awokawk", "lorem", R.drawable.cover4, "Elex Media", "2020", "Novel"),
            Book(5,"Judul Novel 5", "Author Novel 5", "Deskripsi Novel 5","awokawk", "lorem", R.drawable.cover5, "Gramedia", "2019", "Novel"),
        )
    }
}