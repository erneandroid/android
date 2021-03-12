package org.monora.uprotocol.client.android.data

import androidx.lifecycle.LiveData
import org.monora.uprotocol.client.android.database.ClientAddressDao
import org.monora.uprotocol.client.android.database.ClientDao
import org.monora.uprotocol.client.android.database.model.UClient
import org.monora.uprotocol.client.android.database.model.UClientAddress
import org.monora.uprotocol.client.android.util.NsdDaemon
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClientRepository @Inject constructor(
    private val clientDao: ClientDao,
    private val clientAddressDao: ClientAddressDao,
) {
    fun delete(client: UClient) = clientDao.delete(client)

    fun get(uid: String): UClient? = clientDao.get(uid)

    fun getAll(): LiveData<List<UClient>> = clientDao.getAll()

    suspend fun getAddresses(clientUid: String): List<UClientAddress> = clientAddressDao.getAll(clientUid)

    fun insert(client: UClient) = clientDao.insert(client)

    fun insert(address: UClientAddress) = clientAddressDao.insert(address)

    fun update(client: UClient) = clientDao.update(client)
}