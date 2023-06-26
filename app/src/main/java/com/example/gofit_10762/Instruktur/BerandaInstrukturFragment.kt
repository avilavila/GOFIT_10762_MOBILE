package com.example.gofit_10762.Instruktur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_10762.Instruktur.BerandaInstrukturActivity
import com.example.gofit_10762.User.User
import com.example.gofit_10762.databinding.FragmentBerandaInstrukturBinding

class BerandaInstrukturFragment : Fragment() {
    private var _binding : FragmentBerandaInstrukturBinding? = null
    private val binding get() = _binding!!
    private val listUser = ArrayList<User>()
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
        _binding = FragmentBerandaInstrukturBinding.inflate(inflater, container, false)
        idUser = activity!!.getIdUser().toString()
        nama = activity!!.getNama()
        jabatan = activity!!.getJabatan()
        username = activity!!.getUsername()

        binding.namaInstruktur.setText(nama)

        return binding.root
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_dashboard_instruktur, container, false)
    }
}