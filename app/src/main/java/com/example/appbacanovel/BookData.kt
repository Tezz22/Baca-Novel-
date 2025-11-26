package com.example.appbacanovel

object BookData {
    fun getBookList(): List<Book> {
        return listOf(
            Book(1,"Judul Novel 1", "Author Novel 1", "Deskripsi Novel 1", "lorem", R.drawable.cover1),
            Book(2,"Judul Novel 2", "Author Novel 2", "Deskripsi Novel 2", "lorem", R.drawable.cover2),
            Book(3,"Judul Novel 3", "Author Novel 3", "Deskripsi Novel 3", "lorem", R.drawable.cover3),
            Book(4,"Judul Novel 4", "Author Novel 4", "Deskripsi Novel 4", "lorem", R.drawable.cover4),
            Book(5,"Judul Novel 5", "Author Novel 5", "Deskripsi Novel 5", "lorem", R.drawable.cover5),
        )
    }
}