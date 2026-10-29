package com.example.moneyking

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

private var coins = 0
private lateinit var coinText: TextView

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val root = LinearLayout(this)
    root.orientation = LinearLayout.VERTICAL
    root.gravity = Gravity.CENTER_HORIZONTAL
    root.setPadding(24, 35, 24, 24)
    root.setBackgroundColor(Color.rgb(18, 18, 28))

    val title = TextView(this)
    title.text = "👑 MONEY KING"
    title.textSize = 30f
    title.setTextColor(Color.rgb(255, 193, 7))
    title.gravity = Gravity.CENTER
    root.addView(title, matchWidth())

    val subtitle = TextView(this)
    subtitle.text = "Your Rewards Dashboard"
    subtitle.textSize = 16f
    subtitle.setTextColor(Color.WHITE)
    subtitle.gravity = Gravity.CENTER
    root.addView(subtitle, matchWidth())

    coinText = TextView(this)
    coinText.text = "🪙 Your Coins: $coins"
    coinText.textSize = 25f
    coinText.setTextColor(Color.WHITE)
    coinText.gravity = Gravity.CENTER
    coinText.setPadding(0, 40, 0, 30)
    root.addView(coinText, matchWidth())

    addButton(root, "🎁 Daily Bonus") {
        coins += 10
        updateCoins()
        Toast.makeText(this, "Demo bonus: 10 coins added", Toast.LENGTH_SHORT).show()
    }

    addButton(root, "💰 My Wallet") {
        Toast.makeText(this, "Demo wallet: $coins coins", Toast.LENGTH_LONG).show()
    }

    addButton(root, "🏦 Withdraw Request") {
        Toast.makeText(this, "Demo only: real UPI withdrawal is not connected", Toast.LENGTH_LONG).show()
    }

    addButton(root, "👤 Profile") {
        Toast.makeText(this, "Money King Profile", Toast.LENGTH_SHORT).show()
    }

    val note = TextView(this)
    note.text = "Demo coins only — no real money is paid."
    note.textSize = 12f
    note.setTextColor(Color.LTGRAY)
    note.gravity = Gravity.CENTER
    note.setPadding(0, 25, 0, 0)
    root.addView(note, matchWidth())

    setContentView(root)
}

private fun matchWidth(): LinearLayout.LayoutParams {
    return LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
}

private fun addButton(root: LinearLayout, label: String, action: () -> Unit) {
    val button = Button(this)
    button.text = label
    button.textSize = 16f
    button.setOnClickListener { action() }

    val params = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    params.setMargins(0, 8, 0, 8)
    root.addView(button, params)
}

private fun updateCoins() {
    coinText.text = "🪙 Your Coins: $coins"
}

}
