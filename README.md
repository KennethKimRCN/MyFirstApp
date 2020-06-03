# MyFirstApp
This is my first Android app.
Here I have learned how to reference an object.

## Creating Layout

## Create an integer variable
This is how you parse to an integer from the screen
```java
    EditText firstNumEditText = (EditText) findViewById(R.id.input1);
    TextView resultTextView = (TextView) findViewById(R.id.resultNum);
    int num1 = Integer.parseInt(firstNumEditText.getText().toString());
```

How to display text from a variable
```java
    resultTextView.setText(result + "");
```