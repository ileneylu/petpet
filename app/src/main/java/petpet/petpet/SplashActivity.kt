package petpet.petpet

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import petpet.petpet.pet.PetPreference
import petpet.petpet.utility.NotificationUtil
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //set notification channel
        NotificationUtil().createNotificationChannel(this)
    }

    override fun onStart() {
        super.onStart()
        thread(start = true) {
            Thread.sleep(1000)

            if (!PetPreference(this).hasPet()) {
                startActivity(Intent(this, CreatePetActivity::class.java))
            } else {
                startActivity(Intent(this, Home::class.java))
            }
            finish()
        }
    }
}