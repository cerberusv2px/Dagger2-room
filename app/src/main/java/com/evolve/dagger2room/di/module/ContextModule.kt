package com.evolve.dagger2room.di.module

import android.content.Context
import com.evolve.dagger2room.di.ApplicationContext
import dagger.Module
import dagger.Provides

/**
 * Created by sujin on 2/20/18.
 */
@Module
class ContextModule(private val context:Context) {

    @Provides
    fun provideContext(): Context {
        return context.applicationContext
    }
}