package com.project.segunfrancis.hellodagger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Qualifier

const val LOVE = "Love"
const val HELLO = "Hello"

class MainActivity : AppCompatActivity() {

    @Inject
    @field:Choose("Love")
    lateinit var infoLove: Info

    @Inject
    @field:Choose("Hello")
    lateinit var infoHello: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMagicBox.create().poke(this)
        text_view.text = "${infoLove.text} ${infoHello.text}"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_activity -> {
                startActivity(Intent(this@MainActivity, Main2Activity::class.java))
                return true
            }
            R.id.menu_another -> {
                startActivity(Intent(this@MainActivity, BottomNavActivity::class.java))
                return true
            }
            R.id.rx_java_activity -> {
                startActivity(Intent(this@MainActivity, RxJavaActivity::class.java))
                return true
            }
            R.id.otp_activity -> {
                startActivity(Intent(this@MainActivity, OTPVerificationActivity::class.java))
                return true
            }
            R.id.onboarding_activity -> {
                startActivity(Intent(this@MainActivity, OnboardingActivity::class.java))
                return true
            }
            R.id.country_code_picker_activity -> {
                startActivity(Intent(this@MainActivity, CountryCodePickerActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}

class Info constructor(val text: String)

@Module
class Bag {
    @Provides
    @Choose(value = LOVE)
    fun sayLoveDagger2(): Info {
        return Info("Love Dagger 2")
    }

    @Provides
    @Choose(value = HELLO)
    fun sayHelloDagger2(): Info {
        return Info("Hello Dagger 2")
    }
}

@Component(modules = [Bag::class])
interface MagicBox {
    fun poke(app: MainActivity)
}

@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class Choose(val value: String = "")