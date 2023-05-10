package com.geminiboy.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {

    val listProduct = arrayListOf(

        ListBarang("BMW","Rp.800.000.000.000", "Majid" , R.drawable.ic_launcher_foreground),
        ListBarang("Civiv","Rp.800.000.000", "Awar" , R.drawable.ic_launcher_foreground),
        ListBarang("City","Rp.700.000.000", "Bayu" , R.drawable.ic_launcher_foreground),
        ListBarang("Ayla","Rp.500.000.000", "Sasep" , R.drawable.ic_launcher_foreground),
        ListBarang("Avanza","Rp.100.000.000", "Didi" , R.drawable.ic_launcher_foreground)

    )

    val productVm : MutableLiveData<List<ListBarang>> = MutableLiveData()

    fun getData (){
        productVm.value = listProduct
    }
}