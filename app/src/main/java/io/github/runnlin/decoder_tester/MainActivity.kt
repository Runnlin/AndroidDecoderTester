package io.github.runnlin.decoder_tester

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import io.github.runnlin.decoder_tester.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    var customAIDL: CustomAIDL? = null
    var isServiceStarted = false

    // 定义一个 ServiceConnection 对象，用于监听服务回调
    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            // 初始化 AIDL ，获取到自定义的可调用的方法接口
            customAIDL = CustomAIDL.Stub.asInterface(service)
            Log.e("service:", "onServiceConnected")
            isServiceStarted = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            customAIDL = null
            Log.e("service:", "onServiceDisconnected")
            isServiceStarted = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        initService()
        initClick()
    }

    private fun initClick() {
        val snakeListener = View.OnClickListener {
            //TODO: start test decoders
        }
        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Checking all decoder now", Snackbar.LENGTH_LONG)
                .setAction("Action", snakeListener).show()
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), binding.drawerLayout
        )
        setupActionBarWithNavController(
            findNavController(R.id.nav_host_fragment_content_main),
            appBarConfiguration
        )
        binding.navView
            .setupWithNavController(
                findNavController(R.id.nav_host_fragment_content_main)
            )
    }

    private fun initService() {
        bindService(
            Intent(this, AIDLRemoteService::class.java),
            serviceConnection,
            BIND_AUTO_CREATE
        )
    }

    override fun onDestroy() {
        unbindService(serviceConnection)
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}