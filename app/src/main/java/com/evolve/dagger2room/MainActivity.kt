package com.evolve.dagger2room

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.evolve.dagger2room.di.component.DaggerRepoComponent
import com.evolve.dagger2room.di.component.RepoComponent
import com.evolve.dagger2room.di.module.ContextModule
import com.evolve.dagger2room.di.module.RepoModule
import com.evolve.dagger2room.model.Repo
import com.evolve.dagger2room.repository.impl.RepoRepositoryImpl
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    @Inject
    lateinit var repoRepo: RepoRepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repoComponent = DaggerRepoComponent.builder()
                .contextModule(ContextModule(this))
                .repoModule(RepoModule())
                .build()

        repoComponent.inject(this)
        Observable.fromIterable(getData())

                .subscribeOn(Schedulers.io())
                /*.map { it -> repoRepo.insert(it) }*/
                .doOnNext { it -> repoRepo.insert(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { repo -> Log.e(TAG, repo.toString()) },
                        { error -> Log.e(TAG, error.message) },
                        { Log.e(TAG, "Completed") }
                )


    }

    fun getData(): List<Repo> {
        return listOf(
                Repo("3", "Retrofit", "retrofit.com"),
                Repo("4", "DataBinding", "databinding.com")
        )
    }
}
