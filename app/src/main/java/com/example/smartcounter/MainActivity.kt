package com.example.smartcounter

import android.os.Bundle
import android.view.View
import android.window.OnBackInvokedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.smartcounter.databinding.ActivityMainBinding
import com.example.smartcounter.entities.TableData
import com.example.smartcounter.entities.UserData
import com.example.smartcounter.fragments.analyse.AnalyseFragment
import com.example.smartcounter.fragments.archive.ArchiveFragment
import com.example.smartcounter.fragments.archive.fragments.table.TableFragment
import com.example.smartcounter.fragments.feedback.FeedbackFragment
import com.example.smartcounter.fragments.forgetpass.ForgetPassFragment
import com.example.smartcounter.fragments.forgetpass.fragments.recovery.RecoveryFragment
import com.example.smartcounter.fragments.instructions.InstructionsFragment
import com.example.smartcounter.fragments.login.LoginFragment
import com.example.smartcounter.fragments.main.MainFragment
import com.example.smartcounter.fragments.notification.NotificationFragment
import com.example.smartcounter.fragments.prediction.PredictionFragment
import com.example.smartcounter.fragments.register.RegisterFragment
import com.example.smartcounter.fragments.settings.SettingsFragment
import com.example.smartcounter.fragments.settings.fragments.logindata.SLoginDataFragment
import com.example.smartcounter.fragments.settings.fragments.payercode.SPayerFragment
import com.example.smartcounter.fragments.settings.fragments.payercode.fragments.addcode.AddCodeFragment
import com.example.smartcounter.fragments.settings.fragments.records.SRecordsFragment
import com.example.smartcounter.fragments.settings.fragments.records.fragments.showdata.ShowDataFragment
import com.example.smartcounter.fragments.sumcount.CountSumFragment
import com.example.smartcounter.fragments.welcome.WelcomeFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), Communicator{

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var navigationView : NavigationView
    private var userData = UserData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)



        setContentView(binding.root)
        setWelcomeFragment()

        drawerLayout = binding.drawerLayout
        navigationView = binding.navView

        binding.navView.setNavigationItemSelectedListener {
            onNavigationItemSelected(it.itemId)
        }

        binding.instructionBtn.setOnClickListener {
            setInstructionsFragment()
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }


    private fun setFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }

    private fun onNavigationItemSelected(itemId: Int): Boolean {
        when(itemId){
            R.id.nav_main -> setMainFragment(userData)
            R.id.nav_analyse -> setAnalyseFragment()
            R.id.nav_records -> setCountSumFragment()
            R.id.nav_prediction -> setPredictionFragment()
            R.id.nav_exit -> setWelcomeFragment()
            R.id.nav_settings -> setSettingsFragment()
            R.id.nav_archive -> setArchiveFragment()
            R.id.nav_notification -> setNotificationFragment()
            R.id.nav_feedback -> setFeedbackFragment()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun setCountSumFragment() {
        setFragment(CountSumFragment())
        binding.headerText.text = resources.getString(R.string.records_header_text)
        binding.headerApp.visibility = View.VISIBLE
    }

    override fun setMainFragment(userData: UserData) {
        this.userData = userData
        setFragment(MainFragment(userData))
        binding.headerText.text = resources.getString(R.string.main_header_text)
        binding.headerApp.visibility = View.VISIBLE
    }

    override fun setRegisterFragment() {
        setFragment(RegisterFragment())
        binding.headerApp.visibility = View.INVISIBLE
    }

    override fun setWelcomeFragment() {
        setFragment(WelcomeFragment())
        binding.headerApp.visibility = View.INVISIBLE
    }

    override fun setLoginFragment() {
        setFragment(LoginFragment())
        binding.headerApp.visibility = View.INVISIBLE
    }

    override fun setAnalyseFragment() {
        setFragment(AnalyseFragment())
        binding.headerText.text = resources.getString(R.string.analyse_header_text)
        binding.headerApp.visibility = View.VISIBLE
    }

    override fun setPredictionFragment() {
        setFragment(PredictionFragment())
        binding.headerText.text = resources.getString(R.string.prediction_header_text)
        binding.headerApp.visibility = View.VISIBLE
    }

    override fun setSettingsFragment() {
        setFragment(SettingsFragment())
        binding.headerText.text = resources.getString(R.string.nav_settings_text)
        binding.headerApp.visibility = View.VISIBLE
    }

    override fun setArchiveFragment() {
        setFragment(ArchiveFragment())
        binding.headerText.text = resources.getString(R.string.nav_archive_text)
        binding.headerApp.visibility = View.VISIBLE
    }

    override fun setTableFragment(tableData: TableData) {
        setFragment(TableFragment(tableData))
    }

    override fun setSLoginDataFragment() {
        setFragment(SLoginDataFragment())
    }

    override fun setSPayerFragment() {
        setFragment(SPayerFragment())
    }

    override fun setAddCodeFragment() {
        setFragment(AddCodeFragment())
    }

    override fun setSRecordsFragment() {
        setFragment(SRecordsFragment())
    }

    override fun setShowDataFragment() {
        setFragment(ShowDataFragment())
    }

    override fun setForgetPassFragment() {
        setFragment(ForgetPassFragment())
    }

    override fun setRecoveryFragment() {
        setFragment(RecoveryFragment())
    }

    override fun setNotificationFragment() {
        setFragment(NotificationFragment())
        binding.headerText.text = resources.getString(R.string.nav_notifications_text)
        binding.headerApp.visibility = View.VISIBLE
    }

    override fun setFeedbackFragment() {
        setFragment(FeedbackFragment())
        binding.headerText.text = resources.getString(R.string.nav_feedback_text)
        binding.headerApp.visibility = View.VISIBLE
    }

    override fun setInstructionsFragment() {
        setFragment(InstructionsFragment())
        binding.headerText.text = "Инструкция"
        binding.headerApp.visibility = View.VISIBLE
    }

}