package com.mcl.eletriccarapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.mcl.eletriccarapp.R
import com.mcl.eletriccarapp.data.local.CarRepository
import com.mcl.eletriccarapp.domain.Car
import com.mcl.eletriccarapp.ui.adapter.CarAdapter

class FavoriteFragment : Fragment() {

    lateinit var listCarsFavorites: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupList()
    }

    private fun getCarsOnLocalDb(): List<Car> {
        val repository = CarRepository(requireContext())
        val carList = repository.getAll()
        return carList
    }

    fun setupView(view: View) {
        view.apply {
            listCarsFavorites = findViewById(R.id.rv_list_car_favorites)
        }
    }

    fun setupList() {
        val cars =  getCarsOnLocalDb()
        val carAdapter = CarAdapter(cars, isFavoriteScreen = true)

        listCarsFavorites.apply {
            isVisible = true
            adapter = carAdapter
        }

        carAdapter.carItemLister = { car ->
           // IMPLEMENTAR O DELETE NO BANCO DE DADOS
        }
    }

}