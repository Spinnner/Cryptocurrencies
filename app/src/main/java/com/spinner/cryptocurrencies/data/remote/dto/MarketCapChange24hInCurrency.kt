package com.spinner.cryptocurrencies.data.remote.dto


import com.google.gson.annotations.SerializedName

data class MarketCapChange24hInCurrency(
    val aed: Long,
    val ars: Long,
    val aud: Long,
    val bch: Int,
    val bdt: Long,
    val bhd: Long,
    val bmd: Long,
    val bnb: Int,
    val brl: Long,
    val btc: Int,
    val cad: Long,
    val chf: Long,
    val clp: Long,
    val cny: Long,
    val czk: Long,
    val dkk: Long,
    val dot: Double,
    val eos: Double,
    val eth: Int,
    val eur: Long,
    val gbp: Long,
    val gel: Long,
    val hkd: Long,
    val huf: Long,
    val idr: Long,
    val ils: Long,
    val inr: Long,
    val jpy: Long,
    val krw: Long,
    val kwd: Long,
    val lkr: Long,
    val ltc: Int,
    val mmk: Long,
    val mxn: Long,
    val myr: Long,
    val ngn: Long,
    val nok: Long,
    val nzd: Long,
    val php: Long,
    val pkr: Long,
    val pln: Long,
    val rub: Long,
    val sar: Long,
    val sek: Long,
    val sgd: Long,
    val thb: Long,
    @SerializedName("try")
    val tryX: Long,
    val twd: Long,
    val uah: Long,
    val usd: Long,
    val vef: Long,
    val vnd: Long,
    val xag: Int,
    val xau: Int,
    val xdr: Long,
    val xlm: Long,
    val xrp: Long,
    val yfi: Int,
    val zar: Long,
    val bits: Double,
    val link: Int,
    val sats: Double
)