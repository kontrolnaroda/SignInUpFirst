package com.example.signinupfirst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.signinupfirst.databinding.ActivitySignInUpBinding

class SignInUpAct : AppCompatActivity() {
    lateinit var bindingclass : ActivitySignInUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingclass = ActivitySignInUpBinding.inflate(layoutInflater)
        setContentView(bindingclass.root)

       val  state = intent.getStringExtra(Constance.Statemy)
        if (state == Constance.StateIn){ 
            bindingclass.editName.visibility = View.GONE
            bindingclass.editSurname.visibility = View.GONE
            bindingclass.editSurname2.visibility = View.GONE
            bindingclass.bLoadAvatar.visibility = View.INVISIBLE
            bindingclass.btDoneSignUp.text = Constance.StateIn
    }

    }
    fun onClick2(view: View){
        bindingclass.avatar.setImageResource(R.drawable.avatar)
        bindingclass.avatar.visibility = View.VISIBLE
    }
fun onClick1(view: View){
        val i = Intent()
         i.putExtra(Constance.LOGIN, bindingclass.editLogin.text.toString())
        i.putExtra(Constance.PASSWORD, bindingclass.editPassword.text.toString())
        i.putExtra(Constance.NAME, bindingclass.editName.text.toString())
        i.putExtra(Constance.SURNAME, bindingclass.editSurname.text.toString())
         i.putExtra(Constance.SURNAME2, bindingclass.editSurname2.text.toString())

   if (bindingclass.avatar.isVisible) i.putExtra(Constance.AVATAR_ID,R.drawable.avatar)
        setResult(RESULT_OK, i)
        finish()

    }

}