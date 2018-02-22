package com.evolve.dagger2room.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by sujin on 2/20/18.
 */
@Entity
data class Repo(@PrimaryKey val id: String, val name: String, val url: String) {
}