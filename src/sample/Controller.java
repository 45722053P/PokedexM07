package sample;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;


import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class Controller {

    public ListView listaPoke;
    public Label nombre, hp, peso;
    public ImageView imagenPoke;
    public Slider zoom;
    public static ObservableList items =
            FXCollections.observableArrayList();


    public void initialize() {
        Llamadas.listaView();
        listaPoke.setItems(items);
        //Listener del listview para que cuando hagamos click en un posicion haga algo
        listaPoke.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                //Sacamos el numero del �ndice que tenemos seleccionado
                int itemSeleccionado = listaPoke.getSelectionModel().getSelectedIndex();
                //Le sumo uno porque empieza en 0 y las ids de los pokemon empiezan por 1
                itemSeleccionado = itemSeleccionado + 1;
                //System.out.println("http://pokeapi.co/media/img/"+ itemSeleccionado +".png");

                //Muestra la imagen del pokemon cogiendo su posicion que es igual a su id
                imagenPoke.setImage(new Image("http://pokeapi.co/media/img/"+ itemSeleccionado +".png"));

                Pokemon pokemon = Llamadas.inforPokemon(itemSeleccionado);;

                nombre.setText("Nombre: " + pokemon.getNombre());
                hp.setText(String.valueOf("HP: " + pokemon.getHp())+ "");
                peso.setText(String.valueOf("Peso: " + pokemon.getPeso()));
            }
        });
        zoom.setMin(0);
        zoom.setMax(1.5);
        zoom.setValue(1);
        // Listen for Slider value changes
        zoom.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {


                imagenPoke.setScaleX(newValue.doubleValue());
                imagenPoke.setScaleY(newValue.doubleValue());


            }
        });
    }
    //Salir de aplicacion
    public void salirAplicacion(ActionEvent actionEvent) {
        Platform.exit();
    }


}
