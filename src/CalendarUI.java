import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class CalendarUI extends StackPane {

    //Grid pane is a pane of grids.
    //By default, it does not implement cells, gridlines,
    //and it doesn't distribute the sizes equally.
    private GridPane grid;

    //Constructor creates
    public CalendarUI() {
        grid = new GridPane();
        grid.setHgap(2);
        grid.setVgap(2);

        //CSS file with the specifications to allow the UI to mimic the original Windows Calendar.
        this.getStylesheets().add(
                getClass().getResource("/CalendarUI.css").toExternalForm());

        CalendarGrid gridModel = new CalendarGrid(YearMonth.now());
        List<LocalDate> cells = gridModel.getCells();

        for (int i = 0; i < 36; i++) {
            LocalDate date = cells.get(i);
            VBox cell = createCell(date);
            int row = i / 6;
            int col = i % 6;

            grid.add(cell, col, row);
        }

        this.getChildren().add(grid);
    }

    private VBox createCell(LocalDate date) {
        Label label = new Label(String.valueOf(date.getDayOfMonth()));
        VBox box = new VBox(label);
        box.getStyleClass().add("calendar-cell");
        box.setPrefSize(100, 80);

        return box;
    }

    public GridPane getView() {
        return grid;
    }
}