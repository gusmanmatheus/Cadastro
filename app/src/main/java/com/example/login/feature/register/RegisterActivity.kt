package com.example.login.feature.register

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.login.R
import com.example.login.data.model.User
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RegisterActivity : AppCompatActivity(),RegisterContract.View {

    override val presenter by inject<RegisterPresenter> { parametersOf(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        buttonSave.setOnClickListener {
            presenter.request(User(
                email_Ed.text.toString(),
                password_Ed.text.toString(),
                0))
        }

        email_Ed.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!allVoid()){ buttonSave.visibility = View.VISIBLE }else{ buttonSave.visibility = View.INVISIBLE }
            }
        })
        password_Ed.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!allVoid()){ buttonSave.visibility = View.VISIBLE }else{ buttonSave.visibility = View.INVISIBLE }

            }
        })
        cpf_Ed.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!allVoid()){ buttonSave.visibility = View.VISIBLE }else{ buttonSave.visibility = View.INVISIBLE }
            }
        })
            rg_Ed.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!allVoid()){ buttonSave.visibility = View.VISIBLE }else{ buttonSave.visibility = View.INVISIBLE }

            }
        })
    }

    fun allVoid(): Boolean {
        return (email_Ed.text!!.isEmpty() || password_Ed.text!!.isEmpty() ||
            cpf_Ed.text!!.isEmpty() || rg_Ed.text!!.isEmpty())}


    override fun viewLoadingOn() {
        fragmentLoading_Id.visibility = View.VISIBLE
    }

    override fun viewLoadingOff() {
        fragmentLoading_Id.visibility = View.GONE
  }

    override fun dialogResponse(resp: RegisterPresenter.Response) {
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Cadastro")
        alertDialog.setMessage(resp.value)
        alertDialog.setNegativeButton("OK", { _, _ ->
        })
        alertDialog.show()
    }

}
