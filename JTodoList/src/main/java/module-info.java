module org.jtodolist.jtodolist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.jtodolist.jtodolist to javafx.fxml;
    exports org.jtodolist.jtodolist;
}