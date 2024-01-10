package com.example.mycontact

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SaveContactActivity : AppCompatActivity() {

    lateinit var firstName: EditText
    lateinit var lastName: EditText
    lateinit var phoneNumber: EditText
    lateinit var savebtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_contact)

        val actionbar = supportActionBar

        actionbar?.setDisplayHomeAsUpEnabled(true)




        firstName = findViewById(R.id.editTextPersonFirstName)
        lastName = findViewById(R.id.editTextPersonLastName)
        phoneNumber = findViewById(R.id.editTextPersonPhoneNumber)
        savebtn = findViewById(R.id.button)

        savebtn.setOnClickListener {

            if (isValidation()) {
                val intent = Intent()
                intent.putExtra("firstName", firstName.text.toString())
                intent.putExtra("lastName", lastName.text.toString())
                intent.putExtra("phoneNumber", phoneNumber.text.toString())
                setResult(Activity.RESULT_OK, intent)
                Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, "All Field are empty", Toast.LENGTH_LONG).show()
            }
        }
    }

        private fun isValidation() : Boolean {

            if (firstName.text.isEmpty() && lastName.text.isEmpty() && phoneNumber.text.isEmpty()) {
                return false
            }else{
                if (firstName.text.isEmpty()){
                    firstName.setError("First Name Can't be Empty")
                    return false
                }else if (lastName.text.isEmpty()){
                    lastName.setError("Last Name Can't be Empty")
                    return false
                }else if (phoneNumber.text.isEmpty()){
                    phoneNumber.setError("Phone Number Can't be Empty")
                    return false
                }else if (phoneNumber.text.length != 10){
                    phoneNumber.setError("Enter 10 digit Mobile Number")
                    return false
                }
                return true
            }


        }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}