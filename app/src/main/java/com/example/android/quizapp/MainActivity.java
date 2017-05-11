package com.example.android.quizapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Class instance variables for storing and grading the answers to the quiz questions
     */
    private int head = 0;
    private int numberOfCorrectAnswers = 0;
    private String[] answerKey = {"Little Whinging", "150", "Michael Corner", "Fountain of Magical Brethren",
            "Makes him wear the sorting hat and sets it on fire", "The Grey Lady", "Nymphadora Tonks",
            "Gellert Grindelwald", "Accio"};
    private String trackAnswers = "";


    /**
     * Parses resources and inflates default layout
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the start quiz button is clicked by an user
     */
    public void startQuiz(View v) {

        // Remove banner image
        View bannerImageView = findViewById(R.id.banner_image);
        bannerImageView.setVisibility(View.GONE);

        // Remove banner text
        View bannerTextView = findViewById(R.id.banner_text);
        bannerTextView.setVisibility(View.GONE);

        // Remove button
        View startQuizButton = findViewById(R.id.start_button);
        startQuizButton.setVisibility(View.GONE);

        // Set scroll view
        View scrollView = findViewById(R.id.scroll_view);
        scrollView.setVisibility(View.VISIBLE);

        // Set first question hint image
        ImageView questionOneImage = (ImageView) findViewById(R.id.hint_image_view);
        questionOneImage.setImageResource(R.drawable.question_one_hint_image);
        questionOneImage.setVisibility(View.VISIBLE);

        // Make question TextView visible and Set first question
        TextView questionView = (TextView) findViewById(R.id.question_text_view);
        questionView.setText(R.string.question_1);
        questionView.setGravity(Gravity.NO_GRAVITY);
        questionView.setVisibility(View.VISIBLE);

        // Set multiple choices
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        Resources res = getResources();
        String[] getChoices = res.getStringArray(R.array.ChoicesQuestionOne);
        setRadioButtonText(getChoices);
        radioGroup.setVisibility(View.VISIBLE);

        // Set submit button
        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setText(R.string.submit);
        submitButton.setVisibility(View.VISIBLE);

    }

    /**
     * This method is called when an user clicks the next button
     * The button itself shows up only after the submit button is clicked
     */
    public void nextButton(View v) {
        // Get necessary views
        ImageView nextQuestionImage = (ImageView) findViewById(R.id.hint_image_view);
        TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
        Button getSubmitButton = (Button) findViewById(R.id.submit_button);
        head++;

        if (head < answerKey.length) {
            // Increment head by 1 for next question
            // Set the screen for the next question
            // Get resources to set multiple choice string-array
            Resources res = getResources();

            // Set screen corresponding to the next question
            switch (head) {
                // Set the hint image
                // Set the text view for question
                // Set radio group appropriate choices
                // Make submit button visible
                case 1:
                    nextQuestionImage.setImageResource(R.drawable.question_two_hint_image);
                    questionTextView.setText(R.string.question_2);
                    String[] getChoicesQuestionTwo = res.getStringArray(R.array.ChoicesQuestionTwo);
                    setRadioButtonText(getChoicesQuestionTwo);
                    break;
                case 2:
                    nextQuestionImage.setImageResource(R.drawable.question_three_hint_image);
                    questionTextView.setText(R.string.question_3);
                    String[] getChoicesQuestionThree = res.getStringArray(R.array.ChoicesQuestionThree);
                    setRadioButtonText(getChoicesQuestionThree);
                    break;
                case 3:
                    nextQuestionImage.setImageResource(R.drawable.question_four_hint_image);
                    questionTextView.setText(R.string.question_4);
                    String[] getChoicesQuestionFour = res.getStringArray(R.array.ChoicesQuestionFour);
                    setRadioButtonText(getChoicesQuestionFour);
                    break;
                case 4:
                    nextQuestionImage.setImageResource(R.drawable.question_five_hint_image);
                    questionTextView.setText(R.string.question_5);
                    String[] getChoicesQuestionFive = res.getStringArray(R.array.ChoicesQuestionFive);
                    setRadioButtonText(getChoicesQuestionFive);
                    break;
                case 5:
                    nextQuestionImage.setImageResource(R.drawable.question_six_hint_image);
                    questionTextView.setText(R.string.question_6);
                    String[] getChoicesQuestionSix = res.getStringArray(R.array.ChoicesQuestionSix);
                    setRadioButtonText(getChoicesQuestionSix);
                    break;
                case 6:
                    nextQuestionImage.setImageResource(R.drawable.question_seven_hint_image);
                    questionTextView.setText(R.string.question_7);
                    String[] getChoicesQuestionSeven = res.getStringArray(R.array.ChoicesQuestionSeven);
                    setRadioButtonText(getChoicesQuestionSeven);
                    break;
                case 7:
                    nextQuestionImage.setImageResource(R.drawable.question_eight_hint_image);
                    questionTextView.setText(R.string.question_8);
                    String[] getChoicesQuestionEight = res.getStringArray(R.array.ChoicesQuestionEight);
                    setRadioButtonText(getChoicesQuestionEight);
                    break;
                case 8:
                    // Edit Text question type. Remove RadioGroup view
                    View radioGroupView = findViewById(R.id.radio_group);
                    radioGroupView.setVisibility(View.GONE);

                    // Set the hint image
                    nextQuestionImage.setImageResource(R.drawable.question_nine_hint_image);

                    // Set the text view for question
                    questionTextView.setText(R.string.question_9);

                    // Make EditTextView visible
                    View editTextView = findViewById(R.id.user_input_edittext_view);
                    editTextView.setVisibility(View.VISIBLE);
                    break;
            }
        } else {
            // Not multiple-choices nor EditText question type - Multiple CheckBox question type
            // Remove EditText view
            View editTextView = findViewById(R.id.user_input_edittext_view);
            editTextView.setVisibility(View.GONE);

            // Make hint image visible and set hint image view
            nextQuestionImage.setImageResource(R.drawable.question_ten_hint_image);

            // Set question 10 text to question TextView
            questionTextView.setText(R.string.question_10);

            // Make all CheckBox options visible
            isCheckboxVisible(v, true);

            // Set submit button text to finish
            getSubmitButton.setText(R.string.finish);
        }

        // Make submit button visible
        getSubmitButton.setVisibility(View.VISIBLE);

        // Remove next button
        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setVisibility(View.GONE);
    }

    /**
     * This method is called when an user clicks the submit button to submits his/her answer to a question
     */
    public void onSubmitClick(View v) {
        // Select RadioGroup and EditText view
        RadioGroup radioGroupView = (RadioGroup) findViewById(R.id.radio_group);
        EditText editTextView = (EditText) findViewById(R.id.user_input_edittext_view);
        Button submitButtonView = (Button) findViewById(R.id.submit_button);

        // Check question type to appropriately evaluate answer
        if (radioGroupView.getVisibility() == View.VISIBLE) {
            // Multiple-choice question is displayed to user
            // Get the ID of the checked RadioButton from RadioGroup view
            int checkedRadioButtonId = radioGroupView.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) findViewById(checkedRadioButtonId);
            if (checkedRadioButtonId == -1) {
                // None of the radio buttons were checked
                displayToastForResult("Please check one of the options!");
            } else {
                // Get user answer from checked RadioButton
                String userResponse = checkedRadioButton.getText().toString();
                // Compare user answer with answerKey
                boolean isCorrect = userResponse.equals(answerKey[head]);
                if (isCorrect) {
                    // Increment correct answers by 1
                    numberOfCorrectAnswers++;
                    // Toast instant result
                    displayToastForResult("Correct!");
                } else {
                    // Toast instant result
                    displayToastForResult("Incorrect");
                }

                // Remove Submit button
                submitButtonView.setVisibility(View.GONE);

                // Make nextButton visible
                Button nextButton = (Button) findViewById(R.id.next_button);
                nextButton.setVisibility(View.VISIBLE);
            }
        } else if (editTextView.getVisibility() == View.VISIBLE) {
            // EditText question type is displayed to user
            String answerText = editTextView.getText().toString().toLowerCase();
            if (answerText.equals(answerKey[head].toLowerCase())) {
                numberOfCorrectAnswers++;
                // Toast instant result
                displayToastForResult("Correct");
            } else {
                // Toast instant result
                displayToastForResult("Incorrect");
            }
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            // Remove Submit button
            submitButtonView.setVisibility(View.GONE);

            // Make nextButton visible
            Button nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setVisibility(View.VISIBLE);
        } else {
            // Multiple CheckBox question type is displayed to user
            if (trackAnswers.isEmpty()) {
                displayToastForResult("Please check one or more of the options!");
            } else {
                if (trackAnswers.equals("ccc")) {
                    // Correct choices were checked
                    displayToastForResult("Correct");
                    numberOfCorrectAnswers++;
                } else {
                    // Incorrect choices
                    displayToastForResult("Incorrect");
                }
                // Multiple CheckBox question type is the last question
                // Setup summary screen

                // Set summary image view
                ImageView summaryImageView = (ImageView) findViewById(R.id.hint_image_view);
                summaryImageView.setImageResource(R.drawable.summary_image_hogwarts_logo);

                // Set result text view
                TextView resultTextView = (TextView) findViewById(R.id.question_text_view);
                int totalNumberOfQuestions = 10;
                float percentageOfCorrectAnswers = numberOfCorrectAnswers / (float) totalNumberOfQuestions;
                if (percentageOfCorrectAnswers < 0.75) {
                    // Scores less than 75%
                    resultTextView.setText(getString(R.string.average, numberOfCorrectAnswers, totalNumberOfQuestions));
                } else if (percentageOfCorrectAnswers < 1) {
                    // Scores between 75% and 99%
                    resultTextView.setText(getString(R.string.above_average, numberOfCorrectAnswers, totalNumberOfQuestions));
                } else {
                    resultTextView.setText(R.string.perfect_score);
                }
                resultTextView.setGravity(Gravity.CENTER);
                resultTextView.setTypeface(Typeface.SANS_SERIF);

                // Remove multiple Checkboxes from view
                isCheckboxVisible(v, false);

                // Set play again button view
                View getPlayAgainButton = findViewById(R.id.play_again_button);
                getPlayAgainButton.setVisibility(View.VISIBLE);

                // Set button text to finish
                submitButtonView.setVisibility(View.GONE);
            }
        }

    }

    /**
     * This method is called when an user wants to play again
     */
    public void onPlayAgainClick(View v) {
        // Reset app to new quiz
        // Remove scroll view
        View scrollView = findViewById(R.id.scroll_view);
        scrollView.setVisibility(View.GONE);

        // Make banner image visible
        View bannerImageView = findViewById(R.id.banner_image);
        bannerImageView.setVisibility(View.VISIBLE);

        // Make banner text visible
        View bannerTextView = findViewById(R.id.banner_text);
        bannerTextView.setVisibility(View.VISIBLE);

        // Make start quiz button visible
        View startQuizButton = findViewById(R.id.start_button);
        startQuizButton.setVisibility(View.VISIBLE);

        // Set global variables to default
        head = 0;
        numberOfCorrectAnswers = 0;
        trackAnswers = "";

        // Reset checkbox group question and Remove multiple CheckBoxes
        clearCheckedBoxGroup(v, true);

        // Remove hint image view
        View summaryImageView = findViewById(R.id.hint_image_view);
        summaryImageView.setVisibility(View.GONE);

        // Remove question text view
        View questionTextView = findViewById(R.id.question_text_view);
        questionTextView.setVisibility(View.GONE);

        // Remove play again button
        View getPlayAgainButton = findViewById(R.id.play_again_button);
        getPlayAgainButton.setVisibility(View.GONE);
    }

    /**
     * This method is called when a multiple-choice question is presented to an user
     *
     * @param choices a String array that holds the multiple choices for a question
     */
    private void setRadioButtonText(String[] choices) {
        RadioGroup radioGroupView = (RadioGroup) findViewById(R.id.radio_group);
        // Clear prior selections
        radioGroupView.clearCheck();
        // Set multiple choices
        for (int i = 0; i < radioGroupView.getChildCount(); i++) {
            ((RadioButton) radioGroupView.getChildAt(i)).setText(choices[i]);
        }
    }

    /**
     * This method is called when a toast has to be displayed to an user
     *
     * @param displayMessage a String that sets the text for a toast view
     */
    private void displayToastForResult(String displayMessage) {
        Toast eval = Toast.makeText(this, displayMessage, Toast.LENGTH_SHORT);
        eval.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 30);
        eval.show();
    }

    /**
     * This method is called to track the CheckBox options that an user has checked as answers to
     * the multiple CheckBox question type
     */
    public void onCheckboxClicked(View v) {
        // Is the view now checked?
        boolean checked = ((CheckBox) v).isChecked();

        // Check which checkbox was clicked
        switch (v.getId()) {
            case R.id.checkbox_option_1:
                if (checked)
                    // Add i for incorrect answer to trackAnswers String
                    trackAnswers += "i";
                break;
            case R.id.checkbox_option_2:
                if (checked)
                    // Add c for correct answer to trackAnswers String
                    trackAnswers += "c";
                break;
            case R.id.checkbox_option_3:
                if (checked)
                    // Add i for incorrect answer to trackAnswers String
                    trackAnswers += "i";
                break;
            case R.id.checkbox_option_4:
                if (checked)
                    // Add c for correct answer to trackAnswers String
                    trackAnswers += "c";
                break;
            case R.id.checkbox_option_5:
                // Add c for correct answer to trackAnswers String
                trackAnswers += "c";
                break;
            case R.id.checkbox_option_6:
                if (checked)
                    // Add i for incorrect answer to trackAnswers String
                    trackAnswers += "i";
                break;
        }
    }

    /**
     * This method is called to make the entire CheckBox cluster visible
     *
     * @param makeVisible a boolean that indicates whether or not the CheckBox is to be made visible
     */
    private void isCheckboxVisible(View v, boolean makeVisible) {
        // Get individual CheckBox view from CheckBox cluster
        View checkBox1View = findViewById(R.id.checkbox_option_1);
        View checkBox2View = findViewById(R.id.checkbox_option_2);
        View checkBox3View = findViewById(R.id.checkbox_option_3);
        View checkBox4View = findViewById(R.id.checkbox_option_4);
        View checkBox5View = findViewById(R.id.checkbox_option_5);
        View checkBox6View = findViewById(R.id.checkbox_option_6);

        if (makeVisible) {
            // Make CheckBox view visible
            checkBox1View.setVisibility(View.VISIBLE);
            checkBox2View.setVisibility(View.VISIBLE);
            checkBox3View.setVisibility(View.VISIBLE);
            checkBox4View.setVisibility(View.VISIBLE);
            checkBox5View.setVisibility(View.VISIBLE);
            checkBox6View.setVisibility(View.VISIBLE);
        } else {
            // Remove CheckBox view
            checkBox1View.setVisibility(View.GONE);
            checkBox2View.setVisibility(View.GONE);
            checkBox3View.setVisibility(View.GONE);
            checkBox4View.setVisibility(View.GONE);
            checkBox5View.setVisibility(View.GONE);
            checkBox6View.setVisibility(View.GONE);
        }
    }

    /**
     * This method is called to clear out the checked boxes for the CheckBox cluster
     *
     * @param isChecked a boolean indicating the checked status of a CheckBox view
     */
    private void clearCheckedBoxGroup(View v, boolean isChecked) {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox_option_1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_option_2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox_option_3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox_option_4);
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkbox_option_5);
        CheckBox checkBox6 = (CheckBox) findViewById(R.id.checkbox_option_6);

        if (isChecked) {
            checkBox1.setChecked(!isChecked);
            checkBox2.setChecked(!isChecked);
            checkBox3.setChecked(!isChecked);
            checkBox4.setChecked(!isChecked);
            checkBox5.setChecked(!isChecked);
            checkBox6.setChecked(!isChecked);
        }
    }
}