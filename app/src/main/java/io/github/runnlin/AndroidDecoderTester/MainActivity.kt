package io.github.runnlin.AndroidDecoderTester

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import io.github.runnlin.AndroidDecoderTester.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    var customAIDL: CustomAIDL? = null
    var isServiceStarted = false

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            customAIDL = CustomAIDL.Stub.asInterface(service)
            Log.e("service:", "onServiceConnected")
            isServiceStarted = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            customAIDL = null
            Log.e("service:", "onServiceConnected")
            isServiceStarted = false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        binding.btnBindService.setOnClickListener { view ->

            Snackbar.make(view, "Trying Bind Service...", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            bindService(
                Intent(this, AIDLRemoteService::class.java),
                serviceConnection,
                BIND_AUTO_CREATE
            )
        }

        binding.btnTestMethod.setOnClickListener { view ->

            if (!isServiceStarted) {
                Snackbar.make(view, "Please Bind First", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                return@setOnClickListener
            }
            try {
                val str = customAIDL?.str
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
            } catch (e: RemoteException) {
                e.printStackTrace()
            }

        }

//        test()
    }

    fun test() {
//        val xiaoMing = XiaoMing()
//        val mm = MM("小倩")
//
//        val proxyXiaoMing = ProxyXiaoMing(xiaoMing, mm)
//        proxyXiaoMing.giveFlower()
//        proxyXiaoMing.writeLoveLetters()
//        proxyXiaoMing.buyClothes()
//        proxyXiaoMing.doSomething()

//        val zhuimmWay = ZhuimmFactory.getInstance("小倩")
//        zhuimmWay.giveFlower()
//        zhuimmWay.writeLoveLetters()
//        zhuimmWay.buyClothes()
//        zhuimmWay.doSomething()

//        val liuErMiHou:IToWest = LiuErMiHou()
//        liuErMiHou.baohuTangSeng()
//        liuErMiHou.xiangyaoChuMo()
//        liuErMiHou.shangTianRuDi()

//        val sunWuKong = SunWuKong()
//        val proxy = ToWestProxy().getProxy(sunWuKong) as IToWest
//
//        proxy.baohuTangSeng()
//        proxy.xiangyaoChuMo()
//        proxy.shangTianRuDi()

//        val user = User()
//        user.uname = "Runnnlin"
//        user.address = "CN"
//        user.sex = "男"
//        user.idNum = "2312312131"
//        user.pay = "88888"
//
//        val iSellTicket = XiaoZhangSeller(user)
//
//        val dyAutoSellerProxy = DyAutoSellerProxy(iSellTicket)
//
//        val iSellTicket1 = Proxy.newProxyInstance(iSellTicket.javaClass.classLoader,
//            iSellTicket.javaClass.interfaces,
//            dyAutoSellerProxy) as ISellTicket
//
//        iSellTicket1.sellTicket()

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