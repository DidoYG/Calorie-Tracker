This is a Calorie Tracker, that besides counting the calories eaten, sums up the macros also.

The program uses java swing library for the GUI. There are different elements that are part of the library such as: a mainFrame variable that is instance of the JFrame class, a foodPanel instance of the JPanel class and a scrollPane. There are also smaller elements as instances of the JLabel and JButton classes. All these elements together make the UI for the program.

The mainFrame instance contains all the other instances. The scrollPane contains the foodPanel JPanel and makes it scrollable. Most of the JLabel instances’ purpose is only to display macronutrients information. The JLabels in the center of the program change depending on what foods are added and act as a final sum. The search button extracts the text from the search bar and displays the nutritional values of the food if one is found. The add button then adds the searched food to the list of "eaten" foods.

When opening the project, the user is asked to enter their desired calorie limit for the day. Then when adding foods if 70% of the limit is passed the color of the calorie limit text is changed to orange, and after passing the limit the color changes to red.

The project is designed to be interesting to the user. That is why there are colorful texts and indicators implemented in the UI. 

The limitation with the program is that the foods implemented in the code are hardcoded. For now, there are only 20 foods - ranging from salads, fast foods, vegetables, fruit, and desserts.

Added Foods - Caesar salad, potato soup, salmon, white bread, cheese, milk, eggs, apple, beef, pork, cherry tomatoes, watermelon, ramen, sandwich, hamburger, cheese pizza, chocolate, ice cream, chicken, banana

All macros information is for 100 grams of a particular product.

The website used for all the macro nutrients' information -> https://www.fatsecret.com/calories-nutrition/
