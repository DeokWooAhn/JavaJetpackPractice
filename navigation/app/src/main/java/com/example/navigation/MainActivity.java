package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;

import com.example.navigation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 액션바를 만들어준 툴바로 설정 해주고 기본 타이틀을 false로 지정
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        setupJetpackNavigation();
    }

    private void setupJetpackNavigation() {
        NavHostFragment host = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        navController = host.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);

        //최상위 수준으로 지정해 놓으면 툴바에 백버튼 안생김
        appBarConfiguration = new AppBarConfiguration
                .Builder(R.id.home, R.id.search, R.id.like, R.id.user).build();

        // nav_graph에서 지정해 놓은 홈 프래그먼 제외 하고 백버튼 생김
//        appBarConfiguration =
//                new AppBarConfiguration.Builder(navController.getGraph()).build();

        // setupWith로 하면 기본 툴바 타이틀이라 왼쪽으로 붙어 있음
//        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        navController.addOnDestinationChangedListener(
                new NavController.OnDestinationChangedListener() {
                    @Override
                    public void onDestinationChanged(@NonNull NavController navController,
                                                     @NonNull NavDestination navDestination,
                                                     @Nullable Bundle bundle) {
//                        if (navDestination.getId() != R.id.home) {
//                            binding.toolbar.setVisibility(View.GONE);
//                        }
//                        else binding.toolbar.setVisibility(View.VISIBLE);

                        binding.toolbarTitle.setText(
                                navController.getCurrentDestination().getLabel().toString());
                    }
                }
        );

    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

}