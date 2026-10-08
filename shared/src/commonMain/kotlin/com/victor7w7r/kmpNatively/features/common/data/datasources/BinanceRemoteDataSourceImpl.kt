package com.victor7w7r.kmpNatively.features.common.data.datasources

import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.core.annotation.Single

@Single
class BinanceRemoteDataSourceImpl(
  ktorfit: Ktorfit,
) : BinanceRemoteDataSource by ktorfit.create<BinanceRemoteDataSource>()
