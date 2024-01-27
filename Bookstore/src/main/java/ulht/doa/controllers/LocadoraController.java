package ulht.doa.controllers;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import ulht.doa.DTO.*;
import ulht.doa.entities.*;
import ulht.doa.services.*;
import ulht.doa.services.ItemService;

import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller("/bookstore")

    public class LocadoraController {

        private final ClienteService clienteService;
        private final AtorService atorService;
        private final FilmeService filmeService;
        private final ItemService itemService;


        public LocadoraController(
                ClienteService clienteService, AtorService atorService,
                FilmeService filmeService, ItemService itemService
                ) {
            this.clienteService = clienteService;
            this.atorService = atorService;
            this.filmeService = filmeService;
            this.itemService = itemService;
        }




    }
