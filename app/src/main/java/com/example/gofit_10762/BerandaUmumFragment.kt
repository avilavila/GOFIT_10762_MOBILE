package com.example.gofit_10762

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gofit_10762.Member.BerandaMemberActivity
import com.example.gofit_10762.databinding.FragmentBerandaMemberBinding
import com.example.gofit_10762.databinding.FragmentBerandaUmumBinding

class BerandaUmumFragment : Fragment() {
    private var _binding : FragmentBerandaUmumBinding? = null
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

        val activity: BerandaUmumActivity? = activity as BerandaUmumActivity?
        _binding = FragmentBerandaUmumBinding.inflate(inflater, container, false)
//        idUser = activity!!.getIdUser()
//        nama = activity!!.getNama()
//        jabatan = activity!!.getJabatan()
//        username = activity!!.getUsername()
//
//        binding.namaMember.setText(nama)

        return binding.root
    }
}