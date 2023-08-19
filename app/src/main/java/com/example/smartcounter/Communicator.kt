package com.example.smartcounter

import androidx.fragment.app.Fragment
import com.example.smartcounter.entities.TableData
import com.example.smartcounter.entities.UserData

fun Fragment.communicator() : Communicator {
    return requireActivity() as Communicator
}

interface Communicator {
    fun setCountSumFragment()
    fun setMainFragment(userData: UserData)
    fun setRegisterFragment()
    fun setWelcomeFragment()
    fun setLoginFragment()
    fun setAnalyseFragment()
    fun setPredictionFragment()
    fun setSettingsFragment()
    fun setArchiveFragment()
    fun setTableFragment(tableData: TableData)
    fun setSLoginDataFragment()
    fun setSPayerFragment()
    fun setAddCodeFragment()
    fun setSRecordsFragment()
    fun setShowDataFragment()
    fun setForgetPassFragment()
    fun setRecoveryFragment()
    fun setNotificationFragment()
    fun setFeedbackFragment()
    fun setInstructionsFragment()
}