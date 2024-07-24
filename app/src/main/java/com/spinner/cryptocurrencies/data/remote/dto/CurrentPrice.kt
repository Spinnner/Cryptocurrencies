package com.spinner.cryptocurrencies.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CurrentPrice(
    val aed: Int,
    val ars: Int,
    val aud: Int,
    val bch: Double,
    val bdt: Int,
    val bhd: Int,
    val bmd: Int,
    val bnb: Double,
    val brl: Int,
    val btc: Int,
    val cad: Int,
    val chf: Int,
    val clp: Int,
    val cny: Int,
    val czk: Int,
    val dkk: Int,
    val dot: Int,
    val eos: Int,
    val eth: Double,
    val eur: Int,
    val gbp: Int,
    val gel: Int,
    val hkd: Int,
    val huf: Int,
    val idr: Int,
    val ils: Int,
    val inr: Int,
    val jpy: Int,
    val krw: Int,
    val kwd: Int,
    val lkr: Int,
    val ltc: Double,
    val mmk: Int,
    val mxn: Int,
    val myr: Int,
    val ngn: Int,
    val nok: Int,
    val nzd: Int,
    val php: Int,
    val pkr: Int,
    val pln: Int,
    val rub: Int,
    val sar: Int,
    val sek: Int,
    val sgd: Int,
    val thb: Int,
    @SerializedName("try")
    val tryX: Int,
    val twd: Int,
    val uah: Int,
    val usd: Int,
    val vef: Double,
    val vnd: Int,
    val xag: Double,
    val xau: Double,
    val xdr: Int,
    val xlm: Int,
    val xrp: Int,
    val yfi: Double,
    val zar: Int,
    val bits: Int,
    val link: Int,
    val sats: Int
)