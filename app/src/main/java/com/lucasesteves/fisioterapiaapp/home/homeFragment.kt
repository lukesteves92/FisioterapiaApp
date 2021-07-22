package com.lucasesteves.fisioterapiaapp.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lucasesteves.fisioterapiaapp.R
import com.lucasesteves.fisioterapiaapp.adapter.ServicoAdapter
import com.lucasesteves.fisioterapiaapp.databinding.FragmentHomeBinding
import com.lucasesteves.fisioterapiaapp.login.MainActivity
import com.lucasesteves.fisioterapiaapp.model.servicos


class homeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        var username = arguments?.getString(KEY_USER)

        binding?.textHello?.text = "Olá, $username"

        binding?.textHello?.isVisible = true

        binding?.deslogar?.setOnClickListener{
            signOut()
            startActivity(Intent(activity, MainActivity::class.java))
        }

        //Recycle View

        val servico1 = servicos(
            name = "Reabilitação Funcional",
            disponibilidade = "Disponibilidade Imediata",
            R.drawable.reab

        )

        val servico2 = servicos(
            name = "Drenagem Linfática",
            disponibilidade = "Disponibilidade Imediata",
            R.drawable.dren
        )

        val servicosList = listOf(servico1, servico2)

        val servicoAdapter = ServicoAdapter(servicosList){
            Toast.makeText(context, "${it.name} - ${it.disponibilidade}", Toast.LENGTH_SHORT).show()
        }

        binding?.let {
            with(it) {

                servicosRecyclerView.layoutManager = LinearLayoutManager(context)
                servicosRecyclerView.adapter = servicoAdapter

            }
        }

       val bundle = Bundle()

        with(bundle){
           putString(KEY_SERVICO1, servico1.name)
            putString(KEY_SERVICO2, servico2.name)
        }

        binding?.extendedFab?.setOnClickListener{
            findNavController().navigate(
                R.id.action_homeFragment_to_agendamentoFragment, bundle
            )
        }


    }

    private fun signOut() {
        Firebase.auth.signOut()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val KEY_USER = "user"
        const val KEY_PASSWORD = "password"
        const val KEY_SERVICO1 = "01"
        const val KEY_SERVICO2 = "02"
    }

}