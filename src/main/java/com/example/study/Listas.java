package com.example.study;

import java.util.ArrayList;
import java.util.List;

public class Listas {

    public static void main(String[] args) {
        List <Cliente> listaClientes = new ArrayList<>();

        var cliente1 = new Cliente();
        cliente1.setNome("Manoel");

        var cliente2 = new Cliente();
        cliente2.setNome("Roberto");

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);

        System.out.println("Adição Manual");
        System.out.println("Lista com " + listaClientes.size() + " elementos.");

        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.getNome());
        }      
        System.out.println("------------------");

        while (listaClientes.size()>0) {
            listaClientes.remove(0);
        }
        System.out.println("Remoção com while");
        System.out.println("Lista com " + listaClientes.size() + " elementos.");
        System.out.println("------------------");

        while (listaClientes.size()<15) {
            if (Math.random()>0.5){
                listaClientes.add(cliente1);
            } else {
                listaClientes.add(cliente2);
            }
        }
        
        System.out.println("Adição Randomica");
        System.out.println("Lista com " + listaClientes.size() + " elementos.");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.getNome());
        }    
        System.out.println("------------------");
        
        List <Integer> notasTurma = new ArrayList<>();

    }
}
