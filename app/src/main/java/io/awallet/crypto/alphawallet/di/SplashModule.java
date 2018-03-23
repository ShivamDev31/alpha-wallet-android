package io.awallet.crypto.alphawallet.di;

import io.awallet.crypto.alphawallet.interact.AddTokenInteract;
import io.awallet.crypto.alphawallet.interact.FetchWalletsInteract;
import io.awallet.crypto.alphawallet.interact.ImportWalletInteract;
import io.awallet.crypto.alphawallet.repository.EthereumNetworkRepositoryType;
import io.awallet.crypto.alphawallet.repository.PasswordStore;
import io.awallet.crypto.alphawallet.repository.TokenRepositoryType;
import io.awallet.crypto.alphawallet.repository.WalletRepositoryType;
import io.awallet.crypto.alphawallet.viewmodel.SplashViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {

    @Provides
    SplashViewModelFactory provideSplashViewModelFactory(FetchWalletsInteract fetchWalletsInteract,
                                                         EthereumNetworkRepositoryType networkRepository,
                                                         ImportWalletInteract importWalletInteract,
                                                         AddTokenInteract addTokenInteract) {
        return new SplashViewModelFactory(fetchWalletsInteract, networkRepository, importWalletInteract, addTokenInteract);
    }

    @Provides
    FetchWalletsInteract provideFetchWalletInteract(WalletRepositoryType walletRepository) {
        return new FetchWalletsInteract(walletRepository);
    }

    @Provides
    ImportWalletInteract provideImportWalletInteract(
            WalletRepositoryType walletRepository, PasswordStore passwordStore) {
        return new ImportWalletInteract(walletRepository, passwordStore);
    }

    @Provides
    AddTokenInteract provideAddTokenInteract(
            TokenRepositoryType tokenRepository,
            WalletRepositoryType walletRepository) {
        return new AddTokenInteract(walletRepository, tokenRepository);
    }
}
