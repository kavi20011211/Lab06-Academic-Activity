package com.example.scorekeeper

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    // Member variables for holding the score.
    private var mScore1 = 0
    private var mScore2 = 0

    // Member variables for holding the score.
    private lateinit var mScoreText1:TextView
    private lateinit var mScoreText2:TextView

    val STATE_SCORE1="Team Score1"
    val STATE_SCORE2="Team Score2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the TextViews by ID.
        mScoreText1 = findViewById(R.id.score_1)
        mScoreText2 = findViewById(R.id.score_2)

        fun decreaseScore(view: View) {
            // Get the ID of the button that was clicked.
            val viewId = view.id

            if (viewId == R.id.decreaseTeam1){
                mScore1--
                mScoreText1.setText(mScore1.toString())
            }else if (viewId == R.id.decreaseTeam2){
                mScore2--
                mScoreText2.setText(mScore2.toString())
            }
        }

        fun increaseScore(view: View) {
            // Get the ID of the button that was clicked.
            val viewId = view.id

            if (viewId == R.id.increaseTeam1){
                mScore1++
                mScoreText1.setText(mScore1.toString())
            }else if (viewId == R.id.increaseTeam2){
                mScore2++
                mScoreText2.setText(mScore2.toString())
            }
        }

        fun onSaveInstanceState(outState:Bundle) {
            // Save the scores.
            outState.putInt(STATE_SCORE1, mScore1);
            outState.putInt(STATE_SCORE2, mScore2);
            super.onSaveInstanceState(outState);
        }

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE2);

            // Set the score text views.
            mScoreText1.setText(mScore1.toString());
            mScoreText2.setText(mScore2.toString());
        }

    }
}