module com.example.javafx_sample_random_color_window {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_sample_random_color_window to javafx.fxml;
    exports com.example.javafx_sample_random_color_window;
}