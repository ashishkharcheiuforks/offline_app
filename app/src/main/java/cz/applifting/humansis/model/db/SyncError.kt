package cz.applifting.humansis.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Petr Kubes <petr.kubes@applifting.cz> on 27, November, 2019
 */
@Entity(tableName = "errors")
data class SyncError(
    @PrimaryKey val id: Int,
    val location: String,
    val params: String,
    val errorMessage: String
)