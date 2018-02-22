package com.evolve.dagger2room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.webkit.CookieSyncManager.createInstance
import com.evolve.dagger2room.dao.RepoDAO
import com.evolve.dagger2room.model.Repo

/**
 * Created by sujin on 2/20/18.
 */
@Database(entities = arrayOf(Repo::class), version = 1)
abstract class RepoDatabase : RoomDatabase() {

    companion object {

        private const val DB_NAME: String = "repoDatabase.db"
        var instance: RepoDatabase? = null
        fun getInstance(context: Context): RepoDatabase {
            if (instance == null)
                instance = createInstance(context)
            return instance as RepoDatabase
        }

        private fun createInstance(context: Context): RepoDatabase {
            return Room.databaseBuilder(context, RepoDatabase::class.java, DB_NAME).build()
        }
    }



    abstract fun getRepoDAO(): RepoDAO


}