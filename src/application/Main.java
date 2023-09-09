package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		Label header = new Label("Diet Guide");
		header.setFont(Font.font("Cambria", FontWeight.BOLD, 40));

		Button b1 = new Button("Diet Quiz");
		b1.setStyle("-fx-background-color: #f8ecc2");
		b1.setPrefSize(120, 80);
		b1.setFont(Font.font("Cambria", FontWeight.BOLD, 15));

		Button b2 = new Button("meals ideas");
		b2.setPrefSize(120, 80);
		b2.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		b2.setStyle("-fx-background-color: #f8ecc2");

		VBox h = new VBox();
		h.setSpacing(15);
		h.setAlignment(Pos.TOP_CENTER);

		h.getChildren().addAll(header, b1, b2);
		Scene scene = new Scene(h, 500, 400);

		h.setStyle(
				"-fx-background-image: url('https://st.depositphotos.com/1013886/5068/i/950/depositphotos_50685349-stock-photo-healthy-food-background.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 500 500; -fx-background-position: center center;");

		primaryStage.setScene(scene);
		primaryStage.setTitle("DIET GUIDE PROTOTYPE");
		primaryStage.show();

		/**************************** second scene ********************************/

		Label l1 = new Label("What age group do you belong to?");
		l1.setFont(Font.font("Cambria", FontWeight.BOLD, 20));

		RadioButton r1 = new RadioButton("18-29");
		r1.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		RadioButton r2 = new RadioButton("30-39");
		r2.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		RadioButton r3 = new RadioButton("40-49");
		r3.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		RadioButton r4 = new RadioButton("50+");
		r4.setFont(Font.font("Cambria", FontWeight.BOLD, 15));

		HBox hr1 = new HBox();
		hr1.setSpacing(15);
		HBox hr2 = new HBox();
		hr2.setSpacing(15);

		ToggleGroup tg = new ToggleGroup();
		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		r3.setToggleGroup(tg);
		r4.setToggleGroup(tg);

		hr1.getChildren().addAll(r1, r2);
		hr2.getChildren().addAll(r3, r4);

		GridPane grr = new GridPane();

		grr.setAlignment(Pos.BASELINE_LEFT);

		HBox hbl1 = new HBox();
		hbl1.setSpacing(15);

		Label l2 = new Label("Enter your weight in kilograms:");
		l2.setFont(Font.font("Cambria", FontWeight.BOLD, 20));
		TextField txt1 = new TextField();

		hbl1.getChildren().addAll(l2, txt1);

		HBox hbl2 = new HBox();
		hbl2.setSpacing(15);

		Label l3 = new Label("Enter your height in centimeters:");
		l3.setFont(Font.font("Cambria", FontWeight.BOLD, 20));
		TextField txt2 = new TextField();

		hbl2.getChildren().addAll(l3, txt2);

		HBox hbo = new HBox();
		hbo.setSpacing(15);
		Button bmib = new Button("calculate your BMI");
		bmib.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		b1.setStyle("-fx-background-color: #f8ecc2");
		TextField txt3 = new TextField();

		bmib.setOnAction(new EventHandler<ActionEvent>() {
			// double bmical = Double.parseDouble(txt1.getText()) /
			// (Double.parseDouble(txt2.getText()) * Double.parseDouble(txt2.getText()));

			@Override
			public void handle(ActionEvent arg0) {
				double heightr = Double.parseDouble(txt2.getText()) / 100.0;
				double bmical = Double.parseDouble(txt1.getText()) / (heightr * heightr);

				try {
	
					txt3.setText(bmical + "");

				} catch (Exception ex1) {
					txt3.setText("enter values");

					
				
				}
			}
		});

		hbo.getChildren().addAll(bmib, txt3);

		Button nxt = new Button("-->");
		nxt.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		nxt.setStyle("-fx-background-color: #f8ecc2");

		Button back1 = new Button("<--");
		back1.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		back1.setStyle("-fx-background-color: #f8ecc2");

		back1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(scene);
				primaryStage.setTitle("DIET GUIDE PROTOTYPE");
				primaryStage.show();

			}
		});

		VBox vs1 = new VBox();
		vs1.setSpacing(15);

		vs1.getChildren().addAll(l1, hr1, hr2, hbl1, hbl2, hbo, nxt, back1);

		Scene scene1 = new Scene(vs1, 500, 400);
		vs1.setStyle(
				"-fx-background-image: url('https://cdn.wallpapersafari.com/74/99/6fhjbi.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 500 500; -fx-background-position: center center;");

		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(scene1);
				primaryStage.setTitle("Quiz");
				primaryStage.show();

			}
		});

		/******************** 3rd scene *****************************************/

		HBox hbs1 = new HBox();
		hbs1.setSpacing(15);
		Label ql1 = new Label("Are you allergic to gulten?");
		ql1.setFont(Font.font("Cambria", FontWeight.BOLD, 20));

		RadioButton rb1 = new RadioButton("Yes");
		rb1.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		RadioButton rb2 = new RadioButton("No");
		rb2.setFont(Font.font("Cambria", FontWeight.BOLD, 15));

		ToggleGroup tgs1 = new ToggleGroup();
		rb1.setToggleGroup(tgs1);
		rb2.setToggleGroup(tgs1);

		hbs1.getChildren().addAll(rb1, rb2);

		////////////////////////////////////////////////////////////////

		HBox hbs2 = new HBox();
		hbs2.setSpacing(15);

		Label ql2 = new Label("Are you lactose intolerant?");
		ql2.setFont(Font.font("Cambria", FontWeight.BOLD, 20));

		RadioButton rb3 = new RadioButton("Yes");
		rb3.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		RadioButton rb4 = new RadioButton("No");
		rb4.setFont(Font.font("Cambria", FontWeight.BOLD, 15));

		ToggleGroup tgs2 = new ToggleGroup();
		rb3.setToggleGroup(tgs2);
		rb4.setToggleGroup(tgs2);

		hbs2.getChildren().addAll(rb3, rb4);
		///////////////////////////////////////////////////////////////

		HBox hbs3 = new HBox();
		hbs3.setSpacing(15);

		Label ql3 = new Label("Are you a meat eater?");
		ql3.setFont(Font.font("Cambria", FontWeight.BOLD, 20));

		RadioButton rb5 = new RadioButton("Yes");
		rb5.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		RadioButton rb6 = new RadioButton("No");
		rb6.setFont(Font.font("Cambria", FontWeight.BOLD, 15));

		ToggleGroup tgs3 = new ToggleGroup();
		rb5.setToggleGroup(tgs3);
		rb6.setToggleGroup(tgs3);

		hbs3.getChildren().addAll(rb5, rb6);

		///////////////////////////////////////////////////////////////

		HBox hbs4 = new HBox();
		hbs4.setSpacing(15);

		Label ql4 = new Label("Are you willing to stay consistent on a strict diet?");
		ql4.setFont(Font.font("Cambria", FontWeight.BOLD, 20));

		RadioButton rb7 = new RadioButton("Yes");
		rb7.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		RadioButton rb8 = new RadioButton("No");
		rb8.setFont(Font.font("Cambria", FontWeight.BOLD, 15));

		ToggleGroup tgs4 = new ToggleGroup();
		rb7.setToggleGroup(tgs4);
		rb8.setToggleGroup(tgs4);

		hbs4.getChildren().addAll(rb7, rb8);

		Button nxt2 = new Button("-->");
		nxt2.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		nxt2.setStyle("-fx-background-color: #f8ecc2");

		Button bef2 = new Button("<--");
		bef2.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		bef2.setStyle("-fx-background-color: #f8ecc2");

		bef2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(scene1);
				primaryStage.setTitle("Quiz");
				primaryStage.show();
				rb1.setSelected(false);
				rb2.setSelected(false);
				rb3.setSelected(false);
				rb4.setSelected(false);
				rb5.setSelected(false);
				rb6.setSelected(false);
				rb7.setSelected(false);
				rb8.setSelected(false);

			}
		});

		VBox vbs = new VBox();
		vbs.setSpacing(15);

		vbs.getChildren().addAll(ql1, hbs1, ql2, hbs2, ql3, hbs3, ql4, hbs4, nxt2, bef2);
		vbs.setStyle(
				"-fx-background-image: url('https://cdn.wallpapersafari.com/74/99/6fhjbi.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 500 500; -fx-background-position: center center;");

		Scene scene3 = new Scene(vbs, 500, 500);

		nxt.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(scene3);
				primaryStage.setTitle("Quiz");
				primaryStage.show();

			}
		});

		/****************************** scene 4 ***********************************/

		VBox s4 = new VBox();
		s4.setSpacing(15);
		Button res = new Button("Get my result");
		res.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		res.setStyle("-fx-background-color: #f8ecc2");

		Button back = new Button("back to first page");
		back.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		back.setStyle("-fx-background-color: #f8ecc2");
		TextArea ta = new TextArea("Diets suitable for you:");

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				rb1.setSelected(false);
				rb2.setSelected(false);
				rb3.setSelected(false);
				rb4.setSelected(false);
				rb5.setSelected(false);
				rb6.setSelected(false);
				rb7.setSelected(false);
				rb8.setSelected(false);
				ta.appendText("Diets suitable for you:");
				
				
				primaryStage.setScene(scene);
				primaryStage.setTitle("DIET GUIDE PROTOTYPE");
				primaryStage.show();

			}
		});
		Button bb = new Button("previous page");
		bb.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		bb.setStyle("-fx-background-color: #f8ecc2");
		
		bb.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(scene3);
				primaryStage.setTitle("Quiz");
				primaryStage.show();

			}
		});

	//	TextArea ta = new TextArea("Diets suitable for you:");
		s4.getChildren().addAll(res, ta,  bb, back);

		s4.setStyle(
				"-fx-background-image: url('https://cdn.wallpapersafari.com/74/99/6fhjbi.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 500 500; -fx-background-position: center center;");

		Scene scene4 = new Scene(s4, 500, 500);

		nxt2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(scene4);
				primaryStage.setTitle("Result");
				primaryStage.show();

			}
		});

		res.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (rb3.isSelected() && rb1.isSelected() ) {
					ta.appendText("vegan diet, lactose free diet, paleo diet,Gluten free diet,low sugar diet \n ");

				
				

				}
				if (rb1.isSelected() && rb5.isSelected()) {
					ta.appendText("vegan diet, pescaterian diet ,lactose free diet, paleo diet,Gluten free diet,low sugar diet \\n\n");

				}
				if (rb7.isSelected() && rb3.isSelected() && rb1.isSelected()) {
					ta.appendText("keto diet, intermittent fasting,low suger diet, low carbs diet\n"
							+ "vegan diet, lactose free diet, paleo diet,Gluten free diet");

				}
				
				
				if(txt3.getText() != null) {
					if(Double.parseDouble(txt3.getText()) > 18.5 &&  Double.parseDouble(txt3.getText()) < 24.9) {
						ta.appendText("according to your age and BMI: your BMI falls within the normal range, maintaining a balanced diet\n"
								+ " with a variety of foods from all food groups\n is important. Include plenty of fruits, vegetables, whole grains,\n"
								+ " lean proteins (such as poultry, fish, beans, nuts), and healthy fats (such as avocado, nuts, seeds, olive oil) \n"
								+ "in your diet. Limit added sugars, unhealthy fats (such as trans fats and saturated fats), and sodium.");
					}else if (Double.parseDouble(txt3.getText()) < 18.5) {
						ta.appendText("according to your age and BMI: your BMI is below the normal range, it's important to focus on increasing your calorie\n"
								+ " intake to achieve a healthy weight.\n Include nutrient-dense foods such as whole grains, lean proteins, healthy fats,\n"
								+ " and plenty of fruits and vegetables.");
						
					}else if(Double.parseDouble(txt3.getText()) >= 25) {
						ta.appendText("according to your age and BMI:your BMI is in the overweight or obese range, it's important to focus on a balanced diet that is lower in calories to\n"
								+ " achieve and maintain a healthy weight. Include plenty of fruits, vegetables, whole grains,\n"
								+ " lean proteins, and healthy fats, while limiting high-calorie and high-fat foods, sugary drinks, and processed foods. ");
						
						
					}
					
					
				}else 
					ta.appendText("enter you weight and height to calculate your bmi!");
					

			}
		});

		/***************************** meals prep ***********************/
		VBox hbm = new VBox();

		hbm.setSpacing(15);

		Label lm = new Label("Choose a meal: ");
		lm.setFont(Font.font("Cambria", FontWeight.BOLD, 15));

		RadioButton bm1 = new RadioButton("Breakfast");
		bm1.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		RadioButton bm2 = new RadioButton("Lunch");
		bm2.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		RadioButton bm3 = new RadioButton("Dinner");
		bm3.setFont(Font.font("Cambria", FontWeight.BOLD, 15));

		ToggleGroup tgm = new ToggleGroup();
		bm1.setToggleGroup(tgm);
		bm2.setToggleGroup(tgm);
		bm3.setToggleGroup(tgm);

		hbm.getChildren().addAll(bm1, bm2, bm3);
		hbm.setAlignment(Pos.TOP_CENTER);
		

		String[] captions = new String[] { "Products", "Education", "Partners", "Support" };

		String[] urls = new String[] { "https://www.allrecipes.com/gallery/keto-breakfast-ideas/",
				"https://www.delish.com/cooking/recipe-ideas/a28425272/potato-chip-frittata-recipe/",
				"http://www.oracle.com/partners/index.html", "http://www.oracle.com/us/support/index.html" };

		

		ArrayList<String> url = new ArrayList<>();

		Hyperlink hyperlink = new Hyperlink("https://www.allrecipes.com/gallery/keto-breakfast-ideas/");
		Hyperlink hyperlink1 = new Hyperlink(
				"https://www.delish.com/cooking/recipe-ideas/a28425272/potato-chip-frittata-recipe/");
		Hyperlink hyperlink2 = new Hyperlink("https://www.foodnetwork.com/recipes/photos/vegan-breakfast-recipes");

		Hyperlink hyperlinkd = new Hyperlink("https://www.delish.com/cooking/nutrition/g28229401/keto-lunch-ideas/");
		Hyperlink hyperlinkd1 = new Hyperlink("https://www.tasteofhome.com/collection/gluten-free-lunch-ideas/");
		Hyperlink hyperlinkd2 = new Hyperlink("https://www.tasteofhome.com/collection/vegan-lunch-ideas/");

		Hyperlink hyperlinkd3 = new Hyperlink("https://www.delish.com/cooking/g4798/easy-keto-diet-dinner-recipes/");
		Hyperlink hyperlinkd4 = new Hyperlink("https://www.tasteofhome.com/collection/gluten-free-dinner-recipes/");
		Hyperlink hyperlinkd5 = new Hyperlink(
				"https://www.bonappetit.com/gallery/vegan-dinner-recipes-that-we-just-love");

		url.add(hyperlink.getText());

		url.add(hyperlink1.getText());
		url.add(hyperlink2.getText());

		url.add(hyperlinkd.getText());
		url.add(hyperlinkd1.getText());

		url.add(hyperlinkd2.getText());

		url.add(hyperlinkd3.getText());
		url.add(hyperlinkd4.getText());
		url.add(hyperlinkd5.getText());

		hyperlink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				getHostServices().showDocument(hyperlink.getText());

			}
		});

		hyperlink1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				getHostServices().showDocument(hyperlink1.getText());

			}
		});

		hyperlink2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				getHostServices().showDocument(hyperlink2.getText());

			}
		});

		hyperlinkd.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				getHostServices().showDocument(hyperlinkd.getText());

			}
		});

		hyperlinkd1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				getHostServices().showDocument(hyperlinkd1.getText());

			}
		});

		hyperlinkd2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				getHostServices().showDocument(hyperlinkd2.getText());

			}
		});

		hyperlinkd3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				getHostServices().showDocument(hyperlinkd3.getText());

			}
		});

		hyperlinkd4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				getHostServices().showDocument(hyperlinkd4.getText());

			}
		});

		hyperlinkd5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				getHostServices().showDocument(hyperlinkd5.getText());

			}
		});
		
		Button backtomeals = new Button("back to first page");
		backtomeals.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		backtomeals.setStyle("-fx-background-color: #f8ecc2");
		
		
		Button bac = new Button("<--");
		bac.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		bac.setStyle("-fx-background-color: #f8ecc2");
		

		
		TilePane tl = new TilePane();
		tl.getChildren().addAll(hyperlink,hyperlink1, hyperlink2, hyperlinkd,hyperlinkd1,hyperlinkd2,hyperlinkd3,hyperlinkd4,hyperlinkd5, backtomeals,bac);
		hyperlink.setDisable(true);
		hyperlink1.setDisable(true);
		hyperlink2.setDisable(true);
		
		hyperlinkd.setDisable(true);
		hyperlinkd1.setDisable(true);
		hyperlinkd2.setDisable(true);
		
		hyperlinkd3.setDisable(true);
		hyperlinkd4.setDisable(true);
		hyperlinkd5.setDisable(true);

		tl.setStyle("-fx-background-image: url('https://cdn.wallpapersafari.com/74/99/6fhjbi.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 500 500; -fx-background-position: center center;");

		Scene sc = new Scene(tl, 500, 500);
		 
		// TextArea ta1 = new TextArea();

		ListView<String> links = new ListView<>();
		links.setMaxSize(500, 300);

		ComboBox<String> cbh = new ComboBox<>();
		cbh.getItems().addAll("keto diet", "Gulten free diet", "vegan diet");
		cbh.setPromptText("Diets");

		cbh.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (bm1.isSelected()) {

					if (cbh.getSelectionModel().getSelectedItem()== "keto diet") {
						hyperlink.setDisable(false);
						primaryStage.setScene(sc);
						primaryStage.setTitle("meals links");
						primaryStage.show();

					} else if (cbh.getSelectionModel().getSelectedItem() ==  "Gulten free diet") {
						hyperlink1.setDisable(false);
						primaryStage.setScene(sc);
						primaryStage.setTitle("meals links");
						primaryStage.show();
					} else if (cbh.getSelectionModel().getSelectedItem() == "vegan diet") {
						hyperlink2.setDisable(false);

						primaryStage.setScene(sc);
						primaryStage.setTitle("meals links");
						primaryStage.show();
					}

				} else if (bm2.isSelected()) {

					if (cbh.getSelectionModel().getSelectedItem() == "keto diet") {
						hyperlinkd.setDisable(false);

						primaryStage.setScene(sc);
						primaryStage.setTitle("meals links");
						primaryStage.show();

					} else if (cbh.getSelectionModel().getSelectedItem() == "Gulten free diet") {
						hyperlinkd1.setDisable(false);

						primaryStage.setScene(sc);
						primaryStage.setTitle("meals links");
						primaryStage.show();

					} else if (cbh.getSelectionModel().getSelectedItem() == "vegan diet") {
						hyperlinkd2.setDisable(false);

						primaryStage.setScene(sc);
						primaryStage.setTitle("meals links");
						primaryStage.show();
					}

				} else if (bm3.isSelected()) {

					if (cbh.getSelectionModel().getSelectedItem() == "keto diet") {
						hyperlinkd3.setDisable(false);

						primaryStage.setScene(sc);
						primaryStage.setTitle("meals links");
						primaryStage.show();

					} else if (cbh.getSelectionModel().getSelectedItem() == "Gulten free diet") {
						hyperlinkd4.setDisable(false);

						primaryStage.setScene(sc);
						primaryStage.setTitle("meals links");
						primaryStage.show();

					} else if (cbh.getSelectionModel().getSelectedItem() == "vegan diet") {
						hyperlinkd5.setDisable(false);

						primaryStage.setScene(sc);
						primaryStage.setTitle("meals links");
						primaryStage.show();
					}

				}

			}
		});

		Button backkk = new Button("<--");
		backkk.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
		backkk.setStyle("-fx-background-color: #f8ecc2");

		backkk.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(scene);
				primaryStage.setTitle("DIET GUIDE PROTOTYPE");
				primaryStage.show();

			}
		});
		
		

		VBox vbm = new VBox();
		vbm.setSpacing(15);

		vbm.getChildren().addAll(lm, hbm, cbh, backkk);

		vbm.setStyle("-fx-background-image: url('https://cdn.wallpapersafari.com/74/99/6fhjbi.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 500 500; -fx-background-position: center center;");

		vbm.setAlignment(Pos.CENTER);
		Scene scene6 = new Scene(vbm, 300, 300);

		b2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				
				
				bm1.setSelected(false);
				bm2.setSelected(false);
				bm3.setSelected(false);
				primaryStage.setScene(scene6);
				primaryStage.setTitle("meals");
				primaryStage.show();

			}
		});
		
        backtomeals.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				hyperlink.setDisable(true);
				hyperlink1.setDisable(true);
				hyperlink2.setDisable(true);
				
				hyperlinkd.setDisable(true);
				hyperlinkd1.setDisable(true);
				hyperlinkd2.setDisable(true);
				
				hyperlinkd3.setDisable(true);
				hyperlinkd4.setDisable(true);
				hyperlinkd5.setDisable(true);
				cbh.getSelectionModel().clearSelection();
				bm1.setSelected(false);
				bm2.setSelected(false);
				bm3.setSelected(false);
				primaryStage.setScene(scene);
				primaryStage.setTitle("DIET GUIDE PROTOTYPE");
				primaryStage.show();
				
				
				
			}
		});
        
        
       
		bac.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				cbh.getSelectionModel().clearSelection();
				bm1.setSelected(false);
				bm2.setSelected(false);
				bm3.setSelected(false);
				primaryStage.setScene(scene6);
				primaryStage.setTitle("meals");
				primaryStage.show();
				
			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}
