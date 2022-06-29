package com.example.kiriku.di


import android.content.Context
import androidx.room.Room
import com.example.kiriku.database.local.NotesDao
import com.example.kiriku.database.local.NotesDb
import com.example.kiriku.database.repository.NotesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object MyModule {

    @Provides
    fun provideDb(@ApplicationContext context: Context): NotesDb =
        Room.databaseBuilder(
            context,
            NotesDb::class.java,
            "notes_db",
        ).build()


    @Provides
    @ViewModelScoped
    fun provideDao(db: NotesDb): NotesDao = db.notesDao()

    @Provides
    @ViewModelScoped
    fun provideRepositoryImpl(
        notesDao: NotesDao
    ): NotesRepositoryImpl = NotesRepositoryImpl(notesDao = notesDao)

}