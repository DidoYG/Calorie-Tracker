/**

 * File: CalorieTracker.java

 * Author: Deyan Georgiev, Martin Georgiev, Vasko Pohlupkov, Konstantin Hadziiliev

 * Date: 20.04.2023

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalorieTracker {

    // a method that changes the color of the calorie tracker if certain percentages are passed
    public static Color colorChanger(int[] currentCalories, int maxCalories){
        if(currentCalories[0] <= (maxCalories * 0.7)){
            return Color.GREEN;
        }
        else if(currentCalories[0] > (maxCalories * 0.7) && currentCalories[0] < maxCalories){
            return Color.ORANGE;
        }
        else{
            return Color.RED;
        }
    }

    public static void main(String[] args){

        // integer arrays that have only one attribute which is 0 -> later all the macros are added to this only element
        int[] currentCalories = {0}, currentCarbs = {0}, currentProteins = {0}, currentFats = {0};

        // instances of class Fonts -> different fonts used in the code
        Font displayFont = new Font("Serif", Font.BOLD, 36);
        Font informationFont = new Font("SansSerif", Font.PLAIN, 25);
        Font searchFont = new Font("SansSerif", Font.PLAIN, 20);
        Font suggestionFont = new Font("SansSerif", Font.BOLD, 28);
        Font panelFont = new Font("SansSerif", Font.PLAIN, 25);
        Image appIcon = new ImageIcon("res/main_icon.png").getImage();

        // with this message the user enters their preferred daily calorie limit
        String input = JOptionPane.showInputDialog (null, "Enter calorie limit: ");
        int maxCalories = Integer.parseInt(input);

        // this is the main frame which displays everything
        JFrame mainFrame = new JFrame("Calorie Tracker");
        mainFrame.setIconImage(appIcon);
        mainFrame.getContentPane().setBackground(Color.GRAY);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // this is the label that shows the current calories consumed
        JLabel showCalories = new JLabel(currentCalories[0] + " / " + input + " kCal");
        showCalories.setForeground(Color.GREEN);
        showCalories.setFont(displayFont);
        showCalories.setBounds(650, 300, 300, 150);

        // this is the label that shows the current carbs consumed
        JLabel showCarbs = new JLabel(currentCarbs[0] + "g Carbs");
        showCarbs.setForeground(Color.RED);
        showCarbs.setFont(displayFont);
        showCarbs.setBounds(700, 50, 300, 150);

        // this is the label that shows the current proteins consumed
        JLabel showProteins = new JLabel(currentProteins[0] + "g Proteins");
        showProteins.setForeground(Color.BLUE);
        showProteins.setFont(displayFont);
        showProteins.setBounds(450, 550, 300, 150);

        // this is the label that shows the current fats consumed
        JLabel showFats = new JLabel(currentFats[0] + "g Fats");
        showFats.setForeground(Color.YELLOW);
        showFats.setFont(displayFont);
        showFats.setBounds(950, 550, 200, 150);

        // the panel that contains all the "eaten" foods - later passed to a scrollPane making it scrollable
        JPanel foodPanel = new JPanel();
        foodPanel.setBackground(Color.DARK_GRAY);
        // displaying items added vertically
        foodPanel.setLayout(new BoxLayout(foodPanel, BoxLayout.Y_AXIS));

        // label displaying only text
        Label per100Label = new Label("Per 100g: ");
        per100Label.setForeground(Color.WHITE);
        per100Label.setFont(informationFont);
        per100Label.setBounds(1200, 200, 200, 100);

        // label displaying calories of the searched foods
        Label infoCaloriesLabel = new Label();
        infoCaloriesLabel.setForeground(Color.WHITE);
        infoCaloriesLabel.setFont(informationFont);
        infoCaloriesLabel.setBounds(1200, 300, 200, 100);

        // label displaying carbs of the searched foods
        Label infoCarbsLabel = new Label();
        infoCarbsLabel.setForeground(Color.WHITE);
        infoCarbsLabel.setFont(informationFont);
        infoCarbsLabel.setBounds(1200, 400, 200, 100);

        // label displaying proteins of the searched foods
        Label infoProteinsLabel = new Label();
        infoProteinsLabel.setForeground(Color.WHITE);
        infoProteinsLabel.setFont(informationFont);
        infoProteinsLabel.setBounds(1200, 500, 200, 100);

        // label displaying fats of the searched foods
        Label infoFatsLabel = new Label();
        infoFatsLabel.setForeground(Color.WHITE);
        infoFatsLabel.setFont(informationFont);
        infoFatsLabel.setBounds(1200, 600, 200, 100);

        // search button used for searching the food written in the searchBar
        JButton searchButton = new JButton(new ImageIcon("res/search_icon.png"));
        searchButton.setSize(50, 50);
        searchButton.setLocation(1430, 20);

        // add button used for adding the searched food to the foodPanel
        JButton addButton = new JButton(new ImageIcon("res/plus_icon.png"));
        addButton.setSize(50, 50);
        addButton.setLocation(1480, 20);

        // search bar that is an editable textField
        JTextField searchBar = new JTextField();
        searchBar.setSize(230, 50);
        searchBar.setFont(searchFont);
        searchBar.setLocation(1200, 20);

        // a label that shows the searched food as a suggestion -> mainly for style
        JLabel foodSuggestion = new JLabel();
        foodSuggestion.setForeground(Color.WHITE);
        foodSuggestion.setBounds(1280, 120, 300, 50);
        foodSuggestion.setFont(suggestionFont);

        // actionListener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // getting the text from the search bar and setting it to the foodSuggestion
                foodSuggestion.setText(searchBar.getText());

                // when searchButton is clicked the information labels are added to the frame
                mainFrame.add(per100Label);
                mainFrame.add(infoCaloriesLabel);
                mainFrame.add(infoCarbsLabel);
                mainFrame.add(infoProteinsLabel);
                mainFrame.add(infoFatsLabel);

                // checking for matching food and assigning each information label
                if(searchBar.getText().trim().equalsIgnoreCase("banana")){
                    infoCaloriesLabel.setText("Calories: 160");
                    infoCarbsLabel.setText("Carbohydrates: 27g");
                    infoProteinsLabel.setText("Proteins: 1g");
                    infoFatsLabel.setText("Fats: 0g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("chicken")){
                    infoCaloriesLabel.setText("Calories: 147");
                    infoCarbsLabel.setText("Carbohydrates: 0g");
                    infoProteinsLabel.setText("Proteins: 26g");
                    infoFatsLabel.setText("Fats: 3g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("ice cream")){
                    infoCaloriesLabel.setText("Calories: 200");
                    infoCarbsLabel.setText("Carbohydrates: 25g");
                    infoProteinsLabel.setText("Proteins: 2g");
                    infoFatsLabel.setText("Fats: 8g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("chocolate")){
                    infoCaloriesLabel.setText("Calories: 235");
                    infoCarbsLabel.setText("Carbohydrates: 26g");
                    infoProteinsLabel.setText("Proteins: 3g");
                    infoFatsLabel.setText("Fats: 13g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("cheese pizza")){
                    infoCaloriesLabel.setText("Calories: 235");
                    infoCarbsLabel.setText("Carbohydrates: 26g");
                    infoProteinsLabel.setText("Proteins: 10g");
                    infoFatsLabel.setText("Fats: 10g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("hamburger")){
                    infoCaloriesLabel.setText("Calories: 272");
                    infoCarbsLabel.setText("Carbohydrates: 34g");
                    infoProteinsLabel.setText("Proteins: 12g");
                    infoFatsLabel.setText("Fats: 10g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("sandwich")){
                    infoCaloriesLabel.setText("Calories: 291");
                    infoCarbsLabel.setText("Carbohydrates: 28g");
                    infoProteinsLabel.setText("Proteins: 9g");
                    infoFatsLabel.setText("Fats: 15g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("ramen")){
                    infoCaloriesLabel.setText("Calories: 190");
                    infoCarbsLabel.setText("Carbohydrates: 26g");
                    infoProteinsLabel.setText("Proteins: 4g");
                    infoFatsLabel.setText("Fats: 7g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("watermelon")){
                    infoCaloriesLabel.setText("Calories: 30");
                    infoCarbsLabel.setText("Carbohydrates: 8g");
                    infoProteinsLabel.setText("Proteins: 1g");
                    infoFatsLabel.setText("Fats: 0g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("cherry tomatoes")){
                    infoCaloriesLabel.setText("Calories: 4");
                    infoCarbsLabel.setText("Carbohydrates: 1g");
                    infoProteinsLabel.setText("Proteins: 0g");
                    infoFatsLabel.setText("Fats: 0g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("pork")){
                    infoCaloriesLabel.setText("Calories: 271");
                    infoCarbsLabel.setText("Carbohydrates: 0g");
                    infoProteinsLabel.setText("Proteins: 27g");
                    infoFatsLabel.setText("Fats: 17g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("beef")){
                    infoCaloriesLabel.setText("Calories: 288");
                    infoCarbsLabel.setText("Carbohydrates: 0g");
                    infoProteinsLabel.setText("Proteins: 26g");
                    infoFatsLabel.setText("Fats: 20g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("apple")){
                    infoCaloriesLabel.setText("Calories: 52");
                    infoCarbsLabel.setText("Carbohydrates: 14g");
                    infoProteinsLabel.setText("Proteins: 0g");
                    infoFatsLabel.setText("Fats: 0g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("eggs")){
                    infoCaloriesLabel.setText("Calories: 147");
                    infoCarbsLabel.setText("Carbohydrates: 1g");
                    infoProteinsLabel.setText("Proteins: 13g");
                    infoFatsLabel.setText("Fats: 10g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("milk")){
                    infoCaloriesLabel.setText("Calories: 50");
                    infoCarbsLabel.setText("Carbohydrates: 5g");
                    infoProteinsLabel.setText("Proteins: 3g");
                    infoFatsLabel.setText("Fats: 1g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("cheese")){
                    infoCaloriesLabel.setText("Calories: 350");
                    infoCarbsLabel.setText("Carbohydrates: 5g");
                    infoProteinsLabel.setText("Proteins: 22g");
                    infoFatsLabel.setText("Fats: 27g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("white bread")){
                    infoCaloriesLabel.setText("Calories: 266");
                    infoCarbsLabel.setText("Carbohydrates: 51g");
                    infoProteinsLabel.setText("Proteins: 8g");
                    infoFatsLabel.setText("Fats: 3g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("salmon")){
                    infoCaloriesLabel.setText("Calories: 116");
                    infoCarbsLabel.setText("Carbohydrates: 0g");
                    infoProteinsLabel.setText("Proteins: 20g");
                    infoFatsLabel.setText("Fats: 4g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("potato soup")){
                    infoCaloriesLabel.setText("Calories: 43");
                    infoCarbsLabel.setText("Carbohydrates: 2g");
                    infoProteinsLabel.setText("Proteins: 1g");
                    infoFatsLabel.setText("Fats: 2g");
                }
                else if(searchBar.getText().trim().equalsIgnoreCase("caesar salad")){
                    infoCaloriesLabel.setText("Calories: 96");
                    infoCarbsLabel.setText("Carbohydrates: 8g");
                    infoProteinsLabel.setText("Proteins: 8g");
                    infoFatsLabel.setText("Fats: 5g");
                }
                else {
                    // if no matching foods are found the labels are removed
                    foodSuggestion.setText("Nothing Found...");
                    mainFrame.remove(per100Label);
                    mainFrame.remove(infoCaloriesLabel);
                    mainFrame.remove(infoCarbsLabel);
                    mainFrame.remove(infoProteinsLabel);
                    mainFrame.remove(infoFatsLabel);
                }
            }
        });

        // actionListener for the addButton
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // checking for matching values and adding the corresponding macros to the displayed information
                if(foodSuggestion.getText().trim().equalsIgnoreCase("banana")){
                    currentCalories[0] += 160;
                    currentCarbs[0] += 27;
                    currentProteins[0] += 1;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("chicken")){
                    currentCalories[0] += 147;
                    currentProteins[0] += 26;
                    currentFats[0] += 3;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("ice cream")){
                    currentCalories[0] += 200;
                    currentCarbs[0] += 25;
                    currentProteins[0] += 2;
                    currentFats[0] += 8;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("watermelon")){
                    currentCalories[0] += 30;
                    currentCarbs[0] += 8;
                    currentProteins[0] += 1;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("cherry tomatoes")){
                    currentCalories[0] += 4;
                    currentCarbs[0] += 1;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("chocolate")){
                    currentCalories[0] += 235;
                    currentCarbs[0] += 26;
                    currentProteins[0] += 3;
                    currentFats[0] += 13;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("cheese pizza")){
                    currentCalories[0] += 235;
                    currentCarbs[0] += 26;
                    currentProteins[0] += 10;
                    currentFats[0] += 10;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("hamburger")){
                    currentCalories[0] += 272;
                    currentCarbs[0] += 34;
                    currentProteins[0] += 12;
                    currentFats[0] += 10;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("ramen")){
                    currentCalories[0] += 190;
                    currentCarbs[0] += 26;
                    currentProteins[0] += 4;
                    currentFats[0] += 7;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("sandwich")){
                    currentCalories[0] += 291;
                    currentCarbs[0] += 28;
                    currentProteins[0] += 9;
                    currentFats[0] += 15;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("pork")){
                    currentCalories[0] += 271;
                    currentProteins[0] += 27;
                    currentFats[0] += 17;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("beef")){
                    currentCalories[0] += 288;
                    currentProteins[0] += 26;
                    currentFats[0] += 20;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("apple")){
                    currentCalories[0] += 52;
                    currentCarbs[0] += 14;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("eggs")){
                    currentCalories[0] += 147;
                    currentCarbs[0] += 1;
                    currentProteins[0] += 13;
                    currentFats[0] += 10;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("milk")){
                    currentCalories[0] += 50;
                    currentCarbs[0] += 5;
                    currentProteins[0] += 3;
                    currentFats[0] += 1;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("cheese")){
                    currentCalories[0] += 350;
                    currentCarbs[0] += 5;
                    currentProteins[0] += 22;
                    currentFats[0] += 27;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("white bread")){
                    currentCalories[0] += 266;
                    currentCarbs[0] += 51;
                    currentProteins[0] += 8;
                    currentFats[0] += 3;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("salmon")){
                    currentCalories[0] += 116;
                    currentProteins[0] += 20;
                    currentFats[0] += 4;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("potato soup")){
                    currentCalories[0] += 43;
                    currentCarbs[0] += 2;
                    currentProteins[0] += 1;
                    currentFats[0] += 2;

                }
                else if(foodSuggestion.getText().trim().equalsIgnoreCase("caesar salad")){
                    currentCalories[0] += 96;
                    currentCarbs[0] += 8;
                    currentProteins[0] += 8;
                    currentFats[0] += 5;

                }

                // here the food searched is added to the panel as a new label
                if(foodSuggestion.getText() != "Nothing Found..."){
                    JLabel foodLabel = new JLabel("          " + foodSuggestion.getText());
                    foodLabel.setForeground(Color.WHITE);
                    foodLabel.setFont(panelFont);
                    foodPanel.add(foodLabel);
                    foodPanel.revalidate();
                    foodPanel.repaint();
                }

                // calling a method for changing the color of the calories shown
                showCalories.setForeground(colorChanger(currentCalories, maxCalories));

                // updating all the texts of the information displays
                showCalories.setText(currentCalories[0] + " / " + input + " kCal");
                showCarbs.setText(currentCarbs[0] + "g Carbs");
                showProteins.setText(currentProteins[0] + "g Proteins");
                showFats.setText(currentFats[0] + "g Fats");
            }
        });

        // scrollable pane that takes the panel full of foods
        JScrollPane scrollPane = new JScrollPane(foodPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 350, 800);

        // adding all the elements to the frame
        mainFrame.add(scrollPane);
        mainFrame.add(addButton);
        mainFrame.add(searchButton);
        mainFrame.add(foodSuggestion);
        mainFrame.add(searchBar);
        mainFrame.add(showCalories);
        mainFrame.add(showCarbs);
        mainFrame.add(showProteins);
        mainFrame.add(showFats);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }
}
