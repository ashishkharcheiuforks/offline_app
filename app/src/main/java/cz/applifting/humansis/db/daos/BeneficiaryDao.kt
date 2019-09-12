package cz.applifting.humansis.db.daos

import androidx.room.*
import cz.applifting.humansis.model.db.BeneficiaryLocal

@Dao
interface BeneficiaryDao {
    @Query("SELECT * FROM beneficiaries where distributionId = :distributionId")
    suspend fun getByDistribution(distributionId: Int): List<BeneficiaryLocal>?

    @Query("SELECT * FROM beneficiaries where id = :beneficiaryId")
    suspend fun findById(beneficiaryId:Int): BeneficiaryLocal

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(beneficiariesLocal: List<BeneficiaryLocal>)

    @Update
    suspend fun update(beneficiaryLocal: BeneficiaryLocal)

    @Query("DELETE FROM beneficiaries WHERE distributionId = :distributionId")
    suspend fun deleteByDistribution(distributionId: Int)

    @Query("DELETE FROM beneficiaries")
    suspend fun deleteAll()
}