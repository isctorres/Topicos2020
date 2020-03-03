package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.Componentes.ButtonCell;
import sample.Modelos.ProductosDAO;

public class CRUDProductos extends Stage{

    private Scene escena;
    private VBox vbox;
    private TableView<ProductosDAO> tbvProductos;
    private Button btnAgregar;
    private ProductosDAO objP;

    public CRUDProductos(){
        objP = new ProductosDAO();
        CrearGUI();
        this.setTitle("CRUD Productos :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI() {
        vbox = new VBox();
        tbvProductos = new TableView<>();
        CrearTabla();
        btnAgregar = new Button("Agregar Producto");
        btnAgregar.setOnAction(event -> AgregarProducto());
        vbox.getChildren().addAll(tbvProductos,btnAgregar);
        escena = new Scene(vbox,500,300);
    }

    private void CrearTabla() {

        TableColumn<ProductosDAO,Integer> tbcIdProducto = new TableColumn<>("ID");
        tbcIdProducto.setCellValueFactory(new PropertyValueFactory<>("idProducto"));

        TableColumn<ProductosDAO,String> tbcNomProducto = new TableColumn<>("DESCRIPCIÓN");
        tbcNomProducto.setCellValueFactory(new PropertyValueFactory<>("nomProducto"));

        TableColumn<ProductosDAO,Float> tbcCosto = new TableColumn<>("COSTO");
        tbcCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));

        TableColumn<ProductosDAO,Float> tbcPrecio = new TableColumn<>("PRECIO");
        tbcPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<ProductosDAO,Float> tbcExistencia = new TableColumn<>("EXISTENCIA");
        tbcExistencia.setCellValueFactory(new PropertyValueFactory<>("existencia"));

        TableColumn<ProductosDAO,Boolean> tbcVigente = new TableColumn<>("VIGENTE");
        tbcVigente.setCellValueFactory(new PropertyValueFactory<>("vigente"));

        TableColumn<ProductosDAO,Integer> tbcIdProveedor = new TableColumn<>("PROVEEDOR");
        tbcIdProveedor.setCellValueFactory(new PropertyValueFactory<>("idProveedor"));

        TableColumn<ProductosDAO,String> tbcBorrar = new TableColumn<>("Borrar");
        tbcBorrar.setCellFactory(
                new Callback<TableColumn<ProductosDAO, String>, TableCell<ProductosDAO, String>>() {
                    @Override
                    public TableCell<ProductosDAO, String> call(TableColumn<ProductosDAO, String> param) {
                        return new ButtonCell();
                    }
                }
        );

        TableColumn<ProductosDAO,String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(
                new Callback<TableColumn<ProductosDAO, String>, TableCell<ProductosDAO, String>>() {
                    @Override
                    public TableCell<ProductosDAO, String> call(TableColumn<ProductosDAO, String> param) {
                        return new ButtonCell();
                    }
                }
        );


        tbvProductos.getColumns().addAll(tbcIdProducto,tbcNomProducto,tbcCosto,tbcPrecio,tbcExistencia,tbcVigente,tbcIdProveedor,tbcEditar,tbcBorrar);
        tbvProductos.setItems(objP.selAllProducto());
    }

    private void AgregarProducto() {
    }
}
