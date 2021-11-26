package com.example.doctour.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.doctour.*

class Setting: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lainnya)

        val intentButton: ImageView = findViewById(R.id.alamat1)
        intentButton.setOnClickListener { viewDetail() }
        val intentButton1 : ImageView = findViewById(R.id.settingapp)
        intentButton1.setOnClickListener { viewDetail1()}
        val intentButton2: ImageView = findViewById(R.id.profileapp)
        intentButton2.setOnClickListener { viewDetail2() }

    }

    private fun viewDetail() {
        val intent = Intent(this, Alamat::class.java)
        startActivity(intent)
    }
    private fun viewDetail1() {
        val intent = Intent(this, Pengaturan::class.java)
        startActivity(intent)
    }

    private fun viewDetail2() {
        val intent = Intent(this, Profile::class.java)
        startActivity(intent)
    }


}

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class setting_fragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lainnya, container, false)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            setting_fragment().apply {
                Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}