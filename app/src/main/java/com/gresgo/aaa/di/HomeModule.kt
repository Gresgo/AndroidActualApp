package com.gresgo.aaa.di

import com.gresgo.aaa.AppDatabase
import com.gresgo.feature.home.data.LocalHomeDataSource
import com.gresgo.feature.home.data.RemoteHomeDataSource
import com.gresgo.feature.home.data.mapper.GitRepoDataMapper
import com.gresgo.feature.home.data.mapper.GitRepoLocalMapper
import com.gresgo.feature.home.data.mapper.GitRepoRemoteMapper
import com.gresgo.feature.home.data.repository.HomeRepositoryImpl
import com.gresgo.feature.home.domain.HomeInteractor
import com.gresgo.feature.home.domain.HomeRepository
import com.gresgo.feature.home.presentation.TestRepo
import com.gresgo.feature.home.presentation.mapper.GitRepoDomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun provideGitRepoDataMapper(): GitRepoDataMapper = GitRepoDataMapper.Base()

    @Provides
    @Singleton
    fun provideGitRepoLocalMapper(): GitRepoLocalMapper = GitRepoLocalMapper.Base()

    @Provides
    @Singleton
    fun provideGitRepoRemoteMapper(): GitRepoRemoteMapper = GitRepoRemoteMapper.Base()

    @Provides
    @Singleton
    fun provideGitRepoDomainMapper(): GitRepoDomainMapper = GitRepoDomainMapper.Base()


    @Provides
    @Singleton
    fun provideLocalHomeDataSource(): LocalHomeDataSource = LocalHomeDataSource.Base()

    @Provides
    @Singleton
    fun provideRemoteHomeDataSource(): RemoteHomeDataSource = RemoteHomeDataSource.Base()

    @Provides
    @Singleton
    fun provideHomeRepository(
        remote: RemoteHomeDataSource,
        local: LocalHomeDataSource,
        mapper: GitRepoDataMapper
    ): HomeRepository = HomeRepositoryImpl(remote, local, mapper)

    @Provides
    @Singleton
    fun provideHomeInteractor(repository: HomeRepository): HomeInteractor =
        HomeInteractor.Base(repository)

    @Provides
    @Singleton
    fun provideTestRepo(database: AppDatabase): TestRepo = TestRepo(database.testDao())
}