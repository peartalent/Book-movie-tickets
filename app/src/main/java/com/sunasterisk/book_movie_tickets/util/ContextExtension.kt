package com.sunasterisk.book_movie_tickets.util

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

inline fun FragmentManager.inTransaction(function: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().function().commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction {
        add(frameId, fragment)
    }
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, addToStack: Boolean) {
    supportFragmentManager.inTransaction {
        if (addToStack) {
            add(frameId, fragment, fragment.javaClass.simpleName)
                .addToBackStack(fragment.javaClass.simpleName)
        } else {
            add(frameId, fragment, fragment.javaClass.simpleName)
        }
    }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction {
        replace(frameId, fragment)
    }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, addToStack: Boolean) =
    supportFragmentManager.inTransaction {
        if (addToStack) {
            replace(frameId, fragment, fragment.javaClass.simpleName)
                .addToBackStack(fragment.javaClass.simpleName)
        } else {
            replace(frameId, fragment, fragment.javaClass.simpleName)
        }
    }

fun AppCompatActivity.getCurrentFragment(): Fragment? = with(supportFragmentManager) {
    return if (backStackEntryCount > 0) {
        findFragmentByTag(getBackStackEntryAt(backStackEntryCount.minus(1)).name)
    } else {
        null
    }
}
