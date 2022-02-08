package com.example.signinupfirst

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.signinupfirst.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var launcher: ActivityResultLauncher<Intent>? = null
    private var launcher2: ActivityResultLauncher<Intent>? = null
    private lateinit var bindingclass: ActivityMainBinding
    private  var login = Constance.EMPTY
    private  var password = Constance.EMPTY
    private  var name = Constance.EMPTY
    private  var surname = Constance.EMPTY
    private  var surname2 = Constance.EMPTY
    private  var avatars = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingclass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingclass.root)
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
  result : ActivityResult ->
           if (result.resultCode == RESULT_OK) {
               login = result.data?.getStringExtra(Constance.LOGIN)!!
               password = result.data?.getStringExtra(Constance.PASSWORD)!!
               name = result.data?.getStringExtra(Constance.NAME)!!
               surname = result.data?.getStringExtra(Constance.SURNAME)!!
               surname2 = result.data?.getStringExtra(Constance.SURNAME2)!!
               bindingclass.textView.text = ""
               avatars = result.data?.getIntExtra(Constance.AVATAR_ID,0)!!}


           }
            launcher2 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                    result : ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    if (login == result.data?.getStringExtra(Constance.LOGIN)
                        && (password == result.data?.getStringExtra(Constance.PASSWORD))
                    ) {
                        bindingclass.textView.text = "$name $surname $surname2"
                        bindingclass.imageView.visibility = View.VISIBLE
                        bindingclass.imageView.setImageResource(avatars)
                        bindingclass.btSignIn.visibility =View.GONE
                        bindingclass.btSignUp.text = Constance.EXIT
                    }

                     else {
                        bindingclass.imageView.visibility = View.INVISIBLE
                        bindingclass.textView.text ="пользователь не найден"
                }
        }
    }}

  fun  onClickSignUp(@Suppress("UNUSED_PARAMETER")view: View){
if (bindingclass.btSignUp.text == Constance.EXIT) {
    bindingclass.imageView.visibility = View.INVISIBLE
    bindingclass.btSignIn.visibility = View.VISIBLE
    bindingclass.btSignUp.text = Constance.StateUp
    bindingclass.textView.text = ""
}else {
    launcher?.launch(
        Intent(this, SignInUpAct::class.java).putExtra(
            Constance.Statemy,
            Constance.StateUp
        )
    )
}
  }
    fun  onClickSignIn(@Suppress("UNUSED_PARAMETER")view: View){


            launcher2?.launch(
                Intent(this, SignInUpAct::class.java).putExtra(
                    Constance.Statemy,
                    Constance.StateIn
                )
            )

    }
}

