package com.evolve.dagger2room.di.module


import android.content.Context
import com.evolve.dagger2room.di.ApplicationContext
import com.evolve.dagger2room.repository.impl.RepoRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sujin on 2/20/18.
 */
@Module(includes = [(ContextModule::class)])
class RepoModule {

    @Provides
    fun providesRepoRepository(context: Context): RepoRepositoryImpl {
        return RepoRepositoryImpl(context)
    }

}