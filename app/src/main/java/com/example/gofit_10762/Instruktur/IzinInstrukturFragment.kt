package com.example.gofit_10762.Instruktur

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_10762.R
import com.example.gofit_10762.databinding.FragmentIzinInstrukturBinding

class IzinInstrukturFragment : Fragment() {
    private var _binding : FragmentIzinInstrukturBinding? = null
    private val binding get() = _binding!!
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val ft = parentFragmentManager.beginTransaction()
        ft.detach(this).attach(this).commit()

        val activity: BerandaInstrukturActivity? = activity as BerandaInstrukturActivity?
        _binding = FragmentIzinInstrukturBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser().toString()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()
        binding.btnUpload.setOnClickListener {
            val intent = Intent(requireActivity(), IzinInstrukturActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }
        binding.btnLihat.setOnClickListener{
            val intent = Intent(requireActivity(), DataIzinInstrukturActivity::class.java)
            intent.putExtra("idUser", idUser)
            intent.putExtra("nama", nama)
            intent.putExtra("jabatan", jabatan)
            intent.putExtra("username", username)
            startActivity(intent)
        }
        return binding.root
    }
}