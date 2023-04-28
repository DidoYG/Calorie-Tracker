Your project is a Calorie Tracker, that besides counting the calories eaten, sums up the macros also.

We have decided to implement and use java swing library for the GUI. We have used different elements that are part of the library.
In the project there is a mainFrame variable that is instance of the JFrame class, a foodPanel instance of the JPanel class and a scrollPane.
There are also smaller elements as instances of the JLabel and JButton classes.
All these elements together make our UI for the project.

The mainFrame instance contains all the other instances. The scrollPane contains the foodPanel JPanel and makes it scrollable.
Most of the JLabel instances purpose is only to display macronutrients information. 
The JLabels in the center of the program change depending on what foods are added and act as a final sum.
The search button extracts the text from the search bar and displays the nutritional values of the food if one is found. 
The add button then adds the searched food to the list of "eaten" foods.

When opening the project the user is asked to enter his desired calorie limit for the day. Then when adding foods if 70% of the limit is passed the color of the calorie limit text is changed to orange, and after passing the limit the color changes to red.

We designed our project to be interesting to the user. That is why we have implemented colorful text and indicators. For us the visuals play an important role in the program's design.

There is one limitation that our code has and is that the foods implemented in the code are hardcoded. For now, we only have 20 foods - ranging from salads, fast foods, vegetables, fruit, and desserts.

We have used a website for all the macro nutrients' information -> https://www.fatsecret.com/calories-nutrition/