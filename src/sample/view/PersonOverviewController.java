package sample.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Main;
import sample.model.Person;
import sample.model.SourceData;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class PersonOverviewController {

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> telColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label telLabel;
    @FXML
    private Label hobbyLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Reference to the main application.
    private SourceData sourceData;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        telColumn.setCellValueFactory(cellData -> cellData.getValue().telProperty());

        personTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
            @Override
            public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
                showPersonDetails(newValue);
            }
        });
    }

    private void showPersonDetails(Person person) {
        if (person != null) {
            nameLabel.setText(person.getName());
            telLabel.setText(person.getTel());
            hobbyLabel.setText(person.getHobby());
            birthdayLabel.setText(new SimpleDateFormat("yyyy/MM/dd").format(person.getBirthday()));
            cityLabel.setText(person.getCity());

        } else {
            nameLabel.setText("");
            telLabel.setText("");
            hobbyLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param sourceData
     */
    public void setSourceData(SourceData sourceData) {
        this.sourceData = sourceData;

        // Add observable list data to the table
        personTable.setItems(sourceData.getPersonData());
    }
}
