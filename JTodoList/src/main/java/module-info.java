module org.jtodolist.jtodolist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens org.jtodolist.jtodolist to javafx.fxml;


    opens org.jtodolist.jtodolist.Controller to javafx.fxml; // <-- ADD THIS LINE
    exports org.jtodolist.jtodolist;

}