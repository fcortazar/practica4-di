package com.di.practica4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.List;

public class ContactController {
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField telefonoField;
    @FXML
    private TextField correoField;
    @FXML
    private TextArea contactListArea;
    private GestorDeContactos gestorDeContactos;

    public ContactController() {
        this.gestorDeContactos = new GestorDeContactos();
    }

    @FXML
    private void agregarContacto() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String telefono = telefonoField.getText();
        String correo = correoField.getText();

        Contacto nuevoContacto = new Contacto(nombre, apellido, telefono, correo);
        gestorDeContactos.agregarContacto(nuevoContacto);

        // Clear the input fields after adding the contact
        nombreField.clear();
        apellidoField.clear();
        telefonoField.clear();
        correoField.clear();
    }

    @FXML
    private void editarContacto() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String telefono = telefonoField.getText();
        String correo = correoField.getText();

        Contacto nuevoContacto = new Contacto(nombre, apellido, telefono, correo);

        // Assuming you have a method to get a contact by name
        Contacto contactoExistente = gestorDeContactos.getContactoByNombre(nombre);

        if (contactoExistente != null) {
            gestorDeContactos.editarContacto(contactoExistente, nuevoContacto);
        }

        // Clear the input fields after editing the contact
        nombreField.clear();
        apellidoField.clear();
        telefonoField.clear();
        correoField.clear();
    }

    @FXML
    private void eliminarContacto() {
        String nombre = nombreField.getText();

        // Assuming you have a method to get a contact by name
        Contacto contactoExistente = gestorDeContactos.getContactoByNombre(nombre);

        if (contactoExistente != null) {
            gestorDeContactos.eliminarContacto(contactoExistente);
        }

        // Clear the input fields after deleting the contact
        nombreField.clear();
        apellidoField.clear();
        telefonoField.clear();
        correoField.clear();
    }

    @FXML
    private void listarContactos() {
        List<Contacto> contactos = gestorDeContactos.listarContactos();
        StringBuilder contactosStr = new StringBuilder();

        for (Contacto contacto : contactos) {
            contactosStr.append("Nombre: ").append(contacto.getNombre())
                    .append(", Apellido: ").append(contacto.getApellido())
                    .append(", Teléfono: ").append(contacto.getNumeroTelefono())
                    .append(", Correo: ").append(contacto.getCorreoElectronico())
                    .append("\n");
        }

        contactListArea.setText(contactosStr.toString());
    }

    @FXML
    private void exportarContactos() {
        // Implementar lógica para exportar contactos
    }
}