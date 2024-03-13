package com.di.practica4;

import java.util.ArrayList;
import java.util.List;

public class GestorDeContactos {
    private List<Contacto> contactos;

    public GestorDeContactos() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void editarContacto(Contacto contactoExistente, Contacto contactoNuevo) {
        int index = contactos.indexOf(contactoExistente);
        if (index != -1) {
            contactos.set(index, contactoNuevo);
        }
    }

    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }

    public List<Contacto> listarContactos() {
        return contactos;
    }
    public Contacto getContactoByNombre(String nombre) {
        for (Contacto contacto : this.contactos) {
            if (contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        return null;
    }
}
